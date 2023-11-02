
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice customer;
    JTextField room,name,checkin,paid,pending;
    JButton check,update,back;
    
    UpdateCheck(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
        lroom.setBounds(30,120,100,20);
        add(lroom);
        
        room=new JTextField();
        room.setBounds(200,120,150,25);
        add(room);
        
        JLabel lname=new JLabel("Name");
        lname.setBounds(30,160,100,20);
        add(lname);
        
        name=new JTextField();
        name.setBounds(200,160,150,25);
        add(name);
        
        JLabel lcheckin=new JLabel("Checkin Time");
        lcheckin.setBounds(30,200,100,20);
        add(lcheckin);
        
        checkin=new JTextField();
        checkin.setBounds(200,200,150,25);
        add(checkin);
        
        JLabel lpaid=new JLabel("Amount Paid");
        lpaid.setBounds(30,240,100,20);
        add(lpaid);
        
        paid=new JTextField();
        paid.setBounds(200,240,150,25);
        add(paid);
        
        JLabel lpending=new JLabel("Pending Amount");
        lpending.setBounds(30,280,100,20);
        add(lpending);
        
        pending=new JTextField();
        pending.setBounds(200,280,150,25);
        add(pending);
        
        check=new JButton("Check");
        check.addActionListener(this);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
        add(check);
        
        update=new JButton("Update");
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,340,100,30);
        add(update);
        
        back=new JButton("Back");
        back.addActionListener(this); 
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340,100,30);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,500);
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
                    name.setText(rs.getString("name"));
                    checkin.setText(rs.getString("checkintime"));
                    paid.setText(rs.getString("deposit"));
                }
                ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+room.getText()+"'");
                while(rs2.next()){
                    String price=rs2.getString("price");
                    Integer ampaid=Integer.parseInt(price)-Integer.parseInt(paid.getText());
                    pending.setText(""+ampaid);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            String tfnumber=customer.getSelectedItem();
            String tfroom=room.getText();
            String tfname=name.getText();
            String tfcheckin=checkin.getText();
            String tfpaid=paid.getText();
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update customer set room='"+tfroom+"',name='"+tfname+"',checkintime='"+tfcheckin+"',deposit='"+tfpaid+"' where number='"+tfnumber+"'");
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
        new UpdateCheck();
        
    }
    
}
