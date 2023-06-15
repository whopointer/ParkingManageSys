package com.example.parkingmanagesys.Pojo;

import java.util.Date;

public class ParkingHistory {
    private String carId;
    private float parkingFee;
    private float bookingFee;
    private Integer spaceId;
    private Date bookingTime;
    private Date departureTime;
    private Integer bookingId;

    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setParkingFee(float parkingFee) {
        this.parkingFee = parkingFee;
    }

    public float getParkingFee() {
        return parkingFee;
    }

    public void setBookingFee(float bookingFee) {
        this.bookingFee = bookingFee;
    }

    public float getBookingFee() {
        return bookingFee;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

}
