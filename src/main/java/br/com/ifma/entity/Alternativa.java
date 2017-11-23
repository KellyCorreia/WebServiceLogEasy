package br.com.ifma.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the alternativa database table.
 * 
 */
@Entity
@Table(name="alternativa")
@NamedQuery(name="Alternativa.findAll", query="SELECT a FROM Alternativa a")
public class Alternativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlternativa;

	private String texto;

	private byte valor;

	//bi-directional many-to-one association to Questao
	@ManyToOne
	@JoinColumn(name="idquestao")
	private Questao questao;

	//bi-directional many-to-one association to AlternativaAluno
	@OneToMany(mappedBy="alternativa")
	private List<AlternativaAluno> alternativaAlunos;

	public Alternativa() {
	}

	public int getIdAlternativa() {
		return idAlternativa;
	}

	public void setIdAlternativa(int idAlternativa) {
		this.idAlternativa = idAlternativa;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public byte getValor() {
		return this.valor;
	}

	public void setValor(byte valor) {
		this.valor = valor;
	}

	public Questao getQuestao() {
		return this.questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public List<AlternativaAluno> getAlternativaAlunos() {
		return this.alternativaAlunos;
	}

	public void setAlternativaAlunos(List<AlternativaAluno> alternativaAlunos) {
		this.alternativaAlunos = alternativaAlunos;
	}

}