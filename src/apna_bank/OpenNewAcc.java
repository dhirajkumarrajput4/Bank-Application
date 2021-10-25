/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apna_bank;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.util.Random;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
/**
 *
 * @author apptech
 */
public class OpenNewAcc extends JFrame
{
    JPanel panel;
    GridBagLayout gbl;
    GridBagConstraints gbc;
    JLabel lblFather_name,lblCustName,lbldob,lblAdress,lblcity,lblEmailID,lblPhoneNo,lblAccNo,lblscrTxt,lblCustid;
    JTextField txtFather_name,txtCustName,txtdob,txtEmailID,txtPhoneNo,txtAddress,txtAccNo,txtcity,txtCustid;
    JOptionPane jop;
    JButton btnSave,btnReset;  
    
    public OpenNewAcc()
    {
        super("Open new Account");
        Bank_Database.loadJDBCDriverAndCreateConnection();
        create();
    }
    
    private void create()
    {
        Random ran = new Random(System.currentTimeMillis());
    
        panel= new JPanel();
        
       
        gbl = new GridBagLayout();
        gbc=new GridBagConstraints();
        
        
      lblCustName=new JLabel("Candidate Name");
      lbldob=new JLabel("Date of Birth");
      lblAdress=new JLabel("Address");
      lblFather_name=new JLabel("Father's Name");
      lblcity=new JLabel("City's Name");
      lblEmailID=new JLabel("EmailID");
      lblPhoneNo=new JLabel("Phone No");
      lblAccNo=new JLabel("Account No");
      lblCustid=new JLabel("Costumer ID");
      
      
      txtCustName=new JTextField(30);
      txtdob=new JTextField(30);
      txtAddress=new JTextField(30);
      txtFather_name=new JTextField(30);
      txtcity=new JTextField(30);
      txtEmailID=new JTextField(30);
      txtPhoneNo=new JTextField(30); 
      txtAccNo=new JTextField(30);
      txtCustid=new JTextField(30);
      
      btnSave=new JButton("SAVE");        //constructor of JButton class
      btnReset=new JButton("RESET");
     
//        lblscrTxt=new JLabel("Filled Candidate's Details");
//        lblscrTxt.setFont(new Font("ARIAL BLACK",Font.BOLD,30));
       
       
       
       
      
       // panel.add(lblscrTxt);
        gbc.gridx=0;
        gbc.gridy=0;
       panel.setLayout(gbl);
       
        gbc.gridx=0;
        gbc.gridy=0;
        gbl.setConstraints(lblCustName, gbc);
        panel.add(lblCustName);                //adding panel emp Name
        gbc.gridx=1;
        gbc.gridy=0;
       gbl.setConstraints(txtCustName, gbc);
       panel.add(txtCustName);
       
       gbc.gridx=0;
       gbc.gridy=1;
       gbl.setConstraints(lbldob,gbc);
       panel.add(lbldob);
       gbc.gridx=1;
       gbc.gridy=1;
       gbl.setConstraints(txtdob,gbc);
       panel.add(txtdob);
       
       gbc.gridx=0;
       gbc.gridy=2;
       gbl.setConstraints(lblFather_name, gbc);
       panel.add(lblFather_name);
       gbc.gridx=1;
       gbc.gridy=2;
       gbl.setConstraints(txtFather_name,gbc);
       panel.add(txtFather_name);
       
       gbc.gridx=0;
       gbc.gridy=3;
       gbl.setConstraints(lblAdress,gbc);
       panel.add(lblAdress);
       gbc.gridx=1;
       gbc.gridy=3;
       gbl.setConstraints(txtAddress, gbc);
       panel.add(txtAddress);
       
       gbc.gridx=0;
       gbc.gridy=4;
       gbl.setConstraints(lblcity,gbc);
       panel.add(lblcity);
       gbc.gridx=1;
       gbc.gridy=4;
       gbl.setConstraints(txtcity, gbc);
       panel.add(txtcity);
       
       gbc.gridx=0;
       gbc.gridy=5;
       gbl.setConstraints(lblPhoneNo,gbc);
       panel.add(lblPhoneNo);
       gbc.gridx=1;
       gbc.gridy=5;
       gbl.setConstraints(txtPhoneNo,gbc);
       panel.add(txtPhoneNo);
       
       gbc.gridx=0;
       gbc.gridy=6;
       gbl.setConstraints(lblEmailID,gbc);
       panel.add(lblEmailID);
       gbc.gridx=1;
       gbc.gridy=6;
       gbl.setConstraints(txtEmailID,gbc);
       panel.add(txtEmailID);
       
       gbc.gridx=0;
       gbc.gridy=7;
       gbl.setConstraints(lblAccNo,gbc);
       panel.add(lblAccNo);
       gbc.gridx=1;
       gbc.gridy=7;
       gbl.setConstraints(txtAccNo,gbc);
       panel.add(txtAccNo);
       
       gbc.gridx=0;
       gbc.gridy=8;
       gbl.setConstraints(lblCustid,gbc);
       panel.add(lblCustid);
       gbc.gridx=1;
       gbc.gridy=8;
       gbl.setConstraints(txtCustid,gbc);
       panel.add(txtCustid);
       
       gbc.gridx=0;
       gbc.gridy=9;
       gbl.setConstraints(btnSave, gbc);
       panel.add(btnSave);
       gbc.gridx=1;
       gbc.gridy=10;
       gbl.setConstraints(btnReset, gbc);
       panel.add(btnReset);
               
       
       
       
       
           btnSave.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               if( txtCustName.getText().isEmpty() || txtdob.getText().isEmpty() || txtAddress.getText().isEmpty() || txtFather_name.getText().isEmpty() || txtEmailID.getText().isEmpty() || txtPhoneNo.getText().isEmpty()||txtcity.getText().isEmpty())
               {
                   JOptionPane.showMessageDialog(jop,"Please Fills the All fields");
               }
               else
               {
                   txtAccNo.setText(String.valueOf((ran.nextInt(1000000)+1000000000l) * (ran.nextInt(900)+100)));
                   txtCustid.setText(String.valueOf((ran.nextInt(10000000)+1000000000l) * (ran.nextInt(900)+100)));
                   
                   String name=txtCustName.getText();
                   String dob=txtdob.getText();
                   String father=txtFather_name.getText();
                   String address=txtAddress.getText();
                   String city=txtcity.getText();
                   String email=txtEmailID.getText();
                   String phone=txtPhoneNo.getText();
                   String Acc=txtAccNo.getText();
                   String cID=txtCustid.getText();
                   
               
                   
                   
                   
                 Bank_Database.OpenAccount(cID,name, dob, father, address, city, email, phone, Acc);           
                 
                 txtCustName.setText("");
                 txtdob.setText("");
                 txtFather_name.setText("");
                 txtAddress.setText("");
                 txtcity.setText("");
                 txtEmailID.setText("");
                 txtPhoneNo.setText("");
                 
                 
                  
                JOptionPane.showMessageDialog(jop,"Costumer Account No is "+Acc);
                JOptionPane.showMessageDialog(jop,"Costumer ID  is "+cID);
                 
                  // dispose();
               }
           }

          
           
       });
           
           
       btnReset.addActionListener(new ActionListener()
      {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                 txtCustName.setText("");
                 txtdob.setText("");
                 txtFather_name.setText("");
                 txtAddress.setText("");
                 txtcity.setText("");
                 txtEmailID.setText("");
                 txtPhoneNo.setText("");
                 
                 txtAccNo.setText("");
                 txtCustid.setText("");
              } 
                
        });
       panel.setBackground(Color.GREEN);
           panel.setLayout(gbl);
           setVisible(true);
           setSize(500,500);
           add(panel);
           
           
    }
}
