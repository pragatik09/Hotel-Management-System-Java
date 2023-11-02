package hotel.management.system;

import java.util.regex.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField name,age,salary,phone,email,aadhar;
    JRadioButton male,female,other;
    JButton submit;
    JComboBox cbjob;
    
    
    AddEmployee(){
        setLayout(null);
        
        JLabel label=new JLabel("NAME");
        label.setBounds(60,30,120,30);
        label.setFont(new Font("Tahoma",Font.BOLD,17));
        add(label);
        
        name=new JTextField();
        name.setBounds(200,30,150,30);
        add(name);
        
        JLabel lage=new JLabel("AGE");
        lage.setBounds(60,80,120,30);
        lage.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lage);
        
        age=new JTextField();
        age.setBounds(200,80,150,30);
        add(age);
        
        JLabel lgender=new JLabel("GENDER");
        lgender.setBounds(60,130,120,30);
        lgender.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lgender);
        
        male=new JRadioButton("Male");
        male.setBounds(200,130,70,30);
        male.setFont(new Font("Tahoma",Font.PLAIN,14));
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(270,130,70,30);
        female.setFont(new Font("Tahoma",Font.PLAIN,14));
        female.setBackground(Color.WHITE);
        add(female);
        
        other=new JRadioButton("Other");
        other.setBounds(350,130,70,30);
        other.setFont(new Font("Tahoma",Font.PLAIN,14));
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(other);
        
        JLabel ljob=new JLabel("JOB");
        ljob.setBounds(60,180,120,30);
        ljob.setFont(new Font("Tahoma",Font.BOLD,17));
        add(ljob);
        
        String str[]={"Receptionist","Front Desk CLerk","Porter","Housekeeping","Kitchen Staff","Room Service","Chef","Waiter/Waitress","Manager","Accountant","Driver"};
        cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        JLabel lsalary=new JLabel("SALARY");
        lsalary.setBounds(60,230,120,30);
        lsalary.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lsalary);
        
        salary=new JTextField();
        salary.setBounds(200,230,150,30);
        add(salary);
        
        JLabel lphone=new JLabel("PHONE");
        lphone.setBounds(60,280,120,30);
        lphone.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lphone);
        
        phone=new JTextField();
        phone.setBounds(200,280,150,30);
        add(phone);
        
        JLabel lemail=new JLabel("EMAIL");
        lemail.setBounds(60,330,120,30);
        lemail.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lemail);
        
        email=new JTextField();
        email.setBounds(200,330,150,30);
        add(email);
        
        JLabel ladhaar=new JLabel("AADHAAR");
        ladhaar.setBounds(60,380,120,30);
        ladhaar.setFont(new Font("Tahoma",Font.BOLD,17));
        add(ladhaar);
        
        aadhar=new JTextField();
        aadhar.setBounds(200,380,150,30);
        add(aadhar);
        
        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(350,200,850,540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String tfname=name.getText();
        String tfage=age.getText();
        String tfsalary=salary.getText();
        String tfphone=phone.getText();
        String tfemail=email.getText();
        String tfaadhar=aadhar.getText();
        
        String regex =  "^[a-zA-Z0-9_+&*-]+(?:\\."+
                         "[a-zA-Z0-9_+&*-]+)*@" +
                         "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                         "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(tfemail); 
        
        String gender=null;
        
        //Field checks
        if(tfname.equals("") || tfage.equals("") || tfsalary.equals("") || tfphone.equals("") || tfemail.equals("") || tfaadhar.equals("")){
            JOptionPane.showMessageDialog(null, "One or more fields are empty");
            return;
        }
        else if(tfphone.length()!=10){
            JOptionPane.showMessageDialog(null, "Please enter a 10 digit Phone number");
            return;
        }
        else if(tfaadhar.length()!=12){
            JOptionPane.showMessageDialog(null, "Please enter a 12 digit Aadhaar number");
            return;
        }
        else if(matcher.matches()==false){
            JOptionPane.showMessageDialog(null, "Please enter a valid email address ");
            return;
        }
        
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        else if(other.isSelected()){
            gender="Other";
        }
        
        String job=(String)cbjob.getSelectedItem();
        
        try{
            Conn conn=new Conn();
            String query="insert into employee values('"+tfname+"','"+tfage+"','"+gender+"','"+job+"','"+tfsalary+"','"+tfphone+"','"+tfemail+"','"+tfaadhar+"')";
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee details added successfully");
            setVisible(false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new AddEmployee();
    }
    
}
