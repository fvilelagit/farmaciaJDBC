package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class EditarCliente extends JFrame {

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
					EditarCliente frame = new EditarCliente();
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
	public EditarCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\urusi\\Projetos\\TesteDesafio\\TesteDesafio\\src\\img\\medicine.png"));
		setTitle("Loja Tudo de Bom");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 150, 489, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 453, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(86, 72, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(151, 69, 156, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
//				txtCPF.setText(cli.getCpf());
//				txtTelefone.setText(cli.getTelefone());
//				txtNasc.setText(cli.getNascimento());
				
				txtCPF.enable();
				txtTelefone.enable();
				txtNasc.enable();
			}
		});
		btnNewButton.setBounds(317, 67, 100, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(41, 102, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		txtCPF = new JTextField();
		txtCPF.setEnabled(false);
		txtCPF.setBounds(151, 98, 156, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(41, 130, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		txtTelefone = new JTextField();
		txtTelefone.setEnabled(false);
		txtTelefone.setBounds(151, 127, 130, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Nascimento:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 157, 131, 14);
		contentPane.add(lblNewLabel_4);
		
		txtNasc = new JTextField();
		txtNasc.setEnabled(false);
		txtNasc.setBounds(151, 155, 86, 20);
		contentPane.add(txtNasc);
		txtNasc.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(contentPane, "Confirma as edições?");
				switch (i) {
				case 0: {
//					cli.EditarClientes();
					break;
				}
				default:
					break;
				}
			}
		});
		btnNewButton_1.setBounds(125, 209, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCPF.setText("");
				txtTelefone.setText("");
				txtNasc.setText("");
				
				txtCPF.disable();
				txtTelefone.disable();
				txtNasc.disable();
			}
		});
		btnNewButton_2.setBounds(235, 209, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}