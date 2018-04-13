package br.etec.prova.view;

import java.sql.Connection;

import br.etec.prova.model.Horista;
import br.etec.prova.persistence.Conexao;

import br.etec.prova.persistence.HoristaJdbcDao;

public class HoristaExec {
	public static void main (String args[]) {
		Horista horista = new Horista();
		try {	
		
			horista.setPrecoHora(500);
			horista.setHorasTrabalhadas(24);
		
			
			
			Connection connection = Conexao.getConnection();
			HoristaJdbcDao HoristaJdbcDao = new HoristaJdbcDao(connection);
			
			
				HoristaJdbcDao.salvar(horista);
				HoristaJdbcDao.listar();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
