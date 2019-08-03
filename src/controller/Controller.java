package controller;

import view.InsertProductsView;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class Controller {
	private List<Product> data = new ArrayList<Product>();
	
	public List<Product> getData() {
		return data;
	}

	public void AddProduct(String name, int amount) {
		this.data.add(new Product(name, amount));
	}
	
	public static void main(String[] args) {
		
		//InsertProductsView test = new InsertProductsView();
		//test.Run();
		Product p = new Product("test", 1);
		System.out.println(p.getName());
		
		//AddProduct("test1", 0);
	}
}
