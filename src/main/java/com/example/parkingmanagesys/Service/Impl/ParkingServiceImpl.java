package com.example.parkingmanagesys.Service.Impl;

import com.example.parkingmanagesys.DAO.BookingInformationMapper;
import com.example.parkingmanagesys.DAO.BookingMapper;
import com.example.parkingmanagesys.DAO.ParkingMapper;
import com.example.parkingmanagesys.DAO.ParkingSpaceMapper;
import com.example.parkingmanagesys.Pojo.ParkingSpace;
import com.example.parkingmanagesys.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.SimpleDateFormat;
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
        Integer bookingId;
        List<ParkingSpace> parkingSpaceList=parkingSpaceMapper.selectAll();
        for(int i=0;i<parkingSpaceList.size();i++){
            parkingSpace=parkingSpaceList.get(i);
            parkingSpace.setParkingCarId(parkingMapper.selectBySpaceId(parkingSpace.getSpaceId()));
            bookingId=bookingMapper.selectByCarId(parkingSpace.getParkingCarId());
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            parkingSpace.setRealArrivalTime(ft.format(parkingSpace.getArrivalTime()));
            parkingSpace.setRealBookingTime(ft.format(bookingInformationMapper.selectByBookingId(bookingId).getBookingTime()));
        }
        return parkingSpaceList;
    }

    @Override
    public boolean updateBySpaceId(String carId) {
        return false;
    }

    @Override
    public Integer carIn(String carId) {
        return null;
    }

    @Override
    public Float carOut(String carId) {
        return null;
    }

}
