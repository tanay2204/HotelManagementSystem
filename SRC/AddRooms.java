package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
	
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
	
	AddRooms(){
		
		JLabel room = new JLabel("ROOM NUMBER");
		room.setBounds(40,30,120,30);
		room.setForeground(Color.BLACK);
		room.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(room);
		
		t1 = new JTextField();
		t1.setBounds(200,35,200,30);
		add(t1);
		
		JLabel available = new JLabel("AVAILABLE");
		available.setBounds(40,85,120,30);
		available.setForeground(Color.BLACK);
		available.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(available);
		
		c1 = new JComboBox(new String[] { "Available", "Occupied"});
		c1.setBounds(200,85,200,30);
		add(c1);
		
		JLabel status = new JLabel("STATUS");
		status.setBounds(40,135,120,30);
		status.setForeground(Color.BLACK);
		status.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(status);
		
		c2 = new JComboBox(new String[] { "Cleaned", "Dirty"});
		c2.setBounds(200,135,200,30);
		add(c2);
		
		JLabel price = new JLabel("PRICE");
		price.setBounds(40,185,120,30);
		price.setForeground(Color.BLACK);
		price.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(price);
		
		JLabel type = new JLabel("TYPE");
		type.setBounds(40,235,120,30);
		type.setForeground(Color.BLACK);
		type.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(type);
		
		c3 = new JComboBox(new String[] { "Standard","Bussiness","Luxury","Suits"});
		c3.setBounds(200,235,200,30);
		add(c3);
		
		t2 = new JTextField();
		t2.setBounds(200,185,200,30);
		add(t2);
		
		b1= new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(150,290,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2= new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(300,290,100,30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/addroom.jpg"));
        Image i3 = i1.getImage().getScaledInstance(626,400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(0,0,626,400);
        add(l15);
		
		setLayout(null);
		setBounds(400,200,626,400);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			
			String room = t1.getText();
			String available = (String)c1.getSelectedItem();
			String status = (String)c2.getSelectedItem();
			String price = t2.getText();
			String type = (String)c3.getSelectedItem();
			
			Conn c = new Conn();
			
			String str = "insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
			
			try {
				
				c.s.executeUpdate(str);
				
	        	JOptionPane.showMessageDialog(null,"Room Added");
	            this.setVisible(true);
	            
			}catch(Exception e) {
				System.out.println(e);
				
			}
			
			
			
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		
		new AddRooms().setVisible(true);
		

	}

}
