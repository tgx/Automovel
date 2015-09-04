package br.com.carro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Marca {

	@Id
	@GeneratedValue
	private long id;
	private String nomeMarca;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	@Override
	public String toString() {
		return getNomeMarca();
	}

}
