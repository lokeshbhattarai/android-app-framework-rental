package com.asd.framework.car.beans;

import java.io.Serializable;

/**
 * Created by indra on 5/18/2016.
 */
public class Product implements Serializable{

    private String title;
    private String subTitle;
    private String modelNumber;
    private int seats;
    private String availableStatus;
    private double dailyChargeRate;
    private String iconName;

    public Product(String title, String subTitle, String modelNumber, int seats,
                   String availableStatus, double dailyChargeRate, String iconName) {
        this.title = title;
        this.subTitle = subTitle;
        this.modelNumber = modelNumber;
        this.seats = seats;
        this.availableStatus = availableStatus;
        this.dailyChargeRate = dailyChargeRate;
        this.iconName = iconName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(String availableStatus) {
        this.availableStatus = availableStatus;
    }

    public double getDailyChargeRate() {
        return dailyChargeRate;
    }

    public void setDailyChargeRate(double dailyChargeRate) {
        this.dailyChargeRate = dailyChargeRate;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}
