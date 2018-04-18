package br.etec.prova.persistence;

		import java.sql.Connection;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.util.ArrayList;
		import java.util.List;

import br.etec.prova.model.Empregado;
import br.etec.prova.model.Horista;

		

public class HoristaJdbcDao {
	
	private Connection conn;

	public HoristaJdbcDao(Connection conn) {
		this.conn = conn;
	}

	public void salvar(Horista c) throws SQLException {
		String sql = "insert into Horista(Precohora, HorasTrabalhada ) values ('"+c.getPrecoHora()+"','"+ c.getHorasTrabalhadas()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	public void listar1() {
		String sql = "select * from horista";
        System.out.println(sql);
        
	}
        
		public List<Horista> listar() {
			String sql = "select * from horista";
	        System.out.println(sql);
		List<Horista> horista = new ArrayList<Horista>();
		try {
			PreparedStatement prepareStatement1 = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement1.executeQuery();
			while (rs.next()) {

				String horasTrabalhadas = rs.getString("HorasTrabalhada");
				String precoHora = rs.getString("PrecoHora");
				
				Horista Horista = new Horista();

				Horista.setHorasTrabalhadas(horasTrabalhadas);
				Horista.setPrecoHora(precoHora);

				System.out.println("\n" + Horista.getHorasTrabalhadas());
				System.out.println("\n" + Horista.getPrecoHora());
				

				System.out.println("\n**********outra pessoa*********");

			}
			prepareStatement1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horista;
	}
		public void alterar(Horista c) throws SQLException {
			String sql = "update horista set Precohora='"+c.getPrecoHora()+"',HorasTrabalhada='"+c.getPrecoHora()+"'where id_horista='"+c.getId_horista()+"';";
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
			String sql = "delete from horista where id_horista='"+id+"';";
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
