package com.example.parkingmanagesys.Service.Impl;

import com.example.parkingmanagesys.DAO.ParkingMapper;
import com.example.parkingmanagesys.Service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {
    @Autowired
    private ParkingMapper parkingMapper;
    @Override
    public double calVacancyRate() {
        return parkingMapper.count()/20;
    }
}
