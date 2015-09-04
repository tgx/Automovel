package br.com.carro.DAO;

import javax.persistence.EntityManager;

import br.com.carro.factory.JPAUtil;
import br.com.carro.model.Marca;

public class MarcaDAO {
	EntityManager em = JPAUtil.getEntityManager();

	public MarcaDAO(EntityManager em) {
		this.em = em;
	}

	// Marca marca = new Marca();

	public void salva(Marca marca) {
		em.persist(marca);
	}

}
