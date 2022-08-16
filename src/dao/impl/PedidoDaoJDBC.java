package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import dao.DaoFabrica;
import dao.MedicamentoDao;
import dao.PedidoDao;
import db.DB;
import db.DbException;
import entidades.Medicamento;
import entidades.Pedido;
import entidades.PedidoVazio;
import servicos.PedidoServico;

public class PedidoDaoJDBC implements PedidoDao {

	private Connection conn;

	public PedidoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	
	
	public void inserirPedido(String data, int qtdMedicamento, int id_medicamento, String cpf, String tipoPagamento) {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		MedicamentoDao mDao = DaoFabrica.criarMedicamentoDao();
		String nf = PedidoServico.gerarNf();
		PreparedStatement pst = null;
		PreparedStatement pstNovoMedicamento = null;
		PreparedStatement pstListaMed = null;
		PreparedStatement pstId = null;
		ResultSet rs = null;
		boolean continua = false;
		double valorFinal = 0.0;
		int idPedidoVazio = 0;
		int idPedidoMedicamento = 0;
		String statusPagamento = "";
		
		try {
			conn = DB.getConnection();
			String empty = "";
			pstId = conn.prepareStatement("insert into pedido_vazio (texto)" + "values (?); ", pstId.RETURN_GENERATED_KEYS);
			pstId.setString(1, empty);

			int linhasAfetadas = pstId.executeUpdate();

			if (linhasAfetadas > 0) {
				rs = pstId.getGeneratedKeys();
				while (rs.next()) {
					idPedidoVazio = rs.getInt(1);
					System.out.println("ID =" + idPedidoVazio);
				}
			}
			
			PedidoVazio pv = new PedidoVazio(idPedidoVazio,"");
			Pedido p = new Pedido(idPedidoVazio);
			
			
			do {
				valorFinal += novoMedicamentoD(qtdMedicamento, id_medicamento);
				System.out.println("Continua ?");
				continua = sc.nextBoolean();
			
			
			} while (continua == true);

			do {
				pstListaMed = conn.prepareStatement("SELECT * FROM pedido_log_medicamento;");
				rs = pstListaMed.executeQuery();
				rs.next();
				while (rs.next()) {
					int qtd = rs.getInt("quantidade");
					int idMedicamento = rs.getInt("id_medicamento");
					pstNovoMedicamento = conn.prepareStatement(
							"insert into pedido_medicamento " + "(id_medicamento, id_pedido )" + " values (?,?); ",
							pstNovoMedicamento.RETURN_GENERATED_KEYS);

					pstNovoMedicamento.setInt(1, idMedicamento);
					pstNovoMedicamento.setInt(2, idPedidoVazio);
					pstNovoMedicamento.executeUpdate();
					rs = pstNovoMedicamento.getGeneratedKeys();
						
					while (rs.next()) {
						idPedidoMedicamento = rs.getInt(1);
						System.out.println("Id Pedido Medicamento = " + idPedidoMedicamento);
					}

				}

			} while (rs.next());


			pst = conn.prepareStatement("insert into pedido " + "(id, moment, valor_total, "
					+ "status_pagamento, cpf_cliente, id_pedido_medicamento, numero_nf)" + "values " + "(?,?,?,?,?,?,?)",
					pst.RETURN_GENERATED_KEYS);
			pst.setInt(1, idPedidoVazio);
			pst.setDate(2, new java.sql.Date(sdf.parse(data).getTime()));
			pst.setDouble(3, valorFinal);
			pst.setString(4, tipoPagamento);
			pst.setString(5, cpf);
			pst.setInt(6, idPedidoMedicamento);
			pst.setString(7, p.gerarNf());

			int linhasAfetadas1 = pst.executeUpdate();

			if (linhasAfetadas1 > 0) {
				rs = pst.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Registro inserido! N�mero do ID = " + id);
				}
			}
		} catch (ParseException p) {
			p.getMessage();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet();
			DB.closeStatement();
		}
	}

	public Double novoMedicamentoD(int quantidade, int id_medicamento) {

		MedicamentoDao mDao = DaoFabrica.criarMedicamentoDao();

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();
			String planilhaLog = "pedido_log_medicamento";

			if (consultaQtd(id_medicamento) - quantidade >= 0) {
				Medicamento m = mDao.buscarPorId_CONNECTION_ON(id_medicamento);

				if (m.isGenerico()) {
					Double valorInicial = m.getValor();
					Double valorGenerico = valorInicial - valorInicial * 0.2;
					m.setValor(valorGenerico);
					Double valorParcial = m.getValor() * quantidade;

					pst = conn.prepareStatement(
							"insert into " + planilhaLog + "(quantidade, id_medicamento) " + "values " + "(?,?)",
							pst.RETURN_GENERATED_KEYS);
					pst.setInt(1, quantidade);
					pst.setInt(2, id_medicamento);

					System.out.println("Teste ");

					int linhasAfetadas = pst.executeUpdate();
					System.out.println("Teste 2");
					if (linhasAfetadas > 0) {
						rs = pst.getGeneratedKeys();
						while (rs.next()) {
							int id = rs.getInt(1);
							System.out.println("Registro de movimenta��o de estoque gerado com id: " + id);
							System.out.println(linhasAfetadas + " linhas afetadas.");
						}
					}
					return valorParcial;
				} else {
					Double valorParcial = m.getValor() * quantidade;

					pst = conn.prepareStatement(
							"insert into " + planilhaLog + "(quantidade, id_medicamento) " + "values " + "(?,?)",
							pst.RETURN_GENERATED_KEYS);
					pst.setInt(1, quantidade);
					pst.setInt(2, id_medicamento);

					System.out.println("Teste 3");

					int linhasAfetadas = pst.executeUpdate();
					System.out.println("Teste 4");
					if (linhasAfetadas > 0) {
						rs = pst.getGeneratedKeys();
						while (rs.next()) {
							int id = rs.getInt(1);
							System.out.println("Registro de movimenta��o de estoque gerado com id: " + id);
							System.out.println(linhasAfetadas + " linhas afetadas.");
						}
					}
					return valorParcial;
				}
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeResultSet();
			DB.closeStatement();

		}
		return null;
	}



	public int consultaQtd(int idMedicamento) {

		PreparedStatement pst = null;
		ResultSet rs = null;
		String tabela = "view_estoque";

		try {
			pst = conn.prepareStatement("SELECT quantidade FROM " + tabela + " WHERE id_medicamento=?; ");
			pst.setLong(1, idMedicamento);
			rs = pst.executeQuery();
			if (rs.next()) {
				int quantidadeEstoque = (rs.getInt("quantidade"));
				System.out.println("A qtd em estoque �:" + quantidadeEstoque);
				return quantidadeEstoque;

			}
			return 0;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet();
			DB.closeStatement();

		}

	}
	

	@Override
	public void novoMedicamento(int qtd, int id_medicamento) {
		// TODO Auto-generated method stub

	}

}
