package com.example.parkingmanagesys.Controller;

import com.example.parkingmanagesys.DAO.UsersMapper;
import com.example.parkingmanagesys.Pojo.User;
import com.example.parkingmanagesys.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }
    @PostMapping("/login")
    public String login(User user, Model model,HttpSession session) {
        User user1 = loginService.selectByUserPhoneAndUserPassWord(user);

        // 这里可以进行登录验证逻辑
        if (user.getUserPhone().equals("admin") && user.getUserPassWord().equals("123456")) {
            // 登录成功
            model.addAttribute("msg", "登录成功");
            return "index";  // 重定向到首页或其他页面
        } else if (user1 != null){
            model.addAttribute("msg", "登录成功");
            session.setAttribute("user",user1);
            model.addAttribute("user",user1);
            return "user-index";
        }
        else {
            model.addAttribute("msg", "用户名或密码错误，请重新登录");
            return "login";
        }
    }
    @RequestMapping("/userIndex")
    public String toUserIndex(Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        model.addAttribute("user",user);
        return "user-index";
    }
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
}
