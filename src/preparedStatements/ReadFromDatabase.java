package preparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadFromDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/mydb";
		String username= "root";
		String password = "Ktm@4600";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(dbUrl,username,password);
		System.out.println("Database Connection Successfull");
		
		String query = "select * from product where id= ?";
		PreparedStatement pstm = con.prepareStatement(query);
		System.out.println("Enter the Id:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		Product p = new Product();
		
		
		if(rs.next())    {
			
			p.id = rs.getInt("id");
			p.name = rs.getString("name");
			p.manufacturer = rs.getString("manufacturer");
			p.description = rs.getString("description");
			p.price = rs.getFloat("Price");
			p.inStock = rs.getBoolean("inStock");
		}
	
			System.out.print(p);
		
		
		pstm.close();
		con.close();

	}

}
