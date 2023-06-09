package com.example.parkingmanagesys.DAO;

import com.example.parkingmanagesys.Pojo.ParkingSpace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkingSpaceMapper {
    //查询所有车位
    List<ParkingSpace> selectAll();
    //根据车位号修改车位信息
    boolean updateBySpaceId(ParkingSpace parkingSpace);
}
