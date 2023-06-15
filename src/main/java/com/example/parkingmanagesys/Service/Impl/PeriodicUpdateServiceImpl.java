package com.example.parkingmanagesys.Service.Impl;

import com.example.parkingmanagesys.DAO.BookingInformationMapper;
import com.example.parkingmanagesys.Pojo.BookingInformation;
import com.example.parkingmanagesys.Service.PeriodicUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PeriodicUpdateServiceImpl implements PeriodicUpdateService {
    @Autowired
    private BookingInformationMapper bookingInformationMapper;

    @Scheduled(cron = "0/20 * * * * *")
    public void deleteByBookingId() {
        List<BookingInformation> bookingInformationList=bookingInformationMapper.selectAll();
        for(int i=0;i<bookingInformationList.size();i++){
            long diff=new Date().getTime()-bookingInformationList.get(i).getBookingTime().getTime();
            long hour=diff%(1000*24*60*60)/(1000*60*60);
            if(hour>=2){
                bookingInformationMapper.deleteByBookingId(bookingInformationList.get(i).getBookingId());
            }
        }
    }
}
