/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Udayanga
 */
public class DBHelpGRN {
    Connection conn=DBConnect.Connect();
    ResultSet rs=null;
    PreparedStatement pst=null;
    
    public int getCodeErr(tempGRN grn){
       int count=0;
        try {
            String id=grn.getSup_id();
            String sql="select count(*) from ITEM where ITEM_CODE='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()) {
                 count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage()+"/ngetErr DBHelpGRN");
        }
        return count;
    }
    public String getDescription(tempGRN grn){
       String description="";
        try {
            conn=DBConnect.Connect();
            String id=grn.getSup_id();
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
    public double getQTY(tempGRN grn){
        double stock=0;
        try {
            String id=grn.getSup_id();
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
    public double getUnitPrice(tempGRN grn){
        double unit_price=0;
        try {
            String id=grn.getSup_id();
            String sql="select COST from ITEM where ITEM_CODE='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                unit_price=rs.getDouble(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return unit_price;
   }
    public double getCost(tempGRN grn){
        double cost=0;
        try {
            String id=grn.getSup_id();
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
    public double getMaxDisc(tempGRN grn){
        double disc=0;
        try {
            String id=grn.getSup_id();
            String sql="select MAX_DISCOUNT from ITEM where ITEM_CODE='"+id+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                disc=rs.getDouble(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return disc;
   }
    public void addTempGRN(tempGRN grn){
         try{
            String item_code=grn.getItem_code();
            String discription=grn.getDiscription();
            double qty=grn.getQty();
            double unit_price=grn.getUnit_price();
            double cost=grn.getCost();
            double max_disc=grn.getMax_disc();
            double amount=grn.getAmount();
            String sql="insert into TEMP_GRN(ITEM_CODE,DISCRIPTION,QTY,UNIT_PRICE,COST,MAX_DISC,AMOUNT)values(?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,item_code);
            pst.setString(2,discription);
            pst.setDouble(3,qty);
            pst.setDouble(4,unit_price);
            pst.setDouble(5,cost);
            pst.setDouble(6, max_disc);
            pst.setDouble(7, amount);
            pst.execute();
            JOptionPane.showMessageDialog(null, "adedd to temp GRN");
              
          }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage()+"/nUpdate item table");
          }
    }
    public ResultSet getTempAll(){
          
        ResultSet rs=null;
        try {
            conn=DBConnect.Connect();
            String sql="select * from TEMP_GRN";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
      }
    public double getTotalAmount(){
         double amount=0;
         conn=DBConnect.Connect();
        try {
            String sql="select SUM(AMOUNT)AS total from TEMP_GRN";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                amount=rs.getDouble(1);
                // System.out.println("balance"+balance);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       
        return amount;
     }
    public ResultSet getItemTableByCode(tempGRN grn){
          
        ResultSet rs12=null;
        try {
            conn=DBConnect.Connect();
            String sql="select * from ITEM WHERE ITEM_CODE=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, grn.getSearch());
            rs12=pst.executeQuery();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs12;
      }
    public ResultSet getItemTableByName(tempGRN grn){
          
        ResultSet rs11=null;
        try {
            conn=DBConnect.Connect();
            String sql="select * from ITEM WHERE dicription=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, grn.getSearch());
            rs11=pst.executeQuery();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs11;
      }
}
