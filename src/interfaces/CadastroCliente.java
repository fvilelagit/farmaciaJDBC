package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.ClienteDao;
import dao.DaoFabrica;


public class CadastroCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtTelefone;
	private JTextField txtNasc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Loja Tudo de Bom");
		setType(Type.UTILITY);
		setBounds(300, 150, 489, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Ex. 111.111.111-11");
		lblNewLabel_6.setEnabled(false);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_6.setForeground(Color.GRAY);
		lblNewLabel_6.setBounds(328, 98, 107, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(103, 70, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cpf:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(119, 98, 30, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(97, 123, 52, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data de \r\nNascimento:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(23, 148, 126, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNome = new JTextField();
		txtNome.setBounds(159, 67, 177, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(159, 95, 159, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(contentPane, "Salvar Informações?", "Confirmar", 0, 3);
				switch (i) {
				case 0: {
					ClienteDao cli = DaoFabrica.criarClienteDao();
					CadastroCliente frame = new CadastroCliente();
					try {
						String nome = txtNome.getText();
						String cpf = txtCPF.getText();
						String telefone = txtTelefone.getText();
						String nasc = txtNasc.getText();
						cli.inserirCliente(nome, cpf, telefone, nasc);
						JOptionPane.showMessageDialog(contentPane, "Cliente Cadastrado");
						txtNome.setText("");
						txtCPF.setText("");
						txtTelefone.setText("");
						txtNasc.setText("");
						frame.dispose();
					} catch (Exception message) {
						JOptionPane.showMessageDialog(contentPane, message.getMessage());
					}
					break;
				}
				default:
					break;
				}

			}
		});
		btnNewButton.setBounds(186, 198, 101, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Ex. 11/11/1111");
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(276, 148, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ex. (11) 1111-1111");
		lblNewLabel_5.setEnabled(false);
		lblNewLabel_5.setForeground(Color.GRAY);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_5.setBounds(307, 123, 111, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Cadastrar Clientes");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(10, 11, 453, 28);
		contentPane.add(lblNewLabel_7);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(159, 120, 138, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtNasc = new JTextField();
		txtNasc.setToolTipText("");
		txtNasc.setBounds(159, 145, 107, 20);
		contentPane.add(txtNasc);
		txtNasc.setColumns(10);
	}
}