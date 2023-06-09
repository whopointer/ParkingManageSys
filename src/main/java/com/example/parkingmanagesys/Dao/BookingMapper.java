package com.example.parkingmanagesys.Dao;

import com.example.parkingmanagesys.Pojo.Booking;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookingMapper {
    //根据carId查bookingId
    Integer selectByCarId(String carId);
    //根据bookingId查询carId
    String selectByBookingId(Integer bookingId);
    //添加预约信息
    boolean insertBooking(Booking booking);
    //出场后根据carId删除booking
    boolean deleteByCarId(String carId);
}
