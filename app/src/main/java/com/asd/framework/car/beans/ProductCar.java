package com.asd.framework.car.beans;

import java.util.Date;

import project.asd.rentalframework.core.AbstractFineStrategy;
import project.asd.rentalframework.core.AbstractProduct;
import project.asd.rentalframework.core.FixedFineStrategy;
import project.asd.rentalframework.core.ItemState;

/**
 * Created by indra on 5/19/2016.
 */
public class ProductCar extends AbstractProduct {

    private String title;
    private String subTitle;
    private String modelNumber;
    private int seats;
    private String availableStatus;
    private double dailyChargeRate;
    private String iconName;
    private Date rentalDate;
    private ItemState state;


    public ProductCar(String title, String subTitle, String modelNumber, int seats, String availableStatus,
                      double dailyChargeRate, String iconName, Date rentalDate, ItemState state) {
        this.title = title;
        this.subTitle = subTitle;
        this.modelNumber = modelNumber;
        this.seats = seats;
        this.availableStatus = availableStatus;
        this.dailyChargeRate = dailyChargeRate;
        this.iconName = iconName;
        this.rentalDate = rentalDate;
        this.state = state;
    }

    public ItemState getState() {
        return state;
    }

    public void setState(ItemState state) {
        this.state = state;
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

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public double getPrice() {
        return dailyChargeRate;
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }

    @Override
    public void setCurrentState(ItemState state) {
        this.state = state;
    }

    @Override
    public void setCheckedoutState(ItemState state) {

    }

    @Override
    public ItemState getCheckedoutState() {
        return null;
    }

    @Override
    public void setAvailableState(ItemState state) {

    }

    @Override
    public ItemState getAvailableState() {
        return null;
    }

    @Override
    public AbstractFineStrategy getFineStrategy(Date checkedOutDate) {
        this.rentalDate = checkedOutDate;
      //  return new FixedFineStrategy(5, checkedOutDate);
        return null;
    }
}
