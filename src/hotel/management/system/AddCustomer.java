
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField number,name,country,deposit;
    JRadioButton rmale,rfemale,rother;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    
    AddCustomer(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        add(text);
        
        JLabel lid=new JLabel("ID");
        lid.setBounds(35,80,100,20);
        lid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lid);
        
        String option[]={"Aadhaar Card","Passport","Driving License","Voter-id Card","Ration Card"};
        comboid=new JComboBox(option);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lnumber=new JLabel("Number");
        lnumber.setBounds(35,120,100,20);
        lnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lnumber);
        
        number=new JTextField();
        number.setBounds(200,120,150,25);
        add(number);
        
        JLabel lname=new JLabel("Name");
        lname.setBounds(35,160,100,20);
        lname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lname);
        
        name=new JTextField();
        name.setBounds(200,160,150,25);
        add(name);
        
        JLabel lgender=new JLabel("Gender");
        lgender.setFont(new Font("Raleway",Font.PLAIN,20));
        lgender.setBounds(35,200,100,20);
        add(lgender);
        
        rmale=new JRadioButton("Male");
        rmale.setBackground(Color.white);
        rmale.setBounds(200,200,60,25);
        add(rmale);
        
        rfemale=new JRadioButton("Female");
        rfemale.setBackground(Color.white);
        rfemale.setBounds(260,200,70,25);
        add(rfemale);
        
        rother=new JRadioButton("Other");
        rother.setBackground(Color.white);
        rother.setBounds(330,200,100,25);
        add(rother);
        
        JLabel lcountry=new JLabel("Country");
        lcountry.setBounds(35,240,100,20);
        lcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lcountry);
        
        country=new JTextField();
        country.setBounds(200,240,150,25);
        add(country);
        
        JLabel lroom=new JLabel("Room Number");
        lroom.setBounds(35,280,150,20);
        lroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lroom);
        
        
        //dynamically adding roomnumber from sql table
        croom=new Choice();
       
       try{
           Conn conn=new Conn();
           String query="select * from room where availability='Available'";
           ResultSet rs=conn.s.executeQuery(query);
           while(rs.next()){
               croom.add(rs.getString("roomnumber")); 
           }
       } catch(Exception e){
           e.printStackTrace();
       }
       
       croom.setBounds(200,280,150,25);
       add(croom);
       
       JLabel ltime=new JLabel("Checkin Time");
       ltime.setBounds(35,320,150,20);
       ltime.setFont(new Font("Raleway",Font.PLAIN,20));
       add(ltime);
       
       Date date=new Date();
       
       checkintime=new JLabel(""+date);
       checkintime.setBounds(200,320,150,25);
       checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
       add(checkintime);
       
       JLabel ldeposit=new JLabel("Deposit");
        ldeposit.setBounds(35,360,100,20);
        ldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(ldeposit);
        
        deposit=new JTextField();
        deposit.setBounds(200,360,150,25);
        add(deposit);
        
        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add.setBounds(50,410,120,30);
        add(add);
        
        back=new JButton("Back");
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,30);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String tfid=(String) comboid.getSelectedItem();
            String tfnumber=number.getText();
            String tfname=name.getText();
            String tfgender=null;
            
            if(rmale.isSelected()){
                tfgender="Male";
            }
            else if(rfemale.isSelected()){
                tfgender="Female";
            }
            else if(rother.isSelected()){
                tfgender="Other";
            }
            
            String tfcountry=country.getText();
            String tfroom=croom.getSelectedItem();
            String tftime=checkintime.getText();
            String tfdeposit=deposit.getText();
            
            try{
                String query="insert into customer value('"+tfid+"','"+tfnumber+"','"+tfname+"','"+tfgender+"','"+tfcountry+"','"+tfroom+"','"+tftime+"','"+tfdeposit+"')";
                String query2="update room set availability='Occupied' where roomnumber='"+tfroom+"'";
                Conn conn=new Conn();
                
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
    
}
