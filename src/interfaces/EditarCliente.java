package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
import entidades.Cliente;
import javax.swing.ImageIcon;

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
	private JTextField txtID;
	private JButton pesquisar;
	private JButton limpar;
	DateFormat df = new SimpleDateFormat();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarCliente frame = new EditarCliente((long) 0);
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
	public EditarCliente(Long pesq) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					Cliente cli = new Cliente();
					if(pesq > 0) {
						ClienteDao c = DaoFabrica.criarClienteDao();
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
		lblNewLabel_1.setBounds(86, 95, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(151, 92, 156, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnPesquisar = new JButton("");
		pesquisar = btnPesquisar;
		btnPesquisar.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\search.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente tela = new ListarCliente(2);
				tela.setVisible(true);
			}
		});
		btnPesquisar.setBounds(317, 90, 40, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(41, 125, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		txtCPF = new JTextField();
		txtCPF.setEnabled(false);
		txtCPF.setBounds(151, 121, 156, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(41, 153, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		txtTelefone = new JTextField();
		txtTelefone.setEnabled(false);
		txtTelefone.setBounds(151, 150, 130, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Nascimento:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 180, 131, 14);
		contentPane.add(lblNewLabel_4);
		
		txtNasc = new JTextField();
		txtNasc.setEnabled(false);
		txtNasc.setBounds(151, 178, 86, 20);
		contentPane.add(txtNasc);
		txtNasc.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(contentPane, "Confirma as edições?", "Editar Cliente", 0, 2);
				if(i == 0) {
					ClienteDao c = DaoFabrica.criarClienteDao();
					try {
						c.atualizarCliente(Integer.parseInt(txtID.getText()), txtNome.getText(), txtCPF.getText(), txtTelefone.getText(), txtNasc.getText());
						JOptionPane.showMessageDialog(contentPane, "Cliente Alterado");
					} catch (Exception cs) {
						JOptionPane.showMessageDialog(contentPane, cs.getMessage());
					}
				}
			}
		});
		btnNewButton_1.setBounds(192, 209, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnLimpar = new JButton("");
		limpar = btnLimpar;
		btnLimpar.setEnabled(false);
		btnLimpar.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\broom.png"));
		btnLimpar.addActionListener(new ActionListener() {
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
		btnLimpar.setBounds(367, 91, 40, 23);
		contentPane.add(btnLimpar);
		
		JLabel lblNewLabel_5 = new JLabel("Código:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(95, 70, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setEnabled(false);
		txtID.setBounds(151, 67, 65, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
	}
}