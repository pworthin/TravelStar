/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelstar.interface_main;

//import javax.ejb.Stateless;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.travelstar.controllers.GeoLocation;
import javax.inject.*;
import com.project.travelstar.m.JPA.*;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;


@Named
@RequestScoped


public class OpenSession implements Serializable {

    @Inject
GeoLocation location;
  
    @Inject
    Connection connection;
    
    @Inject
     GeoDAO dataAccess;     
            
            
 String departureCity; 
String departureCountry;
String destinationCity;
String destinationCountry;
 
String IATAcodeDP;
String IATAcodeDEST;

String departDate;
String returnDate;

HttpResponse<JsonNode> response;

    public OpenSession() {
    }


   
    
   public void CreateGeoProfile() {
 departureCity = location.getDepartCity();
 departureCountry = location.getDepartCountry();
  destinationCity = location.getDestCity();
  destinationCountry = location.getDepartCountry();
  
   dataAccess.setDPiata(departureCity, departureCountry);
   dataAccess.setDSTiata(destinationCity, destinationCountry);
   
  IATAcodeDP =  dataAccess.ListTestDP();
  IATAcodeDEST =  dataAccess.ListTestDST();
  
  
   departDate = location.getDepartDate().toString();
   returnDate =location.getReturnDate().toString();
   
   
   connection.setValues(IATAcodeDP, IATAcodeDEST, departDate, returnDate);
   
   
     
  
  
   }

    public String getIATAcodeDP() {
        return IATAcodeDP;
    }

    public String getIATAcodeDEST() {
        return IATAcodeDEST;
    }

  
   
   
    
}
