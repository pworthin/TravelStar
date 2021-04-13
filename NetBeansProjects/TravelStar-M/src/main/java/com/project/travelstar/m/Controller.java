
package com.project.travelstar.m;

import javax.faces.webapp.FacesServlet;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.*;

import javax.inject.Named;

@Named
@RequestScoped
public class Controller implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public Controller(){}
    // ------------------//
    @Inject
    GeoLocation geoProfile ;
    @Inject
    AirportInfo airportPorfile;
    Connection SQLconnect;
   
    ResultSet  IATAdp, IATAdst;
    
    
    
    String dpCity = geoProfile.getDepartCity();
    String dpCountry = geoProfile.getDepartCountry();
    String dstCity = geoProfile.getDestCity();
    String dstCountry = geoProfile.getDestCountry();
    
    String dpRESTsend;
    String dstRESTsend;
     ArrayList<String> codeList = new ArrayList<String>();
     ArrayList<String>codeListDST = new ArrayList<String>();
    
    //----------------// 
    
    public void  SQLconnect() throws SQLException  {
            try{
                 Statement query = SQLconnect.createStatement();
                 
            IATAdp = query.executeQuery("SELECT DISTINCT airport_codes.iataCode from travel_info.airport_codes"
                    + " WHERE location='" + dpCity + "' and country='" + dpCountry +"'");
            IATAdst = query.executeQuery("SELECT DISTINCT airport_codes.iataCode from travel_info.airport_codes"
                    + " WHERE location='" + dstCity + "' and country='" + dstCountry +"'");
            int listCountDP= IATAdp.getFetchSize();
            int listCountDST = IATAdst.getFetchSize();
                   
            
            
              if(listCountDP == 0 || listCountDST == 0)
            {
               System.out.println("Error: No resutls found");
               
            }
              if(listCountDP == 1)
              {
                   dpRESTsend = IATAdp.getString("iataCode");
              }
              else if(listCountDP > 1){
                
                  while(IATAdp.next()){
                    codeList.add(IATAdp.getString("iataCode") );                 
                        
                  }
                    
              }
              
              if(listCountDST == 1){
               dstRESTsend = IATAdst.getString("iataCode");
              }
              else if(listCountDP > 1){
                while(IATAdst.next()){
                    codeListDST.add(IATAdst.getString("iataCode"));
                }
              }
         
            }
             catch (SQLException e){
                 
                 System.out.println("Unrecoverable error. System aborted");
                 e.printStackTrace();
             }
            
            
                
            
            }

    public String getDpRESTsend() {
        return dpRESTsend;
    }

    public String getDstRESTsend() {
        return dstRESTsend;
    }

    public ArrayList<String> getCodeList() {
        return codeList;
    }

    public ArrayList<String> getCodeListDST() {
        return codeListDST;
    }

   
           
            
        
        
    
    
}
