package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class RemoveRoom extends JFrame implements ActionListener{
	Choice c1;
	JTextField t1;
	JButton b1,b2;
	
	RemoveRoom(){
		
		JLabel l1 = new JLabel("Room Number");
		l1.setBounds(20,30,120,30);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l1);
		
		c1 = new  Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from room");
            while(rs.next()){
                c1.add(rs.getString("room"));    
            }
		}catch(Exception e){ }
		c1.setBounds(150,35,200,30);
		add(c1);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b1 = new JButton(i6);
        b1.setBounds(360,35,20,20);
        b1.addActionListener(this);
        add(b1);
		
		JLabel l2 = new JLabel("Type");
		l2.setBounds(20,80,120,30);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150,80,200,30);
		add(t1);
		
		b2= new JButton("Delete");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(170,150,100,30);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(450,200,450,250);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			Conn c = new Conn();
			String roomt = c1.getSelectedItem();
			
			try {
				ResultSet rs = c.s.executeQuery("select * from room where room='"+roomt+"'");
				while(rs.next()) {
					t1.setText(rs.getString("type"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == b2) {
			Conn c = new Conn();
			String room = c1.getSelectedItem();
			String str = "delete from room where room='"+room+"'";
			
			try {
				c.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "Room Deleted");
                this.setVisible(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		
		new RemoveRoom().setVisible(true);
		

	}

}
