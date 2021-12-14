package com.firas.sprinboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firas.sprinboot.modele.Salaire;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaireRepository extends JpaRepository<Salaire, Long> {

}
