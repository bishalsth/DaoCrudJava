package jdbc.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/mydb";
		String username= "root";
		String password = "Ktm@4600";
		Class.forName(driver);
		Product p = new Product("Mug", "china","coffee mug",450.50f,true);
		Connection con = DriverManager.getConnection(dbUrl,username,password);
		System.out.println("Database Connection Successfull");
		
		Statement stmt = con.createStatement();
		System.out.println("Inserting records into table");
		
		String sql = "insert into product (name, manufacturer, description, price, inStock)"+
				"values('"+p.name+"', '"+p.manufacturer+"', '"+p.description+"', "+p.price+","+p.inStock+")";
		
		
		stmt.executeUpdate(sql);
		con.close();

	}

}
