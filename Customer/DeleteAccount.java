package Customer;
import Classes.*;
import Admin.*;
import loginframe.*;
import Classes.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;


public class DeleteAccount extends JFrame implements ActionListener {
    
    
    protected String password,id;
    protected JPanel panel;
    protected JLabel pass,confirmPass,title;
    protected JPasswordField setPass,setConfirmPass;
    protected JButton delete,back;
    protected File file;
    protected CustomerLoginInformation Cus;
    
    public DeleteAccount(CustomerLoginInformation Cus)
    {
        
        this.Cus=Cus;
		this.id=Cus.getID();
		this.password=Cus.getPass();
        
        this.setTitle("Delete ACcount");
        this.setBounds(500,200,600,500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        panel= new JPanel();
        title = new JLabel("Delete Account");
        pass = new JLabel("Password : ");
        confirmPass = new JLabel("Re-Type");
        setPass = new JPasswordField();
        setConfirmPass = new JPasswordField();
        delete = new JButton("Delete");
        back = new JButton("<<-");
        
        //size
        title.setBounds(220,15,190,40);
        pass.setBounds(60,80,200,40);
        setPass.setBounds(60,120,200,40);
        confirmPass.setBounds(60,170,200,40);
        setConfirmPass.setBounds(60,210,200,40);
        delete.setBounds(230,300,110,40);
        back.setBounds(10,420,60,30);
        
        //font
        title.setFont(new Font("Title",Font.BOLD,24));
        pass.setFont(new Font("Title",Font.PLAIN,24));
        setPass.setFont(new Font("Arial",Font.BOLD,24));
        confirmPass.setFont(new Font("Arial",Font.PLAIN,24));
        setConfirmPass.setFont(new Font("Arial",Font.BOLD,24));
        delete.setFont(new Font("Title",Font.BOLD,18));
        back.setFont(new Font("Title",Font.BOLD,15));
        //border
        Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        setPass.setBorder(BorderFactory.createEmptyBorder());
        setConfirmPass.setBorder(BorderFactory.createEmptyBorder());
        setPass.setBorder(redBorder);
        setConfirmPass.setBorder(redBorder);
        
        
        panel.setLayout(null);
		
	    panel.setBackground(new Color(102,178,255));
        setPass.setBackground(new Color(102,178,255));
		setConfirmPass.setBackground(new Color(102,178,255));
		
		
		
        panel.add(title);
        panel.add(pass);
        panel.add(setPass);
        panel.add(confirmPass);
        panel.add(setConfirmPass);
        panel.add(delete);
        panel.add(back);
        this.add(panel);
        
        back.addActionListener(this);
        delete.addActionListener(this);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==delete)
        {
            
               
                if(setPass.getText().equals(password) && setConfirmPass.getText().equals(password) && setPass.getText().equals(setConfirmPass.getText()))
                {
                    
                    
                       //JOptionPane.showMessageDialog(null, "Confirmation","Are you sure to delete Account",JOptionPane.YES_NO_OPTION);
                    try{
                   
                        file = new File("Data/Customer-id-"+id+".txt");
                        
                       if(file.exists())
                       {
                           
                           FileWriter writer = new FileWriter(file);
                           writer.write("");
						   //file.delete();
                           writer.close();
                           JOptionPane.showMessageDialog(null, "Your Account has Been Deleted Successfully","Confirmation",JOptionPane.INFORMATION_MESSAGE);
                           //file.delete();
                           new LoginFrame();
                           setVisible(false);
                       }
                    
                    
                    }
                    catch(Exception ex)
                    {
                        System.out.print(ex);
                    }
                
                }
				
				 else
            {
                JOptionPane.showMessageDialog(null, "Password Doesn't Match","Error",JOptionPane.ERROR_MESSAGE);
            }
				
            
           
            
            
        }
        
        else if(e.getSource()==back)
        {
            new CustomerDashBoard(Cus);
            setVisible(false);
       }
    }
    
    
}
