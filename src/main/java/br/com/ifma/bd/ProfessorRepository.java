package br.com.ifma.bd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ifma.entity.Professor;

public class ProfessorRepository {
 
	private final EntityManagerFactory entityManagerFactory;
 
	private final EntityManager entityManager;
 
	public ProfessorRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_logeasy");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void salvar(Professor pessoaEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(pessoaEntity);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void alterar(Professor pessoaEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(pessoaEntity);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * RETORNA TODOS OS PROFESSORES CADASTRADOS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<Professor> todosProfessores(){
 
		return this.entityManager.createQuery("SELECT p FROM Professor p ORDER BY p.nome").getResultList();
	}
 
	/**
	 * CONSULTA UM PROFESSOR CADASTRO PELO CÓDIGO
	 * */
	public Professor getProfessor(Integer codigo){
 
		return this.entityManager.find(Professor.class, codigo);
	}
 
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Integer codigo){
 
		Professor pessoa = this.getProfessor(codigo);
 
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(pessoa);
		this.entityManager.getTransaction().commit();
 
	}
}
