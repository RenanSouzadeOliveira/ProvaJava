package br.etec.prova.view;
	
	import java.sql.Connection;

	import br.etec.prova.persistence.HoristaJdbcDao;
	import br.etec.prova.persistence.Conexao;
	
	import br.etec.prova.model.Horista;


public class HoristaExec {
	public static void main (String args[]) {
		Horista horista = new Horista();
		try {	
		
			horista.setHorasTrabalhadas("200");
			horista.setPrecoHora("1000");
			
			
			Connection connection = Conexao.getConnection();
			HoristaJdbcDao horistaJdbcDao = new HoristaJdbcDao(connection);
			
			
		//	horistaJdbcDao.salvar(horista);
		//	horistaJdbcDao.listar();
		//	horistaJdbcDao.alterar(horista);
			horistaJdbcDao.excluir(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
