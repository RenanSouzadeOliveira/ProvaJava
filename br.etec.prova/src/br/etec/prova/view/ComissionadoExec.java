package br.etec.prova.view;

		import java.sql.Connection;
		
		import br.etec.prova.model.Comissionado;

		import br.etec.prova.persistence.*;
	
public class ComissionadoExec {
	public static void main (String args[]) {
		Comissionado comissionado = new Comissionado();
		try {	
		
			comissionado.setTotal_vendas("1000");
			comissionado.setTaxa_Comissionado("10");
			
			
			
			Connection connection = Conexao.getConnection();
			ComissionadoJdbcDao ComissionadoJdbcDao = new ComissionadoJdbcDao(connection);
			
			
				ComissionadoJdbcDao.salvar(comissionado);
				ComissionadoJdbcDao.listar();
				ComissionadoJdbcDao.alterar(comissionado);
				ComissionadoJdbcDao.excluir(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
