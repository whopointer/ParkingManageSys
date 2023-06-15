package com.example.parkingmanagesys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class ParkingManageSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingManageSysApplication.class, args);
    }

}
