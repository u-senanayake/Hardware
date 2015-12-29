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
public class EdidCustomerHealp {
    String cus_id,name,cus_adress,cus_contact_mobile,cus_contact_work;
    double cus_credict_level,have_to_pay,due_amount;  
    public EdidCustomerHealp(){
        
    }
    public EdidCustomerHealp(String name){
        this.name=name;
    }
    public EdidCustomerHealp(String cus_id,String name,double cus_credict_level ,double have_to_pay, double due_amount){
        this.cus_id=cus_id;
        this.name=name;
        this.cus_credict_level=cus_credict_level;
        this.have_to_pay=have_to_pay;
        this.due_amount=due_amount;
    }
   // getting ID
    public String getID(){
        return this.cus_id;
    }

    // setting id
    public void setID(String cus_id){
        this.cus_id = cus_id;
    }
    public String getName(){
        return this.name;
    }

    // setting name
    public void setName(String name){
        this.name = name;
    }
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
    public double getHaveToPay(){
        return have_to_pay;
    }
    public void setHaveToPay(double have_to_pay){
        this.have_to_pay=have_to_pay;
    }
    public double getDueAmount(){
        return due_amount;
    }
    public void setDueAmount(double due_amount){
        this.due_amount=due_amount;
    }
    
}
