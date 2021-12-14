package com.firas.sprinboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firas.sprinboot.modele.Conges;
import org.springframework.stereotype.Repository;

@Repository
public interface CongesRepository extends JpaRepository<Conges, Long> {

}
