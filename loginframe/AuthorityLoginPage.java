
package loginframe;
import Admin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.*;



public class AuthorityLoginPage extends JFrame implements ActionListener{
    
    protected Container C;
    protected JLabel title, user_id,pass;
    protected JTextField id;
    protected JPasswordField password;
    protected JButton signin,back;
    protected Cursor cursor;
    protected String storeData[];
    protected String takenData;
    protected Scanner sc;
    protected File file;
    
   public  AuthorityLoginPage()
    {
        //creating frame
        this.setBounds(500, 120, 500, 550);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("Authority LoginPage");
        this.setResizable(false);
        
        C=this.getContentPane();//getting contentPane
        C.setLayout(null);
        
        title = new JLabel("Authority Login");
        user_id = new JLabel("USER  ID   ");
        pass = new JLabel("PASSWORD ");
        id = new JTextField();
        password = new JPasswordField();
        signin = new JButton("Sign in");
        back = new JButton("<<=");
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        
        
        title.setBounds(150,30,250,40);
        user_id.setBounds(60,100 ,105 , 50);
        pass.setBounds(60,160,105 ,50 );
        id.setBounds(175,100,190 ,40 );
        password.setBounds(175,160,190 ,40 );
        signin.setBounds(200, 220, 85, 40);
        back.setBounds(390,450,80,30);
        
        signin.setCursor(cursor);
        back.setCursor(cursor);
        
        
        
         title.setFont(new Font("Title",Font.BOLD,24));
         user_id.setFont(new Font("Arial",Font.PLAIN,16));
         pass.setFont(new Font("Arial",Font.PLAIN,16));
         signin.setFont(new Font("Title",Font.BOLD,14));
         back.setFont(new Font("Arial",Font.BOLD,18));
         
         signin.setForeground(Color.WHITE);
         signin.setBackground(Color.BLACK);
        
        
        C.add(title);
        C.add(user_id);
        C.add(pass);
        C.add(id);
        C.add(password);
        C.add(signin);
        C.add(back);
        
        
        signin.addActionListener(this);
        back.addActionListener(this);
        
        this.setVisible(true);
       
        
    }
   
   
   
  public void actionPerformed(ActionEvent e)
   
   {
       if(e.getSource()==signin)
       {
           takenData =id.getText()+" "+password.getText();
		   
		   
		   try{
		   file = new File("Data/AdminLogin.txt");
		   int size=0;
		   
		   
			   sc = new Scanner(file);
			   while(sc.hasNext())
			   {
				   sc.nextLine();
				   size++;
                                  
			   }
                           sc.close();
                            System.out.println(size);
			   
			   storeData = new String[size];
			   
                           Scanner sc2 = new Scanner(file);
                           int i =0;
			   while(sc2.hasNext())
			   {
                               while(i<storeData.length)
                               {
                                   storeData[i]=sc2.nextLine();
                                   i++;
                                   break;
                               }
				   
			   }
                           
                           sc2.close();
                           
                          
				int flag=0;
			   for(int j =0;j<storeData.length;j++)
			   {
				   if(storeData[j].matches(takenData))
				   {
					   flag++;
					  
					   
				   }
                                 
			   }  
			   if(flag==1)
			   {
				    JOptionPane.showMessageDialog(null, "Login SuccessFully!!","Confirmation",JOptionPane.PLAIN_MESSAGE);
                    new AuthorityDashBoard();
                    this.setVisible(false);
                    
			   }
			   else{
				   JOptionPane.showMessageDialog(null, "User and Password is incorect!!","Error!!",JOptionPane.ERROR_MESSAGE);
			   }
		   
		   
         
       }
	   catch(Exception ex)
		   {
			   System.out.println(ex);
		   }
		   
	   
	   
       }
	   
	   
	   
       else if(e.getSource()==back)
       {
           new LoginFrame();
           setVisible(false);
       }
       
       
   }
   
   
   
   
   
   
    
}
