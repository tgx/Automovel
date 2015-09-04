package br.com.carro.DAO;

import javax.persistence.EntityManager;

import br.com.carro.factory.JPAUtil;
import br.com.carro.model.Automovel;

public class AutomovelDAO {
	EntityManager em = JPAUtil.getEntityManager();

	public AutomovelDAO(EntityManager em) {
		this.em = em;
	}

	Automovel automovel;

	public void salva(Automovel automovel) {
		em.persist(automovel);
	}

	public void buscar(Long id) {
		this.automovel = em.find(Automovel.class, id);
	}

}
