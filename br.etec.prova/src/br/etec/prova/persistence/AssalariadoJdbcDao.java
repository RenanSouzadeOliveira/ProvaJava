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
		String sql = "insert into salario(salario) values ('"+c.getSalario()+"')"; ;
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	public void listar1() {
		String sql = "select * from salario";
        System.out.println(sql);
        
	}
        
		public List<Assalariado> listar() {
			String sql = "select * from salario";
	        System.out.println(sql);
		List<Assalariado> assalariado = new ArrayList<Assalariado>();
		try {
			PreparedStatement prepareStatement1 = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement1.executeQuery();
			while (rs.next()) {

				float salario = rs.getFloat("salario");
				

				Assalariado assalariados = new Assalariado();

				assalariados.setSalario(salario);
				

				System.out.println("\n" + assalariados.getSalario());
			

				System.out.println("\n**********outra pessoa*********");

			}
			prepareStatement1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assalariado;
		}
		}
