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

public class Item {
   String id;
   double qty;

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
   public Item(){
       
   }
   public Item(String id){
       this.id=id;
   }
   public String getID(){
       return this.id;
   }
   public void setID(String id){
       this.id=id;
   }
}
