package br.etec.prova.view;

import java.sql.Connection;

import br.etec.prova.model.Comissionado;
import br.etec.prova.persistence.ComissionadoJdbcDao;
import br.etec.prova.persistence.Conexao;

public class ComissionadoExec {
	public static void main (String args[]) {
		Comissionado comissionado = new Comissionado();
		try {	
		
		comissionado.setTotalVenda(1236.00);
		comissionado.setTaxaComissao(30);
			
			
			Connection connection = Conexao.getConnection();
			ComissionadoJdbcDao AssalariadoJdbcDao = new ComissionadoJdbcDao(connection);
			
			
				AssalariadoJdbcDao.salvar(comissionado);
				AssalariadoJdbcDao.listar();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
