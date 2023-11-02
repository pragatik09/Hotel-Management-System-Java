
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice customer;
    JTextField room,av,status;
    JButton check,update,back;
    
    UpdateRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lid=new JLabel("Customer Id");
        lid.setBounds(30,80,100,30);
        add(lid);
        
        customer=new Choice();
        customer.setBounds(200,80,150,25);
        add(customer);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lroom=new JLabel("Room Number");
        lroom.setBounds(30,130,100,20);
        add(lroom);
        
        room=new JTextField();
        room.setBounds(200,130,150,25);
        add(room);
        
        JLabel lname=new JLabel("Availability");
        lname.setBounds(30,180,100,20);
        add(lname);
        
        av=new JTextField();
        av.setBounds(200,180,150,25);
        add(av);
        
        JLabel lcheckin=new JLabel("Cleaning Status");
        lcheckin.setBounds(30,230,100,20);
        add(lcheckin);
        
        status=new JTextField();
        status.setBounds(200,230,150,25);
        add(status);
        
        check=new JButton("Check");
        check.addActionListener(this);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
        add(check);
        
        update=new JButton("Update");
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,300,100,30);
        add(update);
        
        back=new JButton("Back");
        back.addActionListener(this); 
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,450);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id=customer.getSelectedItem();
            String query="select * from customer where number='"+id+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    room.setText(rs.getString("room"));
                    
                }
                ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+room.getText()+"'");
                while(rs2.next()){
                    av.setText(rs2.getString("availability"));
                    status.setText(rs2.getString("cleaning_status"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            String tfnumber=customer.getSelectedItem();
            String tfroom=room.getText();
            String tfav=av.getText();
            String tfstatus=status.getText();
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update room set availability='"+tfav+"',cleaning_status='"+tfstatus+"' where roomnumber='"+tfroom+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
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
        new UpdateRoom();
        
    }
    
}
