
package Customer;
import Classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;


public class PaymentSlip extends JFrame implements ActionListener{
    
    protected JTextArea area;
    protected JPanel panel;
    protected JLabel title;
    protected JButton back;
    protected Car car;
    protected String pickDate,returndate,pass,phnNumber;
    protected double bill,amount;
    protected String id,writeLines;
    protected File file,file2;
    protected Scanner sc;
	protected CustomerLoginInformation Cus;
   // protected CustomerDashBoard cDash;
    public PaymentSlip(Car car,double bill,double amount,String pickDate,String returnDate,CustomerLoginInformation Cus)
    {
        this.car=car;
        this.bill=bill;
        this.amount=amount;
        this.pickDate=pickDate;
        this.returndate=returnDate;
        this.Cus=Cus;
		this.id=Cus.getID();
		System.out.print(id);
        
        panel = new JPanel();
        panel.setLayout(null);
        
        this.setTitle("Payment Slip");
        this.setBounds(400,100,600,600);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        title = new JLabel("Payment Slip");
        back = new JButton("Back to DashBoard");
        area = new JTextArea();
        area.setEditable(false);
        
        
        
        title.setBounds(230,20,200,40);
        area.setBounds(20,70,550,400);
        back.setBounds(200,490,230,40);
        
        
        title.setFont(new Font("Title",Font.BOLD,26));
        area.setFont(new Font("Arial",Font.BOLD,20));
        back.setFont(new Font("Arial",Font.BOLD,18));
        
        panel.setBackground(new Color(51,153,255));
        area.setBackground(new Color(51,153,255));
        back.setBackground(new Color(51,153,255));
       
        
        String allLine= 
                            "Manucaturer name : "+car.getBrandName()+"\n"+
                            "Car ID :  "+car.getCarID()+"\n"+
                            "Customer ID : "+Cus.getID()+"\n"+
                            "Model : "+car.getModel()+"\n"+
                            //"Customer ID : "+cDash.id+"\n"+
                            "Price/hr : "+car.getPrice()+"\n"+
                            "Total Price :  "+bill+"\n"+
                            "Payed   :  "+amount+"\n"+
                            "Remaining :  "+(bill-amount)+"\n"+
                            "Pick up Date : "+pickDate+"\n"+
                            "Deadline : "+returnDate+"\n";
        
        writeLines = car.getBrandName()+" "
                    +car.getModel()+" "
                    + car.getCarID()+" "
                    +Cus.getID()+" "
                    +pickDate+" "
                    +returnDate+" "
                    +car.getPrice()+" "
                    +bill+" "
                    +amount+" "
                    +(bill-amount)+" "
                    +"Rented";
        
        
        area.setText(allLine);
                
        area.setForeground(Color.white);
        
        
        
        
        
        
        
        //title.setOpaque(true);
        
        //title.setBackground(Color.WHITE);
        //title.setForeground(Color.white);
        
        
        
       
        
        
        panel.add(title);
        panel.add(area);
        panel.add(back);
        
        this.add(panel);
        
        back.addActionListener(this);
        
        dataEntry();
        
        
       // this.setVisible(true);
    }
    
    public void dataEntry()
    {
        try
        {
            
            file = new File("Data/Cutomer-"+id+"(Rent Information)"+".txt");
            file2 = new File("Data/AllTransactionDetails.txt");
           /* File file3 = new File("Data/Customer-id-"+id+".txt");
            
            
            sc = new Scanner(file3);
            String PhoneNumber = sc.nextLine();
            sc.close();*/
            
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            pw.print(writeLines+"\n");
            pw.close();

            if(!file2.exists())
            {
                file2.createNewFile();
            }
            
            FileWriter fw1 = new FileWriter(file2, true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter pw1 = new PrintWriter(bw1);
            
            pw1.print(id+" "+Cus.getPhnNumber()+" "+amount+"\n");
            pw1.close();
            
            
            
            
            
            
        }catch(Exception ex)
        {
            
        }
         this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            //new CustomerDashBoard("id","");
            new ReturnCar(Cus);
            setVisible(false);
        }
    }
    
    
    
}
