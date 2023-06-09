package com.example.parkingmanagesys.Pojo;

import java.util.Date;

public class ParkingSpace {
    private Integer spaceId;
    private String spaceType;
    private String spaceState;
    private String realArrivalTime;
    private String realBookingTime;
    private String parkingCarId;
    private String bookingCarId;


    public String getBookingCarId() {
        return bookingCarId;
    }

    public void setBookingCarId(String bookingCarId) {
        this.bookingCarId = bookingCarId;
    }

    public String getParkingCarId() {
        return parkingCarId;
    }

    public void setParkingCarId(String parkingCarId) {
        this.parkingCarId = parkingCarId;
    }
    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceState() {
        return spaceState;
    }

    public void setSpaceState(String spaceState) {
        this.spaceState = spaceState;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    public String getRealArrivalTime() {
        return realArrivalTime;
    }

    public void setRealArrivalTime(String realArrivalTime) {
        this.realArrivalTime = realArrivalTime;
    }

    public String getRealBookingTime() {
        return realBookingTime;
    }

    public void setRealBookingTime(String realBookingTime) {
        this.realBookingTime = realBookingTime;
    }




}
