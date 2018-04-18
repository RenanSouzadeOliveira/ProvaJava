package br.etec.prova.view;

		import java.sql.Connection;
		
		
		
		import br.etec.prova.model.Assalariado;
		
		import br.etec.prova.persistence.*;

public class AssalariadoExec {
	public static void main (String args[]) {
		Assalariado assalariado = new Assalariado();
		try {	
		
			assalariado.setSalario("800");
			
			
			
			Connection connection = Conexao.getConnection();
			AssalariadoJdbcDao AssalariadoJdbcDao = new AssalariadoJdbcDao(connection);
			
			
				AssalariadoJdbcDao.salvar(assalariado);
				AssalariadoJdbcDao.listar();
				//AssalariadoJdbcDao.alterar(assalariado);
				AssalariadoJdbcDao.excluir(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
