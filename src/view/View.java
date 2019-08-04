package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.Controller;
import model.Product;
import view.InsertProductsView;

public class View extends JFrame {
	
	private Controller control;

	/**
	 * Launch the application.
	 */
	public void Run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame to visualize products list.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		control = new Controller();
		InsertProductsView insertProuctsView = new InsertProductsView(control);
		
		JButton btnInsertProduct = new JButton("Adicionar novo produto");
		btnInsertProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertProuctsView.Run(control);
			}
		});
		btnInsertProduct.setBounds(12, 0, 194, 25);
		getContentPane().add(btnInsertProduct);
		
		control.AddProduct("test1", 0);
		control.AddProduct("test2", 0);
		JButton btnAux = new JButton();
		int xAux = 42;
		for (Product i : control.getData()) {
			System.out.println(i.getName());
			btnAux = new JButton(i.getName());
			btnAux.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, i.getName());
				}
			});
			btnAux.setBounds(12, xAux, 426, 25);
			getContentPane().add(btnAux);
			xAux += 30;
	    }
	}
}
