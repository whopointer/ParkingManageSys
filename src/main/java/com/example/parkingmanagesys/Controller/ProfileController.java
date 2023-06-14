package com.example.parkingmanagesys.Controller;

import com.example.parkingmanagesys.Pojo.User;
import com.example.parkingmanagesys.Service.LoginService;
import com.example.parkingmanagesys.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ProfileController {
   @Autowired
   private UserService userService;
    @RequestMapping("/profile")
    public String toProfile(Model model, HttpSession session){
        User user=(User)session.getAttribute("user");
        model.addAttribute("user",user);
        return "profile";
    }
    @RequestMapping("/toEditProfile")
    public String toEditProfile(Model model,HttpSession session){
        User user=(User)session.getAttribute("user");
        model.addAttribute("user",user);
        return "edit-profile";
    }
    @RequestMapping("/editProfile")
    public String editProfile(User user,Model model,HttpSession session){
        User user1 = (User)session.getAttribute("user");
        if(user.getUserName()!=""||user.getColor()!=""){
            if(user.getUserName()!="")user1.setUserName(user.getUserName());
            if(user.getColor()!="")user1.setColor(user.getColor());
            if(userService.updateByCarId(user1)){
                model.addAttribute("user",user1);
                return "profile";
            }
        }
        model.addAttribute("user",user1);
        return "profile";
    }
}
