package it.dstech.service;

import java.util.List;

import it.dstech.model.Messaggio;
import it.dstech.model.Persona;

public interface MessaggioServiceDAO {

	boolean addMessage(Messaggio messaggio);
	
	List<Messaggio> findAll();
	
	void remove(Messaggio messaggio);
	
	List<Messaggio> findSentReceived(Persona p, boolean tipo);
	
}
