package br.com.carro.Beam;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.carro.DAO.MarcaDAO;
import br.com.carro.factory.JPAUtil;
import br.com.carro.model.Marca;

@ManagedBean(name = "marcaMB")
@ViewScoped
public class MarcaMB {
	private Marca marca = new Marca();

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		MarcaDAO dao = new MarcaDAO(em);

		em.getTransaction().begin();
		dao.salva(marca);
		em.getTransaction().commit();
		em.close();

		marca = new Marca();
	}

	private List<Marca> marcas = new ArrayList<Marca>();

	@SuppressWarnings("unchecked")
	public List<Marca> getListMarca() {
		EntityManager em = JPAUtil.getEntityManager();

		Query qry = em.createQuery("select m from Marca m", Marca.class);
		marcas = qry.getResultList();

		return marcas;
	}
}
