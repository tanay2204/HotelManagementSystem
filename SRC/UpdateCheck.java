package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener {
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4,t5;
	Choice c1;
	
	
	UpdateCheck(){
		
		JLabel l1 = new JLabel("Customer Id");
		l1.setBounds(20,30,120,30);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l1);
		
		c1 = new  Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("idn"));    
            }
		}catch(Exception e){ }
		c1.setBounds(150,35,200,30);
		add(c1);
		
		JLabel l2 = new JLabel("Room no");
		l2.setBounds(20,80,120,30);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150,80,200,30);
		add(t1);
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(20,130,120,30);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(150,130,200,30);
		add(t2);
		
		JLabel l4 = new JLabel("Check-In");
		l4.setBounds(20,180,120,30);
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(150,180,200,30);
		add(t3);
		
		JLabel l5 = new JLabel("Amount Paid");
		l5.setBounds(20,230,120,30);
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l5);
		
		t4 = new JTextField();
		t4.setBounds(150,230,200,30);
		add(t4);
		
		JLabel l6 = new JLabel("Amount Pending");
		l6.setBounds(20,280,120,30);
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l6);
		
		t5 = new JTextField();
		t5.setBounds(150,280,200,30);
		add(t5);
		
		b1= new JButton("Check");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(140,350,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2= new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(210,400,100,30);
		b2.addActionListener(this);
		add(b2);
		
		b3= new JButton("Update");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(70,400,100,30);
		b3.addActionListener(this);
		add(b3);
		
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/check.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
		
		setLayout(null);
		setBounds(300,200,980,500);
		setVisible(true);

	
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			
			try {
				String room = null;
				String deposite = null;
				int amountpaid;
				String price = null;
				Conn c = new Conn();
				String id = c1.getSelectedItem();
				String str = "select * from customer where idn = '"+id+"'";
				ResultSet rs = c.s.executeQuery(str);
				while(rs.next()) {
					t1.setText(rs.getString("room"));
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("checked"));
					t4.setText(rs.getString("deposite"));
					room = rs.getString("room");
					deposite = rs.getString("deposite");
					
				}
				
				ResultSet rs2 = c.s.executeQuery("select * from room where room ='"+room+"' ");
				while(rs2.next()) {
					price = rs2.getString("price");
					amountpaid = Integer.parseInt(price) - Integer.parseInt(deposite);
					t5.setText(Integer.toString(amountpaid));
				}
			}catch (Exception e){ }
			
		}else if(ae.getSource() == b3){
			try {
				
				Conn c = new Conn();
				
				String s1 = c1.getSelectedItem();
				String s2 = t1.getText();    
                String s3 = t2.getText();    
                String s4 = t3.getText();     
                String s5 = t4.getText();  
				
                String str1 = "update customer set room = '"+s2+"', name = '"+s3+"', checked = '"+s4+"', deposite = '"+s5+"' where idn = '"+s1+"'";
                
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "Data Updated");
                new Reception().setVisible(true);
                this.setVisible(false);
			}catch (Exception e){ 
				System.out.println(e);
			}
			
		}else if(ae.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		
		new UpdateCheck().setVisible(true);
		
	}

}

