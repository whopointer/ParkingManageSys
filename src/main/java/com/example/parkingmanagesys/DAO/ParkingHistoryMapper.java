package com.example.parkingmanagesys.DAO;

import com.example.parkingmanagesys.Pojo.ParkingHistory;
import com.example.parkingmanagesys.Pojo.ParkingSpace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkingHistoryMapper {
    List<ParkingHistory> selectAll();
    List<ParkingHistory> selectParkingHistoryBySpaceId(Integer spaceId);
    //根据车辆id查询
    List<ParkingHistory> selectParkingHistoryByCarId(String carId);
    //根据id查询预信息
    ParkingHistory selectParkingHistoryByBookingId(Integer bookingId);
    ParkingHistory selectParkingHistoryByHistoryId(Integer historyId);
    //根据id删除
    Boolean deleteByBookingId(Integer bookingId);
    //插入预定信息
    Boolean insertInformation(ParkingHistory parkingHistory);
    //只改到达时间和费用
    Boolean updateByBookingId(ParkingHistory parkingHistory);
}
