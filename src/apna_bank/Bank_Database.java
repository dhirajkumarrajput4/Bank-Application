/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apna_bank;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author apptech
 */
public class Bank_Database {
    
    static Connection con;
    static Statement stmt;
    static PreparedStatement pstmt,pstmt1,pstmt2;
    static ResultSet rs,rs1;
   static JOptionPane jop;
   
   
       
     public static void loadJDBCDriverAndCreateConnection()
    {
         try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Bank","sa","password@123");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex);
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
    }
     
     public static void OpenAccount(String cID,String name,String dob,String father,String address,String city,String email,String phone,String Acc)
     {
           try
         {
            pstmt=con.prepareStatement("insert into Customer values(?,?,?,?,?,?,?,?)");
            pstmt.setString(1,cID);
            pstmt.setString(2,name);
            pstmt.setString(3,dob);
            pstmt.setString(4,father);
            pstmt.setString(5, address);
            pstmt.setString(6,city);
            pstmt.setString(7,email);
            pstmt.setString(8,phone);
            
            pstmt.executeUpdate();
            pstmt.close();
            
            pstmt1=con.prepareStatement("insert into Account (AccountNo,CustomerID) values(?,?)");
            pstmt1.setString(1, Acc);
            pstmt1.setString(2,cID);
            
            pstmt1.executeUpdate();
            pstmt1.close();
             
           
            
            JOptionPane.showMessageDialog(jop,"Successfully Saved");
            
         }
         
       catch(SQLException ex)
       {
         System.out.println(ex);
     }
     
  
     }
     
  public static ResultSet getAcc(String acc)
  {
      
          try
       {
           pstmt2=con.prepareStatement("SELECT CustomerID from Account where AccountNO=?");
           pstmt2.setString(1,acc);
           
           rs=pstmt2.executeQuery();
           rs.next();
           
           pstmt1=con.prepareStatement("select Name from Customer where CustomerID=?");
           pstmt1.setString(1,rs.getString("CustomerID"));
           rs1=pstmt1.executeQuery();
           
           
       }
       catch(SQLException ex)
       {
          JOptionPane.showMessageDialog(jop,"No Customer Found in database for selected customer ID"+ex);
       }
       return rs1;
  }
  
  public static void cashDipo(double ball,String Acc)
  {
      try
      {
          pstmt1=con.prepareStatement("insert into cashDiposit(AccountNo,DepositAmount) values(?,?)");
          pstmt1.setString(1,Acc);
          pstmt1.setDouble(2,ball);
          pstmt1.executeUpdate();
          pstmt2=con.prepareStatement("Select AccountBalance from Account where AccountNo=?");
          pstmt2.setString(1,Acc);
          rs=pstmt2.executeQuery();
          rs.next();
          pstmt=con.prepareStatement("update Account set AccountBalance=(?) where AccountNo=(?)");
          ball=rs.getDouble("AccountBalance")+ball;
          pstmt.setDouble(1,ball);
          pstmt.setString(2,Acc);
          pstmt.executeUpdate();
         
      }
  
   catch(SQLException ex)
   {
       System.out.println(ex);
   }
  
}
  
  public static void cashWithdrow(double balance,String acNo)
  {
      try
      {
          pstmt1=con.prepareStatement("insert into cashWithdrow(AcNo,WithdrowlAmount) values(?,?)");
          pstmt1.setString(1,acNo);
          pstmt1.setDouble(2,balance);
          pstmt1.executeUpdate();
          pstmt2=con.prepareStatement("Select AccountBalance from Account where AccountNo=?");
          pstmt2.setString(1,acNo);
          rs=pstmt2.executeQuery();
          rs.next();    //move cursor one step ahead by default beahind
          pstmt=con.prepareStatement("update Account set AccountBalance=(?) where AccountNo=(?)");
          balance=rs.getDouble("AccountBalance")-balance;
          pstmt.setDouble(1,balance);
          pstmt.setString(2,acNo);
          pstmt.executeUpdate();
         
      }
  
   catch(SQLException ex)
   {
       System.out.println(ex);
   }
  
  }
  public static ResultSet getBal(String acNo)
  {
          try          

       {
           pstmt=con.prepareStatement("SELECT AccountBalance from Account where AccountNO=?");
           pstmt.setString(1,acNo);
           
           rs=pstmt.executeQuery();
         
           
          
           
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
       return rs1;
  }
      
  }
  

