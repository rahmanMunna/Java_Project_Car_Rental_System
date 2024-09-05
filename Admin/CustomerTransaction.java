
package Admin;
import loginframe.*;
import Classes.*;

import java.awt.*;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class CustomerTransaction extends JFrame implements ActionListener {
    
    
   protected JPanel panel; 
   protected JTable table;
   protected DefaultTableModel model;
   protected JScrollPane scPane;
   protected Object[] obj;
   protected String[] row;
   protected File file;
   protected JButton back;
   protected JLabel label;
   protected JTextField showAmount;
   
   public CustomerTransaction()
    {
        this.setTitle("Customer Transaction");
        this.setBounds(00,50,1500,700);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        label = new JLabel("Total Earning : ");
        label.setBounds(550,550,150,40);
        label.setFont(new Font("Arial",Font.BOLD,19));
        
        back = new  JButton("<-Back");
        back.setBounds(1320,600,150,40);
        back.setFont(new Font("Arial",Font.BOLD,17));
        
        panel = new JPanel();
        panel.setLayout(null);
       // panel.setBackground(new Color(160,160,160));
        panel.add(back);
        panel.add(label);
        
        back.addActionListener(this);
        
        
        createTable();
        
    }
    
     public void createTable()
    {
        
        model = new DefaultTableModel();
        model.addColumn("Customer ID");
        model.addColumn("Phone Number");
        model.addColumn("Money Recieved From Customer(TK)");
//        model.addColumn("NID");
//        model.addColumn("Email");
//        model.addColumn("Gendeer");
//        model.addColumn("B/O/D");
//        model.addColumn("Current Add");
//        model.addColumn("Permanent Add");
       
        
        
        
        
        
        
        table = new JTable(model);
        table.setFont(new Font("Arial",Font.PLAIN,16));
        table.getTableHeader().setFont(new Font("Title",Font.BOLD,18));
        table.setRowHeight(30);
        //table.setBackground(new Color(153,153,255));
        //table.setSelectionBackground(new Color(255,102,102));
		//table.setEnabled(false);
		 
        scPane = new JScrollPane(table);
        scPane.setBounds(10,10,1480,500);
        panel.add(scPane);
        
        
        
        updateTable();
        
    }
    
     public void updateTable()
     {
         
         try{
         file = new File("Data/AllTransactionDetails.txt");
         
         if(file.exists())
            
         {  FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
          
            obj = br.lines().toArray();
          
            
            for(int i =0;i<obj.length;i++)
            {
                row = obj[i].toString().split(" ");
                model.addRow(row);
                
            }
            
            br.close();
            
            
            double total=0;
            
            for(int i=0;i<obj.length;i++)
            {
               total+=Double.parseDouble(model.getValueAt(i, 2).toString());
               //System.out.println(total);
            }
            
            String x =Double.toString(total);
            //System.out.println(x);
            showAmount= new JTextField();
            showAmount.setText(x+" Tk");
            showAmount.setBounds(700,550, 120, 40);
            showAmount.setFont(new Font("Arial",Font.BOLD,18));
            showAmount.setEditable(false);
            
            
             }
         
         }
         catch(Exception ex)
             
         {
             System.out.println(ex);
             //JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.INFORMATION_MESSAGE);
         }
         
      panel.add(showAmount);  
      this.add(panel);
      this.setVisible(true);
         
     }
     
     public void actionPerformed(ActionEvent e)
     {
         if(e.getSource()==back)
         {
             new AuthorityDashBoard();
             this.setVisible(false);
         }
     }
     
}
