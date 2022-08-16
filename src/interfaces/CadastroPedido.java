package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDao;
import dao.DaoFabrica;
import dao.MedicamentoDao;
import dao.PedidoDao;
import entidades.Cliente;
import entidades.Medicamento;

public class CadastroPedido extends JFrame {

	private JPanel contentPane;
	private JTextField txtCliente;
	private JTextField txtCPF;
	private JTextField txtData;
	private JRadioButton credito;
	private JRadioButton debito;
	private JRadioButton dinheiro;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private JTable table;
	private JTextField txtProduto;
	private JTextField txtValor;
	private JTextField txtQtde;
	private JButton cli_pesq;
	private JButton med_pesq;
	private JButton add;
	private JButton salvar;
	private Cliente cli = new Cliente();
	private Medicamento med = new Medicamento();
	private String pag;
	private int qtde;
	static long pesq_cli = 0;
	static long pesq_pro = 0;
	private int id;
	private double vt = 0; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPedido frame = new CadastroPedido();
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
	public CadastroPedido() {
		setType(Type.UTILITY);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtData.setText(dtf.format(LocalDateTime.now()));
				pag = "dinheiro";
				if(pesq_cli > 0) {
					ClienteDao c = new DaoFabrica().criarClienteDao();
					try {
						cli = c.buscarPorId(pesq_cli);
						txtCliente.setText(cli.getNome());
						txtCPF.setText(cli.getCpf());
						
						dinheiro.setEnabled(true);
						credito.setEnabled(true);
						debito.setEnabled(true);
						cli_pesq.setEnabled(false);
					} catch (Exception we) {
						System.out.println("erro");
					}
					
				}
				if(pesq_pro > 0) {
					MedicamentoDao m = new DaoFabrica().criarMedicamentoDao();
					try {
						med = m.buscarPorId((int) pesq_pro);
						id = Integer.parseInt(Long.toString(med.getId()));
						txtProduto.setText(med.getNome());
						txtValor.setText("R$ " + Double.toString(med.getValor()));
						
						txtQtde.setEnabled(true);
						add.setEnabled(true);
						
					} catch (Exception we) {
						System.out.println("erro");
					}
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 721, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Novo Pedido");
		lblNewLabel.setBounds(10, 11, 685, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setBounds(10, 91, 46, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtCliente = new JTextField();
		txtCliente.setEnabled(false);
		txtCliente.setBounds(66, 88, 170, 20);
		txtCliente.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 150, 385, 222);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(10, 116, 46, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtCPF = new JTextField();
		txtCPF.setEnabled(false);
		txtCPF.setBounds(66, 113, 170, 20);
		txtCPF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Valor Total: ");
		lblNewLabel_3.setBounds(310, 106, 133, 28);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lbVtotal = new JLabel("R$ 0,00");
		lbVtotal.setBounds(453, 87, 242, 52);
		lbVtotal.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		txtData = new JTextField();
		txtData.setEnabled(false);
		txtData.setBounds(66, 138, 109, 20);
		txtData.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Data:");
		lblNewLabel_5.setBounds(10, 141, 46, 14);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JRadioButton rbDinheiro = new JRadioButton("Dinheiro");
		rbDinheiro.setEnabled(false);
		rbDinheiro.setSelected(true);
		rbDinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debito.setSelected(false);
				credito.setSelected(false);
				dinheiro.setSelected(true);
				pag = "";
				pag = "Dinheiro";
			}
		});
		dinheiro = rbDinheiro;
		rbDinheiro.setBounds(58, 192, 72, 23);
		
		JRadioButton rbDebito = new JRadioButton("Débito");
		rbDebito.setEnabled(false);
		rbDebito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				credito.setSelected(false);
				dinheiro.setSelected(false);
				debito.setSelected(true);
				pag = "";
				pag = "Débito";
			}
		});
		debito = rbDebito;
		rbDebito.setBounds(206, 192, 64, 23);
		
		JRadioButton rbCredito = new JRadioButton("Crédito");
		rbCredito.setEnabled(false);
		rbCredito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debito.setSelected(false);
				dinheiro.setSelected(false);
				credito.setSelected(true);
				pag = "";
				pag = "Crédito";
			}
		});
		credito = rbCredito;
		rbCredito.setBounds(132, 192, 72, 23);
		
		JLabel lblNewLabel_6 = new JLabel("Método de Pagamento");
		lblNewLabel_6.setBounds(105, 171, 128, 14);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(txtCliente);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produto", "Quantidade", "Valor Unit\u00E1rio"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		contentPane.add(lblNewLabel_2);
		contentPane.add(txtCPF);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lbVtotal);
		contentPane.add(txtData);
		contentPane.add(lblNewLabel_5);
		contentPane.add(rbDinheiro);
		contentPane.add(rbDebito);
		contentPane.add(rbCredito);
		contentPane.add(lblNewLabel_6);
		
		JButton btnAdd = new JButton("");
		add = btnAdd;
		btnAdd.setEnabled(false);
		btnAdd.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\plus.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String produto = txtProduto.getText();
				String valor = "R$ " + txtValor.getText();
				qtde = Integer.parseInt(txtQtde.getText());
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				PedidoDao ped = DaoFabrica.criarPedidoDao();
				try {
					vt += ped.novoMedicamentoD(qtde, id);
					lbVtotal.setText("R$ " + Double.toString(vt));
					model.addRow(new String[] { produto, Integer.toString(qtde), valor});
					
					txtProduto.setText("");
					txtValor.setText("");
					txtQtde.setText("");
					add.setEnabled(false);
					salvar.setEnabled(true);
				} catch (Exception ez) {
					JOptionPane.showMessageDialog(contentPane, ez.getMessage());
					System.out.println(ez);
				}
	
			}
		});
		btnAdd.setBounds(246, 262, 40, 23);
		contentPane.add(btnAdd);
		
		JButton btnCli_pesq = new JButton("");
		cli_pesq = btnCli_pesq;
		btnCli_pesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				CadastroPedido.this.dispose();
				ListarCliente tela = new ListarCliente(3);
				tela.setVisible(true);
			}
		});
		btnCli_pesq.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\search.png"));
		btnCli_pesq.setBounds(246, 87, 40, 23);
		contentPane.add(btnCli_pesq);
		
		JButton btnSalvar = new JButton("Fechar Pedido");
		salvar = btnSalvar;
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidoDao ped = DaoFabrica.criarPedidoDao();
				try {
					ped.inserirPedido(txtData.getText(), qtde, (int) pesq_pro, txtCPF.getText(), pag);
					JOptionPane.showMessageDialog(contentPane, "Pedido Efetuado!");
					CadastroPedido.this.dispose();
				} catch (Exception ed) {
					JOptionPane.showMessageDialog(contentPane, ed.getMessage());
				}

			}
		});
		btnSalvar.setBounds(66, 325, 185, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblNewLabel_7 = new JLabel("Produto:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(28, 237, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		txtProduto = new JTextField();
		txtProduto.setEnabled(false);
		txtProduto.setBounds(84, 234, 152, 20);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Valor:");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(28, 262, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Quantidade:");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(10, 287, 64, 14);
		contentPane.add(lblNewLabel_9);
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setBounds(84, 259, 109, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		txtQtde = new JTextField();
		txtQtde.setEnabled(false);
		txtQtde.setBounds(84, 284, 99, 20);
		contentPane.add(txtQtde);
		txtQtde.setColumns(10);
		
		JButton btnMed_pesq = new JButton("");
		med_pesq = btnCli_pesq;
		btnMed_pesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProduto tela = new ListarProduto(3);
				tela.setVisible(true);
			}
		});
		btnMed_pesq.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\search.png"));
		btnMed_pesq.setBounds(246, 233, 40, 23);
		contentPane.add(btnMed_pesq);
	}
}