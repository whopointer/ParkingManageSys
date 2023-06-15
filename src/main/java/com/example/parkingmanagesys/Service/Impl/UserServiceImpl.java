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

    @Override
    public boolean updateByCarId(User user) {
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

