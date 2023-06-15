package com.example.parkingmanagesys.Controller;

import com.example.parkingmanagesys.Pojo.BookingInformation;
import com.example.parkingmanagesys.Pojo.ParkingHistory;
import com.example.parkingmanagesys.Pojo.ParkingSpace;
import com.example.parkingmanagesys.Pojo.User;
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
    @RequestMapping("/toMyOrder")
    public String toMyOder(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        BookingInformation bookingInformation = userService.selectBookingInformationByCarId(user.getCarId());
        List<ParkingHistory>parkingHistoryList = userService.selectAllParkingHistoryByCarId(user.getCarId());
        model.addAttribute("bookingInformation",bookingInformation);
        model.addAttribute("parkingHistoryList",parkingHistoryList);
        model.addAttribute("user",user);
        return  "Query_order";
    }
    @RequestMapping("/myOder")
    public String myOrder(HttpSession session,HttpServletRequest servletRequest ,Model model){
        User user = (User) session.getAttribute("user");
        BookingInformation bookingInformation = null;
        List<ParkingHistory> parkingHistoryList = userService.selectAllParkingHistoryByCarId(user.getCarId());
        Integer bookingId = null;
        if(servletRequest.getParameter("BookingId")!=null){
            bookingId = Integer.valueOf(servletRequest.getParameter("BookingId"));
            BookingInformation temp = userService.selectBookingInfoByBookingId(bookingId);
            if(temp!=null&&temp.getBookingState().equals("未进行")){
                userService.deleteBookingInformationByBookingId(bookingId);
                model.addAttribute("msg","删除成功");
            }
            else {
                model.addAttribute("msg","删除失败，请重新输入订单号");
            }
        }
        else {
            model.addAttribute("msg","删除失败，请重新输入订单号");
        }
        bookingInformation = userService.selectBookingInformationByCarId(user.getCarId());
        if(bookingInformation!=null){
            model.addAttribute("bookingInformation",bookingInformation);
        }
        if(parkingHistoryList!=null){
            model.addAttribute("parkingHistoryList",parkingHistoryList);
        }
        model.addAttribute("user",user);
        return "Query_order";
    }
}
