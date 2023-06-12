package com.example.parkingmanagesys.Service.Impl;

import ch.qos.logback.core.pattern.SpacePadder;
import com.example.parkingmanagesys.DAO.BookingInformationMapper;
import com.example.parkingmanagesys.DAO.BookingMapper;
import com.example.parkingmanagesys.DAO.ParkingMapper;
import com.example.parkingmanagesys.DAO.ParkingSpaceMapper;
import com.example.parkingmanagesys.Pojo.Booking;
import com.example.parkingmanagesys.Pojo.BookingInformation;
import com.example.parkingmanagesys.Pojo.Parking;
import com.example.parkingmanagesys.Pojo.ParkingSpace;
import com.example.parkingmanagesys.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private BookingInformationMapper bookingInformationMapper;
    @Autowired
    private ParkingMapper parkingMapper;

    //管理员查所有车位信息
    //内容：车位号、类型、是否空闲、入场时间、预约时间、车牌
    @Override
    public List<ParkingSpace> selectAll(){
        ParkingSpace parkingSpace;
        Booking booking;
        List<ParkingSpace> parkingSpaceList=parkingSpaceMapper.selectAll();
        for(int i=0;i<parkingSpaceList.size();i++){
            parkingSpace=parkingSpaceList.get(i);
            parkingSpace.setParkingCarId(parkingMapper.selectBySpaceId(parkingSpace.getSpaceId()));
            booking=bookingMapper.selectByCarId(parkingSpace.getParkingCarId());
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
            parkingSpace.setRealArrivalTime(ft.format(parkingSpace.getArrivalTime()));
            parkingSpace.setRealBookingTime(ft.format(bookingInformationMapper.selectByBookingId(booking.getBookingId()).getBookingTime()));
        }
        return parkingSpaceList;
    }

    @Override
    public boolean updateBySpaceId(String carId) {
        ParkingSpace parkingSpace= parkingSpaceMapper.selectBySpaceId(parkingMapper.selectByCarId(carId));
        if(parkingSpace.getSpaceType()=="专用"){
            parkingSpace.setSpaceType("临时");
        }
        else parkingSpace.setSpaceType("专用");
        return true;
    }

    @Override
    public Integer carIn(String carId) {
        ParkingSpace parkingSpace=new ParkingSpace();
        Parking parking=new Parking();

        //专用车辆
        parkingSpace=parkingSpaceMapper.selectByCarId(carId);
        if(parkingSpace!=null){
            //修改parking_space中入场时间和状态
            parkingSpace.setSpaceState("忙碌");
            parkingSpace.setArrivalTime(new Date());
            parkingSpaceMapper.updateBySpaceId(parkingSpace);
            //插入一条新的停车信息
            parking.setCarId(carId);
            parking.setSpaceId(parkingSpace.getSpaceId());
            parkingMapper.insertParking(parking);
            return parkingSpace.getSpaceId();
        }

        //预定车辆
        Booking booking=bookingMapper.selectByCarId(carId);
        if(booking!=null) {
            //修改parking_space中入场时间和状态
            parkingSpace = parkingSpaceMapper.selectBySpaceId(bookingMapper.selectByCarId(carId).getSpaceId());
            parkingSpace.setSpaceState("忙碌");
            parkingSpace.setArrivalTime(new Date());
            parkingSpaceMapper.updateBySpaceId(parkingSpace);
            //插入一条新的停车信息
            parking.setCarId(carId);
            parking.setSpaceId(parkingSpace.getSpaceId());
            parkingMapper.insertParking(parking);
            //修改book_information的到达时间、费用
            BookingInformation bookingInformation=bookingInformationMapper.selectByBookingId(booking.getBookingId());
            bookingInformation.setArrivalTime(new Date());
            //计算差多少小时
            long diff=bookingInformation.getArrivalTime().getTime()-bookingInformation.getBookingTime().getTime();
            long hour=diff%(1000*24*60*60)/(1000*60*60);
            bookingInformation.setBookingFee(hour*6);
            bookingInformationMapper.updateByBookingId(bookingInformation);
            return parkingSpace.getSpaceId();
        }

        //普通车辆（后续还要计算预约的情况）
        ParkingSpace parkingSpace1=new ParkingSpace();
        List<ParkingSpace> parkingSpaceList=parkingSpaceMapper.selectAll();
        for(int i=0;i<parkingSpaceList.size();i++){
            if(parkingSpaceList.get(i).getSpaceState()=="空闲")
            {
                parkingSpace1=parkingSpaceList.get(i);
                break;
            }
        }
        //修改parking_space中入场时间和状态
        parkingSpace1.setSpaceState("忙碌");
        parkingSpace1.setArrivalTime(new Date());
        parkingSpaceMapper.updateBySpaceId(parkingSpace1);
        //插入一条新的停车信息
        parking.setCarId(carId);
        parking.setSpaceId(parkingSpace1.getSpaceId());
        parkingMapper.insertParking(parking);
        return parkingSpace1.getSpaceId();
    }

    @Override
    public Float carOut(String carId) {
        ParkingSpace parkingSpace=parkingSpaceMapper.selectByCarId(carId);
        Parking parking=new Parking();
        //专用车辆
        if(parkingSpace!=null){
            //修改parking_space中入场时间和状态
            parkingSpace.setSpaceState("空闲");
            parkingSpace.setArrivalTime(null);
            parkingSpaceMapper.updateBySpaceId(parkingSpace);
            //删除停车信息
            parkingMapper.deleteByCarId(carId);
            return (float)0;
        }

        //预定车辆
        Booking booking=bookingMapper.selectByCarId(carId);
        if(booking!=null) {
            //修改parking_space中入场时间和状态
            parkingSpace = parkingSpaceMapper.selectBySpaceId(bookingMapper.selectByCarId(carId).getSpaceId());
            parkingSpace.setSpaceState("空闲");
            //计算差多少小时
            long diff=new Time(0).getTime()-parkingSpace.getArrivalTime().getTime();
            long hour=diff%(1000*24*60*60)/(1000*60*60);
            parkingSpace.setArrivalTime(null);
            parkingSpaceMapper.updateBySpaceId(parkingSpace);
            //删除停车信息
            parkingMapper.deleteByCarId(carId);
            //删除预定信息
            float bookingFee=bookingInformationMapper.selectByBookingId(booking.getBookingId()).getBookingFee();
            bookingInformationMapper.deleteByBookingId(booking.getBookingId());
            return hour*6+bookingFee;
        }

        //普通车辆
        parkingSpace = parkingSpaceMapper.selectBySpaceId(bookingMapper.selectByCarId(carId).getSpaceId());
        parkingSpace.setSpaceState("空闲");
        //计算差多少小时
        long diff=new Time(0).getTime()-parkingSpace.getArrivalTime().getTime();
        long hour=diff%(1000*24*60*60)/(1000*60*60);
        parkingSpace.setArrivalTime(null);
        return (float)hour;
    }

}
