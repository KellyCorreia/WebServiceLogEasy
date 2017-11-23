package br.com.ifma.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the disciplina database table.
 * 
 */
@Entity
@Table(name="disciplina")
@NamedQuery(name="Disciplina.findAll", query="SELECT d FROM Disciplina d")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDisciplina;

	private String nome;

	//bi-directional many-to-one association to Grupoconteudo
	@OneToMany(mappedBy="disciplina")
	private List<GrupoConteudos> grupoConteudos;

	public Disciplina() {
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<GrupoConteudos> getGrupoConteudos() {
		return grupoConteudos;
	}

	public void setGrupoConteudos(List<GrupoConteudos> grupoConteudos) {
		this.grupoConteudos = grupoConteudos;
	}

}