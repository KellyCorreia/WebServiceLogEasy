package br.com.ifma.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the avatar database table.
 * 
 */
@Entity
@Table(name="avatar")
@NamedQuery(name="Avatar.findAll", query="SELECT a FROM Avatar a")
public class Avatar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAvatar;

	private String caracteristica;

	private String nome;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="avatar")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to TemaAvatar
	@OneToMany(mappedBy="avatar")
	private List<TemaAvatar> temasAvatar;

	public Avatar() {
	}

	public int getIdAvatar() {
		return idAvatar;
	}

	public void setIdAvatar(int idAvatar) {
		this.idAvatar = idAvatar;
	}

	public String getCaracteristica() {
		return this.caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<TemaAvatar> getTemasAvatar() {
		return temasAvatar;
	}

	public void setTemasAvatar(List<TemaAvatar> temasAvatar) {
		this.temasAvatar = temasAvatar;
	}

}