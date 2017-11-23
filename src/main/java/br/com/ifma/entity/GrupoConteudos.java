package br.com.ifma.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupoconteudos database table.
 * 
 */
@Entity
@Table(name="grupoconteudos")
@NamedQuery(name="GrupoConteudos.findAll", query="SELECT g FROM GrupoConteudos g")
public class GrupoConteudos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGrupoConteudos;

	private String descricao;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="iddisciplina")
	private Disciplina disciplina;

	//bi-directional many-to-one association to GrupoConteudosAluno
	@OneToMany(mappedBy="grupoConteudos")
	private List<GrupoConteudosAluno> grupoConteudosAlunos;

	public GrupoConteudos() {
	}

	public int getIdGrupoConteudos() {
		return idGrupoConteudos;
	}

	public void setIdGrupoConteudos(int idGrupoConteudos) {
		this.idGrupoConteudos = idGrupoConteudos;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<GrupoConteudosAluno> getGrupoConteudosAlunos() {
		return grupoConteudosAlunos;
	}

	public void setGrupoConteudosAlunos(List<GrupoConteudosAluno> grupoConteudosAlunos) {
		this.grupoConteudosAlunos = grupoConteudosAlunos;
	}
	
}