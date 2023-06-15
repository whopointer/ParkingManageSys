package com.example.parkingmanagesys.Controller;


import com.example.parkingmanagesys.Pojo.User;
import com.example.parkingmanagesys.Service.LoginService;
import com.example.parkingmanagesys.Service.UserService;
import com.example.parkingmanagesys.util.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
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

    //查询所有用户
    @GetMapping("/query")
    public String QueryUsers(Model model) {
        List<User> userList = userService.selectAll();
        model.addAttribute("users", userList);
        return "View_UsersInformation";
    }


}

