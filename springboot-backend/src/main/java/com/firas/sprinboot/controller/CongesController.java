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

import com.firas.sprinboot.modele.Conges;
import com.firas.sprinboot.repository.CongesRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class CongesController {


	@Autowired
	private CongesRepository CongesRepository;
	
	//get all Conges
	
		@RequestMapping(value = "/conges", method = RequestMethod.GET)
		public List<Conges> getAllEmployee(){
			return CongesRepository.findAll();
		}
		
		// add Conges
		@RequestMapping(value  = "/conges", method = RequestMethod.POST)
		public Conges addcong(@RequestBody Conges conges) {

			return CongesRepository.save(conges);
		}
		
		// get Conges by id 
		@RequestMapping(value = "/conges/{id}", method = RequestMethod.GET)
		public ResponseEntity<Conges> getCongesById(@PathVariable Long id) {
			Conges Conges = CongesRepository.findById(id).orElse(null);
			return ResponseEntity.ok(Conges);
		}
		
		//update Conges 
			@RequestMapping(value ="/conges/{id}", method = RequestMethod.PUT)
			public ResponseEntity<Conges> updateConges(@PathVariable long id, @RequestBody Conges CongesDeatail){
				Conges Conges = CongesRepository.findById(id).orElse(null);
				
				Conges.setDatedebut(CongesDeatail.getDatedebut());
				Conges.setDatefin(CongesDeatail.getDatefin());
				Conges.setEmployee(CongesDeatail.getEmployee());
				Conges updateConges = CongesRepository.save(Conges);
				return ResponseEntity.ok(updateConges);
			}
			
			//delete Conges 
			@RequestMapping(value="/conges/{id}", method=RequestMethod.DELETE)
			public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
				Conges Conges = CongesRepository.findById(id).orElse(null);
				CongesRepository.delete(Conges);
				Map<String, Boolean> response = new HashMap<String, Boolean>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}

}
