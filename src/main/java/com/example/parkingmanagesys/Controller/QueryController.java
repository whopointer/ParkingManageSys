package com.example.parkingmanagesys.Controller;

import com.example.parkingmanagesys.Pojo.ParkingSpace;
import com.example.parkingmanagesys.Service.ParkingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class QueryController {
    @Autowired
    private ParkingService parkingService;
    @RequestMapping("/userViewParking")
    public String toQuery(Model model, HttpSession session){
        List<ParkingSpace> parkingSpaceList = parkingService.selectAll();
        model.addAttribute("parkingSpaceList",parkingSpaceList);
        return "user-ViewParkingSpace";
    }
    @GetMapping("/bookSpace")
    public String bookSpace(HttpServletRequest request){
        return "user-ViewParkingSpace";
    }
}
