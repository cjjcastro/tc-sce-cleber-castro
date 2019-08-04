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
import view.EditProductView;

public class View extends JFrame {
	
	private JPanel contentPane;
	private JPanel contentPane2;
	private Controller control;

	/**
	 * Launch the application.
	 */
	public void Run(Controller control) {
		this.control = control;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View(control);
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
	public View(Controller control) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.control = control;
		InsertProductsView insertProuctsView = new InsertProductsView(control);
		EditProductView editProductView = new EditProductView(control, "", 0, -1);
		
		JButton btnInsertProduct = new JButton("Adicionar novo produto");
		btnInsertProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertProuctsView.Run(control);
			}
		});
		btnInsertProduct.setBounds(12, 0, 194, 25);
		contentPane.add(btnInsertProduct);
		
		JButton btnRecarregar = new JButton("Recarregar");
		btnRecarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View initialPage = new View(control);
				initialPage.Run(control);
			}
		});
		btnRecarregar.setBounds(324, 0, 114, 25);
		contentPane.add(btnRecarregar);
		
		//control.AddProduct("test1", 2);
		//control.AddProduct("test2", 3);
		JButton btnAux = new JButton();
		int xAux = 42;
		for (Product i : control.getData()) {
			System.out.println(i.getName());
			btnAux = new JButton(i.getName() + " - " + i.getAmount());
			btnAux.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//JOptionPane.showMessageDialog(null, i.getName());
					editProductView.Run(control, i.getName(), i.getAmount(), control.GetProductIndex(i));
				}
			});
			btnAux.setBounds(12, xAux, 426, 25);
			contentPane.add(btnAux);
			xAux += 30;
	    }
	}
}
