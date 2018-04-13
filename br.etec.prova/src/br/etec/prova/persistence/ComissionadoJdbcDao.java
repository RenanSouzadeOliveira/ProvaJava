package br.etec.prova.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.etec.prova.model.Comissionado;



public class ComissionadoJdbcDao {
	private Connection conn;
	
	public ComissionadoJdbcDao(Connection conn) {
		this.conn = conn;
	}

	public void salvar(Comissionado c) throws SQLException {
		String sql = "insert into comissionado(totalVenda, taxaComissao) values ('"+c.getTotalVenda() +"','" + c.getTaxaComissao()+ "')"; 
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
		List<Comissionado> comissi = new ArrayList<Comissionado>();
		try {
			PreparedStatement prepareStatement1 = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement1.executeQuery();
			while (rs.next()) {

				double totalVenda = rs.getDouble("totalVenda");
				double taxaComissao = rs.getDouble("taxaComissao");

				Comissionado comissio = new Comissionado();

				comissio.setTotalVenda(totalVenda);
				comissio.setTaxaComissao(taxaComissao);

			System.out.println("\n" + comissio.getTotalVenda());
				System.out.println("\n" + comissio.getTaxaComissao());

				System.out.println("\n**********outra pessoa*********");

			}
			prepareStatement1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comissi;
}	
}