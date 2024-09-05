
package Customer;
import Classes.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class ChangePassword extends JFrame implements ActionListener{
    
    protected String id,pass,newCreatedPass;
    protected JPanel panel;
    protected JLabel title,oldPass,newPass,confirmPass;
    protected JPasswordField setOld,setNew,setConfirm;
    protected JButton changePass,back;
    protected File file;
    protected Scanner sc,sc2;
    protected String data[];
	protected CustomerLoginInformation Cus;
    public ChangePassword(CustomerLoginInformation Cus)
    {
		this.Cus=Cus;
        this.id=Cus.getID();
        this.pass=Cus.getPass();
        
      
        
        
        this.setTitle("Change PassWord");
        this.setBounds(500,100,600,600);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        panel= new JPanel();
        title = new JLabel("Change Password");
        oldPass = new JLabel("Old Password : ");
        newPass = new JLabel("New Password : ");
        confirmPass = new JLabel("Re-Type : ");
        setOld = new JPasswordField();
        setNew = new JPasswordField();
        setConfirm = new JPasswordField();
        changePass = new JButton("Change Password");
        back = new JButton("<<=");
        
        //size
        title.setBounds(220,15,250,40);
        oldPass.setBounds(60,80,200,40);
        setOld.setBounds(60,110,200,40);
        newPass.setBounds(60,170,200,40);
        setNew.setBounds(60,200,200,40);
        confirmPass.setBounds(60,260,200,40);
        setConfirm.setBounds(60,300,200,40);
        changePass.setBounds(200,400,200,40);
        back.setBounds(10,520,60,30);
        
        //font
        title.setFont(new Font("Title",Font.BOLD,24));
        oldPass.setFont(new Font("Title",Font.BOLD,24));
        setOld.setFont(new Font("Arial",Font.BOLD,24));
        newPass.setFont(new Font("Arial",Font.BOLD,24));
        setNew.setFont(new Font("Arial",Font.BOLD,24));
        confirmPass.setFont(new Font("Arial",Font.BOLD,24));
        setConfirm.setFont(new Font("Arial",Font.BOLD,24));
        changePass.setFont(new Font("Title",Font.BOLD,18));
        back.setFont(new Font("Title",Font.BOLD,15));
        //border
        Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        setOld.setBorder(BorderFactory.createEmptyBorder());
        setNew.setBorder(BorderFactory.createEmptyBorder());
        setConfirm.setBorder(BorderFactory.createEmptyBorder());
        setOld.setBorder(redBorder);
        setNew.setBorder(redBorder);
        setConfirm.setBorder(redBorder);
        
        
        
        
       panel.setBackground(new Color(102,178,255));
       setConfirm.setBackground(new Color(102,178,255));
       setOld.setBackground(new Color(102,178,255));
       setNew.setBackground(new Color(102,178,255));
        
        
        
        
        
        
        panel.setLayout(null);
        
        panel.add(title);
        panel.add(oldPass);
        panel.add(setOld);
        panel.add(newPass);
        panel.add(setNew);
        panel.add(confirmPass);
        panel.add(setConfirm);
        panel.add(changePass);
        panel.add(back);
        this.add(panel);
        
        back.addActionListener(this);
        changePass.addActionListener(this);
        
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==changePass)
        {
            
            if(setOld.getText().toString().matches(pass))
            {
                
                if(setNew.getText().toString().matches(setConfirm.getText().toString()))
                {
                    newCreatedPass ="PassWord : "+setConfirm.getText();
                    System.out.println(newCreatedPass);
                    try{
                        file = new File("Data/Customer-id-"+id+".txt");
                        
                        
                            sc = new Scanner(file);
                            int size =0;
                            
                            while(sc.hasNext())
                            {
                                sc.nextLine();
                                size++;
                            }
                            sc.close();
                            data = new String[size];
                            
                            int i =0;
                            sc2 = new Scanner(file);
                            while(sc2.hasNext())
                            {
                               while(i<data.length)
                               {
                                   data[i]=sc2.nextLine();
                                   i++;
                                   break;
                               }
                            }
                            sc2.close();
                            
                            for(String x : data)
                            {
                                System.out.println(x+"\n");
                            }
                            
                            for(int j =0;j<data.length;j++)
                            {
                                if(data[j].matches("PassWord : "+setOld.getText().toString()))
                                {
                                    data[j]=newCreatedPass;
                                    System.out.println(data[j]);
                                    break;
                                }
                            }
                            
                            //updating file
                            
                            FileWriter writer = new FileWriter(file);
                            
                            for(int j =0;j<data.length;j++)
                            {
                                writer.write(data[j]+"\n");
                                System.out.println("I am writing");
                            }
                            
                            writer.close();
                            
                            
                            
                            JOptionPane.showConfirmDialog(null, "Your Password has been Changed Successfully", "Confirmation", JOptionPane.HEIGHT);
                            new CustomerDashBoard(Cus);
                             setVisible(false);
                            
                        //}
                        
                        
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
                    
                    
                    
                    
                    
                }  
                
                else
                {
                    JOptionPane.showMessageDialog(null, "New Password and Confirm Password doesnt macth", "Incorect", JOptionPane.INFORMATION_MESSAGE);
                }
                
                
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Your entering Current Password is not COrrect", "Incorect", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        
        else if(e.getSource()==back)
        {
            new CustomerDashBoard(Cus);
            setVisible(false);
        }
        
        
        
    
    }
}
    
    


