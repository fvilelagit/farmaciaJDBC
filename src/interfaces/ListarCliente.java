package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private final JTextField txtID = new JTextField();
	private final JTextField txtNome = new JTextField();
	private JTextField txtCPF;
	private JTextField txtTelefone;
	private JTextField txtNasc;
	private Long id;
	private Long pesq;
	private String nome;
	private String cpf;
	private String telefone;
	private Date dNasc;
	private Connection conn;
	private	DateFormat df = new SimpleDateFormat();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCliente frame = new ListarCliente();
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
	public ListarCliente() {
		setTitle("Loja Tudo de Bom");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setType(Type.UTILITY);
		setBounds(300, 150, 489, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 453, 228);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Telefone", "Data Nascimento"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 453, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				entidades.Cliente cli = new entidades.Cliente();
				dao.impl.ClienteDaoJDBC c = new dao.impl.ClienteDaoJDBC(conn);
				
				for(int i = 1; i < 1000; i++) {
					pesq = (long) i;
					cli = c.buscarPorId(pesq);
					if(cli.getNome() != null) {
						id = cli.getId();
						nome = cli.getNome();
						cpf = cli.getCpf();
						telefone = cli.getTelefone();
						dNasc = cli.getData_nascimento();
						model.addRow(new String[] {Long.toString(id), nome, cpf, telefone, df.format(dNasc)});
					}
				}
			}
		});
		btnPesquisar.setBounds(184, 299, 89, 23);
		contentPane.add(btnPesquisar);
		txtID.setBounds(20, 337, 25, 31);
		contentPane.add(txtID);
		txtID.setColumns(10);
		txtNome.setBounds(55, 337, 47, 31);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(112, 342, 86, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(208, 342, 86, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtNasc = new JTextField();
		txtNasc.setBounds(304, 342, 86, 20);
		contentPane.add(txtNasc);
		txtNasc.setColumns(10);
	}
}
