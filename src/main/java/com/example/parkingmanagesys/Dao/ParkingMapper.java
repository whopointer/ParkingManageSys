package com.example.parkingmanagesys.Dao;

import com.example.parkingmanagesys.Pojo.Parking;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParkingMapper {
    //根据carId查spaceId
    Integer selectByCarId(String carId);
    //根据spaceId查carId
    String selectByBookingId(Integer bookingId);
    //添加停车信息
    boolean insertParking(Parking parking);
    //出场后根据carId删除parking
    boolean deleteByCarId(String carId);
}
