package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
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
				model.addRow(new String[] {"0", "Rafael", "123.456.789-00", "11 1111-1111", "11/11/1111"});
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
