package com.example.parkingmanagesys.DAO;

import com.example.parkingmanagesys.Pojo.BookingInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookingInformationMapper {
    //查询所有预定信息
    List<BookingInformation> selectAll();
    BookingInformation selectBookingInformationBySpaceId(Integer spaceId);
    //根据车辆id查询
    BookingInformation selectBookingInformationByCarId(String carId);
    //根据id查询预信息
    BookingInformation selectByBookingId(Integer bookingId);
    //根据id删除
    Boolean deleteByBookingId(Integer bookingId);
    //插入预定信息
    Boolean insertInformation(BookingInformation bookingInformation);
    //只改到达时间和费用
    Boolean updateByBookingId(BookingInformation bookingInformation);
}
