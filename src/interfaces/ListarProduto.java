package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DaoFabrica;
import dao.MedicamentoDao;
import db.DB;
import entidades.Medicamento;

public class ListarProduto extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public int pesq;
	private Long id;
	private String nome;
	private String marca;
	private String valor;
	private String generico;
	private String remedio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProduto frame = new ListarProduto(0);
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
	public ListarProduto(int op) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					Medicamento med = new Medicamento();
					MedicamentoDao m = new DaoFabrica().criarMedicamentoDao();
					
					for(int i = 1; i < 1000; i++) {
						med = m.buscarPorId(i);
						if(med != null) {
							id = med.getId();
							nome = med.getNome();
							marca = med.getMarca();
							valor = "R$ " + Double.toString(med.getValor());
							if(med.isGenerico()) {
								generico = "Sim";
								remedio = "Sim";
							} else {
								generico = "Não";
								remedio = "Não";
							}
							model.addRow(new String[] {Long.toString(id), nome, marca, valor, generico, remedio});
						}
					}
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(contentPane, exc, "Erro", 0, null);
				}
			}
		});
		setTitle("Loja Tudo de Bom");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 150, 489, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 453, 28);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 453, 237);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Marca", "Valor", "Gen\u00E9rico", "Rem\u00E9dio"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Short.class, Short.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(55);
		scrollPane.setViewportView(table);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int linha = table.getSelectedRow();
				if (linha > 0) {
					pesq = Integer.parseInt((String) model.getValueAt(linha, 0));
					if (op == 1) {
						ExcluirProduto tela = new ExcluirProduto(pesq);
						tela.setVisible(true);
					} else if(op == 3) {
						interfaces.CadastroPedido.pesq_pro = pesq;
					} else {
						EditarProduto tela = new EditarProduto(pesq);
						tela.setVisible(true);
					}
					ListarProduto.this.dispose();
				} else {
					JOptionPane.showMessageDialog(contentPane, "Escolha um registro para selecionar");
				}
			}
		});
		btnSelecionar.setBounds(178, 296, 116, 23);
		contentPane.add(btnSelecionar);
	}
}
