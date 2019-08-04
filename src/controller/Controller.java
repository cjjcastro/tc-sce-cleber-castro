package controller;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public class Controller {
	public List<Product> data = new ArrayList<Product>();
	
	public List<Product> getData() {
		return data;
	}

	public void AddProduct(String name, int amount) {
		this.data.add(new Product(name, amount));
	}
	
	public void RemoveProduct(int id) {
		this.data.remove(id);
	}
	
	public void UpdateProduct(int id, String name, int amount) {
		data.set(id, new Product(name, amount));
	}
	
	public int GetProductIndex(Product product) {
		return data.indexOf(product);
	}
}
