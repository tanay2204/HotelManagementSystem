package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
	
	JButton b1;
	
	HotelManagementSystem(){
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/Logo.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1280, 700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(0,0,1280,700);
        add(l15);
		
        b1= new JButton("NEXT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(1080,600,100,30);
		b1.addActionListener(this);
		add(b1);

        setBounds(140,80,1280,700);
		setLayout(null);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		new LoginChoice().setVisible(true);
        this.setVisible(false);
	}
        
	
	public static void main(String[] args) {
		new HotelManagementSystem(); 
	
	}

}