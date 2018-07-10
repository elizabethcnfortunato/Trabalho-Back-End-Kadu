package br.edu.iftm.SistemaExtensao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.SistemaExtensao.domain.Pessoa;
import br.edu.iftm.SistemaExtensao.domain.Projeto;

public class PessoaDao {
	
	@PersistenceContext(name="SistemaExtensaoPU")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas() {
		Query query = entityManager.createQuery("from Pessoa p");
		return query.getResultList();
	}
	
	public Pessoa getPessoaId(Integer id) {
		return entityManager.find(Pessoa.class,id);
	}
	
	@Transactional
	public void excluirPessoa(Integer id) {
		Pessoa p = getPessoaId(id);
		//Pessoa p1 = new Pessoa();
		//p1.setId(id);
		entityManager.remove(p);
	}
	
	@Transactional
	public void inserirPessoa(Pessoa pessoa) {
		//entityManager.getTransaction().begin();
		entityManager.persist(pessoa);
		//entityManager.getTransaction().commit();
		//entityManager.persist(new Projeto());
	}
	
	@Transactional
	public void atualizarPessoa(Pessoa pessoa) {
		pessoa = entityManager.merge(pessoa);
		entityManager.persist(pessoa);
	}

	
}
