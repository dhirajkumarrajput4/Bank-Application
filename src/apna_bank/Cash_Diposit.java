/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apna_bank;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
/**
 *
 * @author apptech
 */
public class Cash_Diposit extends JFrame
{
    JLabel lblUser_Name,lblAccNo,lbldob,lblDipoBall,lbltxt;
    JTextField txtUser_Name,txtAccNo,txtdob,txtDipoBall;
     JButton btncheck,btnDiposit,btnCancel;
    JPanel panel;
    GridBagLayout gbl;
    GridBagConstraints gbc;
    JOptionPane jop;
    ResultSet rs;
    public Cash_Diposit()
    {
        super("Cash Diposit");
        Bank_Database.loadJDBCDriverAndCreateConnection();
        Create();
        
         
         
    }
    private void Create()
    {
         Font f=new Font("ARIAL BLACK",Font.ROMAN_BASELINE,16);
        
        
        lblAccNo=new JLabel("Account No");
        lblUser_Name=new JLabel("User_Name");
        lblUser_Name.setFont(f);
        lblAccNo.setFont(f);
        
        txtUser_Name=new JTextField(20);
        txtUser_Name.disable();
        txtAccNo=new JTextField(20);
        txtUser_Name.setFont(f);
        txtAccNo.setFont(f);
        txtUser_Name.setBackground(Color.yellow);
        txtAccNo.setBackground(Color.yellow);
        
        
        lbldob=new JLabel("Date of Birth");
        lbldob.setFont(f);
        lblDipoBall=new JLabel("Diposit Amount");
        lblDipoBall.setFont(f);
        lblAccNo.setFont(f);
        
        Font fn=new Font("ARIAL BLACK",Font.HANGING_BASELINE,18);
         
         lbltxt=new JLabel("Account Details  ::");
         lbltxt.setForeground(Color.red);
         lbltxt.setFont(fn);
        
        txtdob=new JTextField(20);
        txtDipoBall=new JTextField(20);
        txtdob.setFont(f);
        txtDipoBall.setFont(f);
        txtdob.setBackground(Color.yellow);
        txtDipoBall.setBackground(Color.yellow);
        
        btncheck=new JButton("Check IN");
        btncheck.setFont(f);
        btnCancel=new JButton("Cancel");
        btnCancel.setFont(f);
        btnDiposit=new JButton("Deposit");
        btnDiposit.setFont(f);
        
        
        gbl = new GridBagLayout();
        gbc=new GridBagConstraints();
        
        panel=new JPanel();
        panel.setLayout(gbl);
        
        gbc.gridx=0;
        gbc.gridy=0;
        gbl.setConstraints(lblAccNo, gbc);
        panel.add(lblAccNo);
        gbc.gridx=1;
        gbc.gridy=0;
        gbl.setConstraints(txtAccNo, gbc);
        panel.add(txtAccNo);
        
        gbc.gridx=2;
        gbc.gridy=0;
        gbl.setConstraints(btncheck, gbc);
        panel.add(btncheck);
        
        

         gbc.gridx=0;
         gbc.gridy=1;
         gbl.setConstraints(lbltxt, gbc);
         panel.add(lbltxt);
        
       
       
         
//        gbc.gridx=0;
//        gbc.gridy=2;
//        gbl.setConstraints(lblAccNo, gbc);
//        panel.add(lblAccNo);
//        gbc.gridx=1;
//        gbc.gridy=2;
//        gbl.setConstraints(txtAccNo, gbc);
        
        gbc.gridx=0;
        gbc.gridy=3;
        gbl.setConstraints(lblUser_Name, gbc);
        panel.add(lblUser_Name);
        gbc.gridx=1;
        gbc.gridy=3;
        gbl.setConstraints(txtUser_Name, gbc);
        panel.add(txtUser_Name);
        
    ;
        
        gbc.gridx=0;
        gbc.gridy=4;
        gbl.setConstraints(lblDipoBall, gbc);
        panel.add(lblDipoBall);
        gbc.gridx=1;
        gbc.gridy=4;
        gbl.setConstraints(txtDipoBall, gbc);
        panel.add(txtDipoBall);
        
        gbc.gridx=0;
        gbc.gridy=5;
        gbl.setConstraints(btnDiposit, gbc);
        panel.add(btnDiposit);
        gbc.gridx=1;
        gbc.gridy=5;
        gbl.setConstraints(btnCancel, gbc);
        panel.add(btnCancel);
        
        
        
          btncheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
             if(txtAccNo.getText().isEmpty())
            {
                
             JOptionPane.showMessageDialog(jop,"Please Enter the Account Number");
            }
            else
             {
              String acc=txtAccNo.getText();
              
               rs=Bank_Database.getAcc(acc);
               try
               {
               if(rs.next())
               {
               txtUser_Name.setText(rs.getString("Name"));
               }
               else
               {
                   JOptionPane.showMessageDialog(rootPane,"No Customer Found in database for selected customer ID","MODIFY CUSTOMER DETAILS SCREEN MESSAGE",JOptionPane.INFORMATION_MESSAGE);
               }
               rs.close();
               }
               catch(SQLException ex)
               {
                    JOptionPane.showMessageDialog(rootPane,"No Customer Found in database for selected customer ID"+ex,"MODIFY CUSTOMER DETAILS SCREEN MESSAGE",JOptionPane.INFORMATION_MESSAGE);
                    
               }
            }
        
        
        }});
        
       btnDiposit.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               if(txtDipoBall.getText().isEmpty())
               {
                   JOptionPane.showMessageDialog(jop,"Please input a amount");
               }

               else
               {
                   
                                     
                   double ball=Double.parseDouble(txtDipoBall.getText());
                   String Acc= txtAccNo.getText();
                   
                   Bank_Database.cashDipo(ball,Acc);
                   
                   JOptionPane.showMessageDialog(jop,"Your Account credited by Rs."+ball);
                   txtUser_Name.setText("");
                   txtDipoBall.setText("");
                   txtAccNo.setText("");
                   
               }
           }  
       });
       
       btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int a=JOptionPane.showConfirmDialog(jop,"Are you sure?");
                if(a==JOptionPane.YES_OPTION)
                {
                    dispose();
                } 
                } 
                
        });
       
       
         panel.setLayout(gbl);
       
         add(panel);    
  setVisible(true);
  setSize(500,500);
  
              
             
            
        
      
        
}
    
}
