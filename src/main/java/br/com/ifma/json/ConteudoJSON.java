package br.com.ifma.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ConteudoJSON {

	private Integer idConteudo;

	private String licao;

	private String dica;

	public ConteudoJSON() {
		
	}
	
	public ConteudoJSON(Integer idConteudo, String licao, String dica) {
		super();
		this.idConteudo = idConteudo;
		this.licao = licao;
		this.dica = dica;
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

	public ConteudoJSON(int idConteudo, String licao, String dica) {
		super();
		this.idConteudo = idConteudo;
		this.licao = licao;
		this.dica = dica;
	}
		
}
