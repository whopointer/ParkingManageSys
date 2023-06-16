package com.example.parkingmanagesys.Controller;


import com.example.parkingmanagesys.Pojo.User;
import com.example.parkingmanagesys.Service.LoginService;
import com.example.parkingmanagesys.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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


    //通过carId更新用户
    @GetMapping("/update")
    public String updateUser(HttpServletRequest request,Model model){
        String carId = request.getParameter("carId");
        String color = request.getParameter("Color");
        String userName = request.getParameter("userName");
        String userPassWord = request.getParameter("userPassWord");
        String cardType = request.getParameter("cardType");
        String cardNum = request.getParameter("cardNum");
        try{
            String result = "";
            if(color!="") {
                userService.updateCarColor(carId,color);
                result += "颜色更新成功！ ";
            }
            if(userName!="") {
                userService.updateName(carId,userName);
                result += "用户名更新成功！ ";
            }
            if(userPassWord!="") {
                userService.updatePassWord(carId,userPassWord);
                result += "密码更新成功！ ";
            }
            if(cardType!="") {
                userService.updateCardType(carId,cardType);
                result += "停车卡类型更新成功！ ";
            }
            if(cardNum!="") {
                userService.updateCardNum(carId,cardNum);
                result += "停车卡卡号更新成功！ ";
            }
            List<User> userList = userService.selectAll();
            model.addAttribute("users", userList);
            model.addAttribute("msg",result);
            return "Modify_UsersInformation";
        }catch(Exception e){
            e.printStackTrace();
            return "Modify_UsersInformation";
        }
    }

    //查询所有用户
    @GetMapping("/query")
    public String QueryUsers(Model model) {
        List<User> userList = userService.selectAll();
        if(userList!=null){
            model.addAttribute("users", userList);
            model.addAttribute("msg","查询成功");
        }
        else {
            model.addAttribute("msg","查询失败");
        }
        return "Modify_UsersInformation";
    }


    //插入新用户
    @RequestMapping ("/save")
    public String SaveUser(HttpServletRequest request,Model model){
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
            model.addAttribute("msg","插入成功！");
            return "Modify_UsersInformation";
        }catch(Exception e){
            e.printStackTrace();
            model.addAttribute("msg","插入失败！");
            return "Modify_UsersInformation";
        }
    }

    //通过carId删除用户
    @PostMapping("/del")
    public String delUser(@RequestParam("deleteId") String carId,Model model) {
            List<User> userList = userService.selectAll();
            model.addAttribute("users", userList);
        try{
            userService.deleteByCarId(carId);
            model.addAttribute("users", userList);
            model.addAttribute("msg","删除成功");
            return "Modify_UsersInformation";
        }catch(Exception e){
            e.printStackTrace();
            model.addAttribute("users", userList);
            model.addAttribute("msg","删除失败该用户有未删除的订单");
            return "Modify_UsersInformation";
        }
    }
}


