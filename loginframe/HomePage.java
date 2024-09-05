
package loginframe;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class HomePage extends JFrame implements ActionListener {
    
    protected JLabel myLabel;
    protected JPanel Panel;
    protected JButton click;
    
    
    public HomePage()
    {
        
        
        this.setTitle("Home Page");
        this.setBounds(450,200,736,414);
       
        Panel= new JPanel();
        click = new JButton("Goto LogInFrame");
        
        ImageIcon image = new ImageIcon(getClass().getResource("/Image/homePage.jpg"));
        myLabel = new JLabel(image);
        myLabel.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
        click.setBounds(260,10,220,40);
        click.setFont(new Font("Title",Font.BOLD,18));
        click.setBackground(Color.red);
        
        Panel.setLayout(null);
        myLabel.add(click);
        Panel.add(myLabel);
        this.add(Panel);
        
        click.addActionListener(this);
        
        this.setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==click)
        {
         new LoginFrame();   
		 setVisible(false);
        }
    }
    
}
