package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao extends AbstractDao<Product> {

	 
	 PreparedStatement pstm;
	 ResultSet rs;
	 String sql;
	 int i;
	
	@Override
	public int save(Product p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql = "insert into product"+
		"(name,manufacturer,description,price,inStock)"
				+"values(?,?,?,?,?)";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, p.getName());
		pstm.setString(2, p.getManufacturer());
		pstm.setString(3, p.getDescription());
		pstm.setFloat(4, p.getPrice());
		pstm.setBoolean(5, p.isInStock());
		i= pstm.executeUpdate();
		disconnect();
		
		return i;
	}

	@Override
	public Product getOne(Long id) throws ClassNotFoundException, SQLException {
		
		sql = "select * from product where id = ?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setLong(1,id);
		rs = pstm.executeQuery();
		Product p = new Product();
		if(rs.next()) {
			p.setId(rs.getLong("id"));
			p.setName(rs.getString("name"));
			p.setManufacturer(rs.getString("Manufacturer"));
			p.setDescription(rs.getString("Description"));
			p.setPrice(rs.getFloat("Price"));
			p.setInStock(rs.getBoolean("inStock"));
		}
		disconnect();
		return p;
	}

	@Override
	public ArrayList<Product> getAll() throws ClassNotFoundException, SQLException {
		
		sql = "select * from product ";
		connect();
		pstm = con.prepareStatement(sql);
		
		rs = pstm.executeQuery();
		ArrayList<Product> products = new ArrayList<>();
		
		
		while(rs.next()) {
			Product p = new Product();
			
			p.setId(rs.getLong("id"));
			p.setName(rs.getString("name"));
			p.setManufacturer(rs.getString("Manufacturer"));
			p.setDescription(rs.getString("Description"));
			p.setPrice(rs.getFloat("Price"));
			p.setInStock(rs.getBoolean("inStock"));
			products.add(p);
		}
		disconnect();
		return products;
	}

	@Override
	public int update(Product p) throws ClassNotFoundException, SQLException {
		sql = "update product set name=?,manufacturer=?,description=?,price=?,inStock=?"
				+" where id =?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, p.getName());
		pstm.setString(2, p.getManufacturer());
		pstm.setString(3, p.getDescription());
		pstm.setFloat(4, p.getPrice());
		pstm.setBoolean(5, p.isInStock());
		pstm.setLong(6, p.getId());
		int i = pstm.executeUpdate();
		return i;
		
		
	}

	@Override
	public int delete(Long id) throws ClassNotFoundException, SQLException {
		
		sql = "delete from product where id =?";
		connect();
		pstm = con.prepareStatement(sql);
		pstm.setLong(1, id);
		i=pstm.executeUpdate();
		disconnect();
		return i;
	}

}
