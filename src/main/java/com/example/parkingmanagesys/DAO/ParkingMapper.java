package com.example.parkingmanagesys.DAO;

import com.example.parkingmanagesys.Pojo.Parking;
import com.example.parkingmanagesys.Pojo.ParkingSpace;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParkingMapper {
    //根据carId查spaceId
    Parking selectByCarId(String carId);
    //根据spaceId查carId
    Parking selectBySpaceId(Integer spaceId);
    //添加停车信息
    boolean insertParking(Parking parking);
    //出场后根据carId删除parking
    boolean deleteByCarId(String carId);
    //计算停车总数
    double count();
    //根据id插入车位
    public boolean insertBySpaceId(ParkingSpace parkingSpace);

}
