package com.example.parkingmanagesys.Pojo;

import java.sql.Time;

public class ParkingSpace {
    private Integer spaceId;
    private String spaceType;
    private String spaceState;
    private String userName;
    private Time arrivalTime;//记录车辆已经入场
private String realArrivalTime;
    private String realBookingTime;
private Time bookingTime;
private String CarId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }
}
