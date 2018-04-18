package br.etec.prova.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.etec.prova.model.Assalariado;



public class AssalariadoJdbcDao {
	private Connection conn;

	public AssalariadoJdbcDao(Connection conn) {
		this.conn = conn;
	}

	public void salvar(Assalariado c) throws SQLException {
		String sql = "insert into assalariado(Salario ) values ('"+c.getSalario()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	public void listar1() {
		String sql = "select * from assalariado";
        System.out.println(sql);
        
	}
        
		public List<Assalariado> listar() {
			String sql = "select * from assalariado";
	        System.out.println(sql);
		List<Assalariado> Assalariado = new ArrayList<Assalariado>();
		try {
			PreparedStatement prepareStatement1 = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement1.executeQuery();
			while (rs.next()) {

				String salario = rs.getString("Salario");
				
				Assalariado assalariado = new Assalariado();

				assalariado.setSalario(salario);
				

				System.out.println("\n" + assalariado.getSalario());
				

				System.out.println("\n**********outra pessoa*********");

			}
			prepareStatement1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}return Assalariado;
	}
		public void alterar(Assalariado c) throws SQLException {
			String sql = "update assalariado set Salario='"+c.getSalario()+"';";
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
			String sql = "delete from assalariado where id_salario='"+id+"';";
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