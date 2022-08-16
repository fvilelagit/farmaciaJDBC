package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ClienteDao;
import dao.DaoFabrica;
import dao.impl.ClienteDaoJDBC;
import entidades.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
	private JTextField txtID;
	private JButton pesquisar;
	private JButton limpar;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	DateFormat df = new SimpleDateFormat();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirCliente frame = new ExcluirCliente((long) 0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param pesq 
	 */
	public ExcluirCliente(Long pesq) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					Cliente cli = new Cliente();
					if(pesq > 0) {
						ClienteDao c = new DaoFabrica().criarClienteDao();
						cli = c.buscarPorId(pesq);
						txtID.setText(Long.toString(pesq));
						txtNome.setText(cli.getNome());
						txtCPF.setText(cli.getCpf());
						txtTelefone.setText(cli.getTelefone());
						txtNasc.setText(df.format(cli.getData_nascimento()));
						
						txtNome.setEnabled(true);
						txtCPF.setEnabled(true);
						txtTelefone.setEnabled(true);
						txtNasc.setEnabled(true);
						limpar.setEnabled(true);
						pesquisar.setEnabled(false);
					}
				} catch (Exception ex) {
					System.out.println("Erro: " + ex);
				}
			}
		});
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
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(151, 75, 156, 20);
		contentPane.add(txtNome);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(86, 78, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(41, 108, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		txtCPF = new JTextField();
		txtCPF.setEnabled(false);
		txtCPF.setColumns(10);
		txtCPF.setBounds(151, 104, 156, 20);
		contentPane.add(txtCPF);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(41, 136, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		txtTelefone = new JTextField();
		txtTelefone.setEnabled(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(151, 133, 130, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Nascimento:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 163, 131, 14);
		contentPane.add(lblNewLabel_4);
		
		txtNasc = new JTextField();
		txtNasc.setEnabled(false);
		txtNasc.setColumns(10);
		txtNasc.setBounds(151, 161, 86, 20);
		contentPane.add(txtNasc);
		
		JButton btnPesquisar = new JButton("");
		pesquisar = btnPesquisar;
		btnPesquisar.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\search.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente tela = new ListarCliente(1);
				tela.setVisible(true);
			}
		});
		btnPesquisar.setBounds(322, 73, 40, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnLimpar = new JButton("");
		limpar = btnLimpar;
		btnLimpar.setEnabled(false);
		btnLimpar.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\broom.png"));
		btnLimpar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtNome.setText("");
				txtCPF.setText("");
				txtTelefone.setText("");
				txtNasc.setText("");
				
				txtNome.setEnabled(false);
				txtCPF.setEnabled(false);
				txtTelefone.setEnabled(false);
				txtNasc.setEnabled(false);
				pesquisar.setEnabled(true);
				limpar.setEnabled(false);
			}
		});
		btnLimpar.setBounds(363, 74, 40, 23);
		contentPane.add(btnLimpar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(contentPane, "Confirma a exclusão?", "Excluir Cliente", 0, 2);
				if(i == 0) {
					ClienteDao c = new DaoFabrica().criarClienteDao();
					c.deletarPorId(Integer.parseInt(txtID.getText()));
				}
			}
		});
		btnExcluir.setBounds(192, 192, 89, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblNewLabel_5 = new JLabel("Código:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(95, 53, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(151, 50, 46, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
	}

}