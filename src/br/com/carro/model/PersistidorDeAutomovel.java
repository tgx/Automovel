package br.com.carro.model;

import javax.persistence.EntityManager;

import br.com.carro.factory.JPAUtil;

public class PersistidorDeAutomovel {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		Automovel auto = new Automovel();

		auto.setAnoFabricacao(2015);
		auto.setModelo("Ferrari");
		auto.setObservacoes("Nunca foi batido");

		em.getTransaction().begin();
		em.persist(auto);
		em.getTransaction().commit();
		em.close();

	}

}
