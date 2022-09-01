package jdbc.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		String driver = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/mydb";
		String username= "root";
		String password = "Ktm@4600";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(dbUrl,username,password);
		System.out.println("Database Connection Successfull");
		
		Statement stmt = con.createStatement();
		System.out.println("Inserting records into table");
		String sql = "INSERT INTO product (name,manufacturer,description,price,inStock) VALUES  ('ram','THimi','Nepali Ceramic','123.456',true)";
		stmt.executeUpdate(sql);
		con.close();

		
	}

}
