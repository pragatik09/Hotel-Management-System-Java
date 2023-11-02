
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
    Choice customer;
    JLabel roomnumber,checkin,checkout;
    JButton checkoutb,back;
    Checkout(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel lid=new JLabel("Checkout");
        lid.setBounds(30,80,100,30);
        add(lid);
        
        customer=new Choice();
        customer.setBounds(150,80,150,25);
        add(customer);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel tick=new JLabel(i3);
        tick.setBounds(310,80,20,20);
        add(tick);
        
        JLabel lroom=new JLabel("Room Number");
        lroom.setBounds(30,130,100,30);
        add(lroom);
        
        roomnumber=new JLabel();
        roomnumber.setBounds(150,130,100,30);
        add(roomnumber);
        
        JLabel lcheckin=new JLabel("Checkin Time");
        lcheckin.setBounds(30,180,100,30);
        add(lcheckin);
        
        checkin=new JLabel();
        checkin.setBounds(150,180,170,30);
        add(checkin);
        
        JLabel lcheckout=new JLabel("Checkout Time");
        lcheckout.setBounds(30,230,100,30);
        add(lcheckout);
        
        Date date=new Date();
        checkout=new JLabel(""+date);
        checkout.setBounds(150,230,170,30);
        add(checkout);
        
        checkoutb=new JButton("Checkout");
        checkoutb.addActionListener(this);
        checkoutb.setBackground(Color.BLACK);
        checkoutb.setForeground(Color.WHITE);
        checkoutb.setBounds(30,280,120,30);
        add(checkoutb);
        
        back=new JButton("Back");
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
        add(back);
        
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
                roomnumber.setText(rs.getString("room"));
                checkin.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(350,50,400,250);
        add(image);
        
        
        setBounds(300,200,800,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkoutb){
            String query1="delete from customer where number='"+customer.getSelectedItem()+"'";
            String query2="update room set availability='Available' where roomnumber= '"+roomnumber.getText()+"'";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Checkout Done!");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Checkout();
    }
}
