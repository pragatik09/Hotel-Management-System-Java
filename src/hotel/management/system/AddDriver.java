package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JButton add,cancel;
    JTextField name,age,company,model,location;
    JComboBox gendercombo,avcombo;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lname=new JLabel("Name");
        lname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lname.setBounds(60,80,120,30);
        add(lname);
        
        name=new JTextField();
        name.setBounds(200,80,150,30);
        add(name);
        
        JLabel lage=new JLabel("Age");
        lage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lage.setBounds(60,130,120,30);
        add(lage);
        
        age=new JTextField();
        age.setBounds(200,130,150,30);
        add(age);
        
        JLabel lgender=new JLabel("Gender");
        lgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lgender.setBounds(60,180,120,30);
        add(lgender);
        
        String gop[]={"Male","Female","Other"};
        gendercombo= new JComboBox(gop);
        gendercombo.setBounds(200,180,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        JLabel lcar=new JLabel("Car Company");
        lcar.setFont(new Font("Tahoma",Font.PLAIN,16));
        lcar.setBounds(60,230,120,30);
        add(lcar);
        
        company=new JTextField();
        company.setBounds(200,230,150,30);
        add(company);
        
        JLabel ltype=new JLabel("Car Model");
        ltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        ltype.setBounds(60,280,120,30);
        add(ltype);
        
        model=new JTextField();
        model.setBounds(200,280,150,30);
        add(model);
        
        JLabel lavail=new JLabel("Availability");
        lavail.setFont(new Font("Tahoma",Font.PLAIN,16));
        lavail.setBounds(60,330,120,30);
        add(lavail);
        
        String driverop[]={"Available","Busy"};
        avcombo= new JComboBox(driverop);
        avcombo.setBounds(200,330,150,30);
        avcombo.setBackground(Color.WHITE);
        add(avcombo);
        
        JLabel lloca=new JLabel("Location");
        lloca.setFont(new Font("Tahoma",Font.PLAIN,16));
        lloca.setBounds(60,380,120,30);
        add(lloca);
        
        location=new JTextField();
        location.setBounds(200,380,150,30);
        add(location);
        
        add=new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,430,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,430,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,350,   Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,430);
        add(image);
        
                
        setBounds(300,200,980,530);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String tfname=name.getText();
            String tfage=age.getText();
            String av=(String) avcombo.getSelectedItem();
            String tfgender=(String) gendercombo.getSelectedItem();
            String tfcompany=company.getText();
            String brand=model.getText();
            String tfloc=location.getText();
            
            try{
                Conn conn=new Conn();
                String str="insert into driver values('"+tfname+"','"+tfage+"','"+tfgender+"','"+tfcompany+"','"+brand+"','"+av+"','"+tfloc+"')";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
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
        new AddDriver();
    }
}
