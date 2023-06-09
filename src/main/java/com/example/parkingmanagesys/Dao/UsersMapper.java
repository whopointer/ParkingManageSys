package com.example.parkingmanagesys.Dao;

import com.example.parkingmanagesys.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    //登录查询
    User selectByUserPhoneAndUserPassWord(User user);
    //查看所有车主
    List<User> selectAll();
    //根据车辆id删除车主
    boolean deleteByCarId(String carId);
    //根据车辆id改车主
    boolean updateByCarId(User user);
    //添加车主信息
    boolean insertUser(User user);
}
