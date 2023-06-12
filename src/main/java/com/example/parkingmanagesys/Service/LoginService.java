package com.example.parkingmanagesys.Service;

import com.example.parkingmanagesys.Pojo.User;

public interface LoginService {
    //登录
    public User selectByUserPhoneAndUserPassWord(User user);
    //注册
    public boolean insertUser(User user);
}
