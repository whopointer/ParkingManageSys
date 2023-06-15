package com.example.parkingmanagesys.Service.Impl;

import com.example.parkingmanagesys.DAO.UsersMapper;
import com.example.parkingmanagesys.Pojo.User;
import com.example.parkingmanagesys.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public User selectByUserPhoneAndUserPassWord(User user) {
        return usersMapper.selectByUserPhoneAndUserPassWord(user);
    }

    @Override
    public boolean insertUser(User user){
        List<User> userList=usersMapper.selectAll();
        for(int i=0;i<userList.size();i++){
            if(user.getCarId() == userList.get(i).getCarId()){
                System.out.println("存在重复车牌号！");
                return false;
            }
            if(user.getUserPhone() == userList.get(i).getUserPhone()){
                System.out.println("存在重复手机号！");
                return false;
            }
            if(user.getCardNum() == userList.get(i).getCardNum())
                System.out.println("存在重复停车卡号！");
            return false;
        }
        return usersMapper.insertUser(user);
    }
}
