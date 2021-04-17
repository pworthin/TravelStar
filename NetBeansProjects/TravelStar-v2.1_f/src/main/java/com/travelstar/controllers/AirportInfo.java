/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelstar.controllers;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="AirportInfo")
@RequestScoped

public class AirportInfo implements Serializable {
    
    String  terminalName;
    String locationCity;
    String locationCountry;
    String iataCode;
    
     private static final long serialVersionUID = 1L;

    public AirportInfo() {
    }

    
    
    public AirportInfo(String terminalName, String locationCity, String locationCountry, String iataCode) {
       super();
        this.terminalName = terminalName;
        this.locationCity = locationCity;
        this.locationCountry = locationCountry;
        this.iataCode = iataCode;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }
    
    
    
    
}
