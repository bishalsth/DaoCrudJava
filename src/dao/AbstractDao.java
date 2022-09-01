package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao<T> implements DataAccessObject<T> {
	
	
	Connection con;
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mydb";
	String  user = "root";
	 String pass = "Ktm@4600";
	
	@Override
	public void connect() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName(driver);
		con = DriverManager.getConnection(url,user,pass);
	}
	
	@Override
	public void disconnect() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		con.close();
	}
	
}
