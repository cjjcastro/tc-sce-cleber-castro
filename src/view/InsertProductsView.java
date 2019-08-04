package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.Controller;
import model.Product;

public class InsertProductsView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Controller control;

	/**
	 * Launch the application.
	 */
	public void Run(Controller control) {
		this.control = control;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertProductsView frame = new InsertProductsView(control);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertProductsView(Controller control) {
		this.control = control;
		for (Product i : control.getData()) {
			System.out.println(i.getName());
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(22, 39, 204, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(12, 12, 147, 15);
		contentPane.add(lblNomeDoProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(12, 67, 162, 15);
		contentPane.add(lblQuantidade);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(22, 94, 29, 20);
		contentPane.add(spinner);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.AddProduct(textField.getText(), spinner.getValue().hashCode());
				textField.setText("");
				spinner.setValue(0);
			}
		});
		btnCadastrar.setBounds(230, 162, 154, 25);
		contentPane.add(btnCadastrar);
	}
}
