package Customer;
import Classes.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Scanner;
import java.io.*;
import java.awt.event.*;

public class ReturnCar implements ActionListener  {

    JFrame frame;
    JPanel panel;
    JButton returnCar,back;
    JTable table;
    DefaultTableModel model;
    JScrollPane scPane;
    protected Object obj[];
    protected Scanner sc;
    protected File file;
    protected String id,msg1,msg2;
    protected String lines[];
	protected CustomerLoginInformation Cus;

	public ReturnCar(){}
    public ReturnCar(CustomerLoginInformation Cus)
    {
        this.Cus=Cus;
		this.id= Cus.getID();

        frame = new JFrame("Return Car");
        frame.setBounds(10,100,1500,650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        returnCar = new JButton("Return");
        back = new JButton("<<=");

        returnCar.setBounds(700,550,100,30);
        back.setBounds(1400,570,80,30);

        returnCar.setFont(new Font("Arial",Font.BOLD,18));
        back.setFont(new Font("Arial",Font.BOLD,18));

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(160,160,160));
        panel.add(returnCar);
        panel.add(back);

        returnCar.addActionListener(this);
        back.addActionListener(this);


       createTable();

    }

    public void createTable()
    {
        model = new DefaultTableModel();
        model.addColumn("Manufacturer");
        model.addColumn("Model");
        model.addColumn("Car ID");
        model.addColumn("Customer Id");
        model.addColumn("Pick up date");
        model.addColumn("Deadline");
        model.addColumn("Price/hr");
        model.addColumn("Total bill");
        model.addColumn("Paid");
        model.addColumn("Due");
        model.addColumn("Status");


        table = new JTable(model);
        table.setFont(new Font("Arial",Font.PLAIN,16));
        table.getTableHeader().setFont(new Font("Title",Font.BOLD,18));
        table.setRowHeight(30);
		table.setBackground(new Color(153,153,255));
        table.setSelectionBackground(new Color(255,102,102));

        scPane = new JScrollPane(table);
        scPane.setBounds(10,10,1480,500);
        panel.add(scPane);
        frame.add(panel);

        updateTable();

    }



        public void updateTable(){

//        int count = model.getColumnCount();
//        obj = new Object[count];



        try{

            file = new File("Data/Cutomer-"+id+"(Rent Information)"+".txt");

			if(!file.exists())
			{
				file.createNewFile();
			}

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);


//            System.out.println(br.readLine());
//            System.out.println(br.readLine());


            obj = br.lines().toArray();
          //System.out.println(obj[1]);

            for(int i =0;i<obj.length;i++)
            {
                String [] row = obj[i].toString().split(" ");
                model.addRow(row);
            }

            br.close();
            fr.close();






//            if(file.exists())
//            {
//                sc = new Scanner(file);
//                for(int i =0;i<obj.length;i++)
//                {
//                    obj[i]=sc.next();
//                }
//            }
//            else
//            {
//
//                JOptionPane.showConfirmDialog(null, "NO Rented Car Yet","Not found",JOptionPane.PLAIN_MESSAGE);
//
//            }
            //sc.close();



        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
       // model.addRow(obj);

        //System.out.println();







//
//        table = new JTable(model);
//        table.setFont(new Font("Arial",Font.PLAIN,16));
//        table.getTableHeader().setFont(new Font("Title",Font.BOLD,18));
//        table.setRowHeight(30);
//
//        scPane = new JScrollPane(table);
//        scPane.setBounds(10,10,1480,500);
//        panel.add(scPane);
//        frame.add(panel);
        frame.setVisible(true);




    }



    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==returnCar)
        {
            //model.removeRow(table.getSelectedRow());

            int x=table.getSelectedRow();


             String data = model.getValueAt(x, 0).toString()+" "
                          +model.getValueAt(x, 1).toString()+" "
                          +model.getValueAt(x, 2).toString()+" "
                          +model.getValueAt(x, 3).toString()+" "
                          +model.getValueAt(x, 4).toString()+" "
                          +model.getValueAt(x, 5).toString()+" "
                          +model.getValueAt(x, 6).toString()+" "
                          +model.getValueAt(x, 7).toString()+" "
                          +model.getValueAt(x, 8).toString()+" "
                          +model.getValueAt(x, 9).toString()+" "
                          +model.getValueAt(x, 10).toString()+" ";





           try
           {
               int a=model.getRowCount();
               int i=0;
               lines = new String[a];

               sc = new Scanner(file);

               while(sc.hasNext())
               {
                   while(i<lines.length)
                   {
                       lines[i]=sc.nextLine();
                       i++;
                       break;
                   }
               }

              sc.close();

              int flag=0;
              for(int j=0;j<lines.length;j++)
              {
                  if(lines[j].equals(data))
                  {
					  flag++;
                      for(int k=j;k<lines.length-1;k++)
                      {
                          lines[k]=lines[j+1];


                      }
                  }
              }

			  JOptionPane.showConfirmDialog(null, "You Have Successfully returned the Car","Successfull",JOptionPane.PLAIN_MESSAGE);
			   model.removeRow(x);


			 /* if(flag!=0)
               {
                   JOptionPane.showConfirmDialog(null, "You Have Successfully returned the Car");
				   model.removeRow(x);
               }

               else{
                   JOptionPane.showMessageDialog(null, "Car Returned Failed", "Failed", JOptionPane.INFORMATION_MESSAGE);
               }
			  */

              FileWriter writer = new FileWriter(file);

              for(int j =0;j<lines.length-1;j++)
              {
                  if(!lines[j].isEmpty())
                  writer.write(lines[j]+"\n");
              }

              writer.close();
              //model.removeRow(x);



           }

            catch(Exception ex)
            {
                System.out.println(ex);
            }





        }
        else if(e.getSource()==back)
        {
            new CustomerDashBoard(Cus);
            frame.setVisible(false);
        }

    }


}
