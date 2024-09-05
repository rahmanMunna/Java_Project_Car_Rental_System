
package Customer;
import Classes.*;
import Admin.*;
import loginframe.*;
import java.io.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


public class CustomerDashBoard extends JFrame implements ActionListener {
    
    protected Container C;
    protected Cursor cursor;
    protected String id,pass,phnNumber;
    protected JLabel title,user,myLabel;
    protected JButton rent,returnCar,logout,delete,profile;
    protected File file;
    protected ImageIcon image1,image2,image3,image4,image5,image6;
	protected CustomerLoginInformation Cus;
	
    public CustomerDashBoard(CustomerLoginInformation Cus)
    {
        this.Cus=Cus;
       // this.file=file;
        
        this.setBounds(100,00,1270,800);
        this.setTitle("DashBoard");
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        C=this.getContentPane();
        C.setLayout(null);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        
       
       
        
       
        
        
        
        //initializing
        title = new JLabel("X Car Rental Shop");
        user = new JLabel("USER :"+Cus.getID());
        //userId = new JLabel(id); 
        
        
        
        
        
        //set absoulate SIze
        title.setBounds(240,20,250,40);
        user.setBounds(30,10,200,40);
//        userId.setBounds(70,10,100,40);
//        profile.setBounds(250,80,200,50);
//        //rent.setBounds(250,140,200,50);
//        returnCar.setBounds(250,200,200,50);
//        orderDetails.setBounds(250,260,200,50);
//        delete.setBounds(250,320,200,50);
//        logout.setBounds(250,380,200,50);
        
        
        
        
        //Set Font
        title.setFont(new Font("Title",Font.BOLD,25));
        user.setFont(new Font("Title",Font.BOLD,16));
//        userId.setFont(new Font("Arial",Font.PLAIN,18));
//        profile.setFont(new Font("Arial",Font.BOLD,19));
//        returnCar.setFont(new Font("Arial",Font.BOLD,19));
//        orderDetails.setFont(new Font("Arial",Font.BOLD,19));
//        delete.setFont(new Font("Arial",Font.BOLD,19));
//        logout.setFont(new Font("Arial",Font.BOLD,19));
//        //rent.setFont(new Font("Arial",Font.BOLD,19));
        
        
        
        
        
        
        
        
        
        //adding color
        //title.setForeground(Color.white);
        user.setForeground(Color.white);
        C.setBackground(Color.BLACK);
        
        
        
        
        
        
        //adding image
//        
        image1 = new ImageIcon(getClass().getResource("/Image/rent0.jpg"));
        image2 = new ImageIcon(getClass().getResource("/Image/ChangePassword.png"));
        image3 = new ImageIcon(getClass().getResource("/Image/Return2.png"));
        image4 = new ImageIcon(getClass().getResource("/Image/Delete.jfif"));
        image5 = new ImageIcon(getClass().getResource("/Image/Logout.jfif"));
        image6 = new ImageIcon(getClass().getResource("/Image/B.gif"));
        
       
        
        myLabel = new JLabel(image6);
       
        
        rent = new JButton(image1);
        rent.setCursor(cursor);
        profile = new JButton(image2);
        profile.setCursor(cursor);
        returnCar = new JButton(image3);
        returnCar.setCursor(cursor);
        delete= new JButton(image4);
        delete.setCursor(cursor);
        logout = new JButton(image5);
        logout.setCursor(cursor);
        
        
        
        
        
        //setSize
        myLabel.setSize(1250,800);
        rent.setBounds(20,90,image1.getIconWidth(),image1.getIconHeight());
        profile.setBounds(820,90,image2.getIconWidth(),image2.getIconHeight());
        returnCar.setBounds(500,90,image3.getIconWidth(),image3.getIconHeight());
        logout.setBounds(20,450,image5.getIconWidth(),image5.getIconHeight());
        delete.setBounds(350,450,image5.getIconWidth(),image5.getIconHeight());
        
        
       myLabel.add(rent);
       myLabel.add(profile);
       myLabel.add(returnCar);
       myLabel.add(delete);
       myLabel.add(logout );
       myLabel.add(user); 
        
        
        
        
        //adding to Container
 ;

          C.add(myLabel);
          
        
        
                
        profile.addActionListener(this);
        logout.addActionListener(this);
        delete.addActionListener(this);
        rent.addActionListener(this);
        returnCar.addActionListener(this);
        
        
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==rent)
        {
            new CustomerCarList(Cus);
            this.setVisible(false);
        }
        else if(e.getSource()==logout)
        {
            new LoginFrame();
            setVisible(false);
            
        }
        
        else if(e.getSource()==returnCar)
        {
            ReturnCar r = new ReturnCar(Cus);
            setVisible(false);
        }
        
        else if(e.getSource()==delete)
        {
            new DeleteAccount(Cus);
            setVisible(false);
            
        }
       else if(e.getSource()==profile)
	   {
		   new ChangePassword(Cus);
		   setVisible(false);
	   }
        
    }
    
}
    

