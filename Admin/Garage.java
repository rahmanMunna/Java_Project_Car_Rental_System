
package Admin;
import loginframe.*;
import Classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.border.Border;

public class Garage extends JFrame implements ActionListener{
    
   protected JLabel label1,label2,label3,label4,label5,label6;
   protected JButton btn1,btn2,btn3,btn4,btn5,btn6,back;
   protected ImageIcon img1,img2,img3,img4,img5,img6,img7;
   protected Font F;
   protected JPanel panel;
  // protected Car[] c;
   protected Cursor cursor;
  // protected Car car;
   
        Car camry = new Toyota("TOYOTA","CAMRY","01","BLUE",750,"Available");
        Car Corolla = new Toyota("TOYOTA","COROLLA","02","BLUE",650,"Available");
        Car IX2 = new BMW("BMW","BMW IX2","03","BLUE",700,"Available");
        Car i20 = new Hyundai("HYUNDAI","HYUNDAI I20","05","WHITE",720,"Available"); 
        Car GTR = new Nissan("NISSAN","GT-R","06","ORANGE",750,"Available");
        Car A4 = new Audi("AUDI","A4","07","BLUE",710,"Available");
   
  
  
  public  Garage()
   {
      // c= new Car[number];
       //this.c=car.getCar();
       cursor = new Cursor(Cursor.HAND_CURSOR);
       
       this.setTitle("Garage");
       this.setBounds(150,0,1300,800);
       this.setResizable(false);
       this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
       
       //initializing 
       
      
       
       
       img1 = new ImageIcon(getClass().getResource("/image/ToyotaCamry.jfif"));
       img2 = new ImageIcon(getClass().getResource("/image/ToyotaCorolla.jfif"));
       img3 = new ImageIcon(getClass().getResource("/image/BMW_IX2.jfif"));
       img4 = new ImageIcon(getClass().getResource("/image/AudiA4.jfif"));
       img5 = new ImageIcon(getClass().getResource("/image/Hyundai_I20.jfif"));
       img6 = new ImageIcon(getClass().getResource("/image/NIssanGTR.jfif"));
       
       
       
       
       
       
       label1 = new JLabel(img1);
       label2 = new JLabel(img2);
       label3 = new JLabel(img3);
       label4 = new JLabel(img4);
       label5 = new JLabel(img5);
       label6 = new JLabel(img6);
       
       
       btn1 = new JButton("See more");
       btn2 = new JButton("See more");
       btn3 = new JButton("See more");
       btn4 = new JButton("See more");
       btn5 = new JButton("See more");
       btn6 = new JButton("See more");
       back = new JButton("<<-");
       //adding cursor
       btn1.setCursor(cursor);
       btn2.setCursor(cursor);
       btn3.setCursor(cursor);
       btn4.setCursor(cursor);
       btn5.setCursor(cursor);
       btn6.setCursor(cursor);
       back.setCursor(cursor);
       
       
       F= new Font("Title",Font.BOLD,18);
       
       panel= new JPanel();
       
       
       //set size 
       label1.setBounds(60,60,img1.getIconWidth(),img1.getIconHeight());
       label2.setBounds(450,60,img2.getIconWidth(),img2.getIconHeight());
       label3.setBounds(855,60,img3.getIconWidth(),img3.getIconHeight());
       label4.setBounds(60,400,img4.getIconWidth(),img4.getIconHeight());
       label5.setBounds(450,400,img5.getIconWidth(),img5.getIconHeight());
       label6.setBounds(855,400,img6.getIconWidth(),img6.getIconHeight());
       
       btn1.setBounds(200,310,120,30);
       btn2.setBounds(550,310,120,30);
       btn3.setBounds(965,310,120,30);
       btn4.setBounds(200,655,120,30);
       btn5.setBounds(570,655,120,30);
       btn6.setBounds(965,655,120,30);
       back.setBounds(1180,710,85,30);
       
       
      btn1.setBorder(BorderFactory.createEmptyBorder());
      btn2.setBorder(BorderFactory.createEmptyBorder());
       btn3.setBorder(BorderFactory.createEmptyBorder());
       btn4.setBorder(BorderFactory.createEmptyBorder());
       btn5.setBorder(BorderFactory.createEmptyBorder());
       btn6.setBorder(BorderFactory.createEmptyBorder());
       
       
       
       
       
       btn1.setFont(F);
       btn2.setFont(F);
       btn3.setFont(F);
       btn4.setFont(F);
       btn5.setFont(F);
       btn6.setFont(F);
       back.setFont(F);
       
       
       
       //color
      btn1.setBackground(new Color(102,178,255));
      btn2.setBackground(new Color(102,178,255));
      btn3.setBackground(new Color(102,178,255));
      btn4.setBackground(new Color(102,178,255));
      btn5.setBackground(new Color(102,178,255));
      btn6.setBackground(new Color(102,178,255));
      panel.setBackground(new Color(102,178,255));
      panel.setLayout(null);
       
       panel.add(label1);
       panel.add(label2);
       panel.add(label3);
       panel.add(label4);
       panel.add(label5);
       panel.add(label6);
       panel.add(btn1);
       panel.add(btn2);
       panel.add(btn3);
       panel.add(btn4);
       panel.add(btn5);
       panel.add(btn6);
       panel.add(back);
       
      
       this.add(panel);
       
       btn1.addActionListener(this);
       btn2.addActionListener(this);
       btn3.addActionListener(this);
       btn4.addActionListener(this);
       btn5.addActionListener(this);
       btn6.addActionListener(this);
       back.addActionListener(this);
       
       
       this.setVisible(true);
       
               
       
       
   }
  

  
 
  
public void  actionPerformed(ActionEvent e)
  {
      if(e.getSource()==btn1)
      {
         new GuiToyotaCamry(camry);
         this.setVisible(false);
      }
      else if(e.getSource()==btn2)
      {
         new GuiToyotaCorolla(Corolla);
         this.setVisible(false);
          
      }
      else if(e.getSource()==btn3)
      {
         new GuiBMW_IX2(IX2);
         this.setVisible(false);
          
      }
      else if(e.getSource()==btn4)
      {
         new GuiAudiA4(A4);
         this.setVisible(false);
          
      }
      else if(e.getSource()==btn5)
      {
         new GuiHyundai_I20(i20);
         this.setVisible(false);
      }
      else if(e.getSource()==btn6)
      {
         new GuiNissanGTR(GTR);
         this.setVisible(false);
          
      }
            
      else if(e.getSource()==back)
      {
          new AuthorityDashBoard();
          setVisible(false);
      }
      
      
      
      
      
      
      
  }
   
   
   
      
}
