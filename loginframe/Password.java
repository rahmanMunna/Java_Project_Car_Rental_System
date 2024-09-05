
package loginframe;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;


public class Password extends JFrame implements ActionListener{
    
    protected Container C;
    protected Cursor cursor ;
    protected JLabel title1,title2,currentAddress,permanentAddress,password,confirmPassword,imageLabel;
    protected JTextArea area1,area2;
    private JPasswordField pass1,pass2;
    protected JButton confirmReg;
    protected String getPass; 
    protected String id,name,phnNumber,customerDetails;
    
    
   
            
    
    public Password(String id,String name,String phnNumber,String customerDetails)
    {
        this.id=id;
        this.name=name;
        this.phnNumber=phnNumber;
        this.customerDetails=customerDetails;
        
        this.setBounds(250,100,1200,650);
        this.setTitle("Password Page");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
       
        C=this.getContentPane();
        C.setLayout(null);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        
        
        
        
        
        //initializing
        title1 = new JLabel("Location");
        title1.setOpaque(true);
        currentAddress = new JLabel("Current Address : ");
        area1 = new JTextArea();   
        permanentAddress = new JLabel("Permanent Address : ");
        area2 = new JTextArea();
        title2 = new JLabel("Create A Password");
        password = new JLabel("Password : ");
        pass1 = new JPasswordField();
        confirmPassword = new JLabel("Confirm Password : ");
        pass2 = new JPasswordField();
        confirmReg = new JButton("Confirm Registration");
        confirmReg.setCursor(cursor);
        
        
        
        title1.setBounds(240, 10, 120, 30);
        currentAddress.setBounds(70,70,200,30);
        area1.setBounds(70,100,400,60);
        permanentAddress.setBounds(70,180,230,30);
        area2.setBounds(70,210,400,60);
        title2.setBounds(190, 310, 270, 30);
        title2.setOpaque(true);
        password.setBounds(70,370,200,30);
        pass1.setBounds(70,400,250,40);
        confirmPassword.setBounds(70,450,250,30);
        pass2.setBounds(70,480,250,40);
        confirmReg.setBounds(210,550,240,35);
        
        
        
        //size and location
        title1.setFont(new Font("title",Font.BOLD,28));
        currentAddress.setFont(new Font("Arial",Font.BOLD,20));
        permanentAddress.setFont(new Font("Arial",Font.BOLD,20));
        area1.setFont(new Font("Arial",Font.PLAIN,22));
        area2.setFont(new Font("Arial",Font.PLAIN,22));
        title2.setFont(new Font("title",Font.BOLD,28));
        password.setFont(new Font("Arial",Font.BOLD,26));
        confirmPassword.setFont(new Font("Arial",Font.BOLD,24));
        pass1.setFont(new Font("Arial",Font.BOLD,22));
        pass2.setFont(new Font("Arial",Font.BOLD,22));
        confirmReg.setFont(new Font("Title",Font.BOLD,20));
        
        
        //adding image
        ImageIcon image = new ImageIcon(getClass().getResource("/Image/Password.gif"));
        imageLabel = new JLabel(image);
        imageLabel.setBounds(550,5,image.getIconWidth(),image.getIconHeight());
        
        //color
        title1.setBackground(new Color(51,153,255));
        title2.setBackground(new Color(51,153,255));
        confirmReg.setBackground(Color.red);
        C.setBackground(new Color(51,153,255));
        
        C.add(imageLabel);
        C.add(title1);
        C.add(currentAddress);
        C.add(area1);
        C.add(permanentAddress);
        C.add(area2);
        C.add(title2);
        C.add(password);
        C.add(pass1);
        C.add(confirmPassword);
        C.add(pass2);
        C.add(confirmReg);
        
        confirmReg.addActionListener(this);
        
        
     
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==confirmReg)
        {
            if(pass1.getText().equals(pass2.getText()))
            {
                getPass = pass2.getText();
               
                customerDetails+=area1.getText()+" "+area2.getText();
                
                try
                {
                    File file = new File("Data/Customer-id-"+id+".txt");
                    if(!file.exists())
                    {
                        file.createNewFile();
                    }
                    
                    FileWriter writer1 = new FileWriter(file);
                    writer1.write("Phone Number : "+phnNumber+"\n");
                    writer1.write("User Id : "+id+"\n");
                    writer1.write("PassWord : "+getPass);
                    writer1.close();
                    
                    File file2 = new File("Data/AllCustomer.txt");
                    if(!file2.exists())
                    {
                       file2.createNewFile();
                    }
                    
                    FileWriter writer2 = new FileWriter(file2,true);
                    writer2.write(customerDetails+"\n");
                    writer2.close();
                    
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
                
                JOptionPane.showMessageDialog(null, "Your Account has been Created Successfully!!!", "Confirmation Messege", JOptionPane.PLAIN_MESSAGE);
                
                new LoginFrame();
                this.setVisible(false);
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Password Doesn't Match", "Error!!", JOptionPane.WHEN_FOCUSED);
            }
        }
        
    }
    
    
}
