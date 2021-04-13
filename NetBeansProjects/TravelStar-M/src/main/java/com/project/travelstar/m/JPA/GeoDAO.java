/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.travelstar.m.JPA;


import javax.enterprise.context.RequestScoped;
import javax.inject.*;
import com.project.travelstar.m.GeoLocation;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import javax.persistence.criteria.*;

@Named
@RequestScoped


public class GeoDAO implements Serializable{
    
    @Inject
    GeoLocation geoProfile;
    
   
    
    EntityManager em;
    CriteriaBuilder criteria = em.getCriteriaBuilder();
    
    
    
    
    
    
    String dpRESTsend;
    String dstRESTsend;
    int  dpresultCount = 0;
    int  dstresultCount = 0;
     ArrayList<String> codeList = new ArrayList<String>();
     ArrayList<String>codeListDST = new ArrayList<>();

    public GeoDAO() {
    }
    
     
     
     
     
    
    public void setDPiata(String dpCity, String dpCountry){
//    dpCity = geoProfile.getDepartCity();
//    dpCountry = geoProfile.getDepartCountry();
        
      
        Query query = em.createNamedQuery("AirportCodes.findByIataCode");
        Query countQ = em.createNamedQuery("Airport.duplicateCheck");
       query.setParameter("location", dpCity);
       query.setParameter("country", dpCountry);
       countQ.setParameter("location", dpCity);
       countQ.setParameter("country", dpCountry);
       
       
        dpresultCount = Integer.parseInt(countQ.toString());
     
       if(dpresultCount == 0)
       {
           System.out.println("Error: Location not found");
       }
       else if(dpresultCount ==1){
           dpRESTsend = query.getResultList().toString();
       }
       else if(dpresultCount > 1){
            while(!query.getResultList().isEmpty()){
                codeList.add(query.getResultList().iterator().next().toString());
            }
       
       }
           
       }
   public void setDSTiata(String dstCity, String dstCountry){
//        dstCity = geoProfile.getDestCity();
//     dstCountry = geoProfile.getDestCountry();
   
        Query query = em.createNamedQuery("AirportCodes.findByIataCode");
        Query countQ = em.createNamedQuery("Airport.duplicateCheck");
       query.setParameter("location", dstCity);
       query.setParameter("country", dstCountry);
       countQ.setParameter("location", dstCity);
       countQ.setParameter("country", dstCountry);
       
       
        dstresultCount = Integer.parseInt(countQ.toString());
     
       if(dstresultCount == 0)
       {
           System.out.println("Error: Location not found");
       }
       else if(dstresultCount ==1){
           dstRESTsend = query.getResultList().toString();
       }
       else if(dstresultCount > 1){
            while(!query.getResultList().isEmpty()){
                codeListDST.add(query.getResultList().iterator().next().toString());
            }
       
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
      
    public String ListTestDP(){
        if  (dpresultCount ==1){
         return   this.getDpRESTsend();
        }
        else{
         return   this.getCodeList().toString();
        }
        
    }
    
    public String ListTestDST(){
    
        if(dstresultCount ==1){
            return this.getDstRESTsend();
        }
        else{
            return this.getCodeListDST().toString();
        }
    }
    
        
    
    }
    
    

