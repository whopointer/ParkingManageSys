package com.example.parkingmanagesys.Service;

import com.example.parkingmanagesys.Pojo.User;

import java.util.List;

public interface AdminUserService {
    //查询所有用户
    List<User> selectAll();
    //用户购买永久卡
    String updateByCarId(String carId);
}
