package com.example.parkingmanagesys.Controller;

import com.example.parkingmanagesys.Pojo.BookingInformation;
import com.example.parkingmanagesys.Pojo.ParkingSpace;
import com.example.parkingmanagesys.Service.ParkingService;
import com.example.parkingmanagesys.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QueryController {
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private UserService userService;
    @RequestMapping("/userViewParking")
    public ModelAndView toQuery(Model model){
        List<ParkingSpace> parkingSpaceList = parkingService.selectAll();
        model.addAttribute("parkingSpaceList",parkingSpaceList);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("parkingSpaceList",parkingSpaceList);
        modelAndView.setViewName("user-ViewParkingSpace");
        return modelAndView;
    }
    @GetMapping("/bookSpace")
    public String bookSpace(BookingInformation bookingInformation, List<ParkingSpace> parkingSpaceList,Model model){
        if(parkingSpaceList.get(bookingInformation.getSpaceId()-1).getSpaceState()!="空闲") {
            model.addAttribute("msg","该车位不是空闲车位");
            return "user-ViewParkingSpace";
        }
        else userService.updateBookingInformationByCarId(bookingInformation);
        return "user-ViewParkingSpace";
    }
}
