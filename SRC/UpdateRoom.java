package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
	
	JButton b1,b2,b3;
	JTextField t1,t2,t3;
	Choice c1;
	
	UpdateRoom(){
		
		JLabel l1 = new JLabel("Guest Id");
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
		
		JLabel l2 = new JLabel("Room Number");
		l2.setBounds(20,80,120,30);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150,80,200,30);
		add(t1);
		
		JLabel l3 = new JLabel("Availability");
		l3.setBounds(20,130,120,30);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(150,130,200,30);
		add(t2);
		
		JLabel l5 = new JLabel("Clean Status");
		l5.setBounds(20,180,120,30);
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l5);
		
		t3 = new JTextField();
		t3.setBounds(150,180,200,30);
		add(t3);
		
		b1= new JButton("Check");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(140,290,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2= new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(210,340,100,30);
		b2.addActionListener(this);
		add(b2);
		
		b3= new JButton("Update");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(70,340,100,30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/clean.gif"));
        Image i3 = i1.getImage().getScaledInstance(600, 450,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,600,450);
        add(image);
		
		setLayout(null);
		setBounds(300,200,600,450);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String room = null;
			String s1 = c1.getSelectedItem();
			Conn c = new Conn();
			try {
			ResultSet rs = c.s.executeQuery("select * from customer where idn = '"+s1+"'");
			while(rs.next()) {
				t1.setText(rs.getString("room"));
				room = rs.getString("room");
			}
			ResultSet rs2 = c.s.executeQuery("select * from room where room = '"+room+"'");
			while(rs2.next()) {
				t2.setText(rs2.getString("available"));
				t3.setText(rs2.getString("status"));
			}
			}catch(Exception e){ }
		}else if(ae.getSource() == b3) {
			try {
				Conn c = new Conn();
				String room = t1.getText();
				String available = t2.getText();
				String status = t3.getText();
				
				String str = "update room set available='"+available+"', status ='"+status+"' where room = '"+room+"' ";
				c.s.executeUpdate(str);
				JOptionPane.showInternalMessageDialog(null,"Room Updated");
				new Reception().setVisible(true);
				this.setVisible(false);
			}catch(Exception e){ }
			
		}else if(ae.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
public static void main(String[] args) {
		
		new UpdateRoom().setVisible(true);
		

	}

}
