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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.DaoFabrica;
import dao.LogMedicamentoDao;
import dao.MedicamentoDao;
import entidades.Medicamento;

public class CadastroEstoque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtProduto;
	private JTextField txtMarca;
	private JTextField txtValor;
	private JTextField txtData;
	private JTextField txtQtde;
	private JButton add;
	private JButton pesquisar;
	private JButton limpar;
	private Medicamento med = new Medicamento();
	public static int pesq_pro = 0;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEstoque frame = new CadastroEstoque();
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
	public CadastroEstoque() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if(pesq_pro > 0) {
					MedicamentoDao m = DaoFabrica.criarMedicamentoDao();
					try {
						med = m.buscarPorId((int) pesq_pro);
						txtID.setText(Long.toString(med.getId()));
						txtProduto.setText(med.getNome());
						txtMarca.setText(med.getMarca());
						txtData.setText(dtf.format(LocalDateTime.now()));						
						txtValor.setText("R$ " + Double.toString(med.getValor()));
						
						txtQtde.setEnabled(true);
						add.setEnabled(true);
						limpar.setEnabled(true);
						pesquisar.setEnabled(false);
						
					} catch (Exception we) {
						System.out.println("erro");
					}
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
		
		JLabel lblNewLabel = new JLabel("Cadastrar Estoque");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 453, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigo.setBounds(108, 64, 46, 14);
		contentPane.add(lblCdigo);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(164, 61, 46, 20);
		contentPane.add(txtID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Produto:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(90, 92, 64, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtProduto = new JTextField();
		txtProduto.setEnabled(false);
		txtProduto.setColumns(10);
		txtProduto.setBounds(164, 89, 159, 20);
		contentPane.add(txtProduto);
		
		JLabel lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(102, 117, 52, 14);
		contentPane.add(lblNewLabel_2);
		
		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setColumns(10);
		txtMarca.setBounds(164, 114, 138, 20);
		contentPane.add(txtMarca);
		
		JLabel lblNewLabel_3 = new JLabel("Valor:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(28, 142, 126, 14);
		contentPane.add(lblNewLabel_3);
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setToolTipText("ddddd");
		txtValor.setColumns(10);
		txtValor.setBounds(164, 139, 107, 20);
		contentPane.add(txtValor);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogMedicamentoDao med = DaoFabrica.criarLogMedicamentoDao();
				try {
					med.inserirLogPositivo(Integer.parseInt(txtQtde.getText()), Integer.parseInt(txtID.getText()), txtData.getText());
					JOptionPane.showMessageDialog(contentPane, "Cadastrado!");
					CadastroEstoque.this.dispose();
					ListarEstoque tela = new ListarEstoque();
					tela.setVisible(true);
				} catch (Exception es) {
					JOptionPane.showMessageDialog(contentPane, es.getMessage());
				}
			}
		});
		add = btnCadastrar;
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(186, 232, 101, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(108, 167, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtData = new JTextField();
		txtData.setEnabled(false);
		txtData.setBounds(164, 164, 101, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(90, 192, 64, 14);
		contentPane.add(lblNewLabel_4);
		
		txtQtde = new JTextField();
		txtQtde.setEnabled(false);
		txtQtde.setBounds(164, 189, 64, 20);
		contentPane.add(txtQtde);
		txtQtde.setColumns(10);
		
		JButton btnPesquisar = new JButton("");
		pesquisar = btnPesquisar;
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProduto tela = new ListarProduto(4);
				tela.setVisible(true);
			}
		});
		btnPesquisar.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\search.png"));
		btnPesquisar.setBounds(333, 88, 40, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setEnabled(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtProduto.setText("");
				txtMarca.setText("");
				txtData.setText("");						
				txtValor.setText("");
				
				txtQtde.setEnabled(false);
				add.setEnabled(false);
				limpar.setEnabled(false);
				pesquisar.setEnabled(true);
			}
		});
		limpar = btnLimpar;
		btnLimpar.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\broom.png"));
		btnLimpar.setBounds(374, 88, 40, 23);
		contentPane.add(btnLimpar);
	}
}
