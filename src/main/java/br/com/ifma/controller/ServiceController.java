package br.com.ifma.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.ifma.bd.ProfessorRepository;
import br.com.ifma.entity.Conteudo;
import br.com.ifma.entity.Professor;
import br.com.ifma.json.ConteudoJSON;
import br.com.ifma.json.ProfessorJSON;
 
/**
 * Essa classe vai expor os nossos métodos para serem acessados via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/service")
public class ServiceController {
 
	private final  ProfessorRepository repository = new ProfessorRepository();
 
	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 * Esse método cadastra um novo professor
	 * */
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(Professor professor){
 
		Professor entity = new Professor();
 
		try {
 
			entity.setNome(professor.getNome());
			entity.setEmail(professor.getEmail());
			entity.setSenha(professor.getSenha());
 
			repository.salvar(entity);
 
			return "Registro cadastrado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
 
	}
 
	/**
	 * Essse método altera um professor já cadastrado
	 * **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterar")
	public String alterar(Professor professor){
 
		Professor entity = new Professor();
 
		try {
 
			entity.setIdProfessor(professor.getIdProfessor());
			entity.setNome(professor.getNome());
			entity.setEmail(professor.getEmail());
			entity.setSenha(professor.getSenha());
 
			repository.alterar(entity);
 
			return "Registro alterado com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao alterar o registro " + e.getMessage();
 
		}
 
	}
	/**
	 * Esse método lista todos professores cadastrados na base
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todosProfessores")
	public List<ProfessorJSON> todosProfessores(){
 
		List<ProfessorJSON> professoresJSON =  new ArrayList<ProfessorJSON>();
 
		List<Professor> professoresBD = repository.todosProfessores();
 
		for (Professor entity : professoresBD) {
			ConteudoJSON[] conteudosJSON = new ConteudoJSON[entity.getConteudos().size()];
			int i=0;
			for(Conteudo c:entity.getConteudos()) {
				ConteudoJSON cJson = new ConteudoJSON(c.getIdConteudo(), c.getLicao(), c.getDica());
				conteudosJSON[i] = cJson;
				i++;
			}
			professoresJSON.add(new ProfessorJSON(entity.getIdProfessor(), entity.getEmail(),entity.getNome(), entity.getSenha(), conteudosJSON));
		}
 
		return professoresJSON;
	}
 
	/**
	 * Esse método busca um professor cadastrado pelo código
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getProfessor/{codigo}")
	public Professor getProfessor(@PathParam("codigo") Integer codigo){
 
		Professor entity = repository.getProfessor(codigo);
 
		return entity;
	}
 
	/**
	 * Excluindo um professor pelo código
	 * */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{codigo}")	
	public String excluir(@PathParam("codigo") Integer codigo){
 
		try {
 
			repository.excluir(codigo);
 
			return "Registro excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o registro! " + e.getMessage();
		}
 
	}
	
	public static void main(String[] args) {
		ServiceController s = new ServiceController();
		s.todosProfessores();
	}
 
}