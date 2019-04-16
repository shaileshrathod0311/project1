package jdbcH2config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Config {

	static final String JDBC_DRIVER ="org.h2.Driver";
	static final String URL = "jdbc:h2:tcp://localhost/~/abc";
	
	static final String USERNAME = "sa";
	static final String PASSWORD ="";
	
	public static Connection getConnection()
	{
		Connection con = null;
		Statement stmt = null;
		try {
			
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		    stmt = con.createStatement();
			//con.close();
		//	stmt.close();
			
		}
		catch(SQLException se){
			
			System.out.println(se);
		
		}
		catch(Exception e) {
			
			System.out.println(e);
			
		}
		return con;
	}
	

}
