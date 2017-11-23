package br.com.ifma.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfessorJSON {

	private int idProfessor;

	private String email;

	private String nome;

	private String senha;
	
	private ConteudoJSON conteudos[];
	
	public ProfessorJSON() {
		
	}

	public ProfessorJSON(int idProfessor, String email, String nome, String senha, ConteudoJSON conteudos[]) {
		super();
		this.idProfessor = idProfessor;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.conteudos = conteudos;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ConteudoJSON[] getConteudos() {
		return conteudos;
	}

	public void setConteudos(ConteudoJSON[] conteudos) {
		this.conteudos = conteudos;
	}
	
}
