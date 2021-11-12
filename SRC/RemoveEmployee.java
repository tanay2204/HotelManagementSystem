package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class RemoveEmployee extends JFrame implements ActionListener {
	
	JButton b1,b2;
	Choice c1;
	JTextField t1,t2;
	RemoveEmployee(){
		

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b1 = new JButton(i6);
        b1.setBounds(360,35,20,20);
        b1.addActionListener(this);
        add(b1);
		
		JLabel l1 = new JLabel("Employee Id");
		l1.setBounds(20,30,120,30);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l1);
		
		c1 = new  Choice();
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                c1.add(rs.getString("id"));    
            }
		}catch(Exception e){ }
		c1.setBounds(150,35,200,30);
		add(c1);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(20,80,120,30);
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150,80,200,30);
		add(t1);
		
		JLabel l3 = new JLabel("Job");
		l3.setBounds(20,130,120,30);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(150,130,200,30);
		add(t2);
		
		b2= new JButton("Delete");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(170,200,100,30);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(400,150,450,300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			Conn c = new Conn();
			String id = c1.getSelectedItem();
			
			try {
				ResultSet rs = c.s.executeQuery("select * from employee where id='"+id+"'");
				while(rs.next()) {
					t1.setText(rs.getString("name"));
					t2.setText(rs.getString("job"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == b2) {
			Conn c = new Conn();
			String id = c1.getSelectedItem();
			String str = "delete from employee where id='"+id+"'";
			
			try {
				c.s.executeUpdate(str);
				
				JOptionPane.showMessageDialog(null, "Employee Deleted");
                this.setVisible(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		new RemoveEmployee().setVisible(true);

	}

}
