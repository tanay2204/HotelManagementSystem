package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener {
	
	JTextField t1,t2,t3,t4,t5;
	JRadioButton r1,r2;
	JComboBox c1;
	JButton b1;
	
	AddEmployee(){
		
		JLabel name = new JLabel("NAME");
		name.setBounds(50,30,120,30);
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(200,30,200,30);
		add(t1);
		
		JLabel age = new JLabel("AGE");
		age.setBounds(50,80,120,30);
		age.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(200,80,100,30);
		add(t2);
		
		JLabel gender = new JLabel("GENDER");
		gender.setBounds(50,130,120,30);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(gender);
		
		r1 = new JRadioButton("Male");
		r1.setBounds(200,130,70,30);
		r1.setBackground(Color.WHITE);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(300,130,70,30);
		r2.setBackground(Color.WHITE);
		add(r2);
		
		JLabel job = new JLabel("JOB");
		job.setBounds(50,180,120,30);
		job.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(job);
		
		String str[] = {"Front Desk","Porters","Housekeeping","Kitchen Staff","Waiter/Waitress","Manager","Accountant","Chef"};
		c1 = new JComboBox(str); 
		c1.setBounds(200,180,150,30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		JLabel salary = new JLabel("SALARY");
		salary.setBounds(50,230,120,30);
		salary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(salary);
		
		t3 = new JTextField();
		t3.setBounds(200,230,200,30);
		add(t3);
		
		JLabel phone = new JLabel("PHONE");
		phone.setBounds(50,280,120,30);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(phone);
		
		t4 = new JTextField();
		t4.setBounds(200,280,200,30);
		add(t4);
		
		JLabel id = new JLabel("ID");
		id.setBounds(50,330,120,30);
		id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(id);
		
		t5 = new JTextField();
		t5.setBounds(200,330,200,30);
		add(t5);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(390,0,450,450);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/button_submit.jpg"));
        Image i5 = i4.getImage().getScaledInstance(110, 65,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b1 = new JButton(i6);
        b1.setBounds(200,370,110,30);
        b1.addActionListener(this);
        add(b1);
        
        getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(400,200,850,450);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String id = t5.getText();
        
        String gender = null;
        
        if(r1.isSelected()) {
        	gender = "Male";
        }else if(r2.isSelected()) {
        	gender = "Female";
        	
        }
        
        String job = (String)c1.getSelectedItem();
        
        Conn c = new Conn();
        
        String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+id+"')";
       
        try {
        	c.s.executeUpdate(str);
        	JOptionPane.showMessageDialog(null,"Employee Added");
            this.setVisible(false);
        	
        }catch(Exception e) {
        	System.out.println(e);
        	
        }
        
	}

	public static void main(String[] args) {
		new AddEmployee().setVisible(true);
		

	}

}
