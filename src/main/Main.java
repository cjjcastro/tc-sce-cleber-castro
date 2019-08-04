package main;

import view.View;
import controller.Controller;
import model.Product;

public class Main {

	public static void main(String[] args) {
		Controller control = new Controller();
		View initialPage = new View(control);
		initialPage.Run(control);
	}

}
