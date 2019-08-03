package main;

import view.View;
import controller.Controller;
import model.Product;

public class Main {

	public static void main(String[] args) {
		View initialPage = new View();
		initialPage.Run();
		Controller c = new Controller();
		c.AddProduct("test1", 0);
		c.AddProduct("test2", 0);
		for (Product i : c.getData()) {
			System.out.println(i.getName());
	    }
	}

}
