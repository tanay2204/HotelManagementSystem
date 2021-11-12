package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginChoice extends JFrame implements ActionListener {
	
	JButton b1,b2;
	
	LoginChoice(){
		
		JLabel l1 = new JLabel("WHO IS LOGGIN INTO HOTEL");
		l1.setBounds(150,20,250,20);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(l1);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/buttontaff.png"));
        Image i5 = i4.getImage().getScaledInstance(178, 50,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b1 = new JButton(i6);
        b1.setBounds(30,80,178,50);
        b1.addActionListener(this);
        add(b1);
		
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/button.png"));
        Image i8 = i7.getImage().getScaledInstance(178, 50,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        b2 = new JButton(i9);
        b2.setBounds(270,80,178,50);
        b2.addActionListener(this);
        add(b2);
        
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(500,300,500,250);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			new LoginStaff().setVisible(true);
			this.setVisible(false);
			
		}else if(ae.getSource() == b2){
			new Login().setVisible(true);
			this.setVisible(false);
			
		}
		
	}

	public static void main(String[] args) {
		
		new LoginChoice().setVisible(true);

	}

}
