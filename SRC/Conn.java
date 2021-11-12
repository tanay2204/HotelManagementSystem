package hotel.management.system;

import java.sql.*;

public class Conn {
	
	Connection c;
    Statement s;
    
    public Conn() {
    	try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kumar");
            s = c.createStatement();
            
    	}catch(Exception e) {
        	System.out.println(e);
        }

    }

}
