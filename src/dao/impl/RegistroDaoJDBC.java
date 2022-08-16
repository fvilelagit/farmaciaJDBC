package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import dao.DaoFabrica;
import dao.MedicamentoDao;
import dao.RegistroDao;
import db.DB;
import db.DbException;
import entidades.Registro;

public class RegistroDaoJDBC implements RegistroDao{
	
	private Connection conn;
	public RegistroDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	//Esse método deve ser automatizado 
	@Override
	public void inserirRegistro(String data, int qtdMedicamento, int idMedicamento, String cpf) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		MedicamentoDao mDao = DaoFabrica.criarMedicamentoDao();
		String nf = Registro.gerarNf();	
		PreparedStatement pst = null;
		ResultSet rs = null;
			try {
				conn= DB.getConnection();
				
				Double valorTotal = mDao.buscarPorId_CONNECTION_ON(idMedicamento).getValor() * qtdMedicamento;
				String nome_medicamento = mDao.buscarPorId_CONNECTION_ON(idMedicamento).getNome();
				//validar se tem em medicamento em estoque se nao exibir msg - FALTA 
				
				pst = conn.prepareStatement(
					"insert into registro"	
					+ "(data_registro, qtd_medicamento, valor_total, numeroNF, "
					+ "cpf_cliente, id_medicamento,nome_medicamento)"
					+ "values "
					+ "(?,?,?,?,?,?,?)",
					pst.RETURN_GENERATED_KEYS);
				pst.setDate(1, new java.sql.Date(sdf.parse(data).getTime()));
				pst.setInt(2, qtdMedicamento);
				pst.setDouble(3, valorTotal);
				pst.setString(4,nf);
				pst.setString(5,cpf);
				pst.setInt(6, idMedicamento);
				pst.setString(7, nome_medicamento);
				
				int linhasAfetadas = pst.executeUpdate();
				
				if (linhasAfetadas > 0) {
					rs = pst.getGeneratedKeys();
					while(rs.next()) {
						int id = rs.getInt(1);
						System.out.println("Registro inserido! Número do ID = " + id);
					}
				}
				
			} catch (ParseException p) {
				p.getMessage();
			}
			catch (SQLException e) {
				throw new DbException (e.getMessage());
			}
			finally {
				DB.closeResultSet();
				DB.closeStatement();
			}
	}


	@Override
	public void deletarPorId(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override  // MÉTODO DE Histórico DE CONTA 
	 public void buscarPorCliente(String cpf) { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat sdfBR = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(
					"SELECT registro. *, cliente.cpf as Cpf "
					+ "FROM registro INNER JOIN cliente "
					+ "ON registro.cpf_cliente = cliente.cpf "		
					+ "WHERE cliente.cpf = ?");
			pst.setString(1, cpf);
			rs = pst.executeQuery();
			System.out.println("Teste");
				if(rs.next()) {    
				while(rs.next()) {
					String id = Integer.toString(rs.getInt("qtd_medicamento"));
					String data_pedido = sdfBR.format(rs.getDate("data_registro")); 
					String vt = Double.toString(rs.getDouble("valor_total"));
					String nf= Long.toString(rs.getLong("numeroNf"));
					String id_med = Integer.toString(rs.getInt("id_medicamento"));
					String cpf_cliente = rs.getString("cpf_cliente");	
					
					System.out.println("ID : " + id);
					System.out.println("Data: " + data_pedido);
					System.out.println("Valor total R$: " + vt);
					System.out.println("Número da NF :" + nf);
					System.out.println("Id do Medicamento: " + id_med);
					System.out.println("CPF do Cliente: " + cpf_cliente);

				}	
			} else {
				String msg = "Sem retorno de consulta!";
				System.out.println(msg);
			}

			
		}catch (SQLException e) {
			throw new DbException (e.getMessage());
		}
		finally {
			DB.closeResultSet();
			DB.closeStatement();
			DB.closeConnection();
		}
		
	}

	@Override
	public List<Registro> listarRegistros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Registro> buscarPorMedicamento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}





}
