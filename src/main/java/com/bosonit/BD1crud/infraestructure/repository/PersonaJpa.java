package com.bosonit.BD1crud.infraestructure.repository;

import com.bosonit.BD1crud.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaJpa extends JpaRepository<Persona, Integer> {
}
