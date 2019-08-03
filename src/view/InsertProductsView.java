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

public class InsertProductsView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void Run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertProductsView frame = new InsertProductsView();
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
	public InsertProductsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setBounds(12, 138, 66, 15);
		contentPane.add(lblPreo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(22, 165, 124, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(230, 162, 154, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(291, 195, 93, 25);
		contentPane.add(btnCancelar);
	}
}
