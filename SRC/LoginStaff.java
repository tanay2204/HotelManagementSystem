package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginStaff extends JFrame implements ActionListener{
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;

	LoginStaff(){

		l1 = new JLabel("Username");
		l1.setBounds(40,20,100,30);
		add(l1);

		l2 = new JLabel("Password");
		l2.setBounds(40,70,100,30);
		add(l2);

		t1 = new JTextField();
		t1.setBounds(150,20,150,30);
		add(t1);

		t2 = new JPasswordField();
		t2.setBounds(150,70,150,30);
		add(t2);

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/button_submit.jpg"));
		Image i5 = i4.getImage().getScaledInstance(110, 65,Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		b1 = new JButton(i6);
		b1.setBounds(40,150,110,30);
		b1.addActionListener(this);
		add(b1);

		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/cancel_button.jpg"));
		Image i8 = i7.getImage().getScaledInstance(110, 65,Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		b2 = new JButton(i9);
		b2.setBounds(160,150,110,30);
		b2.addActionListener(this);
		add(b2);


		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/staff-login.png"));
		Image i3 = i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel image = new JLabel(i2);
		image.setBounds(350,10,100,150);
		add(image);

		getContentPane().setBackground(Color.WHITE);

		setLayout(null);
		setBounds(500,300,500,250);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			String uname = t1.getText();
			String pass = t2.getText();
			Conn c = new Conn();

			String str1 = "select * from reception where uname = '"+uname+"' and pass ='"+pass+"'";

			try {
				ResultSet rs1 = c.s.executeQuery(str1);
				if(rs1.next()) {
					new Reception().setVisible(true);
					this.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid login");
					this.setVisible(false);
				}
			}catch(Exception e) {

			}

		}else if(ae.getSource()==b2) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new LoginStaff().setVisible(true);

	}

}



