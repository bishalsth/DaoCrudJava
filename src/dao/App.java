package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	static Scanner sc = new Scanner(System.in);
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	ProductDao pDao = new ProductDao();
	
	char ch;
	int i;
do {
	System.out.println("---------Main Menu-------");
	System.out.println("1. Add Product");
	System.out.println("2. View a product");
	System.out.println("3. View all products");
	System.out.println("4. Update a products");
	System.out.println("5. Delete a product");
	
	do {
		System.out.println("choice: ");
		ch = sc.next().charAt(0);
		
	}while(!(Integer.parseInt(ch+"")<6 && Integer.parseInt(ch+"")>0));
	if (ch=='1') {
		Product p = new Product();
		System.out.println("enter the product details:");
		p = getProductDetails();
		i=pDao.save(p);
		if(i==1) {
			System.out.println("product is added");
		}else {
			System.out.println("task failed");
		}
	}
	
	else if(ch== '2') {
		System.out.println("enter the id of the product");
		long id = sc.nextLong();
		Product p = pDao.getOne(id);
		System.out.println(p);
	}
	
	else if(ch == '3') {
		ArrayList<Product> products = pDao.getAll();
		for(Product stp : products) {
			System.out.println(stp);
		}
		System.out.println("------- End of List ------");
	}
	else if (ch =='4') {
		System.out.println("enter the id of the product");
		long id = sc.nextLong();
		Product p = pDao.getOne(id);
		System.out.println(p);
		System.out.println("enter the updated details");
		p = getProductDetails();
		p.setId(id);
		i = pDao.update(p);
		if (i ==1) {
			System.out.println("Product details updated");
			
		}else {
			System.out.println("Task Failed");
		}
		
	}
	else if(ch== '5') {
		System.out.println("enter the id of the product");
		long id = sc.nextLong();
		Product p = pDao.getOne(id);
		System.out.println(p);
		
		do {
			System.out.println("Confirm Delete(y/n)?");
			ch = sc.next().charAt(0);
		
	}while(!(ch== 'y'|| ch=='n'));
		if(ch=='y') {
			i = pDao.delete(id);
			if(i==1) {
				System.out.println("product deleted succesfully");
			}else {
				System.out.println("task failed");
			}
		}
		
	}
	
	
	
	do {
		System.out.println("do you want to continue(y/n):?");
		ch = sc.next().charAt(0);
	
}
	while(!(ch== 'y'|| ch=='n'));
}
while(ch=='y');
}

private static Product getProductDetails() {
	// TODO Auto-generated method stub
	Product p = new Product();
	
	System.out.println("name: ");
	p.setName(sc.next());
	System.out.println("Manufacturer:");
	p.setManufacturer(sc.next());
	System.out.println("Description:");
	p.setDescription(sc.next());
	System.out.println("Price:");
	p.setPrice(sc.nextFloat());
	System.out.println("Is Available(yes/no):");
	p.setInStock(sc.next().equalsIgnoreCase("yes")?true:false);
	
	return p;
}}
