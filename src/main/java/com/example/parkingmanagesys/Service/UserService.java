package com.example.parkingmanagesys.Service;

import com.example.parkingmanagesys.Pojo.BookingInformation;
import com.example.parkingmanagesys.Pojo.ParkingHistory;
import com.example.parkingmanagesys.Pojo.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {
    //修改用户个人信息
    public boolean updateByCarId(User user);

    //用户注销
    public boolean deleteByCarId(String carId);

    //查看预定
    public BookingInformation selectBookingInformationByCarId(String carId);
    //查询全部信息
    public List<User> selectAll();
    public BookingInformation selectBookingInfoByCarId(String carId);
    public List<ParkingHistory> selectAllParkingHistoryByCarId(String carId);
    //预定
    public boolean updateBookingInformationByCarId(BookingInformation bookingInformation);
}


