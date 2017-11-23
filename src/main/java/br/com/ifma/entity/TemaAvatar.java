package br.com.ifma.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tema_avatar database table.
 * 
 */
@Entity
@Table(name="tema_avatar")
@NamedQuery(name="TemaAvatar.findAll", query="SELECT t FROM TemaAvatar t")
public class TemaAvatar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTemaAvatar;

	private String falaInicialNivel;

	//bi-directional many-to-one association to Avatar
	@ManyToOne
	@JoinColumn(name="idavatar")
	private Avatar avatar;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="idtema")
	private Tema tema;

	public TemaAvatar() {
	}

	public int getIdTemaAvatar() {
		return idTemaAvatar;
	}

	public void setIdTemaAvatar(int idTemaAvatar) {
		this.idTemaAvatar = idTemaAvatar;
	}

	public String getFalaInicialNivel() {
		return this.falaInicialNivel;
	}

	public void setFalaInicialNivel(String falaInicialNivel) {
		this.falaInicialNivel = falaInicialNivel;
	}

	public Avatar getAvatar() {
		return this.avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}