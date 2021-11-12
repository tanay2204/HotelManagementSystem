package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5,t6,t7;
    JComboBox c1;
    JButton b1,b2,b3;
    JRadioButton r1,r2;
    Choice c2;

    AddCustomer(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/welcome.jpg"));
        Image i3 = i1.getImage().getScaledInstance(420, 450,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(460,40,350,450);
        add(image);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,30,120,30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(l1);

        t1 = new JTextField();
        t1.setBounds(150,30,200,30);
        add(t1);

        JLabel l2 = new JLabel("ID");
        l2.setBounds(30,80,120,30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(l2);

        c1 = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
        c1.setBounds(150,80,200,30);
        add(c1);

        JLabel l3 = new JLabel("Number");
        l3.setBounds(30,130,120,30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(l3);

        t2 = new JTextField();
        t2.setBounds(150,130,200,30);
        add(t2);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(30,180,120,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(l4);

        r1 = new JRadioButton("Male");
        r1.setBounds(150,180,70,30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(250,180,70,30);
        r2.setBackground(Color.WHITE);
        add(r2);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(30,230,120,30);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(l5);

        t3 = new JTextField();
        t3.setBounds(150,230,200,30);
        add(t3);

        JLabel l6 = new JLabel("Allocate Room");
        l6.setBounds(30,280,120,30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(l6);

        c2 = new Choice();
        try{
            Conn c = new Conn();
            String str ="select * from room where available = 'Available'";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("room"));
            }
        }catch(Exception e){ }
        c2.setBounds(150,280,200,30);
        add(c2);

        JLabel l9 = new JLabel("Price/Day");
        l9.setBounds(30,330,120,30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(l9);

        JLabel l10 = new JLabel("Type");
        l10.setBounds(30,380,120,30);
        l10.setForeground(Color.BLACK);
        l10.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(l10);

        t7 = new JTextField();
        t7.setBounds(150,380,200,30);
        add(t7);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b3 = new JButton(i6);
        b3.setBounds(360,280,20,20);
        b3.addActionListener(this);
        add(b3);

        t6 = new JTextField();
        t6.setBounds(150,330,200,30);
        add(t6);

        JLabel l7 = new JLabel("Deposited");
        l7.setBounds(30,430,120,30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(l7);

        t4 = new JTextField();
        t4.setBounds(150,430,200,30);
        add(t4);

        JLabel l8 = new JLabel("Checked In");
        l8.setBounds(30,480,120,30);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(l8);

        t5 = new JTextField();
        t5.setBounds(150,480,200,30);
        add(t5);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/Add_button.jpg"));
        Image i8 = i7.getImage().getScaledInstance(125, 45,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        b1 = new JButton(i9);
        b1.setBounds(70,550,125,45);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/button_back.jpg"));
        Image i11 = i10.getImage().getScaledInstance(125, 45,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        b2 = new JButton(i12);
        b2.setBounds(270,550,125,45);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(400,50,900,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            String name = t1.getText();
            String id = (String) c1.getSelectedItem();
            String idn = t2.getText();
            String gender = null;
            if(r1.isSelected()) {
                gender = "Male";
            }else if(r2.isSelected()) {
                gender = "Female";
            }
            String country = t3.getText();
            String room = (String) c2.getSelectedItem();
            String deposite = t4.getText();
            String  checked = t5.getText();

            String str = "insert into customer values('"+name+"','"+id+"','"+idn+"','"+gender+"','"+country+"','"+room+"','"+deposite+"','"+checked+"')";
            String str2 = "update room set available = 'Occupied' where room ='"+room+"'";

            try {

                Conn c = new Conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null,"Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);

            }catch(Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == b3) {
            Conn c = new Conn();
            String cost = c2.getSelectedItem();
            try {
                ResultSet rs = c.s.executeQuery("select * from room where room='"+cost+"'");
                while(rs.next()) {
                    t6.setText(rs.getString("price"));
                    t7.setText(rs.getString("type"));
                }
            } catch (Exception e) {}

        }else if(ae.getSource() == b2) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {

        new AddCustomer().setVisible(true);

    }

}
