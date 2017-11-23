package br.com.ifma.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the grupoconteudos_aluno database table.
 * 
 */
@Entity
@Table(name="grupoconteudos_aluno")
@NamedQuery(name="GrupoConteudosAluno.findAll", query="SELECT g FROM GrupoConteudosAluno g")
public class GrupoConteudosAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGrupoConteudosAluno;

	private int pontuacao;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="idaluno")
	private Aluno aluno;

	//bi-directional many-to-one association to GrupoConteudo
	@ManyToOne
	@JoinColumn(name="idgrupoconteudos")
	private GrupoConteudos grupoConteudos;

	public int getIdGrupoConteudosAluno() {
		return idGrupoConteudosAluno;
	}

	public void setIdGrupoConteudosAluno(int idGrupoConteudosAluno) {
		this.idGrupoConteudosAluno = idGrupoConteudosAluno;
	}

	public int getPontuacao() {
		return this.pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public GrupoConteudos getGrupoConteudos() {
		return grupoConteudos;
	}

	public void setGrupoConteudos(GrupoConteudos grupoConteudos) {
		this.grupoConteudos = grupoConteudos;
	}

}