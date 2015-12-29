/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardware;

/**
 *
 * @author Udayanga
 */
public class Supply {
    String sup_id,sup_name,sup_adress,sup_contact_mobile,sup_contact_work;
    double sup_credict_level;  
    
    public Supply(){
        
    }
     public Supply(String sup_id,String sup_name,String sup_adress,String sup_contact_mobile,String sup_contact_work,double sup_credict_level){
        this.sup_id=sup_id;
        this.sup_name=sup_name;
        this.sup_adress=sup_adress;
        this.sup_contact_mobile=sup_contact_mobile;
        this.sup_contact_work=sup_contact_work;
        this.sup_credict_level=sup_credict_level;
    }
     public Supply(String name){
         this.sup_name=name;
     }
    
   // getting ID
    public String getID(){
        return this.sup_id;
    }

    // setting id
    public void setID(String sup_id){
        this.sup_id = sup_id;
    }
       // getting name
    public String getName(){
        return this.sup_name;
    }

    // setting name
    public void setName(String sup_name){
        this.sup_name = sup_name;
    }
       // getting Adress
    public String getAdress(){
        return this.sup_adress;
    }

    // setting Adress
    public void setAdress(String sup_adress){
        this.sup_adress = sup_adress;
    }
       // getting Contact mobile
    public String getContactMobile(){
        return this.sup_contact_mobile;
    }

    // setting Contact Monbile
    public void setContactMobile(String sup_contact_mobile){
        this.sup_contact_mobile = sup_contact_mobile;
    }
       // getting Contact Work
    public String getContactWork(){
        return this.sup_contact_work;
    }

    // setting Contact Work
    public void setContactWork(String sup_contact_work){
        this.sup_contact_work = sup_contact_work;
    }
       // getting Credict level
    public double getCredictLevel(){
        return this.sup_credict_level;
    }

    // setting Credict Level
    public void setCredictLevel(double sup_credict_level){
        this.sup_credict_level = sup_credict_level;
    }
   
}