
package loginframe;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;



public class Registration extends JFrame implements ActionListener {
    
    protected Container C;
    protected Cursor cursor;
    protected JLabel title,name,phnNumber,nidNumber,gender,DOB,email,userId,imageLabel;
    protected JTextField setname,setphn,setnid,setemail,setUser ;
    protected JRadioButton male,female;
    protected ButtonGroup group;
    
    protected JComboBox date,month,year;
    protected JCheckBox checkBox;
    protected JButton submit,previous;
    
    
    protected String  fullName,id,othersData,customerDetails;
    
    private String dates[] 
                 ={"1","2","3","4","5","6","7","8","9","10",
                  "11","12","13","14","15","16","17","18","19","20",
                  "21","22","23","24","25","26","27","28","29","30","31"} ;
    
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    
    private String years []
            ={"1989","1990","1991","1992","1993","1994","1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019","2020","2021","2022","2023" };
    
    
    
   public  Registration()
    {
        this.setBounds(300, 100, 1100, 680);
        this.setTitle("Registration Page");
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        C=this.getContentPane();
        C.setLayout(null);
        
        //label
        title = new JLabel("Create A New Account");
        
        name = new JLabel("NAME  ");
        userId = new JLabel("User Id ");
        phnNumber = new JLabel("PHONE ");
        email = new JLabel("EMAIL ");
        nidNumber = new JLabel("NID NO");
        gender = new JLabel("GENDER ");
        DOB = new JLabel("D.O.B ");
        
        
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        //button
        submit = new JButton("Submit");
        submit.setCursor(cursor);
        previous = new JButton("<<=");
        
        
        //radioButton
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        group = new ButtonGroup();
        
        
        //textfield
        setname= new JTextField();
        setUser = new JTextField();
        setphn= new JTextField();
        setnid= new JTextField();
        setemail= new JTextField();
        
        //combobox
        date = new JComboBox(dates);
        date.setEditable(true);
        
        month = new JComboBox(months);
        month.setEditable(true);
        
        year = new JComboBox(years);
        year.setEditable(true);
        
        
        checkBox = new JCheckBox();
        checkBox.setText("Accept All Terms and Condition");
        
        
        //
        title.setOpaque(true);
        
        
        
        
        //size
        title.setBounds(80, 25, 270, 30);
        name.setBounds(30, 90, 80, 40);
        userId.setBounds(30,140,80,40);
        phnNumber.setBounds(30,190,80,40);
        email.setBounds(30,240,80,40);
        nidNumber.setBounds(30,290,80,40);
        gender.setBounds(30,340,85,40);
        DOB.setBounds(30,390,80,40);
        
        setname.setBounds(125,95,200,30);
        setUser.setBounds(125,145,200,30);
        setphn.setBounds(125,195,200,30);
        setemail.setBounds(125,245,200,30);
        setnid.setBounds(125,295,200,30);
         
        
        male.setBounds(125,345,100,30);
        female.setBounds(225,345,100,30);
        
        date.setBounds(125,395,65,30);
        month.setBounds(195,395,65,30);
        year.setBounds(260,395,65,30);
        
        checkBox.setBounds(40,475,300,40);
        
        submit.setBounds(120,540,120,35);
       
        previous.setBounds(370,600,70,30);
        
        
        
        
        
        
        
        //Font
        title.setFont(new Font("Title",Font.BOLD,25));
        name.setFont(new Font("Arial",Font.BOLD,18));
        userId.setFont(new Font("Arial",Font.BOLD,18));
        phnNumber.setFont(new Font("Arial",Font.BOLD,18));
        email.setFont(new Font("Arial",Font.BOLD,18));
        nidNumber.setFont(new Font("Arial",Font.BOLD,18));
        gender.setFont(new Font("Arial",Font.BOLD,18));
        DOB.setFont(new Font("Arial",Font.BOLD,18));
        male.setFont(new Font("Arial",Font.BOLD,16));
        female.setFont(new Font("Arial",Font.BOLD,16));
        checkBox.setFont(new Font("Times New Roman",Font.BOLD,18));
        submit.setFont(new Font("Title",Font.BOLD,18));
        
        
        
        
        
        
        
        
        
        
        
       // previous.setFont(new Font("Times New Roman",Font.BOLD,23));
        
       
       
       //adding image
       ImageIcon image = new ImageIcon(getClass().getResource("/Image/Registration.png"));
       imageLabel = new JLabel(image);
       imageLabel.setBounds(450,0,image.getIconWidth(),image.getIconHeight());
        
        
        //color
        title.setBackground(new Color(51,153,255));
        checkBox.setBackground(new Color(51,153,255));
        submit.setBackground(Color.magenta);
        
       // previous.setBackground(Color.lightGray);
        
       
        C.setBackground(new Color(51,153,255));
        
        
        
        //
        group.add(male);
        group.add(female);
        
        //adding to container
        C.add(title);
        C.add(name);
        C.add(userId);
        C.add(phnNumber);
        C.add(email);
        C.add(nidNumber);
        C.add(gender);
        C.add(DOB);
        C.add(setname);
        C.add(setUser);
        C.add(setphn);
        C.add(setemail);
        C.add(setnid);
        C.add(male);
        C.add(female);
        C.add(date);
        C.add(month);
        C.add(year);
        C.add(previous);
        C.add(checkBox);
        C.add(submit);
        C.add(imageLabel);
        C.add(previous);
        
        
        
        
        //addActionListener
        submit.addActionListener(this);
        previous.addActionListener(this);
        
      
        
      
        this.setVisible(true);
        
    }
    
  
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit)
        {
            String gender1 ="male"; 
            if(checkBox.isSelected())
            {
                if(setname.getText().isBlank()==true || setUser.getText().isBlank()==true || setphn.getText().isBlank()==true || setemail.getText().isBlank()==true || setnid.getText().isBlank()==true)
                {
                   JOptionPane.showMessageDialog(null, "Fill Up all the Field!","Empty field", JOptionPane.ERROR_MESSAGE);
                
                }
                else
                {
                fullName = setname.getText();
                id = setUser.getText();
                
//                othersData ="Phone Number : "+setphn.getText()+"\n"
//                        
//                           +"Email        : "+setemail.getText()+"\n"
//                           +"NID Number   : "+setnid.getText()+"\n";
                
                customerDetails =fullName+" "+id+" ";
                customerDetails+=setphn.getText()+" "+setnid.getText()+" "+setemail.getText()+" ";                
                
                if(female.isSelected())
                {
                    gender1 ="Femail";
                //othersData +="Gender       : "+gender1+"\n";
                customerDetails+=gender1+" ";
                }
                      
                else
                {
               // othersData +="Gender       : "+gender1+"\n"; 
                customerDetails+=gender1+" ";
                    
                }
                //othersData =othersData+"Date Of Birth: "+(String)date.getSelectedItem()+"-"+(String)month.getSelectedItem()+"-"+(String)year.getSelectedItem();
                customerDetails =customerDetails+(String)date.getSelectedItem()+"-"+(String)month.getSelectedItem()+"-"+(String)year.getSelectedItem()+" ";
                           
                 int x = JOptionPane.showConfirmDialog(null, "Are You Sure To Confrm Your Registration", "Confirmation", JOptionPane.YES_NO_OPTION);
                 if(x==0)
            {
               setVisible(false);
               new Password(id,fullName,setphn.getText(),customerDetails);
               
             }
        
                
                        
                    
                }
                
                
                
            }
            else
            {
               JOptionPane.showMessageDialog(null,"You Didn't Accept the Agreement","Error",JOptionPane.WARNING_MESSAGE);
               
            }
            
        }
//        if(e.getSource()==confirm)
//        {
//           int x = JOptionPane.showConfirmDialog(null, "Are You Sure To Confrm Your Registration", "Confirmation", JOptionPane.YES_NO_OPTION);
//           if(x==0)
//           {
//               Password P =new Password(id,fullName,setphn.getText(),othersData);
//               this.setVisible(false);
//           }
//          
//        }
        
        else if(e.getSource()==previous)
        {
            new LoginFrame();
            setVisible(false);
        }
            
        
    }
}
