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
public class Customer {

    String cus_id,cus_name,cus_adress,cus_contact_mobile,cus_contact_work;
    double cus_credict_level,have_to_pay,due_amount;
    public Customer(){
        
    }
     public Customer(String cus_id,String cus_name,String cus_adress,String cus_contact_mobile,String cus_contact_work,double cus_credict_level){
        this.cus_id=cus_id;
        this.cus_name=cus_name;
        this.cus_adress=cus_adress;
        this.cus_contact_mobile=cus_contact_mobile;
        this.cus_contact_work=cus_contact_work;
        this.cus_credict_level=cus_credict_level;
    }
    public Customer(String cus_name){
        this.cus_name=cus_name;
    }
    public Customer(String cus_name,String cus_id){
        this.cus_name=cus_name;
        this.cus_id=cus_id;
    }
   // getting ID
    public String getID(){
        return this.cus_id;
    }

    // setting id
    public void setID(String cus_id){
        this.cus_id = cus_id;
    }
       // getting name
    public String getName(){
        return this.cus_name;
    }

    // setting name
    public void setName(String cus_name){
        this.cus_name = cus_name;
    }
       // getting Adress
    public String getAdress(){
        return this.cus_adress;
    }

    // setting Adress
    public void setAdress(String cus_adress){
        this.cus_adress = cus_adress;
    }
       // getting Contact mobile
    public String getContactMobile(){
        return this.cus_contact_mobile;
    }

    // setting Contact Monbile
    public void setContactMobile(String cus_contact_mobile){
        this.cus_contact_mobile = cus_contact_mobile;
    }
       // getting Contact Work
    public String getContactWork(){
        return this.cus_contact_work;
    }

    // setting Contact Work
    public void setContactWork(String cus_contact_work){
        this.cus_contact_work = cus_contact_work;
    }
       // getting Credict level
    public double getCredictLevel(){
        return this.cus_credict_level;
    }

    // setting Credict Level
    public void setCredictLevel(double cus_credict_level){
        this.cus_credict_level = cus_credict_level;
    }
    
   
}