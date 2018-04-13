package br.etec.prova.model;

public class Empregado {
	

	private Integer id_empregado;
	private String nome;
	private String sobrenome;
	private String CPF;
	
	public Integer getId_empregado() {
		return id_empregado;
	}
	public void setId_empregado(Integer id_empregado) {
		this.id_empregado = id_empregado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}

}
