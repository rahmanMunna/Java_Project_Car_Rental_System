package Customer;
import Classes.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class RentInformation extends JFrame implements ActionListener {
    protected JLabel time,pickupDate,returnDate,title,Day,Hr;
    protected JTextField day,hr,pickdate,returnDt;
    protected JPanel panel;
    protected JButton gotoPayment,back;
    protected ImageIcon image;
    protected double amount;
    protected Car car;
    protected  CustomerLoginInformation Cus;
    
	public RentInformation(){}
    public RentInformation(Car car,CustomerLoginInformation Cus)
    {
        this.Cus=Cus;
        this.car = car;
        this.setTitle("Rent Information : ");
        this.setBounds(400,100,600,600);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        
        
        title = new JLabel("Rent Information");
        time = new JLabel("Want To Rent For:");
        pickupDate = new JLabel("Pick Up Date(DD/MM/YY)");
        returnDate = new JLabel("Will Return on-Date(DD/MM/YY)");
        Day = new JLabel("day");
        Hr = new JLabel("hr");
        day = new JTextField();
        hr = new JTextField();
        pickdate = new JTextField();
        returnDt = new JTextField();
        
        
        
        
        gotoPayment = new JButton("Payment");
        back = new JButton("<<-");
        
        title.setBounds(200,10,200,40);
        time.setBounds(40,60,200,40);
        day.setBounds(40,100,100,30);
        Day.setBounds(145,100,30,30);
        hr.setBounds(190,100,100,30);
        Hr.setBounds(295,100,30,30);
        pickupDate.setBounds(40,150,300,30);
        pickdate.setBounds(40,190,200,30);
        returnDate.setBounds(40,220,300,30);
        returnDt.setBounds(40,260,200,30);
        gotoPayment.setBounds(200,310,140,40);
        back.setBounds(5,530,70,30);
        
        
        title.setFont(new Font("Title",Font.BOLD,24));
        time.setFont(new Font("Title",Font.BOLD,22));
        day.setFont(new Font("Arial",Font.PLAIN,22));
        Day.setFont(new Font("Arial",Font.BOLD,18));
        hr.setFont(new Font("Arial",Font.PLAIN,18));
        Hr.setFont(new Font("Arial",Font.BOLD,18));
        pickupDate.setFont(new Font("Arial",Font.BOLD,22));
        pickdate.setFont(new Font("Arial",Font.PLAIN,20));
        returnDate.setFont(new Font("Arial",Font.BOLD,20));
        returnDt.setFont(new Font("Arial",Font.PLAIN,22));
        gotoPayment.setFont(new Font("Arial",Font.BOLD,22));
        back.setFont(new Font("Title",Font.BOLD,18));
       
        
        
        panel = new JPanel();
        panel.setLayout(null);
        
        panel.setBackground(new Color(102,178,255));
        
        panel.add(title);
        panel.add(time);
        panel.add(pickupDate);
        panel.add(returnDate);
        panel.add(gotoPayment);
        panel.add(day);
        panel.add(hr);
        panel.add(Day);
        panel.add(Hr);
        panel.add(pickdate);
        panel.add(returnDt);
        
        //panel.add(back);
        
        gotoPayment.addActionListener(this);
        back.addActionListener(this);
        
        this.add(panel);
        this.setVisible(true);
        
        
    }
    
    public double getCalculatedAmmount(int day,int hr,double pricePerHr)
    {
        int totalTimeInHr = (day*24)+hr;
        amount = (double)totalTimeInHr*pricePerHr;
        return amount;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==gotoPayment)
        {
            if(!day.getText().isEmpty() && !hr.getText().isEmpty() && !pickdate.getText().isEmpty() && !returnDt.getText().isEmpty())
            {
                
            int d=Integer.parseInt(day.getText());
            int h =Integer.parseInt(hr.getText());
            String pickDate = pickdate.getText();
            String returnD = returnDt.getText();
           
            double totalPrice = getCalculatedAmmount(d,h,car.getPrice());
            int x =JOptionPane.showConfirmDialog(null,"Your Total BIll : "+totalPrice+" Tk","Show Payment",JOptionPane.OK_OPTION);
			//JOptionPane.showMessageDialog(null,"Your Total BIll : "+totalPrice+" Tk" ,"Show Payment", HEIGHT);
			if(x==0)
			{ new MobileBanking(totalPrice,pickDate,returnD, car,Cus);
            setVisible(false);}
			
            
            }
            else{
                JOptionPane.showMessageDialog(null, "Field are Empty !! Fill all the fields","Error" ,JOptionPane.ERROR_MESSAGE);
                
            }
         }
         
        }
        
    }

    

