package br.com.ifma.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the conteudo database table.
 * 
 */
@Entity
@Table(name="conteudo")
@NamedQuery(name="Conteudo.findAll", query="SELECT c FROM Conteudo c")
public class Conteudo implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConteudo;

	private String licao;

	private String dica;
	
	//bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name="idprofessor")
	@Basic(fetch = FetchType.LAZY)
	private Professor professor;
	
	//bi-directional many-to-one association to GrupoConteudo
	@ManyToOne
	@JoinColumn(name="idgrupoconteudo")
	@Basic(fetch = FetchType.LAZY)
	private GrupoConteudos grupoConteudo;
		
	//bi-directional many-to-one association to Nivel
	@ManyToOne
	@JoinColumn(name="idnivel")
	@Basic(fetch = FetchType.LAZY)
	private Nivel nivel;

	//bi-directional many-to-one association to Questao
	@OneToMany(mappedBy="conteudo")
	@Basic(fetch = FetchType.LAZY)
	private List<Questao> questoes;

	public Conteudo() {
	}

	public Integer getIdConteudo() {
		return idConteudo;
	}

	public void setIdConteudo(Integer idConteudo) {
		this.idConteudo = idConteudo;
	}

	public String getLicao() {
		return licao;
	}

	public void setLicao(String licao) {
		this.licao = licao;
	}

	public String getDica() {
		return dica;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public GrupoConteudos getGrupoConteudo() {
		return grupoConteudo;
	}

	public void setGrupoConteudo(GrupoConteudos grupoConteudo) {
		this.grupoConteudo = grupoConteudo;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	
	@Override
	public String toString() {
		return this.idConteudo + " - " + this.dica + " - " + this.licao;
	}
}
