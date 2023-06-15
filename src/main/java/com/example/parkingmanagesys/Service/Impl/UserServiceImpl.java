package com.example.parkingmanagesys.Service.Impl;

import com.example.parkingmanagesys.DAO.BookingInformationMapper;
import com.example.parkingmanagesys.DAO.ParkingHistoryMapper;
import com.example.parkingmanagesys.DAO.ParkingSpaceMapper;
import com.example.parkingmanagesys.DAO.UsersMapper;
import com.example.parkingmanagesys.Pojo.BookingInformation;
import com.example.parkingmanagesys.Pojo.ParkingHistory;
import com.example.parkingmanagesys.Pojo.User;
import com.example.parkingmanagesys.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UsersMapper usersMapper;
@Autowired
private BookingInformationMapper bookingInformationMapper;
@Autowired
private ParkingHistoryMapper parkingHistoryMapper;


    //根据车辆id改车辆颜色
    @Override
    public boolean updateCarColor(String carId,String color) {
        return usersMapper.updateCarColor(carId,color);
    }
    //根据车辆id改车主用户名
    @Override
    public boolean updateName(String carId,String userName) {
        return usersMapper.updateName(carId,userName);
    }
    //根据车辆id改车主密码
    @Override
    public boolean updatePassWord(String carId,String userPassWord) {
        return usersMapper.updatePassWord(carId,userPassWord);
    }
    //根据车辆id改车主卡类型
    @Override
    public boolean updateCardType(String carId,String cardType) {
        return usersMapper.updateCardType(carId,cardType);
    }
    //根据车辆id改车主卡号
    @Override
    public boolean updateCardNum(String carId,String cardNum) {
        return usersMapper.updateCardNum(carId,cardNum);
    }
    //根据车辆id改车主信息
    @Override
    public boolean updateByCarId(User user){
        return usersMapper.updateByCarId(user);
    }

    @Override
    public boolean deleteByCarId(String carId) {
        return usersMapper.deleteByCarId(carId);
    }


    @Override
    public BookingInformation selectBookingInformationByCarId(String carId) {
        return bookingInformationMapper.selectBookingInformationByCarId(carId);
    }

    @Override
    public boolean updateBookingInformationByCarId(BookingInformation bookingInformation){
        List<BookingInformation> bookingInformationList=bookingInformationMapper.selectAll();
        bookingInformation.setBookingId(bookingInformationList.size()+1);
        return bookingInformationMapper.insertInformation(bookingInformation);
    }

    @Override
    public List<User> selectAll(){
        return usersMapper.selectAll();
    }

    @Override
    public BookingInformation selectBookingInfoByCarId(String carId){
        return bookingInformationMapper.selectBookingInformationByCarId(carId);
    }
    @Override
    public List<ParkingHistory> selectAllParkingHistoryByCarId(String carId){
        return parkingHistoryMapper.selectParkingHistoryByCarId(carId);
    }
}

