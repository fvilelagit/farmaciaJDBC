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
		setBounds(10, 10, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(240, 240, 240));
		menuBar.setBounds(10, 11, 648, 67);
		contentPane.add(menuBar);
		
		JMenu mbClientes = new JMenu("Clientes");
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
				EditarCliente tela = new EditarCliente();
				tela.setVisible(true);
			}
		});
		mbEditCliente.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\pencil.png"));
		mbClientes.add(mbEditCliente);
		
		JMenuItem mbDelCliente = new JMenuItem("Excluir Cliente");
		mbDelCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirCliente tela = new ExcluirCliente();
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
				//pro.CadastrarProdutos();
			}
		});
		mbNewProduto.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\add.png"));
		mbProdutos.add(mbNewProduto);
		
		JMenuItem mbEditProduto = new JMenuItem("Editar Produto");
		mbEditProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pro.EditarProdutos();
			}
		});
		mbEditProduto.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\pencil.png"));
		mbProdutos.add(mbEditProduto);
		
		JMenuItem mbDelProduto = new JMenuItem("Excluir Produto");
		mbDelProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pro.ExcluirProdutos();
			}
		});
		mbDelProduto.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\x-button.png"));
		mbProdutos.add(mbDelProduto);
		
		JMenu mbPedidos = new JMenu("Pedidos");
		mbPedidos.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\order.png"));
		menuBar.add(mbPedidos);
		
		JMenuItem mbNewPedido = new JMenuItem("Novo Pedido");
		mbNewPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ped.CadastrarPedidos();
			}
		});
		mbNewPedido.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\add.png"));
		mbPedidos.add(mbNewPedido);
		
		JMenuItem mbEditPedido = new JMenuItem("Editar Pedido");
		mbEditPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ped.EditarPedidos();
			}
		});
		mbEditPedido.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\pencil.png"));
		mbPedidos.add(mbEditPedido);
		
		JMenuItem mbDelPedido = new JMenuItem("Excluir Pedido");
		mbDelPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ped.ExcluirPedidos();
			}
		});
		mbDelPedido.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\x-button.png"));
		mbPedidos.add(mbDelPedido);
		
		JMenu mbLista = new JMenu("Listas");
		mbLista.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\to-do-list.png"));
		menuBar.add(mbLista);
		
		JMenuItem mbListaClientes = new JMenuItem("Listar Clientes");
		mbListaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cli.ListarClientes();
			}
		});
		mbListaClientes.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\list.png"));
		mbLista.add(mbListaClientes);
		
		JMenuItem mbListaProdutos = new JMenuItem("Listar Produtos ");
		mbListaProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pro.ListarProdutos();
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
		
		JLabel Imagem = new JLabel("");
		Imagem.setForeground(new Color(240, 240, 240));
		Imagem.setIcon(new ImageIcon("C:\\Users\\urusi\\Projetos\\farmaciaJDBC\\img\\medicine - Copia.png"));
		Imagem.setBounds(490, 230, 518, 499);
		contentPane.add(Imagem);
		
		
	}
}