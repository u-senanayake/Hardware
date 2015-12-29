/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardware;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Udayanga
 */
public class DBHelp {
    Connection conn;
    ResultSet rs=null;
    PreparedStatement pst=null;
    
    /*******************************************************************************************************************
                                        SUPPLY database help
     * @param supply
    **********************************************************************************************************************/
   public void addSupply(Supply supply){
       conn=DBConnect.Connect();
       try{
            String sql="insert into SUPPLY(ID,SUP_NAME,SUP_ADRESS,SUP_CONTACT_MOBILE,SUP_CONTACT_WORK,SUP_CREDICT_LEVEL)values(?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,supply.getID() );
            pst.setString(2,supply.getName());
            pst.setString(3,supply.getAdress());
            pst.setString(4,supply.getContactMobile());
            pst.setString(5,supply.getContactWork());
            pst.setDouble(6,supply.getCredictLevel());
            pst.execute();
            JOptionPane.showMessageDialog(null, "saved");

        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());}
        finally{
                try{
                    rs.close();
                    pst.close();
                }
                catch(Exception e){}
            }
   }
   public String getSupplyID(Supply supply){
       String ID="";
        String NAME=supply.getName();
       conn=DBConnect.Connect();
       try{
        String sql="select * from SUPPLY where sup_name='"+NAME+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
         if(rs.next()){
                ID=rs.getString("ID"); 
         }
       }
       catch (Exception exp){
           System.out.println(exp.getMessage());
       }
      return ID;
      
   }
   
   /*******************************************************************************************************************
                                        CUSTOMER database help
     * @param costomer
    **********************************************************************************************************************/
   public void addCustomer(Customer costomer){
       conn=DBConnect.Connect();
       try{
            String sql="insert into CUSTOMER(CUS_ID,CUS_NAME,CUS_ADRESS,CUS_CONTACT_MOBILE,CUS_CONTACT_WORK,CUS_CREDICT_LEVEL)values(?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,costomer.getID() );
            pst.setString(2,costomer.getName());
            pst.setString(3,costomer.getAdress());
            pst.setString(4,costomer.getContactMobile());
            pst.setString(5,costomer.getContactWork());
            pst.setDouble(6,costomer.getCredictLevel());
//pst.setString(4, ((JTextField)date.getDateEditor().getUiComponent()).getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "saved");

        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());}
        finally{
                try{
                    rs.close();
                    pst.close();
                }
                catch(Exception e){}
            }
   }
   public void UpdateCustomer(Customer customer){
       
      
       
       try{
           String _id=customer.getID();
       String _name=customer.getName();
       String _adress=customer.getAdress();
       String _mobile=customer.getContactMobile();
       String _work=customer.getContactWork();
       Double _credict_level=customer.getCredictLevel();
     //  System.out.println(_id);
            String sql="update CUSTOMER set CUS_NAME ='"+_name+"'where CUS_ID=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, _id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Succsed");
       }
       catch(Exception exp){
           JOptionPane.showMessageDialog(null, exp.getMessage());
       }
           
   }
   public String getCustomerID(Customer customer){
       String ID="";
        String NAME=customer.getName();
       conn=DBConnect.Connect();
       try{
        String sql="select * from CUSTOMER where cus_name='"+NAME+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
         if(rs.next()){
                ID=rs.getString("CUS_ID"); 
         }
       }
       catch (Exception exp){
           System.out.println(exp.getMessage());
       }
      return ID;
      
   }
   public ResultSet getCustomerAllDetails(Customer customer){
       String id=customer.getID();
       ResultSet rst=null;
       //get customer details and return 
     try{
        String sql="select * from CUSTOMER where CUS_ID='"+id+"'";
        pst=conn.prepareStatement(sql);
        rst=pst.executeQuery();
         
       }
       catch (Exception exp){
           JOptionPane.showMessageDialog(null, exp.getMessage());
       }
     return rst;
   }
   public double getCustomerCredictAmount(Customer customer){
       double balance=0;
        try {
            String id=customer.getID();
            String sql="select SUM(PAY_AMOUNT)AS total from CUS_INVOICE where CUS_ID='"+id+"' and STATE='CREDICT'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                balance=rs.getDouble(1);
                 System.out.println("balance"+balance);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       
        return balance;
   }
   public double getCustomerCredictLimit(Customer customer){
       double limit=0;
        try {
            String id=customer.getID();
            String sql="select CUS_CREDICT_LEVEL from CUSTOMER where CUS_ID='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                limit=rs.getDouble(6);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return limit;
   }
    public String getCustomerName(Customer customer){
       String name="";
        try {
            String id=customer.getID();
            System.out.println(id);
            String sql="select CUS_NAME from CUSTOMER where CUS_ID='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                name=rs.getString(2);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return name;
   }
   public void DeleteCustomer(Customer customer){
       String id=customer.getID();
        try {
            
            System.out.println(id);
            String qry="delete from CUSTOMER where CUS_ID='"+id+"'";
            pst=conn.prepareStatement(qry);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Success");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
   }
   public int getNextInvoiceNumber(){
       int id=0;
       try{
           String qry="SELECT sup_invoice_number FROM sup_invoice_seq ORDER BY sup_invoice_number DESC LIMIT 1";
           pst=conn.prepareStatement(qry);
           rs=pst.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
            
       }
       catch(Exception ex){
           System.out.println(ex.getMessage());
       }
       return id;
   }
     /*******************************************************************************************************************
                                        ITEM database help
     * @param item
    **********************************************************************************************************************/
   public String sup_id(Item item){
       String sup_id="";
        try {
            conn=DBConnect.Connect();
            String id=item.getID();
           // System.out.println(id);
            String sql="select SUP_ID from ITEM where ITEM_CODE='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                sup_id=rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return sup_id;
   }
    public String description(Item item){
       String description="";
        try {
            conn=DBConnect.Connect();
            String id=item.getID();
           // System.out.println(id);
            String sql="select DICRIPTION from ITEM where ITEM_CODE='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                description=rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return description;
   }
   public double cost(Item item){
       double cost=0;
        try {
            conn=DBConnect.Connect();
            String id=item.getID();
           // System.out.println(id);
            String sql="select COST from ITEM where ITEM_CODE='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                cost=rs.getDouble(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cost;
   }
   public double sell_price(Item item){
       double sell_price=0;
        try {
            conn=DBConnect.Connect();
            String id=item.getID();
           // System.out.println(id);
            String sql="select SELL_PRICE from ITEM where ITEM_CODE='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                sell_price=rs.getDouble(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return sell_price;
   }
    public double max_discount(Item item){
       double max_discount=0;
        try {
            conn=DBConnect.Connect();
            String id=item.getID();
           // System.out.println(id);
            String sql="select MAX_DISCOUNT from ITEM where ITEM_CODE='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                max_discount=rs.getDouble(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return max_discount;
   }
     public double stock(Item item){
       double stock=0;
        try {
            conn=DBConnect.Connect();
            String id=item.getID();
           // System.out.println(id);
            String sql="select STOCK from ITEM where ITEM_CODE='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                stock=rs.getDouble(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return stock;
   }
    public int getCodeErr(Item item){
       int count=0;
        try {
             conn=DBConnect.Connect();
            String id=item.getID();
            String sql="select count(*) from ITEM where ITEM_CODE='"+id+"'";
            pst=conn.prepareStatement(sql);
          //  pst.setString(1, id);
            rs=pst.executeQuery();
            if(rs.next()) {
                 count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHelp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    
     /*******************************************************************************************************************
                                        TEMP database help
     * @param tmp
    **********************************************************************************************************************/
    public void addDataTemp(temp tmp){
       
       try{
            conn=DBConnect.Connect();
            System.out.println(tmp.getAmount());
           String  date=tmp.getDate();
            String sql="insert into TEMP(ITEM_CODE,DISCRIPTION,QTY,UNIT_PRICE,COST,ITEM_DISCOUNT,AMOUNT,INVOICE_NUMBER,CUS_ID,DATE,WITHOUT_DISC)values(?,?,?,?,?,?,?,?,?,?,?)";
            System.out.println(tmp.getAmount());
            pst=conn.prepareStatement(sql);
            pst.setString(1,tmp.getItemCode() );
            pst.setString(2,tmp.getDiscription());
            pst.setDouble(3,tmp.getQty());
            pst.setDouble(4,tmp.getUnitPrice());
            pst.setDouble(5,tmp.getCost());
            pst.setDouble(6,tmp.getItemDisc());
            pst.setDouble(7, tmp.getAmount());
            pst.setString(8, tmp.getInvoiceNumber());
            pst.setString(9, tmp.getCusID());
            pst.setString(10,date);
            pst.setDouble(11, tmp.getWithoutDisc());
            pst.execute();
            JOptionPane.showMessageDialog(null, "adedd to Temp");

        }

        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage());}
        finally{
                try{
                    rs.close();
                    pst.close();
                }
                catch(Exception e){}
            }
    }
    public ResultSet viewTable(){
        ResultSet rs=null;
        try {
            conn=DBConnect.Connect();
            String sql="select * from TEMP";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
    }
    public void insertTempToAllInvoice(){
         try{
            conn=DBConnect.Connect();
            String sql="INSERT INTO ALL_INVOICE(AMOUNT,COST,DISCRIPTION,ITEM_CODE,ITEM_DISCOUNT,NUMBER,QTY,UNIT_PRICE,INVOICE_NUMBER,CUS_ID,DATE,WITHOUT_DISCOUNT) (SELECT AMOUNT,COST,DISCRIPTION,ITEM_CODE,ITEM_DISCOUNT,NUMBER,QTY,UNIT_PRICE,INVOICE_NUMBER,CUS_ID,DATE,WITHOUT_DISC  FROM TEMP);";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added to all invoice");

        }

        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage());}
        finally{
                try{
                    rs.close();
                    pst.close();
                }
                catch(Exception e){}
            }
    }
    public void removeTemp(){
        try {
            conn=DBConnect.Connect();
            String sql="TRUNCATE TABLE TEMP";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Temp table removed");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
     public void addToCusInvoice(temp tmp){
          try{
            conn=DBConnect.Connect();
            String sql="insert into CUS_INVOICE(CUS_ID,BILL_DATE,STATE,TOTAL_AMOUNT,TOTAL_BILL_DISCOUNT,PAY_AMOUNT,NUMBER_OF_ITEM,QTY,CHEQ_NUMBER,BANK)values(?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,tmp.getCusID());
            pst.setString(2,tmp.getDate());
            pst.setString(3,tmp.getState());
            pst.setDouble(4,tmp.getTotal_without_discount());
            pst.setDouble(5,tmp.getTotalDiscount());
            pst.setDouble(6, tmp.getTotalAmount());
            pst.setDouble(7, tmp.getNumber_of_item());
            pst.setDouble(8, tmp.getQty());
            pst.setDouble(9, tmp.getCheq_num());
            pst.setString(10, tmp.getBank());
            pst.execute();
            JOptionPane.showMessageDialog(null, "adedd to cus invoice");

        }

        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e.getMessage());}
        finally{
                try{
                    rs.close();
                    pst.close();
                }
                catch(Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}

        }
    }
     public double getTotalQTY(){
         double balance=0;
         conn=DBConnect.Connect();
        try {
            String sql="select SUM(QTY)AS total from TEMP";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                balance=rs.getDouble(1);
                // System.out.println("balance"+balance);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       
        return balance;
     }
          public double getTotaAmount(){
         double balance=0;
         conn=DBConnect.Connect();
        try {
            String sql="select SUM(amount)AS total from TEMP";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                balance=rs.getDouble(1);
                // System.out.println("balance"+balance);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       
        return balance;
     }
           public double getTotalWithoutDiscount(){
         double balance=0;
         conn=DBConnect.Connect();
        try {
            String sql="select SUM(WITHOUT_DISC)AS total from TEMP";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                balance=rs.getDouble(1);
                // System.out.println("balance"+balance);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       
        return balance;
     }
      public ResultSet getTempAll(){
          
        ResultSet rs=null;
        try {
            conn=DBConnect.Connect();
            String sql="select * from TEMP";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
      }
      public int getNumberItem(){
       int count=0;
        try {
             conn=DBConnect.Connect();
            String sql="select count(*) from TEMP ";
            pst=conn.prepareStatement(sql);
          //  pst.setString(1, id);
            rs=pst.executeQuery();
            if(rs.next()) {
                 count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHelp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
      public void updateItemTable(temp tmp){
          try{
            String id=tmp.getItemCode();
            double stock=tmp.getStock();
            conn=DBConnect.Connect();
            String sql="update ITEM set STOCK =STOCK-"+stock+" where ITEM_CODE=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Item table updated");
              
          }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage()+"/nUpdate item table");
          }
      }
    public void updateTempCustomerName(temp tmp){
        try{
            conn=DBConnect.Connect();
            String id=tmp.getCusID();
            String sql="update TEMP set CUS_ID =?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "temp table cus_id upadated");
              
          }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage()+"/nUpdate item table");
          }
    }
    public void updateTempInvoiceNumber(temp tmp){
        try{
            conn=DBConnect.Connect();
            String invoice_number=tmp.getInvoiceNumber();
            String sql="update TEMP set INVOICE_NUMBER =?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, invoice_number);
            pst.execute();
            JOptionPane.showMessageDialog(null, "temp table invoice number  updated");
              
          }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage()+"/nUpdate item table");
          }
    }
}
