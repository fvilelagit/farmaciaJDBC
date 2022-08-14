package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ExcluirCliente extends JFrame {

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
					ExcluirCliente frame = new ExcluirCliente();
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
	public ExcluirCliente() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 150, 489, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Excluir Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 453, 28);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(151, 52, 156, 20);
		contentPane.add(txtNome);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(86, 55, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(41, 85, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		txtCPF = new JTextField();
		txtCPF.setEnabled(false);
		txtCPF.setColumns(10);
		txtCPF.setBounds(151, 81, 156, 20);
		contentPane.add(txtCPF);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(41, 113, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		txtTelefone = new JTextField();
		txtTelefone.setEnabled(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(151, 110, 130, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Nascimento:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 140, 131, 14);
		contentPane.add(lblNewLabel_4);
		
		txtNasc = new JTextField();
		txtNasc.setEnabled(false);
		txtNasc.setColumns(10);
		txtNasc.setBounds(151, 138, 86, 20);
		contentPane.add(txtNasc);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
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
		btnPesquisar.setBounds(322, 50, 100, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
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
		btnLimpar.setBounds(235, 192, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(contentPane, "Confirma a Exclusão?");
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
		btnExcluir.setBounds(125, 192, 89, 23);
		contentPane.add(btnExcluir);
	}

}