package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener {
	
	JButton b1,b2,b4,b5,b6,b7,b8,b9,b10,b11;
	
	Reception(){
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/cust.jpg"));
        Image i8 = i7.getImage().getScaledInstance(200, 41,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        b1 = new JButton(i9);
        b1.setBounds(10,20,200,41);
        b1.addActionListener(this);
        add(b1);
		
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/room_button.jpg"));
        Image i11 = i10.getImage().getScaledInstance(200, 41,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        b2 = new JButton(i12);
        b2.setBounds(10,80,200,41);
        b2.addActionListener(this);
        add(b2);
		
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/emp_button.jpg"));
        Image i14 = i13.getImage().getScaledInstance(200, 41,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        b4 = new JButton(i15);
        b4.setBounds(700,80,200,41);
        b4.addActionListener(this);
        add(b4);
		
        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/CUST_button.jpg"));
        Image i17 = i16.getImage().getScaledInstance(200, 41,Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        b5 = new JButton(i18);
        b5.setBounds(350,20,200,41);
        b5.addActionListener(this);
        add(b5);
		
        ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/MAN_button.jpg"));
        Image i20 = i19.getImage().getScaledInstance(200, 41,Image.SCALE_DEFAULT);
        ImageIcon i21 = new ImageIcon(i20);
        b6 = new JButton(i21);
        b6.setBounds(700,20,200,41);
        b6.addActionListener(this);
        add(b6);
		
        ImageIcon i22 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/CHECK_Obutton.jpg"));
        Image i23 = i22.getImage().getScaledInstance(200, 41,Image.SCALE_DEFAULT);
        ImageIcon i24 = new ImageIcon(i23);
        b7 = new JButton(i24);
        b7.setBounds(350,80,200,41);
        b7.addActionListener(this);
        add(b7);
		
        ImageIcon i25 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/UPDATE CHECK STATUSbutton.jpg"));
        Image i26 = i25.getImage().getScaledInstance(200, 41,Image.SCALE_DEFAULT);
        ImageIcon i27 = new ImageIcon(i26);
        b8 = new JButton(i27);
        b8.setBounds(10,140,200,41);
        b8.addActionListener(this);
        add(b8);
		
        ImageIcon i28 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/UPDATE ROOM STATUSbutton.jpg"));
        Image i29 = i28.getImage().getScaledInstance(200, 41,Image.SCALE_DEFAULT);
        ImageIcon i30 = new ImageIcon(i29);
        b9 = new JButton(i30);
        b9.setBounds(350,140,200,41);
        b9.addActionListener(this);
        add(b9);
		
        ImageIcon i31 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/SEARCH ROOMbutton.jpg"));
        Image i32 = i31.getImage().getScaledInstance(200, 41,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i32);
        b10 = new JButton(i33);
        b10.setBounds(700,140,200,41);
        b10.addActionListener(this);
        add(b10);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/log_button.jpg"));
        Image i5 = i4.getImage().getScaledInstance(199, 66,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b11 = new JButton(i6);
        b11.setBounds(360,560,199,66);
        b11.addActionListener(this);
        add(b11);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/rec.jpg"));
        Image i3 = i1.getImage().getScaledInstance(995, 705,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,995,705);
        add(image);
		
		setLayout(null);
		setBounds(200,50,995,705);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			new AddCustomer().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource() == b2){
			try {
				new Room();
			} catch (SQLException e) {
				e.printStackTrace();
			}this.setVisible(true);
			
		}else if(ae.getSource() == b4){
			try {
				new Employee();
			} catch (SQLException e) {
				e.printStackTrace();
			}this.setVisible(true);
			
		}else if(ae.getSource() == b5){
			try {
				new Customer();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}else if(ae.getSource() == b6){
			try {
				new Manager();
			} catch (SQLException e) {
				e.printStackTrace();
			}this.setVisible(true);
			
		}else if(ae.getSource() == b7){
			new CheckOut().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource() == b8){
			new UpdateCheck().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource() == b9){
			new UpdateRoom().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource() == b10){
			new SearchRoom().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource() == b11){
			setVisible(false);
		}
			
	}

	public static void main(String[] args) {
		
		new Reception().setVisible(true);
		

	}

}
