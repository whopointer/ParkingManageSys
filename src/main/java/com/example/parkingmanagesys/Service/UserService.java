package com.example.parkingmanagesys.Service;

import com.example.parkingmanagesys.Pojo.BookingInformation;
import com.example.parkingmanagesys.Pojo.ParkingHistory;
import com.example.parkingmanagesys.Pojo.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    //根据车辆id改车辆颜色
    boolean updateCarColor(String carId,String color);
    //根据车辆id改车主用户名
    boolean updateName(String carId,String userName);
    //根据车辆id改车主密码
    boolean updatePassWord(String carId,String userPassWord);
    //根据车辆id改车主卡类型
    boolean updateCardType(String carId,String cardType);
    //根据车辆id改车主卡号
    boolean updateCardNum(String carId,String cardNum);
    //根据车辆id改车主信息
    boolean updateByCarId(User user);

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


