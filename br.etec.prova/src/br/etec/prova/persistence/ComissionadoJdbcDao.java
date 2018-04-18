package br.etec.prova.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.etec.prova.model.Assalariado;
import br.etec.prova.model.Comissionado;

public class ComissionadoJdbcDao {
	private Connection conn;

	public ComissionadoJdbcDao(Connection conn) {
		this.conn = conn;
	}

	public void salvar(Comissionado c) throws SQLException {
		String sql = "insert into comissionado(Total_vendas,Taxa_comissao ) values ('"+c.getTotal_vendas()+ "','" + c.getTaxa_Comissionado()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	public void listar1() {
		String sql = "select * from comissionado";
        System.out.println(sql);
        
	}
        
		public List<Comissionado> listar() {
			String sql = "select * from comissionado";
	        System.out.println(sql);
		List<Comissionado> comissionado = new ArrayList<Comissionado>();
		try {
			PreparedStatement prepareStatement1 = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement1.executeQuery();
			while (rs.next()) {

				String Total_vendas = rs.getString("Total_vendas");
				
				Comissionado comissionado1 = new Comissionado();

				comissionado1.setTotal_vendas(Total_vendas);
				

				System.out.println("\n" + comissionado1.getTotal_vendas());
				

				System.out.println("\n**********outra pessoa*********");

			}
			prepareStatement1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comissionado;
		}
		public void alterar(Comissionado c) throws SQLException {
			String sql = "update comissionado set Total_vendas='"+c.getTotal_vendas()+"',Taxa_comissionado='"+c.getTaxa_Comissionado()+"'where id_comissionado='"+c.getId_comissionado()+"';";
			System.out.println(sql);
			PreparedStatement prepareStatement;
			try {
				prepareStatement = this.conn.prepareStatement(sql);
				prepareStatement.executeUpdate();
	            prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		public void excluir(int id) {
			String sql = "delete from comissionado where id_comissionado='"+id+"';";
			System.out.println(sql);
	        try {
	    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
	    		prepareStatement.executeUpdate();
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}             		
		}
}
