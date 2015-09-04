package br.com.carro.Beam;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.carro.DAO.AutomovelDAO;
import br.com.carro.factory.JPAUtil;
import br.com.carro.model.Automovel;
import br.com.carro.model.Marca;

@ManagedBean(name = "automovelMB")
@ViewScoped
public class AutomovelBeam {

	private Marca marca = new Marca();

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	private Automovel automovel = new Automovel();

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	private List<Automovel> automoveis;

	@SuppressWarnings("unchecked")
	public List<Automovel> getListAutomovel() {
		EntityManager em = JPAUtil.getEntityManager();
		Query qry = em
				.createQuery("select a from Automovel a", Automovel.class);

		automoveis = qry.getResultList();
		em.close();

		return automoveis;
	}

	public void salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		AutomovelDAO dao = new AutomovelDAO(em);
		automovel.setMarca(marca);

		em.getTransaction().begin();
		dao.salva(automovel);
		em.getTransaction().commit();
		em.close();

		automovel = new Automovel();
		marca = new Marca();
	}

	private List<Automovel> listaPorMarcas;

	public List<Automovel> getListPorMarca() {
		EntityManager em = JPAUtil.getEntityManager();
		// System.out.println("Marca: " + marca.getNomeMarca());
		String sql = "from Automovel auto join fetch auto.marca";

		TypedQuery<Automovel> qry = em.createQuery(sql, Automovel.class);

		listaPorMarcas = qry.getResultList();
		em.close();

		return listaPorMarcas;
	}

	private List<Marca> listaMarcas;

	@SuppressWarnings("unchecked")
	public List<Marca> getListaMarcas() {
		EntityManager em = JPAUtil.getEntityManager();

		String sql = "select m from Marca m";
		Query qry = em.createQuery(sql);

		this.listaMarcas = qry.getResultList();

		return listaMarcas;
	}

	public Automovel buscar(Automovel automovel) {
		EntityManager em = JPAUtil.getEntityManager();
		AutomovelDAO dao = new AutomovelDAO(em);

		em.getTransaction().begin();
		if (automovel != null) {
			dao.buscar(automovel.getId());
		}
		em.getTransaction().commit();
		em.close();

		return automovel;
	}
}
