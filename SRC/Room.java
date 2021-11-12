package hotel.management.system;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

public class Room {
JTable t1;
	
	Room() throws SQLException{
		
		t1 = new JTable();
		
		Conn c = new Conn();
		String str ="select * from room";
		ResultSet rs = c.s.executeQuery(str);
		        
		t1 = new JTable(buildTableModel(rs));
		
		JOptionPane.showMessageDialog(null, new JScrollPane(t1));
						
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

	public static void main(String[] args) throws SQLException {
		
		new Room();
	}	
}


