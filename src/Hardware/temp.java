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
public class temp {
    String item_code,discription,invoice_number,cus_id,state;
    double qty,unit_price,cost,item_discount,amount,total_amount,total_discount,number_of_item,total_without_discount,cheq_num,stock;
    String date,bank;
    
    public temp(){
        
    }
    public temp(String item_code, String discription,double qty,double unit_price, double cost,double item_discount,double amount,String invoice_number,String cus_id,String date,double total_without_discount){
        this.amount=amount;
        this.cost=cost;
        this.discription=discription;
        this.item_code=item_code;
        this.qty=qty;
        this.unit_price=unit_price;
        this.invoice_number=invoice_number;
        this.cus_id=cus_id;
        this.date=date;
        this.total_without_discount=total_without_discount;
    }
    public temp(String cus_id,String date,String state,double total_without_discount,double total_discount,double total_amount,double number_of_item,double qty,double cheq_num,String bank){
        this.cus_id=cus_id;
        this.date=date;
        this.state=state;
        this.total_without_discount=total_without_discount;
        this.total_discount=total_discount;
        this.total_amount=total_amount;
        this.number_of_item=number_of_item;
        this.qty=qty;
        this.cheq_num=cheq_num;
        this.bank=bank;
        
        this.date=date;
    }
    public temp(String item_code,double stock){
        this.item_code=item_code;
        this.stock=stock;
    }
    public temp(String id , String invoice_number){
        this.invoice_number= invoice_number;
        this.cus_id=id;
    }
    public void setStock(double stock) {
        this.stock = stock;
    }
   

    public double getStock() {
        return stock;
    }
    public double getCheq_num() {
        return cheq_num;
    }

    public void setCheq_num(double cheq_num) {
        this.cheq_num = cheq_num;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

  

    public double getNumber_of_item() {
        return number_of_item;
    }

    public void setNumber_of_item(double number_of_item) {
        this.number_of_item = number_of_item;
    }

    public double getTotal_without_discount() {
        return total_without_discount;
    }

    public void setTotal_without_discount(double total_without_discount) {
        this.total_without_discount = total_without_discount;
    }
    
    public String getItemCode(){
       return this.item_code;
   }
   public void setItemCode(String item_code){
       this.item_code=item_code;
   }
   /**
     * @return ********************************************************************/
       public String getDiscription(){
       return this.discription;
   }
   public void setDiscription(String discription){
       this.discription=discription;
   }
   /**
     * @return **********************************************************************/
       public double getQty(){
       return this.qty;
   }
   public void setQty(double qty){
       this.qty=qty;
   }
   /**
     * @return *********************************************************************************/
       public double getUnitPrice(){
       return this.unit_price;
   }
   public void setUnitPrice(double unit_price){
       this.unit_price=unit_price;
   }
   /**
     * @return ****************************************************************************/
       public double getCost(){
       return this.cost;
   }
   public void setCost(double cost){
       this.cost=cost;
   }
   /**
     * @return *******************************************************************************/
       public double getItemDisc(){
       return this.item_discount;
   }
   public void setItemDisc(double item_discount){
       this.item_discount=item_discount;
   }
   /**
     * @return **************************************************************************/
       public double getAmount(){
       return this.amount;
   }
   public void setAmount(double amount){
       this.amount=amount;
   }
   public String getInvoiceNumber(){
       return this.invoice_number;
   }
   public void setInvoiceNumber(String invoice_number){
       this.invoice_number=invoice_number;
   }
   public String getCusID(){
       return this.cus_id;
   }
   public void setCusID(String cus_id){
       this.cus_id=cus_id;
   }
   public String getDate(){
       return this.date;
   }

    /**
     *
     * @param date
     */
    public void setDate(String date){
       this.date=date;
   }
    public String getState(){
       return this.state;
   }
   public void setState(String state){
       this.state=state;
   }
   public double getTotalAmount(){
       return this.total_amount;
   }
   public void setTotalAmount(double total_amount){
       this.total_amount=total_amount;
   }
      public double getTotalDiscount(){
       return this.total_discount;
   }
   public void setTotalDiscount(double total_discount){
       this.total_discount=total_discount;
   }
    public double getPayAmount(){
       return this.total_amount;
   }
   public void setPayAmount(double pay_amount){
       this.total_amount=pay_amount;
   }
    public double getWithoutDisc(){
       return this.total_without_discount;
   }
   public void setWithoutDisc(double without_disc){
       this.total_without_discount=without_disc;
   }

}
