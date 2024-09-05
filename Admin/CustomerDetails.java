
package Admin;
import java.awt.Font;
import java.io.File;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;






public class CustomerDetails extends JFrame implements ActionListener  {
    
    JFrame frame;
    JPanel panel;
    JButton back;
    JTable table;
    DefaultTableModel model;
    JScrollPane scPane;
    protected Object obj[];
    protected Scanner sc;
    protected String id,msg1,msg2;
    protected File file;
    
    public CustomerDetails()
    {
        
        frame = new JFrame("Customer Details");
        frame.setBounds(10,100,1500,650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        back = new JButton("<<=");
        
       
        back.setBounds(1400,570,80,30);
        
        
        back.setFont(new Font("Arial",Font.BOLD,18));
        
        panel = new JPanel();
        panel.setLayout(null);
        //panel.setBackground(new Color(160,160,160));
        
        panel.add(back);
        
       
        back.addActionListener(this);
        
        
        createTable();
        
        
    }
    
    
    public void createTable()
    {
        
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("User Id");
        model.addColumn("Phone Num");
        model.addColumn("NID");
        model.addColumn("Email");
        model.addColumn("Gendeer");
        model.addColumn("B/O/D");
        model.addColumn("Current Add");
        model.addColumn("Permanent Add");
       
        
        
        
        
        
        
        table = new JTable(model);
        table.setFont(new Font("Arial",Font.PLAIN,16));
        table.getTableHeader().setFont(new Font("Title",Font.BOLD,18));
        table.setRowHeight(30);
       // table.setBackground(new Color(153,153,255));
       // table.setSelectionBackground(new Color(255,102,102));
	    //table.setEnabled(false);
		
        scPane = new JScrollPane(table);
        scPane.setBounds(10,10,1480,500);
        panel.add(scPane);
        frame.add(panel);
        
        
        updateTable();
        
    }
    
    
    
      
        public void updateTable()
        
  {
 
        
        
        try{
            
            file = new File("Data/AllCustomer.txt");
            if(!file.exists())
            {
                file.createNewFile();
            }
            
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
 
            
            obj = br.lines().toArray();
          
            
            for(int i =0;i<obj.length;i++)
            {
                String [] row = obj[i].toString().split(" ");
                model.addRow(row);
            }
            
            br.close();
            fr.close();
            
            
            
            
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
      
        frame.setVisible(true);
        
        
        
                
  }
    
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            new AuthorityDashBoard();
            frame.setVisible(false);
        }
        
    }
    
    
}
