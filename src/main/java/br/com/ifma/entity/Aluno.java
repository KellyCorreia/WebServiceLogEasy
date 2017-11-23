package br.com.ifma.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@Table(name="aluno")
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAluno;

	private String email;

	private String nome;

	private String senha;
	
	//bi-directional many-to-one association to Avatar
	@ManyToOne
	@JoinColumn(name="idavatar")
	private Avatar avatar;

	//bi-directional many-to-one association to AlternativaAluno
	@OneToMany(mappedBy="aluno")
	private List<AlternativaAluno> alternativasAluno;

	//bi-directional many-to-one association to GrupoConteudosAluno
	@OneToMany(mappedBy="aluno")
	private List<GrupoConteudosAluno> grupoConteudosAluno;

	public Aluno() {
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Avatar getAvatar() {
		return this.avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public List<AlternativaAluno> getAlternativasAluno() {
		return alternativasAluno;
	}

	public void setAlternativasAluno(List<AlternativaAluno> alternativasAluno) {
		this.alternativasAluno = alternativasAluno;
	}

	public List<GrupoConteudosAluno> getGrupoConteudosAluno() {
		return grupoConteudosAluno;
	}

	public void setGrupoConteudosAluno(List<GrupoConteudosAluno> grupoConteudosAluno) {
		this.grupoConteudosAluno = grupoConteudosAluno;
	}

}