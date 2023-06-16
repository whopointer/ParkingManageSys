package com.example.parkingmanagesys.DAO;

import com.example.parkingmanagesys.Pojo.ParkingSpace;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkingSpaceMapper {
    //查询所有车位
    List<ParkingSpace> selectAll();
    //根据spaceId查询车位
    ParkingSpace selectBySpaceId(Integer spaceId);
    //根据车位号修改车位信息
    boolean updateBySpaceId(ParkingSpace parkingSpace);
    //根据车位id改车位类型
    boolean updateSpaceType(String spaceId,String spaceType);
    //根据车位id改车位状态
    boolean updateSpaceState(String spaceId,String spaceState);
    //根据id插入车位
    public boolean insertBySpaceId(ParkingSpace parkingSpace);

    boolean updateSpceState(String spaceId, String spaceState);
}
