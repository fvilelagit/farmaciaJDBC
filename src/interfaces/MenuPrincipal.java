package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\urusi\\Projetos\\TesteDesafio\\TesteDesafio\\src\\img\\medicine.png"));
		setTitle("Loja Tudo de Bom");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 947, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(230, 230, 250));
		menuBar.setBounds(15, 11, 900, 67);
		contentPane.add(menuBar);
		
		JMenu mbClientes = new JMenu("Clientes");
		mbClientes.setBackground(new Color(230, 230, 250));
		mbClientes.setHorizontalAlignment(SwingConstants.TRAILING);
		mbClientes.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\man.png"));
		menuBar.add(mbClientes);
		
		JMenuItem mbNewCliente = new JMenuItem("Novo Cliente");
		mbNewCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente tela = new CadastroCliente();
				tela.setVisible(true);
			}
		});
		mbNewCliente.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\add.png"));
		mbNewCliente.setHorizontalAlignment(SwingConstants.LEFT);
		mbClientes.add(mbNewCliente);
		
		JMenuItem mbEditCliente = new JMenuItem("Editar Cliente");
		mbEditCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarCliente tela = new EditarCliente((long) 0);
				tela.setVisible(true);
			}
		});
		mbEditCliente.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\pencil.png"));
		mbClientes.add(mbEditCliente);
		
		JMenuItem mbDelCliente = new JMenuItem("Excluir Cliente");
		mbDelCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirCliente tela = new ExcluirCliente((long) 0);
				tela.setVisible(true);
			}
		});
		mbDelCliente.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\x-button.png"));
		mbClientes.add(mbDelCliente);
		
		JMenu mbProdutos = new JMenu("Produtos");
		mbProdutos.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\box.png"));
		menuBar.add(mbProdutos);
		
		JMenuItem mbNewProduto = new JMenuItem("Novo Produto");
		mbNewProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProduto tela = new CadastroProduto();
				tela.setVisible(true);
			}
		});
		mbNewProduto.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\add.png"));
		mbProdutos.add(mbNewProduto);
		
		JMenuItem mbEditProduto = new JMenuItem("Editar Produto");
		mbEditProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarProduto tela = new EditarProduto(0);
				tela.setVisible(true);
			}
		});
		mbEditProduto.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\pencil.png"));
		mbProdutos.add(mbEditProduto);
		
		JMenuItem mbDelProduto = new JMenuItem("Excluir Produto");
		mbDelProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirProduto tela = new ExcluirProduto(0);
				tela.setVisible(true);
			}
		});
		mbDelProduto.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\x-button.png"));
		mbProdutos.add(mbDelProduto);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pedidos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPedido tela = new CadastroPedido();
				tela.setVisible(true);
			}
		});
		mntmNewMenuItem.setBackground(new Color(230, 230, 250));
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\order.png"));
		menuBar.add(mntmNewMenuItem);
		
		JMenu mbLista = new JMenu("Listas");
		mbLista.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\to-do-list.png"));
		menuBar.add(mbLista);
		
		JMenuItem mbListaClientes = new JMenuItem("Listar Clientes");
		mbListaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente tela = new ListarCliente(0);
				tela.setVisible(true);
			}
		});
		mbListaClientes.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\list.png"));
		mbLista.add(mbListaClientes);
		
		JMenuItem mbListaProdutos = new JMenuItem("Listar Produtos ");
		mbListaProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProduto tela = new ListarProduto(0);
				tela.setVisible(true);
			}
		});
		mbListaProdutos.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\list.png"));
		mbLista.add(mbListaProdutos);
		
		JMenuItem mbListaPedidos = new JMenuItem("Listar Pedidos");
		mbListaPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ped.ListarPedidos();
			}
		});
		mbListaPedidos.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\list.png"));
		mbLista.add(mbListaPedidos);
		
		JMenu mbEstoque = new JMenu("Estoque");
		mbEstoque.setBackground(Color.LIGHT_GRAY);
		mbEstoque.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\shelf.png"));
		menuBar.add(mbEstoque);
		
		JMenuItem mbConsultEstoque = new JMenuItem("Consultar Estoque");
		mbConsultEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//est.ConsultaEstoque();
			}
		});
		mbConsultEstoque.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\list.png"));
		mbEstoque.add(mbConsultEstoque);
		
		JMenuItem mbSair = new JMenuItem("Sair");
		mbSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal.this.dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Histórico");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\history.png"));
		mntmNewMenuItem_1.setBackground(new Color(230, 230, 250));
		menuBar.add(mntmNewMenuItem_1);
		mbSair.setBackground(new Color(230, 230, 250));
		mbSair.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\log-out.png"));
		menuBar.add(mbSair);
		
		JLabel Imagem = new JLabel("");
		Imagem.setForeground(new Color(240, 240, 240));
		Imagem.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\medicine - Copia.png"));
		Imagem.setBounds(206, 115, 518, 499);
		contentPane.add(Imagem);
		
		
	}
}