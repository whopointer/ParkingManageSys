package com.example.parkingmanagesys.Controller;


import com.example.parkingmanagesys.Pojo.User;
import com.example.parkingmanagesys.Service.LoginService;
import com.example.parkingmanagesys.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    //插入新用户
    @GetMapping("/save")
    public String SaveUser(HttpServletRequest request){
        String carid = request.getParameter("carId");
        String Color = request.getParameter("Color");
        String userName = request.getParameter("userName");
        String userPassWord = request.getParameter("userPassWord");
        String userPhone = request.getParameter("userPhone");
        String cardType = request.getParameter("cardType");
        String cardNum = request.getParameter("cardNum");
        try{
            User user = new User(carid,Color,userName,userPassWord,userPhone,cardType,cardNum);
            loginService.insertUser(user);
            return "Save_Successfully";
        }catch(Exception e){
            e.printStackTrace();
            return "Save_Failed";
        }
    }
    //通过carId更新用户
    @RequestMapping ("/update")
    public String toUpdate(){
        return "Update_UsersInformation";
    }

    @GetMapping("/DoUpdate")
    public String updateUser(HttpServletRequest request){
        String carId = request.getParameter("carId");
        String color = request.getParameter("Color");
        String userName = request.getParameter("userName");
        String userPassWord = request.getParameter("userPassWord");
        String cardType = request.getParameter("cardType");
        String cardNum = request.getParameter("cardNum");
        try{
            if(color!="") {userService.updateCarColor(carId,color);}
            if(!userName.isEmpty()) {userService.updateName(carId,userName);}
            if(!userPassWord.isEmpty()) {userService.updatePassWord(carId,userPassWord);}
            if(!cardType.isEmpty()) {userService.updateCardType(carId,cardType);}
            if(!cardNum.isEmpty()) {userService.updateCardNum(carId,cardNum);}
            return "Save_Successfully";
        }catch(Exception e){
            e.printStackTrace();
            return "Save_Failed";
        }
    }


    //查询所有用户
    @GetMapping("/query")
    public String QueryUsers(Model model) {
        List<User> userList = userService.selectAll();
        model.addAttribute("users", userList);
        return "View_UsersInformation";
    }

    //通过carId删除用户
    @RequestMapping("/delete")
    public String toDelte(){
        return "Delete_UsersInformation";
    }

    @PostMapping("/del")
    public String delUser(@RequestParam("deleteId") String carId) {
        try{
            userService.deleteByCarId(carId);
            return "Del_successfully";
        }catch(Exception e){
            e.printStackTrace();
            return "Del_Failed";
        }
    }




}

