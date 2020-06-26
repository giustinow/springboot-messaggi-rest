package it.dstech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.dstech.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {

	 @Query("SELECT p FROM Persona p WHERE p.nickname = ?1")
	    Persona findPersonaByID(String nickname);
}
