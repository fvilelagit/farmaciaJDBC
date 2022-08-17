package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.DaoFabrica;
import dao.MedicamentoDao;

public class CadastroProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor;
	private JTextField txtMarca;
	private JTextField txtNome;
	private JCheckBox cb_Remedio;
	private JCheckBox cb_Generico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto();
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
	public CadastroProduto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 150, 489, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Cadastrar Produtos");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(10, 11, 453, 28);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(103, 70, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(70, 98, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(97, 123, 52, 14);
		contentPane.add(lblNewLabel_2);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(159, 120, 138, 20);
		contentPane.add(txtValor);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(159, 95, 159, 20);
		contentPane.add(txtMarca);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(159, 67, 177, 20);
		contentPane.add(txtNome);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(contentPane, "Salvar Informações?", "Confirmar", 0, 3);
				if(i == 0) {
					MedicamentoDao med = DaoFabrica.criarMedicamentoDao();
					try {
						String nome = txtNome.getText();
						String marca = txtMarca.getText();
						Double valor = Double.parseDouble(txtValor.getText());
						Boolean remedio, generico;
						if(cb_Remedio.isSelected()) {
							remedio = true;
						} else {
							remedio = false;
						}
						if(cb_Generico.isSelected()) {
							generico = true;
						} else {
							generico = false;
						}
						try {
							med.inserirMedicamento(nome, marca, valor, generico, remedio);
							JOptionPane.showMessageDialog(contentPane, "Produto Cadastrado");
							txtNome.setText("");
							txtMarca.setText("");
							txtValor.setText("");
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(contentPane, "Produto não Cadastrado");
						}
						
					} catch (Exception message) {
						JOptionPane.showMessageDialog(contentPane, "Erro ao cadastrar cliente!/n cód. "+ message);
					}
				}
			}
		});
		btnCadastrar.setBounds(186, 198, 101, 23);
		contentPane.add(btnCadastrar);
		
		JCheckBox cbGenerico = new JCheckBox("Genérico");
		cb_Generico = cbGenerico;
		cbGenerico.setEnabled(false);
		cbGenerico.setBounds(239, 153, 97, 23);
		contentPane.add(cbGenerico);
		
		JCheckBox cbRemedio = new JCheckBox("Remédio");
		cbRemedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cb_Remedio.isSelected()) {
					cb_Generico.setEnabled(true);
				} else {
					cb_Generico.setSelected(false);
					cb_Generico.setEnabled(false);
				}
			}
		});
		cb_Remedio = cbRemedio;
		cbRemedio.setBounds(140, 153, 97, 23);
		contentPane.add(cbRemedio);
	}
}
