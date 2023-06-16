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
    //根据车位id改车位类型
    boolean updateSpaceType(String spaceId,String spaceType);
    //根据车位id改车位状态
    boolean updateSpaceState(String spaceId,String spaceState);
    //根据id插入车位
    public boolean insertBySpaceId(ParkingSpace parkingSpace);

}
