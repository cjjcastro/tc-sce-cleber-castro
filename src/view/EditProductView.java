package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditProductView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void Run(Controller control, String name, int amount, int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProductView frame = new EditProductView(control, name, amount, id);
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
	public EditProductView(Controller control, String name, int amount, int id) {
		System.out.println(id);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(12, 12, 188, 15);
		contentPane.add(lblNomeDoProduto);
		
		textField = new JTextField();
		textField.setBounds(22, 29, 124, 19);
		textField.setText(name);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(12, 71, 114, 15);
		contentPane.add(lblQuantidade);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(22, 98, 29, 20);
		spinner.setValue(amount);
		contentPane.add(spinner);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.UpdateProduct(id, textField.getText(), spinner.getValue().hashCode());
			}
		});
		btnAtualizar.setBounds(153, 165, 114, 25);
		contentPane.add(btnAtualizar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.RemoveProduct(id);
			}
		});
		btnApagar.setBounds(283, 165, 114, 25);
		contentPane.add(btnApagar);
	}
}
