package com.example.parkingmanagesys.Controller;


import com.example.parkingmanagesys.Pojo.User;
import com.example.parkingmanagesys.Service.LoginService;
import com.example.parkingmanagesys.Service.UserService;
import com.example.parkingmanagesys.util.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private LoginService loginService;
    @GetMapping("/save")
    public String SaveUser(HttpServletRequest request){
        String carid = request.getParameter("carId");
        String Color = request.getParameter("Color");
        String userName = request.getParameter("userName");
        String userPassWord = request.getParameter("userPassWord");
        String userPhone = request.getParameter("userPhone");
        String cardType = request.getParameter("cardType");
        String cardNum = request.getParameter("cardNum");
        User user = new User(carid,Color,userName,userPassWord,userPhone,cardType,cardNum);
        loginService.insertUser(user);
        return "Save_Successfully";
        }
}
