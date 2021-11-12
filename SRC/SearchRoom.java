package hotel.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;


public class SearchRoom extends JFrame implements ActionListener {
	
	JComboBox c1;
	JCheckBox c2;
	JTable t1,t2;
	JButton b1,b2;
	
	SearchRoom(){
		
		
		t1 = new JTable();
		t2 = new JTable();
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel l1 = new JLabel("Room Type ");
		l1.setBounds(10,30,120,30);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(l1);
		
		c1 =  new JComboBox(new String[] { "Standard","Bussiness","Luxury","Suits"});
		c1.setBounds(120,30,200,30);
		add(c1);
		
		c2 = new JCheckBox ("Available");
	    c2.setBounds(350,30,100,30);
	    c2.setBackground(Color.WHITE);
	    add(c2);
	    
		b1= new JButton("Search");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(70,150,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2= new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(200,150,100,30);
		b2.addActionListener(this);
		add(b2);
		
		setLayout(null);
		setBounds(400,200,500,300);
		setVisible(true);
	}
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==b1) {
				try {
				Conn c = new Conn();
				
				if(c2.isSelected()) {
					String str2 ="select * from room where available='Available' and type='"+c1.getSelectedItem()+"'";
					ResultSet rs2 = c.s.executeQuery(str2);
					t2 = new JTable(buildTableModel(rs2));
					
					JOptionPane.showMessageDialog(null, new JScrollPane(t2));
				}else {
					String str = "select * from room where type='"+c1.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(str);
					t1 = new JTable(buildTableModel(rs));
					
					JOptionPane.showMessageDialog(null, new JScrollPane(t1));
					
				}
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}else if(ae.getSource()==b2) {
				new Reception().setVisible(true);
				this.setVisible(false);
			}
		}
		
		public static DefaultTableModel buildTableModel(ResultSet rs)
		        throws SQLException {

		    ResultSetMetaData metaData = rs.getMetaData();

		    Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(metaData.getColumnName(column));
		    }

		    
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    while (rs.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            vector.add(rs.getObject(columnIndex));
		        }
		        data.add(vector);
		    }

		    return new DefaultTableModel(data, columnNames);

		}
		
		public static DefaultTableModel buildTableModel1(ResultSet rs2)
		        throws SQLException {

		    ResultSetMetaData metaData = rs2.getMetaData();

		    Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int column = 1; column <= columnCount; column++) {
		        columnNames.add(metaData.getColumnName(column));
		    }

		    
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    while (rs2.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            vector.add(rs2.getObject(columnIndex));
		        }
		        data.add(vector);
		    }

		    return new DefaultTableModel(data, columnNames);

		}

	public static void main(String[] args) {
		new SearchRoom().setVisible(true);

	}

}
