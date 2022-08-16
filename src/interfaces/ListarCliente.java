package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDao;
import dao.DaoFabrica;
import entidades.Cliente;

public class ListarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Long id;
	public Long pesq;
	private String nome;
	private String cpf;
	private String telefone;
	private Date dNasc;
	private	DateFormat df = new SimpleDateFormat();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCliente frame = new ListarCliente(0);
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
	public ListarCliente(int op) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					Cliente cli = new Cliente();
					ClienteDao c = DaoFabrica.criarClienteDao();
					
					for(int i = 1; i < 1000; i++) {
						cli = c.buscarPorId((long) i);
						if(cli != null && cli.getNome() != null) {
							id = cli.getId();
							nome = cli.getNome();
							cpf = cli.getCpf();
							telefone = cli.getTelefone();
							dNasc = cli.getData_nascimento();
							model.addRow(new String[] {Long.toString(id), nome, cpf, telefone, df.format(dNasc)});
						}
					}
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(contentPane, exc, "Erro", 0, null);
				}
			}
		});
		setTitle("Loja Tudo de Bom");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setType(Type.UTILITY);
		setBounds(300, 150, 489, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 453, 235);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "CPF", "Telefone", "Data Nascimento"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 453, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBackground(new Color(230, 230, 250));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int linha = table.getSelectedRow();
				if (linha >= 0) {
					pesq = Long.parseLong((String) model.getValueAt(linha, 0));
					if (op == 1) {
						ExcluirCliente tela = new ExcluirCliente(pesq);
						tela.setVisible(true);
					} else if (op == 3) {
//						CadastroPedido tela = new CadastroPedido(pesq);
//						tela.setVisible(true);
						interfaces.CadastroPedido.pesq_cli = pesq;
					} else {
						EditarCliente tela = new EditarCliente(pesq);
						tela.setVisible(true);
					}
					ListarCliente.this.dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "Escolha um registro para selecionar");
				}
			}
		});
		btnSelecionar.setBounds(178, 296, 116, 23);
		contentPane.add(btnSelecionar);
	}
}
