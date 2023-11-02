package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel text=new JLabel("Search for Room");
         text.setFont(new Font("Tahoma",Font.PLAIN,20));
         text.setBounds(400,30,200,30);
         add(text);
         
         JLabel lbed=new JLabel("Bed Type");
         lbed.setBounds(50,100,100,20);
         add(lbed);
         
         bedtype=new JComboBox(new String[]{"Single Bed","Double Bed"});
         bedtype.setBounds(150,100,150,25);
         bedtype.setBackground(Color.WHITE);
         add(bedtype);
         
         available=new JCheckBox("Only display Available Rooms");
         available.setBounds(600,100,300,25);
         available.setBackground(Color.WHITE);
         add(available);
         
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);
        add(l5);
        
        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        //Display all rooms
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
       
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                //Display rooms as per conditions
                Conn conn=new Conn();
                String query1="select * from room where bed_type='"+bedtype.getSelectedItem()+"'";
                String query2="select * from room where availability='Available' AND bed_type='"+bedtype.getSelectedItem()+"'";
                ResultSet rs;
                if(available.isSelected()){
                    rs=conn.s.executeQuery(query2);
                }else{
                    rs=conn.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new SearchRoom();
    }
}

