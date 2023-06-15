package com.example.parkingmanagesys.Pojo;

import java.util.Date;

public class Parking {
    private String carId;
    private Integer spaceId;
    private Float parkingFee;

    public Float getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(Float parkingFee) {
        this.parkingFee = parkingFee;
    }

    private Date arrivalTime;

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }
}
