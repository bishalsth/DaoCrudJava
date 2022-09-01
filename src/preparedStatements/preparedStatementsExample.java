package preparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class preparedStatementsExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/mydb";
		String username= "root";
		String password = "Ktm@4600";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(dbUrl,username,password);
		System.out.println("Database Connection Successfull");
		Product p = new Product("Pan", "Patan","Patan mug",450.50f,true);
		String query = "insert into product (name, manufacturer,description,price,inStock) values(?,?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setString(1, p.name);
		pstm.setString(2, p.manufacturer);
		pstm.setString(3, p.description);
		pstm.setFloat(4,p.price);
		pstm.setBoolean(5, p.inStock);
		pstm.executeUpdate();
		pstm.close();
		con.close();
	
	}

}
