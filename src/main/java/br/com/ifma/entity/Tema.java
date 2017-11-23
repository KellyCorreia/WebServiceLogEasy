package br.com.ifma.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tema database table.
 * 
 */
@Entity
@Table(name="tema")
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTema;

	private String descricao;

	private String elemento;

	private String objetivo;

	//bi-directional many-to-one association to Nivel
	@OneToMany(mappedBy="tema")
	private List<Nivel> niveis;

	//bi-directional many-to-one association to TemaAvatar
	@OneToMany(mappedBy="tema")
	private List<TemaAvatar> temasAvatar;

	public Tema() {
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getElemento() {
		return this.elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public List<Nivel> getNiveis() {
		return niveis;
	}

	public void setNiveis(List<Nivel> niveis) {
		this.niveis = niveis;
	}

	public List<TemaAvatar> getTemasAvatar() {
		return temasAvatar;
	}

	public void setTemasAvatar(List<TemaAvatar> temasAvatar) {
		this.temasAvatar = temasAvatar;
	}

}