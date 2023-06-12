package com.example.parkingmanagesys.Service.Impl;

import com.example.parkingmanagesys.DAO.UsersMapper;
import com.example.parkingmanagesys.Pojo.User;
import com.example.parkingmanagesys.Service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public List<User> selectAll() {
        return usersMapper.selectAll();
    }

    @Override
    public String updateByCarId(String carId) {
        User user=usersMapper.selectByCarId(carId);
        user.setCardType("永久卡");
        String prefix=new SimpleDateFormat("yyyymmdd").format(new Date());
        Random r=new Random();
        String suffix=Integer.toString(r.nextInt(899)+100);
        user.setCardNum(prefix+suffix);
        usersMapper.insertUser(user);
        return prefix+suffix;
    }
}
