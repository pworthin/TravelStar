/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelstar.controllers;

import java.io.Serializable;
import java.util.Date;




import javax.enterprise.context.RequestScoped;
import javax.inject.*;

@Named(value="GeoLocation")
@RequestScoped


public class GeoLocation implements Serializable {
    
    String  departCity;
    String departState;
    String departCountry;
    String destCity;
    String destState;
    String destCountry;
    String cityCode;
    String countryCode;
    Date  departDate;
    Date returnDate;
     private static final long serialVersionUID = 1L;
    
    
    public GeoLocation() {
    }

    
    
    public GeoLocation(String departCity, String departState, String departCountry, String destCity, String destState,
            String destCountry, String cityCode, String countryCode, Date departDate, Date returnDate) {
        super();
        this.departCity = departCity;
        this.departState = departState;
        this.departCountry = departCountry;
        this.destCity = destCity;
        this.destState = destState;
        this.destCountry = destCountry;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.departDate = departDate;
        this.returnDate = returnDate;
    }

    public String getDepartCity() {
        return departCity;
    }

    public void setDepartCity(String departCity) {
        this.departCity = departCity;
    }

    public String getDepartState() {
        return departState;
    }

    public void setDepartState(String departState) {
        this.departState = departState;
    }

    public String getDepartCountry() {
        return departCountry;
    }

    public void setDepartCountry(String departCountry) {
        this.departCountry = departCountry;
    }

    public String getDestCity() {
        return destCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public String getDestState() {
        return destState;
    }

    public void setDestState(String destState) {
        this.destState = destState;
    }

    public String getDestCountry() {
        return destCountry;
    }

    public void setDestCountry(String destCountry) {
        this.destCountry = destCountry;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    
    
    
}
