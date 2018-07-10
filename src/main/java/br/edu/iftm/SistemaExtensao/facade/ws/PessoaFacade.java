package br.edu.iftm.SistemaExtensao.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.SistemaExtensao.dao.PessoaDao;
import br.edu.iftm.SistemaExtensao.domain.Pessoa;

@WebService(serviceName="ws/pessoa")
public class PessoaFacade {
	
	@Inject
	private PessoaDao pessoaDao;
	
	@WebMethod
	public List<Pessoa> getPessoas() {
		List<Pessoa> pessoas = pessoaDao.getPessoas();
		for (Pessoa p: pessoas) {
			p.setParticipacoes(null);
			p.setProjetosAutor(null);
		}
		return pessoas;
	}
	
	@WebMethod
	public Pessoa getPessoaId(@WebParam(name="codigoPessoa") Integer id) {
		Pessoa p = pessoaDao.getPessoaId(id);
		if (p != null) {
			p.setParticipacoes(null);
			p.setProjetosAutor(null);	
		}
		return p;
	}
	
	@WebMethod
	public void excluirPessoa(@WebParam(name="codigoPessoa") Integer id) {
		pessoaDao.excluirPessoa(id);
	}
	
	@WebMethod
	public void atualizarPessoa(@WebParam(name="pessoa") Pessoa pessoa) {
		pessoaDao.atualizarPessoa(pessoa);
	}
	
	@WebMethod
	public void salvarPessoa(@WebParam(name="pessoa") Pessoa pessoa) {
		pessoaDao.inserirPessoa(pessoa);
	}
	
	

}
