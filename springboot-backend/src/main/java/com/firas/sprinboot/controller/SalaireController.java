package com.firas.sprinboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firas.sprinboot.modele.Salaire;
import com.firas.sprinboot.repository.SalaireRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class SalaireController {
	@Autowired
	private SalaireRepository SalaireRepository;
	
	//get all employee
	
	@RequestMapping(value = "/salaire", method = RequestMethod.GET)
	public List<Salaire> getAllEmployee(){
		return SalaireRepository.findAll();
	}
	
	// add salaire
	@RequestMapping(value  = "/salaire", method = RequestMethod.POST)
	public Salaire addSalaire(@RequestBody Salaire salaire) {
		return SalaireRepository.save(salaire);
	}
	
	// get salaire by id 
	@RequestMapping(value = "/salaire/{id}", method = RequestMethod.GET)
	public ResponseEntity<Salaire> getsalaireById(@PathVariable Long id) {
		Salaire salaire = SalaireRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(salaire);
	}
	
	//update employee rest api
		@RequestMapping(value ="/salaire/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Salaire> updatesalaire(@PathVariable long id, @RequestBody Salaire salaireDeatail){
			Salaire salaire = SalaireRepository.findById(id).orElseThrow();
			
			salaire.setNumcontrat(salaireDeatail.getNumcontrat());
			salaire.setDatepayement(salaireDeatail.getDatepayement());
			salaire.setSalaire(salaireDeatail.getSalaire());
			
			Salaire updatesalaire = SalaireRepository.save(salaire);
			return ResponseEntity.ok(updatesalaire);
		}
		
		//delete employee rest api
		@RequestMapping(value="/employees/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
			Salaire salaire = SalaireRepository.findById(id).orElseThrow();
			SalaireRepository.delete(salaire);
			Map<String, Boolean> response = new HashMap<String, Boolean>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
}
