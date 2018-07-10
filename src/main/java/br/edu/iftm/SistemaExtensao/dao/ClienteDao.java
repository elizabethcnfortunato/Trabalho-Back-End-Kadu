//PACOTES
package br.edu.iftm.SistemaExtensao.dao;

//IMPORTAÇÕES
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.client.Client;

import br.edu.iftm.SistemaExtensao.domain.Cliente;


public class ClienteDao {
	
	@PersistenceContext(name="SistemaExtensaoPU")
	private EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	
	
	public List<Client> getClientes() {
		Query query = entityManager.createQuery("from Cliente cli");
		return query.getResultList();
	}
	
	
	public Client getClienteId(Integer id) {
		return entityManager.find(Client.class,id);
	}
	
	@Transactional
	public void excluirCliente(Integer id) {
		Client cli = getClienteId(id);
		entityManager.remove(cli);
	}
	
	@Transactional
	public void inserirCliente(Client cliente) {
		entityManager.persist(cliente);

	}
	
	@Transactional
	public void atualizarCliente(Client cliente) {
		cliente = entityManager.merge(cliente);
		entityManager.persist(cliente);
	}

	
}
