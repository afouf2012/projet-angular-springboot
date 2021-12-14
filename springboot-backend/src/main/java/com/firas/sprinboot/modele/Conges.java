package com.firas.sprinboot.modele;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
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




	@Column(name ="employee")
    private String employee;


	

}
