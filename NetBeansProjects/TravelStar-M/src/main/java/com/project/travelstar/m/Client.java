/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.travelstar.m;


import java.io.Serializable;
import javax.ejb.EJB;
import com.project.travelstar.m.InterfaceController.OpenSession;
import com.project.travelstar.m.InterfaceController.Connection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value="Client")
@RequestScoped






public class Client implements Serializable{

    @EJB
    private static Connection opInterface;
    
    
    
    
    
    public void sessionBegin(){
    
        
                OpenSession profiler = new OpenSession();
                
                profiler.CreateGeoProfile();
                opInterface.getResponse();
                System.out.println(opInterface.getResponseString());
                
            
                  
                        
    
    }
    
}
