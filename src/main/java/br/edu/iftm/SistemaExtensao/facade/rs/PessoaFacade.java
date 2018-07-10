package br.edu.iftm.SistemaExtensao.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.iftm.SistemaExtensao.dao.PessoaDao;
import br.edu.iftm.SistemaExtensao.domain.Pessoa;

@Path(value="/pessoa")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class PessoaFacade {
	
	@Inject
	private PessoaDao pessoaDao;
	
	@GET
	public List<Pessoa> getPessoas() {
		List<Pessoa> pessoas = pessoaDao.getPessoas();
		for (Pessoa p: pessoas) {
			p.setParticipacoes(null);
			p.setProjetosAutor(null);
		}
		return pessoas;
	}
	
	@GET
	@Path("/{codigo}")
	public Pessoa getPessoaId(@PathParam(value="codigo") Integer id) {
		return pessoaDao.getPessoaId(id);
	}
	
	@DELETE
	@Path("/{codigo}")
	public void excluirPessoa(@PathParam(value="codigo") Integer id) {
		pessoaDao.excluirPessoa(id);
	}
	
	@POST
	public void salvarPessoa(Pessoa pessoa) {
		pessoaDao.inserirPessoa(pessoa);
	}
	
	@PUT
	public void atualizarPessoa(Pessoa pessoa) {
		pessoaDao.atualizarPessoa(pessoa);
	}
	
}





