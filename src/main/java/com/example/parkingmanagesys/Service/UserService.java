package com.example.parkingmanagesys.Service;

import com.example.parkingmanagesys.Pojo.BookingInformation;
import com.example.parkingmanagesys.Pojo.User;

import java.text.ParseException;

public interface UserService {
    //修改用户个人信息
    public boolean updateByCarId(User user);
    //用户注销
    public boolean deleteByCarId(String carId);
    //查看预定
    public BookingInformation selectBookingInformationByCarId(String carId);
    //预定
    public boolean updateBookingInformationByCarId(String carId);

    boolean updateBookingInformationByCarId(String carId, String date) throws ParseException;
}
