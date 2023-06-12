package com.example.parkingmanagesys.Controller;

import com.example.parkingmanagesys.Pojo.ParkingSpace;
import com.example.parkingmanagesys.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/parking")
public class AdminParkingController {
    @Autowired
    private ParkingService parkingService;

    //查询所有车位信息
    @RequestMapping("/selectParking")
    public String selectParking(Model model){
        List<ParkingSpace> parkingSpaceList=parkingService.selectAll();
        model.addAttribute("parkingSpaceList",parkingSpaceList);
        return "View_ParkingSpace";
    }
}
