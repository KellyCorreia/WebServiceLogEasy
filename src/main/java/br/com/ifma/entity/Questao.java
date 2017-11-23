package br.com.ifma.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the questao database table.
 * 
 */
@Entity
@Table(name="questao")
@NamedQuery(name="Questao.findAll", query="SELECT q FROM Questao q")
public class Questao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQuestao;

	private String enunciado;

	private String pontuacao;
	
	//bi-directional many-to-one association to Conteudo
	@ManyToOne
	@JoinColumn(name="idconteudo")
	private Conteudo conteudo;

	//bi-directional many-to-one association to Alternativa
	@OneToMany(mappedBy="questao")
	private List<Alternativa> alternativas;

	public Questao() {
	}

	public int getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getEnunciado() {
		return this.enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getPontuacao() {
		return this.pontuacao;
	}

	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<Alternativa> getAlternativas() {
		return this.alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public Conteudo getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

}