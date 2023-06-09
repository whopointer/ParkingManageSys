package com.example.parkingmanagesys.Service;

import com.example.parkingmanagesys.Pojo.ParkingSpace;

import java.util.List;

public interface ParkingService {
    //管理员查询所有车位信息
    List<ParkingSpace> selectAll();
    //管理员设置车位为某车主的专用车位
    boolean updateBySpaceId(String carId);
    //车辆入场
    Integer carIn(String carId);
    //车辆出场
    Float carOut(String carId);
}
