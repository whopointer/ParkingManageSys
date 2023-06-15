package com.example.parkingmanagesys.Pojo;

import java.util.Date;

public class BookingInformation {
    private Integer bookingId;
    private Integer spaceId;
    private String carId;
    private Date bookingTime;
    private Date arrivalTime;
    private float bookingFee;
    private String realBookingTime;
    private String realArrivalTime;
    private String bookingState;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
    public Integer getSpaceId() {
        return spaceId;
    }
    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public float getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(float bookingFee) {
        this.bookingFee = bookingFee;
    }

    public String getRealBookingTime() {
        return realBookingTime;
    }

    public void setRealBookingTime(String realBookingTime) {
        this.realBookingTime = realBookingTime;
    }

    public String getRealArrivalTime() {
        return realArrivalTime;
    }

    public void setRealArrivalTime(String realArrivalTime) {
        this.realArrivalTime = realArrivalTime;
    }
    public void setBookingState(String bookingState){this.bookingState = bookingState;}
    public String getBookingState(){return bookingState;}
}
