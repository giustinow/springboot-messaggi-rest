package it.dstech.service;

import java.util.List;

import it.dstech.model.Messaggio;
import it.dstech.model.Persona;

public interface PersonaServiceDAO {
	
	Persona findPersonaById(String nickname);
	
	boolean findPersona(String p);
	
	boolean add(Persona p);
	
	List<Persona> findAll();
	
	void remove(Persona p);
	
	List<Messaggio> listAllSent(Persona p);
	
	List<Messaggio> listAllReceived(Persona p);
}
