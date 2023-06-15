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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class QueryController {
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private UserService userService;
    @RequestMapping("/userViewParking")
    public String toQuery(Model model){
        List<ParkingSpace> parkingSpaceList = parkingService.selectAll();
        model.addAttribute("parkingSpaceList",parkingSpaceList);
        return "user-ViewParkingSpace";
    }
    @RequestMapping("/bookSpace")
    public String bookSpace(@ModelAttribute BookingInformation bookingInformation,Model model,HttpSession session) throws ParseException {
        User user=(User)session.getAttribute("user");
        bookingInformation.setCarId(user.getCarId());
        List<ParkingSpace> parkingSpaceList = parkingService.selectAll();
        if(parkingSpaceList.get(bookingInformation.getSpaceId()-1).getSpaceState().compareTo("空闲")!=0){
            model.addAttribute("msg","该车位不为空闲,请重新预定");
            model.addAttribute("parkingSpaceList",parkingSpaceList);
            return "user-ViewParkingSpace";
        }
        else {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            bookingInformation.setBookingTime(ft.parse(bookingInformation.getRealBookingTime().replaceFirst("T", " ")));
            userService.updateBookingInformationByCarId(bookingInformation);
            model.addAttribute("msg","预定成功");
            model.addAttribute("parkingSpaceList",parkingSpaceList);
            return "user-ViewParkingSpace";
        }
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
