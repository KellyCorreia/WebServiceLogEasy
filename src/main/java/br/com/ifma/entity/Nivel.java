package br.com.ifma.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@Table(name="nivel")
@NamedQuery(name="Nivel.findAll", query="SELECT n FROM Nivel n")
public class Nivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNivel;

	private String descricao;

	private int pontosQuestaoDefault;

	private int qtdPontosFinal;

	private int qtdPontosInicial;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="idtema")
	private Tema tema;

	public Nivel() {
	}

	public int getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(int idNivel) {
		this.idNivel = idNivel;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPontosQuestaoDefault() {
		return this.pontosQuestaoDefault;
	}

	public void setPontosQuestaoDefault(int pontosQuestaoDefault) {
		this.pontosQuestaoDefault = pontosQuestaoDefault;
	}

	public int getQtdPontosFinal() {
		return this.qtdPontosFinal;
	}

	public void setQtdPontosFinal(int qtdPontosFinal) {
		this.qtdPontosFinal = qtdPontosFinal;
	}

	public int getQtdPontosInicial() {
		return this.qtdPontosInicial;
	}

	public void setQtdPontosInicial(int qtdPontosInicial) {
		this.qtdPontosInicial = qtdPontosInicial;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}