package com.firas.sprinboot.modele;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Salaire")
public class Salaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name ="num_contrat")
	private String numcontrat;
	
	@Column(name ="Date_payement")
	private String datepayement;
	
	@Column(name ="Salaire")
	private String salaire;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id", insertable = false, updatable = false)
    private Employee employee;
	
	public Salaire() {
	}
	public Salaire(long id, String numcontrat, String datepayement, String salaire) {
		super();
		this.id = id;
		this.numcontrat = numcontrat;
		this.datepayement = datepayement;
		this.salaire = salaire;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumcontrat() {
		return numcontrat;
	}

	public void setNumcontrat(String numcontrat) {
		this.numcontrat = numcontrat;
	}

	public String getDatepayement() {
		return datepayement;
	}

	public void setDatepayement(String datepayement) {
		this.datepayement = datepayement;
	}

	public String getSalaire() {
		return salaire;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	

	
}
