/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apna_bank;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
        



/**
 *
 * @author apptech
 */
public class  Wellcome_Screen extends JFrame 
{
    JPanel panel;
    JMenuBar menuBar;
    JMenu masterMenu,editMenu,helpMenu,menuExit;
    JMenuItem openAcc,cashDiposit,cashWithrough,checkBall,modifyAcc;
    JLabel lblWellText;
    
     public Wellcome_Screen()
     {
         super("WELLCOME TO APNA BANK");
           
         addComponents();
     }
     
     private void addComponents()
     {
         panel=new JPanel();
         
        lblWellText=new JLabel("WELCOME TO APNA BANK APPLICATION");
        lblWellText.setFont(new Font("ARIAL BLACK",Font.BOLD,40));
        
        menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.green);
        
       
        masterMenu=new JMenu("MASTER");
        masterMenu.setFont(new Font("ARIAL BLACK",Font.BOLD,16));
        editMenu=new JMenu("EDIT");
        editMenu.setFont(new Font("ARIAL BLACK",Font.BOLD,16));
        helpMenu=new JMenu("HELP");
        helpMenu.setFont(new Font("ARIAL BLACK",Font.BOLD,16));
        helpMenu.addMouseListener(new MouseListener(){
            @Override
           public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(rootPane,"Costumer Application to add and edit costumer detail and their Account Details","Costumer Application Massage",JOptionPane.INFORMATION_MESSAGE);
                
                
                
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
              
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            }
            
            
            
        });
        menuExit=new JMenu("QUIT");
        menuExit.setFont(new Font("ARIAL BLACK",Font.BOLD,16));
setFont(new Font("ARIAL BLACK",Font.BOLD,16));
menuExit.addMouseListener(new MouseListener()
          {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) 
            {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) 
            {
              
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
              
            }
            
            
        });
        menuBar.add(masterMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        menuBar.add(menuExit);
        
        
        openAcc=new JMenuItem("OPEN NEW ACCOUNT");
        openAcc.setBackground(Color.red);
        openAcc.setFont(new Font("ARIAL BLACK",Font.PLAIN,16));
        openAcc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                OpenNewAcc obj =new OpenNewAcc();
            
            }
            
            
        });
        
        masterMenu.add(openAcc);
        
        
        cashDiposit=new JMenuItem("CASH DIPOSIT");
        cashDiposit.setBackground(Color.red);
        cashDiposit.setFont(new Font("ARIAL BLACK",Font.PLAIN,16));
        cashDiposit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                Cash_Diposit obj=new Cash_Diposit();
            
            }
            
            
        });
          masterMenu.add(cashDiposit);
        
        cashWithrough=new JMenuItem("CASH WITHDROW");
        cashWithrough.setBackground(Color.red);
        cashWithrough.setFont(new Font("ARIAL BLACK",Font.PLAIN,16));
        cashWithrough.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
            
                   Cash_Withdrow obj=new Cash_Withdrow();
            }
            
            
        });
        masterMenu.add(cashWithrough);
        
        
        checkBall=new JMenuItem("CHECK BALLANCE");
        checkBall.setBackground(Color.red);
        checkBall.setFont(new Font("ARIAL BLACK",Font.PLAIN,16));
        checkBall.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
            
                Check_Bal obj=new Check_Bal();
            
            }
            
            
        });
        masterMenu.add(checkBall);
                  
        
        modifyAcc=new JMenuItem("MODIFY ACCOUNT");
        modifyAcc.setBackground(Color.red);
        modifyAcc.setFont(new Font("ARIAL BLACK",Font.PLAIN,16));
        modifyAcc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
            
            
            }
            
            
        });
        editMenu.add(modifyAcc);
        panel.add(lblWellText);
        panel.setBackground(Color.orange);
        add(panel);          
     
    
     Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width,screenSize.height);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     
    
    
     }
}
