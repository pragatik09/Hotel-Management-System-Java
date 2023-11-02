
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    
    JButton newcust,rooms,dept,allemp,manager,customers,sroom,status,update,pickup,logout,checkout;
    
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); 
        
        newcust=new JButton("New Customer Form");
        newcust.addActionListener(this);
        newcust.setBounds(10,30,200,30);
        newcust.setBackground(Color.BLACK);
        newcust.setForeground(Color.WHITE);
        add(newcust);
        
        rooms=new JButton("Rooms");
        rooms.addActionListener(this);
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        add(rooms);
        
        dept=new JButton("Department");
        dept.addActionListener(this);
        dept.setBounds(10,110,200,30);
        dept.setBackground(Color.BLACK);
        dept.setForeground(Color.WHITE);
        add(dept);
        
        allemp=new JButton("All Employees Info");
        allemp.addActionListener(this);        
        allemp.setBounds(10,150,200,30);
        allemp.setBackground(Color.BLACK);
        allemp.setForeground(Color.WHITE);
        add(allemp);
        
        customers=new JButton("Customer Info");
        customers.addActionListener(this);
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        add(customers);
        
        manager=new JButton("Manager Info");
        manager.addActionListener(this); 
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        add(manager);
        
        checkout=new JButton("Checkout");
        checkout.addActionListener(this);
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);
        
        update=new JButton("Update Customer Status");
        update.addActionListener(this);
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);
        
        status=new JButton("Update Room Status");
        status.addActionListener(this);
        status.setBounds(10,350,200,30);
        status.setBackground(Color.BLACK);
        status.setForeground(Color.WHITE);
        add(status);
        
        pickup=new JButton("Pickup Service");
        pickup.addActionListener(this);
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        add(pickup);
        
        sroom=new JButton("Search Room");
        sroom.addActionListener(this);
        sroom.setBounds(10,430,200,30);
        sroom.setBackground(Color.BLACK);
        sroom.setForeground(Color.WHITE);
        add(sroom);
        
        logout=new JButton("Logout");
        logout.addActionListener(this);
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newcust){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==dept){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource()==allemp){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource()==manager){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource()==customers){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource()==sroom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource()==status){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource()==pickup){
            setVisible(false);
            new Pickup();
        }
        else if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
        
    }
    
    public static void main(String[] args){
        new Reception();
    }
}
