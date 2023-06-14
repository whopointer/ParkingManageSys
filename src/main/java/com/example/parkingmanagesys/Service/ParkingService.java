package com.example.parkingmanagesys.Service;

import com.example.parkingmanagesys.Pojo.ParkingSpace;

import java.util.List;

public interface ParkingService {
    //管理员查询所有车位信息
    List<ParkingSpace> selectAll();
    //车辆入场
    Integer carIn(String carId);
    //车辆出场
    Float carOut(String carId);
}
