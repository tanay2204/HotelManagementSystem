package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
	
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4,i5;
	
	
	Dashboard(){
		
		mb = new JMenuBar();
		add(mb);
		
		m1 = new JMenu("Hotel Management");
		m1.setForeground(Color.BLUE);
		mb.add(m1);
		
		m2 = new JMenu("Admin");
		m2.setForeground(Color.RED);
		mb.add(m2);
		
		i1 = new JMenuItem("RECEPTION");
		i1.addActionListener(this);
		m1.add(i1);
		
		i2 = new JMenuItem("ADD EMPLOYEE");
		i2.addActionListener(this);
		m2.add(i2);
		
		i3 = new JMenuItem("ADD ROOM");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4 = new JMenuItem("REMOVE EMPLOYEE");
		i4.addActionListener(this);
		m2.add(i4);
		
		i5 = new JMenuItem("REMOVE ROOM");
		i5.addActionListener(this);
		m2.add(i5);
		
		mb.setBounds(0,0,1500,30);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/hotel1.gif"));
        Image i3 = i1.getImage().getScaledInstance(1500,768,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(0,0,1500,768);
        add(l15);
		
		setLayout(null);
		setBounds(30,30,1500,768);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("RECEPTION")) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}else if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee().setVisible(true);
		}else if (ae.getActionCommand().equals("ADD ROOM")) {
			new AddRooms().setVisible(true);
	}else if (ae.getActionCommand().equals("REMOVE EMPLOYEE")) {
		new RemoveEmployee().setVisible(true);
	}else if (ae.getActionCommand().equals("REMOVE ROOM")) {
		new RemoveRoom().setVisible(true);
	}
	}

	public static void main(String[] args) {
		new Dashboard().setVisible(true);		
		
		
	}

}
