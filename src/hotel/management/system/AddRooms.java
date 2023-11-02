package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JButton add,cancel;
    JTextField room,price;
    JComboBox avcombo,tycombo,clcombo;
    
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lroomno=new JLabel("Room Number");
        lroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lroomno.setBounds(60,80,120,30);
        add(lroomno);
        
        room=new JTextField();
        room.setBounds(200,80,150,30);
        add(room);
        
        JLabel lavail=new JLabel("Availability");
        lavail.setFont(new Font("Tahoma",Font.PLAIN,16));
        lavail.setBounds(60,130,120,30);
        add(lavail);
        
        String availop[]={"Available","Occupied"};
        avcombo= new JComboBox(availop);
        avcombo.setBounds(200,130,150,30);
        avcombo.setBackground(Color.WHITE);
        add(avcombo);
        
        JLabel lclean=new JLabel("Cleaning Status");
        lclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lclean.setBounds(60,180,120,30);
        add(lclean);
        
        String cleanop[]={"Cleaned","Dirty"};
        clcombo= new JComboBox(cleanop);
        clcombo.setBounds(200,180,150,30);
        clcombo.setBackground(Color.WHITE);
        add(clcombo);
        
        JLabel lprice=new JLabel("Price");
        lprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lprice.setBounds(60,230,120,30);
        add(lprice);
        
        price=new JTextField();
        price.setBounds(200,230,150,30);
        add(price);
        
        JLabel ltype=new JLabel("Bed Type");
        ltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        ltype.setBounds(60,280,120,30);
        add(ltype);
        
        String typeop[]={"Single Bed","Double Bed"};
        tycombo= new JComboBox(typeop);
        tycombo.setBounds(200,280,150,30);
        tycombo.setBackground(Color.WHITE);
        add(tycombo);
        
        add=new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
                
        setBounds(330,200,940,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String tfroom=room.getText();
            String av=(String) avcombo.getSelectedItem();
            String status=(String) clcombo.getSelectedItem();
            String tfprice=price.getText();
            String type=(String) tycombo.getSelectedItem();
            
            try{
                Conn conn=new Conn();
                String str="insert into room values('"+tfroom+"','"+av+"','"+status+"','"+tfprice+"','"+type+"')";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddRooms();
    }
}
