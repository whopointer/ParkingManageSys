package com.example.parkingmanagesys.Service.Impl;

import com.example.parkingmanagesys.DAO.BookingInformationMapper;
import com.example.parkingmanagesys.DAO.BookingMapper;
import com.example.parkingmanagesys.DAO.ParkingSpaceMapper;
import com.example.parkingmanagesys.DAO.UsersMapper;
import com.example.parkingmanagesys.Pojo.BookingInformation;
import com.example.parkingmanagesys.Pojo.ParkingSpace;
import com.example.parkingmanagesys.Pojo.User;
import com.example.parkingmanagesys.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UsersMapper usersMapper;
@Autowired
private BookingInformationMapper bookingInformationMapper;
@Autowired
private BookingMapper bookingMapper;
@Autowired
private ParkingSpaceMapper parkingSpaceMapper;

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
        return bookingInformationMapper.selectByBookingId(bookingMapper.selectByCarId(carId).getBookingId());
    }

    @Override
    public boolean updateBookingInformationByCarId(String carId, String date) throws ParseException {
        //查所有的车位，找到空闲车位，改为“预定”,得到spaceId
        ParkingSpace parkingSpace=new ParkingSpace();
        Integer spaceId;
        List<ParkingSpace> parkingSpaceList=parkingSpaceMapper.selectAll();
        for(int i=0;i<parkingSpaceList.size();i++){
            if(parkingSpaceList.get(i).getSpaceState()=="空闲")
            {
                parkingSpace=parkingSpaceList.get(i);
                break;
            }
        }
        spaceId=parkingSpace.getSpaceId();
        parkingSpace.setSpaceState("预定");
        parkingSpaceMapper.updateBySpaceId(parkingSpace);
        //添加bookingInformation信息
        BookingInformation bookingInformation=new BookingInformation();
        List<BookingInformation> bookingInformationList=bookingInformationMapper.selectAll();
        bookingInformation.setBookingId(bookingInformationList.size());
        //将String的日期改为正常日期，如果不对return false
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
        bookingInformation.setBookingTime(ft.parse(date));
        bookingInformationMapper.insertBookingTime(bookingInformation);
        //添加booking信息

        return false;
    }
}
