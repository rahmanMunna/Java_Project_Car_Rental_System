
package Customer;
import Classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MobileBanking extends JFrame implements ActionListener{
    
    protected JPanel panel1,panel2;
    protected ImageIcon image;
    protected JLabel title,number,pin,amount,showAmount,imageLabel1,imageLabel2;
    protected JTextField setNumber,setPin,setAmount;
    protected JButton confirm;
    protected double bill,givenAmount;
    protected String pickDate,returnDate,id,pass,phnNumber;
    protected Car car;
	protected CustomerLoginInformation Cus;
    
	public MobileBanking(){}
    public MobileBanking(double bill,String pickDate,String returnDate,Car car,CustomerLoginInformation Cus)
    {
        this.pickDate=pickDate;
        this.returnDate=returnDate;
        this.car=car;
        this.Cus=Cus;
        //image = new ImageIcon(getClass().getResource(""));
        this.bill= bill;
        this.setTitle("Online Payment");
        this.setBounds(150,100,1300,600);
        this.setResizable(false);  
        
        title = new JLabel("Mobile Banking");
        number = new JLabel("Bkash Number");
        pin = new JLabel("Bkash PIN");
        amount = new JLabel("Enter Ammount");
        setNumber = new JTextField();
        setPin = new JTextField();
        setAmount = new JTextField();
        confirm = new JButton("Confirm & Get PaymentSlip");
        showAmount = new JLabel("Total bill : "+bill+" TK");
        
        title.setBounds(950,20,200,40);
        number.setBounds(800,100,200,40);
        setNumber.setBounds(800,140,200,40);
        pin.setBounds(800,190,200,40);
        setPin.setBounds(800,230,200,40);
        amount.setBounds(800,280,200,40);
        setAmount.setBounds(800,320,200,40);
        confirm.setBounds(900,400,300,40);
        showAmount.setBounds(970,470,300,30);
        
        
        
        
        title.setFont(new Font("Title",Font.BOLD,28));
        number.setFont(new Font("Arial",Font.PLAIN,24));
        setNumber.setFont(new Font("Arial",Font.BOLD,20));
        pin.setFont(new Font("Arial",Font.PLAIN,24));
        setPin.setFont(new Font("Arial",Font.BOLD,20));
        amount.setFont(new Font("Arial",Font.BOLD,24));
        setAmount.setFont(new Font("Arial",Font.BOLD,20));
        confirm.setFont(new Font("Aria",Font.BOLD,18));
        showAmount.setFont(new Font("Arial",Font.BOLD,14));
        
        showAmount.setForeground(Color.red);
        
        //adding image
        ImageIcon image1 = new ImageIcon(getClass().getResource("/Image/MobileBanking.gif"));
        imageLabel1 = new JLabel(image1);
        imageLabel1.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
        
//      ImageIcon image2 = new ImageIcon(getClass().getResource("/Image/Bkash.jfif"));
//      imageLabel2 = new JLabel(image2);
//      imageLabel2.setBounds(1050,150,150,10);
        
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel1.setBounds(0,0,750,600);
        panel2.setBounds(550,0,550,600);
        panel1.setLayout(null);
        panel2.setLayout(null);
        
        panel1.add(imageLabel1);
       // panel2.add(imageLabel2);
        panel2.add(title);
        panel2.add(number);
        panel2.add(setNumber);
        panel2.add(pin);
        panel2.add(setPin);
        panel2.add(amount);
        panel2.add(setAmount);
        panel2.add(confirm);
        panel2.add(showAmount);
        
        //color
        panel2.setBackground(new Color(153,153,255));
        
        confirm.addActionListener(this);
        
        this.add(panel1);
        this.add(panel2);
        setVisible(true);
    }
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==confirm)
        {
           
			if(setNumber.getText()!="" && setPin.getText()!="" && setAmount.getText()!="")
				
				{
					 givenAmount = Double.parseDouble(setAmount.getText());
					if(givenAmount==bill)
					{
                
                //new ReturnCar(car,bill,id,"Payed",pickDate);
                
                new  PaymentSlip(car,bill,givenAmount,pickDate,returnDate,Cus);
                setVisible(false);
					}
					
				else{
					JOptionPane.showMessageDialog(null, "Pay the Full Ammount", "Error", HEIGHT);
				}
				
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Fill all the Fields", "Error", HEIGHT);
				}
            
        }
    }
    
}
