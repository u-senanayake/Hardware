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
public class tempGRN {
    String sup_id;
    String item_code, discription; double qty,unit_price,cost,max_disc,amount;
    String Search;
    
    public tempGRN(){
        
    }

    public void setSearch(String Search) {
        this.Search = Search;
    }

    public String getSearch() {
        return Search;
    }
    public tempGRN(String sup_id){
        this.sup_id=sup_id;
        this.Search=sup_id;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setMax_disc(double max_disc) {
        this.max_disc = max_disc;
    }

    public String getItem_code() {
        return item_code;
    }

    public String getDiscription() {
        return discription;
    }

    public double getQty() {
        return qty;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public double getCost() {
        return cost;
    }

    public double getMax_disc() {
        return max_disc;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    public tempGRN(String item_code,String discription,double qty,double unit_price,double cost,double max_disc,double amount){
        this.item_code=item_code;
        this.discription=discription;
        this.qty=qty;
        this.unit_price=unit_price;
        this.cost=cost;
        this.max_disc=max_disc;
        this.amount=amount;
    }
    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }
    
    
}
