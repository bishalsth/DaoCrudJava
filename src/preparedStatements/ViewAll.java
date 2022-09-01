package preparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewAll {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/mydb";
		String username = "root";
		String password = "Ktm@4600";
		Class.forName(driver);
		

		Connection con = DriverManager.getConnection(dbUrl,username,password);
		System.out.println("Connected Successfully.");
		String query = "select * from product";
		PreparedStatement pstm = con.prepareStatement(query);
		
		ResultSet rs = pstm.executeQuery();
		ArrayList<Product> products = new ArrayList<>();
		while(rs.next()) {
			Product p = new Product();
			p.id = rs.getInt("id");
			p.name = rs.getString("name");
			p.manufacturer = rs.getString("manufacturer");
			p.description = rs.getString("description");
			p.price = rs.getFloat("price");
			p.inStock = rs.getBoolean("inStock");
			products.add(p);
		}
		for(Product pd:products) {
			System.out.println(pd);
		}
		System.out.println();
}
}


