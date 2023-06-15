package com.example.parkingmanagesys.DAO;

import com.example.parkingmanagesys.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    //登录查询
    User selectByUserPhoneAndUserPassWord(User user);
    //查看所有车主
    List<User> selectAll();
    //根据车辆id查车主
    User selectByCarId(String carId);
    //根据车辆id删除车主
    boolean deleteByCarId(String carId);
    //根据车辆id改车辆颜色
    boolean updateCarColor(String carId,String color);
    //根据车辆id改车主用户名
    boolean updateName(String carId,String userName);
    //根据车辆id改车主密码
    boolean updatePassWord(String carId,String userPassWord);
    //根据车辆id改车主卡类型
    boolean updateCardType(String carId,String cardType);
    //根据车辆id改车主卡号
    boolean updateCardNum(String carId,String cardNum);
    //根据id修改车主信息
    boolean updateByCarId(User user);

    //添加车主信息
    boolean insertUser(User user);
}
