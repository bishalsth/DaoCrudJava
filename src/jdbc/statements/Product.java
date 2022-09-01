package jdbc.statements;

public class Product {
	int id;
	String name;
	String manufacturer;
	String description;
	float price;
	boolean inStock;
	public Product(int id, String name, String manufacturer, String description, float price, boolean inStock) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.price = price;
		this.inStock = inStock;
	}
	public Product(String name, String manufacturer, String description, float price, boolean inStock) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.price = price;
		this.inStock = inStock;
	}

}
