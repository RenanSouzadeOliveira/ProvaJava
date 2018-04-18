package br.etec.prova.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.etec.prova.model.*;

public class EmpregadoJdbcDao {

	private Connection conn;

	public EmpregadoJdbcDao(Connection conn) {
		this.conn = conn;
	}

	public void salvar(Empregado c) throws SQLException {
		String sql = "insert into empregado(nome, sobrenome,CPF ) values ('"+c.getNome()+"','"+c.getSobrenome()+"','"+c.getCPF()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	public void listar1() {
		String sql = "select * from empregado";
        System.out.println(sql);
        
	}
        
		public List<Empregado> listar() {
			String sql = "select * from empregado";
	        System.out.println(sql);
		List<Empregado> empregados = new ArrayList<Empregado>();
		try {
			PreparedStatement prepareStatement1 = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement1.executeQuery();
			while (rs.next()) {

				String nome = rs.getString("nome");
				String sobrenome = rs.getString("Sobrenome");
				String CPF = rs.getString("CPF");

				Empregado empregado = new Empregado();

				empregado.setNome(nome);
				empregado.setSobrenome(sobrenome);
				empregado.setCPF(CPF);

				System.out.println("\n" + empregado.getNome());
				System.out.println("\n" + empregado.getSobrenome());
				System.out.println("\n" + empregado.getCPF());

				System.out.println("\n**********outra pessoa*********");

			}
			prepareStatement1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empregados;
	}
		public void alterar(Empregado c) throws SQLException {
			String sql = "update empregado set nome='"+c.getNome()+"',sobrenome='"+c.getSobrenome()+"',CPF='"+c.getCPF()+"'where id_empregado='"+c.getId_empregado()+"';";
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
