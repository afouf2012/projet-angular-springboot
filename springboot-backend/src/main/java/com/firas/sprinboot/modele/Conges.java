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
@Table(name="Conges")
public class Conges {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="Date_debut")
	private String datedebut;
	
	@Column(name ="Date_fin")
	private String datefin;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id", insertable = false, updatable = false)
    private Employee employee;

	public Conges() {
	}
	public Conges(long id, String datedebut, String datefin) {
		super();
		this.id = id;
		this.datedebut = datedebut;
		this.datefin = datefin;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}

	public String getDatefin() {
		return datefin;
	}

	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}


	

}
