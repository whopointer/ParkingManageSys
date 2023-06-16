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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;

@Controller
public class ParkingSpaceController {
        @Autowired
        private ParkingService parkingService;


    @RequestMapping("/toinsert")
    public String toEditProfile(Model model, HttpSession session){
        ParkingSpace space = (ParkingSpace)session.getAttribute("space");
        model.addAttribute("space",space);
        return "Modify_ParkingSpace";
    }

        //通过SpaceId更新用户
        @GetMapping("/updateSpace")
        public String updateSpace(HttpServletRequest request, Model model){
            String spaceId = request.getParameter("spaceId");
            String spaceType = request.getParameter("spaceType");
            String spaceState = request.getParameter("spaceState");
            try{
                String result = "";
                if(!Objects.equals(spaceType, "")) {
                    parkingService.updateSpaceType(spaceId,spaceType);
                    result += "车位类型更新成功！ ";
                }
                if(!Objects.equals(spaceState, "")) {
                    parkingService.updateSpaceState(spaceId,spaceState);
                    result += "车位状态更新成功！ ";
                }
                List<ParkingSpace> spaceList = parkingService.selectAll();
                model.addAttribute("spaces", spaceList);
                model.addAttribute("msg",result);
                return "Modify_ParkingSpace";
            }catch(Exception e){
                e.printStackTrace();
                return "Modify_ParkingSpace";
            }
        }

        //查询所有用户
        @GetMapping("/querySpace")
        public String QueryUsers(Model model) {
            List<ParkingSpace> spaceList = parkingService.selectAll();
            if(spaceList!=null){
                model.addAttribute("spaces", spaceList);
                model.addAttribute("msg","查询成功");
            }
            else {
                model.addAttribute("msg","查询失败");
            }
            return "Modify_ParkingSpace";
        }


        //插入新用户
        @RequestMapping("/saveSpace")
        public String SaveUser(HttpServletRequest request,Model model){
            Integer spaceId = parseInt(request.getParameter("spaceId"));
            String spaceType = request.getParameter("spaceType");
            String spaceState = request.getParameter("spaceState");
            try{
                ParkingSpace parking = new ParkingSpace();
                parking.setSpaceId(spaceId);
                parking.setSpaceType(spaceType);
                parking.setSpaceState(spaceState);
                parkingService.insertBySpaceId(parking);
                model.addAttribute("msg","插入成功！");
                return "Modify_ParkingSpace";
            }catch(Exception e){
                e.printStackTrace();
                model.addAttribute("msg","插入失败！");
                return "Modify_ParkingSpace";
            }
        }
    }



