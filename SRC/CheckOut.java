package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CheckOut extends JFrame implements ActionListener {
	
	JButton b1,b2,b3;
	Choice c1;
	JTextField t1;
	
	CheckOut(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/out.png"));
        Image i3 = i1.getImage().getScaledInstance(280, 220,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(400,0,350,200);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b3 = new JButton(i6);
        b3.setBounds(360,35,20,20);
        b3.addActionListener(this);
        add(b3);
		
		getContentPane().setBackground(Color.WHITE);
		
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
		
		JLabel l2 = new JLabel("Room no");
		l2.setBounds(20,80,120,30);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150,80,200,30);
		add(t1);
		
		
		b1= new JButton("Check Out");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(70,220,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2= new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(200,220,100,30);
		b2.addActionListener(this);
		add(b2);
		
		setLayout(null);
		setBounds(500,200,800,300);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String id = c1.getSelectedItem();
			String room = t1.getText();
			String str = "delete from customer where idn='"+id+"'";
			String str2 = "update room set available='Available' where room='"+room+"'";
			Conn c = new Conn();
			try {
				c.s.executeUpdate(str);
				c.s.executeUpdate(str2);
				
				JOptionPane.showMessageDialog(null, "Checked Out Done");
				new Reception().setVisible(true);
                this.setVisible(false);
			}catch (Exception e) {
				System.out.println(e);
			}
		}else if(ae.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
			
	}else if(ae.getSource() == b3) {
		
		Conn c = new Conn();
		String id = c1.getSelectedItem();
		try {
			ResultSet rs = c.s.executeQuery("select * from customer where idn='"+id+"'");
			while(rs.next()) {
				t1.setText(rs.getString("room"));
			}
		} catch (Exception e) {}
	}
	}

	public static void main(String[] args) {
		new CheckOut().setVisible(true);
		

	}

}
