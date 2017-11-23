package br.com.ifma.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alternativa_aluno database table.
 * 
 */
@Entity
@Table(name="alternativa_aluno")
@NamedQuery(name="AlternativaAluno.findAll", query="SELECT a FROM AlternativaAluno a")
public class AlternativaAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlternativaAluno;

	//bi-directional many-to-one association to Alternativa
	@ManyToOne
	@JoinColumn(name="idalternativa")
	private Alternativa alternativa;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="idaluno")
	private Aluno aluno;

	public AlternativaAluno() {
	}

	public int getIdAlternativaAluno() {
		return idAlternativaAluno;
	}

	public void setIdAlternativaAluno(int idAlternativaAluno) {
		this.idAlternativaAluno = idAlternativaAluno;
	}

	public Alternativa getAlternativa() {
		return this.alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}