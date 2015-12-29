/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardware;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Udayanga
 */
public class  DBConnect  {
    Connection conn=null;
    public static Connection Connect(){
     //   ?zeroDateTimeBehavior=convertToNull [root on Default schema
        try{
           String host="jdbc:mysql://localhost:3306/hardware";
           String uName="root";
           String uPass="root";
           Connection conn=DriverManager.getConnection(host, uName, uPass);
 
          
            return conn;
        }
        catch(Exception e){
            System.out.println(e.getMessage()); 
           return null;}
    }
    
    
    
}
