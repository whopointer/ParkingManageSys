package com.example.parkingmanagesys.Service.Impl;

import com.example.parkingmanagesys.DAO.BookingInformationMapper;
import com.example.parkingmanagesys.DAO.ParkingMapper;
import com.example.parkingmanagesys.DAO.ParkingSpaceMapper;
import com.example.parkingmanagesys.DAO.SpecialMapper;
import com.example.parkingmanagesys.Pojo.BookingInformation;
import com.example.parkingmanagesys.Pojo.Parking;
import com.example.parkingmanagesys.Pojo.ParkingSpace;
import com.example.parkingmanagesys.Pojo.Special;
import com.example.parkingmanagesys.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;
    @Autowired
    private BookingInformationMapper bookingInformationMapper;
    @Autowired
    private ParkingMapper parkingMapper;
    @Autowired
    private SpecialMapper specialMapper;
    //管理员查所有车位信息
    //内容：车位号、类型、状态、入场时间、预约时间、车牌
    @Override
    public List<ParkingSpace> selectAll(){
        ParkingSpace parkingSpace;
        Parking parking;
        BookingInformation bookingInformation;
        List<ParkingSpace> parkingSpaceList=parkingSpaceMapper.selectAll();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
        for(int i=0;i<parkingSpaceList.size();i++){
            parkingSpace=parkingSpaceList.get(i);
            //改状态
            if(parkingSpace.getSpaceType().compareTo("Permanent")==0) {
                parkingSpace.setSpaceType("永久");
            }
            else parkingSpace.setSpaceType("临时");
            //已有停车的情况
            parkingSpace.setSpaceState("空闲");
            parking=parkingMapper.selectBySpaceId(parkingSpace.getSpaceId());
            if(parking!=null){
                parkingSpace.setRealArrivalTime(ft.format(parking.getArrivalTime()));
                parkingSpace.setParkingCarId(parking.getCarId());
                parkingSpace.setSpaceState("有车");
                bookingInformation=bookingInformationMapper.selectBookingInformationBySpaceId(parkingSpace.getSpaceId());
                if(bookingInformation!=null&&bookingInformation.getArrivalTime()==null){
                    parkingSpace.setBookingCarId(bookingInformation.getCarId());
                    parkingSpace.setRealBookingTime((ft.format(bookingInformation.getBookingTime())));
                }
                continue;
            }
            //有预定的情况
            bookingInformation=bookingInformationMapper.selectBookingInformationBySpaceId(parkingSpace.getSpaceId());
            if(bookingInformation!=null&&bookingInformation.getArrivalTime()==null){
                parkingSpace.setSpaceState("预定");
                parkingSpace.setBookingCarId(bookingInformation.getCarId());
                parkingSpace.setRealBookingTime((ft.format(bookingInformation.getBookingTime())));
            }
        }
        return parkingSpaceList;
    }
    @Override
    public Integer carIn(String carId) {
        ParkingSpace parkingSpace=new ParkingSpace();
        Parking parking=new Parking();
        //专用车辆
        Special special=specialMapper.selectByCarId(carId);
        if(special!=null){
            //插入一条新的停车信息
            parking.setCarId(carId);
            parking.setSpaceId(special.getSpaceId());
            parking.setArrivalTime(new Date());
            parkingMapper.insertParking(parking);
            return special.getSpaceId();
        }

        //预定车辆
        BookingInformation bookingInformation=bookingInformationMapper.selectBookingInformationByCarId(carId);
        if(bookingInformation!=null&&bookingInformation.getArrivalTime()==null) {
            //插入一条新的停车信息
            parking.setCarId(carId);
            parking.setSpaceId(bookingInformation.getSpaceId());
            parking.setArrivalTime(new Date());
            parkingMapper.insertParking(parking);
            parkingSpace=parkingSpaceMapper.selectBySpaceId(parking.getSpaceId());
            parkingSpace.setSpaceState("Busy");
            //修改book_information的到达时间、费用
            bookingInformation.setArrivalTime(new Date());
            //计算差多少小时
            long diff=bookingInformation.getArrivalTime().getTime()-bookingInformation.getBookingTime().getTime();
            long hour=diff/1000/60/60;
            bookingInformation.setBookingFee((int)hour*6);
            bookingInformation.setBookingState("Finished");
            bookingInformationMapper.updateByBookingId(bookingInformation);
            parkingSpaceMapper.updateBySpaceId(parkingSpace);
            return bookingInformation.getSpaceId();
        }

        //普通车辆（后续还要计算预约的情况）
        List<ParkingSpace> parkingSpaceList=parkingSpaceMapper.selectAll();
        List<ParkingSpace> parkingSpaceList1=new ArrayList<>();
        for(int i=0;i<parkingSpaceList.size();i++){
            bookingInformation=bookingInformationMapper.selectBookingInformationBySpaceId(parkingSpaceList.get(i).getSpaceId());
            if(parkingSpaceList.get(i).getSpaceState().compareTo("Spare")==0)
            {
                if(bookingInformation==null) {
                    parkingSpace = parkingSpaceList.get(i);
                    break;
                }
                else parkingSpaceList1.add(parkingSpaceList.get(i));
            }
        }
        if(parkingSpace==null){
            if(parkingSpaceList1.size()==0){
                return -1;
            }
            else{
                parkingSpace=parkingSpaceList1.get(0);
                bookingInformation=bookingInformationMapper.selectBookingInformationBySpaceId(parkingSpace.getSpaceId());
                long bookingTime=bookingInformation.getBookingTime().getTime();
                for(int i=1;i<parkingSpaceList.size();i++){
                    if(bookingInformationMapper.selectBookingInformationBySpaceId(parkingSpaceList1.get(i).getSpaceId()).getBookingTime().getTime()>bookingTime) {
                        parkingSpace=parkingSpaceList1.get(i);
                        bookingInformation=bookingInformationMapper.selectBookingInformationBySpaceId(parkingSpace.getSpaceId());
                        bookingTime=bookingInformation.getBookingTime().getTime();
                    }
                }
            }
        }
        //插入一条新的停车信息
        parking.setCarId(carId);
        parking.setSpaceId(parkingSpace.getSpaceId());
        parking.setArrivalTime(new Date());
        parkingMapper.insertParking(parking);
        parkingSpace=parkingSpaceMapper.selectBySpaceId(parking.getSpaceId());
        parkingSpace.setSpaceState("Busy");
        parkingSpaceMapper.updateBySpaceId(parkingSpace);
        return parkingSpace.getSpaceId();
    }

    @Override
    public Float carOut(String carId) {
        Parking parking=parkingMapper.selectByCarId(carId);
        ParkingSpace parkingSpace=parkingSpaceMapper.selectBySpaceId(parking.getSpaceId());
        //专用车辆
        Special special=specialMapper.selectByCarId(carId);
        if(special!=null){
            //删除停车信息
            parkingMapper.deleteByCarId(carId);
            return (float)0;
        }

        Float fee;
        //普通车辆
        parkingSpace.setSpaceState("Spare");
        parkingSpaceMapper.updateBySpaceId(parkingSpace);
        //计算差多少小时
        long diff=new Date().getTime()-parking.getArrivalTime().getTime();
        long hour=diff/1000/60/60;
        fee=(float)hour*6;
        //删除停车信息
        parkingMapper.deleteByCarId(carId);
        //预定车辆、注意不只一条后续有时间要改
        BookingInformation bookingInformation=bookingInformationMapper.selectBookingInformationByCarId(carId);
        if(bookingInformation!=null) {
            fee+=bookingInformation.getBookingFee();
        }
        return fee;
    }

    @Override
    public boolean updateSpaceType(String spaceId,String spaceType) {
        return parkingSpaceMapper.updateSpaceType(spaceId,spaceType);
    }

    @Override
    public boolean updateSpaceState(String spaceId, String spaceState) {
        return parkingSpaceMapper.updateSpceState(spaceId,spaceState);
    }

    @Override
    public boolean insertBySpaceId(ParkingSpace parkingSpace) {
        return parkingMapper.insertBySpaceId(parkingSpace);
    }

}
