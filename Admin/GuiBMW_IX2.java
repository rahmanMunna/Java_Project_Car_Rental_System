
package Admin;
import loginframe.*;
import Classes.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class GuiBMW_IX2 extends JFrame implements ActionListener {
    
    protected JLabel title,brandName,model,carID,color,price,status,imageLabel;
    protected JPanel panel;
    protected JButton back;
    protected ImageIcon image;
	protected Car car;
    protected JTextField setname,setModel,setCarID,setColor,setPrice,setStatus;
    
    public GuiBMW_IX2(Car IX2)
    {
		this.car=IX2;
		
        this.setTitle("Toyota Corolla");
        this.setBounds(450,200,800,600);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        
        
        panel = new JPanel();
        
        setname = new JTextField(IX2.getBrandName());
        setModel = new JTextField(IX2.getModel());
        setCarID = new JTextField(IX2.getCarID());
        setColor = new JTextField(IX2.getColor());
        setPrice = new JTextField(IX2.getPrice()+" TK");
        setStatus = new JTextField(IX2.getStatus());
        
        
        setname.setEditable(false);
        setModel.setEditable(false);
        setCarID.setEditable(false);
        setname.setEditable(false);
        setColor.setEditable(false);
        setPrice.setEditable(false);
        setStatus.setEditable(false);
       
        
        
        brandName = new JLabel("Manufacturer Name : ");
        model = new JLabel(     "Model            ");
        carID = new JLabel(     "Car ID            ");
        color = new JLabel(     "COLOR             ");
        price = new JLabel(     "Price/hr          ");
        status = new JLabel("Status");
        
        
        back = new JButton("<<=");
        
        brandName.setBounds(15,30,210,40);
        model.setBounds(15,90,210,40);
        carID.setBounds(15,160,210,40);
        color.setBounds(15,225,210,40);
        price.setBounds(15,295,210,40);
        status.setBounds(15,365,210,40);
        
        back.setBounds(700,520,70,30);
        
        setname.setBounds(235,30,150,40);
        setModel.setBounds(235,80,150,40);
        setCarID.setBounds(235,145,150,40);
        setColor.setBounds(235,215,150,40);
        setPrice.setBounds(235,285,150,40);
        setStatus.setBounds(235,355,150,40);
        
        
        
        Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        setname.setBorder(BorderFactory.createEmptyBorder());
        setModel.setBorder(BorderFactory.createEmptyBorder());
        setCarID.setBorder(BorderFactory.createEmptyBorder());
        setColor.setBorder(BorderFactory.createEmptyBorder());
        setPrice.setBorder(BorderFactory.createEmptyBorder());
        setStatus.setBorder(BorderFactory.createEmptyBorder());
        
        setname.setBorder(redBorder);
        setModel.setBorder(redBorder);
        setCarID.setBorder(redBorder);
        setColor.setBorder(redBorder);
        setPrice.setBorder(redBorder);
        setStatus.setBorder(redBorder);
        
       
        

        
        
        
        
        
        brandName.setFont(new Font("Arial",Font.BOLD,20));
        model.setFont(new Font("Arial",Font.BOLD,20));
        carID.setFont(new Font("Arial",Font.BOLD,20));
        color.setFont(new Font("Arial",Font.BOLD,20));
        price.setFont(new Font("Arial",Font.BOLD,20));
        status.setFont(new Font("Arial",Font.BOLD,20));
        
        setname.setFont(new Font("Arial",Font.PLAIN,20));
        setModel.setFont(new Font("Arial",Font.PLAIN,20));
        setCarID.setFont(new Font("Arial",Font.PLAIN,20));
        setColor.setFont(new Font("Arial",Font.PLAIN,20));
        setPrice.setFont(new Font("Arial",Font.PLAIN,20));
        setStatus.setFont(new Font("Arial",Font.PLAIN,20));
        
        
        back.setFont(new Font("Arial",Font.BOLD,16));
        
        
        
        //adding image
        image = new ImageIcon(getClass().getResource("/Image/BMW_IX2.jfif"));
        imageLabel = new JLabel(image);
        imageLabel.setBounds(410,90,image.getIconWidth(),image.getIconHeight());
        
        
        //panel.setBackground(Color.decode("#24292e"));
        //panel.setForeground(Color.WHITE);
        
        panel.setLayout(null);
        
        panel.add(brandName);
        panel.add(model);
        panel.add(carID);
        panel.add(color);
        panel.add(price);
        panel.add(status);
        panel.add(back);
        panel.add(setname);
        panel.add(setModel);
        panel.add(setCarID);
        panel.add(setColor);
        panel.add(setPrice);
        panel.add(setStatus);
        panel.add(imageLabel);
        
        
        back.addActionListener(this);
        
        this.add(panel);
        setVisible(true);
    }
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            new Garage();
            setVisible(false);
        }
    }
    
    
}
