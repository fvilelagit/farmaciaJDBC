package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.DaoFabrica;
import dao.MedicamentoDao;
import entidades.Medicamento;

public class EditarProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtMarca;
	private JTextField txtValor;
	private JCheckBox remedio;
	private JCheckBox generico;
	private JButton limpar;
	private JButton pesquisar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProduto frame = new EditarProduto(0);
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
	public EditarProduto(int pesq) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					Medicamento med = new Medicamento();
					if(pesq > 0) {
						MedicamentoDao m = DaoFabrica.criarMedicamentoDao();
						med = m.buscarPorId(pesq);
						txtID.setText(Long.toString(pesq));
						txtNome.setText(med.getNome());
						txtMarca.setText(med.getMarca());
						txtValor.setText(Double.toString(med.getValor()));
						if(med.isRemedio()) {
							remedio.setSelected(true);
						} else {
							remedio.setSelected(false);
						}
						if(med.isGenerico()) {
							generico.setSelected(true);
						} else {
							generico.setSelected(false);
						}
						
						txtValor.setEnabled(true);
						limpar.setEnabled(true);
						pesquisar.setEnabled(false);
					}
				} catch (Exception ex) {
					System.out.println("Erro: " + ex);
				}
			}
		});
		setTitle("Loja Tudo de Bom");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 150, 489, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarProduto = new JLabel("Editar Produto");
		lblEditarProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarProduto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEditarProduto.setBounds(10, 11, 453, 28);
		contentPane.add(lblEditarProduto);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(151, 67, 65, 20);
		contentPane.add(txtID);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(151, 92, 156, 20);
		contentPane.add(txtNome);
		
		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setColumns(10);
		txtMarca.setBounds(151, 121, 156, 20);
		contentPane.add(txtMarca);
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
		txtValor.setColumns(10);
		txtValor.setBounds(151, 150, 130, 20);
		contentPane.add(txtValor);
		
		JLabel lblNewLabel_3 = new JLabel("Valor:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(41, 153, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(41, 125, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(86, 95, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Código:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(95, 70, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnPesquisar = new JButton("");
		pesquisar = btnPesquisar;
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProduto tela = new ListarProduto(2);
				tela.setVisible(true);
			}
		});
		btnPesquisar.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\search.png"));
		btnPesquisar.setBounds(317, 91, 40, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnLimpar = new JButton("");
		limpar = btnLimpar;
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtNome.setText("");
				txtMarca.setText("");
				txtValor.setText("");
				remedio.setSelected(false);
				generico.setSelected(false);
				
				txtValor.setEnabled(false);
				limpar.setEnabled(false);
				pesquisar.setEnabled(true);
			}
		});
		btnLimpar.setEnabled(false);
		btnLimpar.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\broom.png"));
		btnLimpar.setBounds(358, 91, 40, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(contentPane, "Confirma as edições?", "Editar Produto", 0, 2);
				if (i == 0) {
					MedicamentoDao m = DaoFabrica.criarMedicamentoDao();
					try {
						m.atualizarValorMedicamento(txtNome.getText(), Double.parseDouble(txtValor.getText()));
						JOptionPane.showMessageDialog(contentPane, "Produto Alterado!");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(contentPane, "Erro ao alterar produto!");
					}
				}
				
			}
		});
		btnSalvar.setBounds(192, 219, 89, 23);
		contentPane.add(btnSalvar);
		
		JCheckBox cbRemedio = new JCheckBox("Remédio");
		remedio = cbRemedio;
		cbRemedio.setEnabled(false);
		cbRemedio.setHorizontalAlignment(SwingConstants.CENTER);
		cbRemedio.setBounds(121, 177, 97, 23);
		contentPane.add(cbRemedio);
		
		JCheckBox cbGenerico = new JCheckBox("Genérico");
		
		cbGenerico.setEnabled(false);
		generico = cbGenerico;
		cbGenerico.setHorizontalAlignment(SwingConstants.CENTER);
		cbGenerico.setBounds(220, 177, 97, 23);
		contentPane.add(cbGenerico);
	}

}
