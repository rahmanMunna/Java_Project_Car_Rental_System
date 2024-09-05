

package Admin;
import loginframe.*;
import Classes.*;
import java.awt.Color;
import java.io.*;
import java.util.Scanner;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;


public class AuthorityDashBoard extends JFrame implements ActionListener {
    
    protected Container C;
    protected Cursor cursor;
    protected Car car;
    protected JLabel welcome,myLabel,totalCustomer,totalCar,totalTrans;
    protected JButton garage,customerDetails,changePass,logout,transaction;
    protected ImageIcon img1;
    protected Scanner sc,sc2;
    protected int count1,count2;
    public AuthorityDashBoard()
    {
        this.setBounds(300,100,1000,700);
        this.setTitle("Authority_DashBoard");
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        C=this.getContentPane();
        C.setLayout(null);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        count1 = 0;
        count2=0;
        
        try
        {
            File file= new File("Data/AllCustomer.txt");
            File file2= new File("Data/AllTransactionDetails.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
            sc = new Scanner(file);
            while(sc.hasNext())
            {
                sc.nextLine();
                count1++;
            }
            sc.close();
			
			if(!file2.exists())
			{
				file2.createNewFile();
			}
            sc2 = new Scanner(file2);
            while(sc2.hasNext())
            {
                sc2.nextLine();
                count2++;
                
            }
            sc2.close();
            
        }
        
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
        
        
        
        
        String x =Integer.toString(count1);
		String y =Integer.toString(count2);
        
        totalCustomer = new JLabel(x);
        totalCar= new JLabel("6");
        totalTrans = new JLabel(y);
        
        
        
        //Adding image
        img1 = new ImageIcon(getClass().getResource("/Image/Authority.jpg"));
       
       
        
        myLabel = new JLabel(img1);
        garage = new JButton("Goto Garage");
        customerDetails = new JButton("Customer Details");
        transaction = new JButton("Transaction Details");
        logout = new JButton("Logout");
        
        
        
        //initializing
        welcome = new JLabel("Management Page");
        garage.setCursor(cursor);
        customerDetails.setCursor(cursor);
//        changePass= new JButton("Change Password");
//        changePass.setCursor(cursor);
        logout.setCursor(cursor);
        transaction.setCursor(cursor);
        
        
        //set absoulate SIze
        myLabel.setBounds(0,0,img1.getIconWidth(),img1.getIconHeight());
       // welcome.setBounds(240,20,250,40);
        garage.setBounds(100,100,350,200);
        totalCar.setBounds(160,130,40,30);
        customerDetails.setBounds(510,100,350,200);
        totalCustomer.setBounds(160,130,40,30);
        logout.setBounds(510,410,350,200);
        transaction.setBounds(100,410,350,200);
        totalTrans.setBounds(160,130,40,40);
        
        
        
        //Set Font
        //welcome.setFont(new Font("Title",Font.BOLD,25));
       
        garage.setFont(new Font("Arial",Font.BOLD,25));
        
        //changePass.setFont(new Font("Arial",Font.BOLD,19));
        logout.setFont(new Font("Arial",Font.BOLD,25));
        customerDetails.setFont(new Font("Arial",Font.BOLD,25));
        transaction.setFont(new Font("Arial",Font.BOLD,25));
        totalCustomer.setFont(new Font("Arial",Font.BOLD,23));
        totalCar.setFont(new Font("Arial",Font.BOLD,23));
        totalTrans.setFont(new Font("Arial",Font.BOLD,23));
        
        
        
        //set COlor
        garage.setBackground(new Color(153,51,253));
        customerDetails.setBackground(new Color(102,102,255));
        transaction.setBackground(new Color(204,204,255));
        logout.setBackground(new Color(255,51,51));
        
        
        
        //adding to Container
        
        garage.setLayout(null);
        customerDetails.setLayout(null);
        transaction.setLayout(null);
        
        garage.add(totalCar);
        customerDetails.add(totalCustomer);
        transaction.add(totalTrans);
        myLabel.add(garage);
        myLabel.add(customerDetails);
        myLabel.add(transaction);
        myLabel.add(logout);
        C.add(myLabel);
        
              
       garage.addActionListener(this);
       customerDetails.addActionListener(this);
       transaction.addActionListener(this);
       logout.addActionListener(this);
        
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==garage)
        {
            new Garage();
            this.setVisible(false);
        }
        else if(e.getSource()==customerDetails)
        {
            new CustomerDetails();
            setVisible(false);
        }
        else if(e.getSource()==transaction)
        {
            new CustomerTransaction();
            setVisible(false);
        }
        else if(e.getSource()==logout)
        {
            new AuthorityLoginPage();
            setVisible(false);
        }
    }
    
    
}
