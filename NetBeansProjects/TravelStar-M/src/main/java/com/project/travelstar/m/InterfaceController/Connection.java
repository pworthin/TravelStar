/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.travelstar.m.InterfaceController;

import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import java.io.Serializable;
import javax.ejb.Stateless;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


@Stateless


public class Connection implements Serializable{
    
   
    String val1, val2, date1, date2;
    String charset = "UTF-8";
    
    
    String host = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/";
    String x_rapidapi_host ="skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";
    String x_rapidapi_key = "e331105ffcmsh324e49fbcc43c2ep16cc36jsnc7515aa02550";
    HttpResponse <JsonNode> response;
    String responseString;

    public Connection() {
    }
    
    public void setValues(String val1, String val2, String date1, String date2){
        this.val1 = val1;
        this.val2 = val2;
        this.date1 = date1;
        this.date2 = date2;
    };
    
    
    
    public void requestGet(String val1, String val2, String date1, String date2) throws Exception {
        try{
     val1  = String.format("s=%s", URLEncoder.encode(val1, charset));
     val2 = String.format("s=%s", URLEncoder.encode(val2, charset));
      response = Unirest.get(host + "" + val1 + "/"  + val2 + "/"+ date1 + "?inboundpartialdate=" + date2 +"")
              .header("x-rapidapi-host", x_rapidapi_host)
              .header("x-rapidapi-key", x_rapidapi_key)
              .asJson();
      System.out.println(response.getStatus());
      System.out.println(response.getHeaders().get("Content-Type"));
      
      
      Gson formatter = new GsonBuilder().setPrettyPrinting().create();
               JsonParser parser = new JsonParser();
               JsonElement js = parser.parse(response.getBody().toString());
               
                responseString = formatter.toJson(js);
              
              System.out.println(responseString);
        }   
        
        catch (Exception e){
            
                    e.printStackTrace();
            
        }
        
    
    }

    public HttpResponse<JsonNode> getResponse() {
        return response;
    }

    public String getResponseString() {
        return responseString;
    }
    
    
    
    
}
