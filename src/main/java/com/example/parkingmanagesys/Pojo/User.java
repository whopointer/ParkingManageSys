package com.example.parkingmanagesys.Pojo;

public class User {
    private String carId;
    private String Color;
    private String userName;
    private String userPassWord;
    private String userPhone;
    private String cardType;
    private String cardNum;

    public User(String carId, String color, String userName, String userPassWord, String userPhone, String cardType, String cardNum) {
        this.carId = carId;
        Color = color;
        this.userName = userName;
        this.userPassWord = userPassWord;
        this.userPhone = userPhone;
        this.cardType = cardType;
        this.cardNum = cardNum;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
