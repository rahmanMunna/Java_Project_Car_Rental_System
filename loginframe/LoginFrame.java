
package loginframe;
import Customer.*;
import Classes.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.util.Scanner;
import javax.swing.border.Border;


public class LoginFrame extends JFrame implements ActionListener {
    
    protected JPanel panel1;
    protected JLabel title,phn,user_id,pass,simpletext,addImage;
    protected JTextField phoneNumber,user_id_field;
    protected JPasswordField password;
    protected JButton sign_in,sign_up,authority;
    protected Scanner sc;
    protected String fileData;
    protected ImageIcon image;
    
    
    public LoginFrame()
    {
        //creating a frame
        this.setBounds(200, 120, 980, 550);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setTitle("LogIn Page");
        this.setResizable(false);
       
       image = new ImageIcon(getClass().getResource("/Image/Login.jfif"));
        
       panel1= new JPanel();
       panel1.setBounds(0,0,600,550);
       
       
       panel1.setLayout(null);
       
      
       
        //initializing Content
        title = new JLabel("Login Form");
        phn    = new JLabel("PHONE        : ");
        user_id= new JLabel("USER  ID     : ");
        pass = new JLabel("PASSWORD:");
        simpletext = new JLabel("Don't Have An Account?");
        authority = new JButton("Authority Login?");
        phoneNumber = new JTextField();
        user_id_field= new JTextField();
        password = new JPasswordField();
        sign_in = new JButton("SIGN IN");
        sign_up = new JButton("SIGN UP");
        addImage = new JLabel(image);
        
        //set COlor
        title.setForeground(Color.WHITE);
        phn.setForeground(Color.WHITE);
        user_id.setForeground(Color.WHITE);
        pass.setForeground(Color.WHITE);
        simpletext.setForeground(Color.WHITE);
        //authority.setForeground(Color.WHITE);
        
      
        //Setting Size
          title.setBounds(175,20 ,150 ,50 );
          phn.setBounds(60,100,105 ,50 );
          user_id.setBounds(60,160 ,105 , 50);
          pass.setBounds(60,220,105 ,50 );
          phoneNumber.setBounds(175,105,250 ,40 );
          user_id_field.setBounds(175,160 , 250, 40);
          password.setBounds(175, 220,250 ,40 );
          sign_in.setBounds(200, 285, 85, 40);
          sign_up.setBounds(200,410,85,40);
          simpletext.setBounds(150,360,250,50);
          authority.setBounds(10,460,140,40); 
          addImage.setBounds(500,0,image.getIconWidth(),image.getIconHeight());
          
          
          Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
          authority.setBorder(BorderFactory.createEmptyBorder());
          authority.setBorder(redBorder);
          
          
          //Setting Font
          title.setFont(new Font("Arial",Font.BOLD,25));
          phn.setFont(new Font("Arial",Font.PLAIN,16));
          user_id.setFont(new Font("Arial",Font.PLAIN,16));
          pass.setFont(new Font("Arial",Font.PLAIN,16));
          simpletext.setFont(new Font("Arial",Font.BOLD,18));
          authority.setFont(new Font("Arial",Font.ITALIC,14));
          phoneNumber.setFont(new Font("Arial",Font.BOLD,17));
          user_id_field.setFont(new Font("Arial",Font.BOLD,17));
          password.setFont(new Font("Arial",Font.BOLD,20));
          
          
          authority.setForeground(Color.red);
        
         //Adding Components 
          
          
          
          panel1.add(title);
          panel1.add(phn);
          panel1.add(user_id);
          panel1.add(simpletext);
          panel1.add(pass);
          panel1.add(phoneNumber);
          panel1.add(user_id_field);
          panel1.add(password);
          panel1.add(sign_in);
          panel1.add(sign_up);
          panel1.add(authority);
          panel1.add(addImage);
          panel1.setBackground(Color.DARK_GRAY);
          panel1.setForeground(Color.WHITE);
         
          this.add(panel1);
            
        sign_up.addActionListener(this);
        sign_in.addActionListener(this);
        authority.addActionListener(this);
        
        
        
        this.setVisible(true);
    }

   
    public void actionPerformed(ActionEvent e){
        
      
        if(e.getSource()==sign_in)
                {
                   
                    try
                    {
                        File file = new File("Data/Customer-id-"+user_id_field.getText()+".txt");
                       
                        //String path = file.getAbsolutePath();
						
						if(file.exists())
						{ 
						sc = new Scanner(file);
                        
                        while(sc.hasNext())
                        {
                            fileData+=sc.nextLine()+"\n";
                        }
						
						if(fileData!="")
                        
					
				{	
					if(fileData.contains("Phone Number : "+phoneNumber.getText()) && fileData.contains("User Id : "+user_id_field.getText()) && fileData.contains("PassWord : "+password.getText()))
                        { 
								String phn = phoneNumber.getText();
								String id= user_id_field.getText();
								String p = password.getText();
					
                            CustomerLoginInformation Cus = new CustomerLoginInformation(phn,id,p);
                            
                            JOptionPane.showMessageDialog(null,"Login SuccessFully","SucessfullMessage",JOptionPane.PLAIN_MESSAGE);
                            
							//CustomerLoginInformation C = new CustomerLoginInformation(phoneNumber.getText(),user_id_field.getText(),password.getText());
							
                          CustomerDashBoard C = new CustomerDashBoard(Cus);
                          this.setVisible(false);
                            
                        }
						else
					{
						JOptionPane.showMessageDialog(null, "Account Doesn't EXIST", "Couldn't Foud", HEIGHT);
					}
				}
					else
					{
						JOptionPane.showMessageDialog(null, "Account Doesn't EXIST", "Couldn't Foud", HEIGHT);
					}
                        
			}
			
			else{
				JOptionPane.showMessageDialog(null, "Account Doesn't EXIST", "Couldn't Foud", HEIGHT);
			}
                   
                   
                }
				 catch(Exception ex)
                    {
                       System.out.println(ex);
                    }
					
				}
         else if(e.getSource()==sign_up)
        {
           Registration R =  new Registration();
            this.setVisible(false);
        }
         else if(e.getSource()==authority)
         {
             new AuthorityLoginPage();
             this.setVisible(false);
         }
        
        
    }
    
}

