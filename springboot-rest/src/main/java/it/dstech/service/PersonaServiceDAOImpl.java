package it.dstech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.model.Messaggio;
import it.dstech.model.Persona;
import it.dstech.repository.PersonaRepository;

@Service
public class PersonaServiceDAOImpl implements PersonaServiceDAO {
	@Autowired
	private PersonaRepository repo;

	@Override
	public boolean add(Persona p) {
		Persona save = repo.save(p);
		return save != null;
	}

	@Override
	public List<Persona> findAll() {
		return repo.findAll();
	}

	@Override
	public void remove(Persona p) {
		repo.delete(p);
		
	}

	@Override
	public boolean findPersona(String p) {
		if(repo.findById(p) != null) {
			return true;			
		}return false;
	}

	@Override
	public List<Messaggio> listAllSent(Persona p) {
		return p.getMessaggi();
	}

	@Override
	public List<Messaggio> listAllReceived(Persona p) {
		return p.getMessaggi();
	}

	@Override
	public Persona findPersonaById(String nickname) {
		return repo.findPersonaByID(nickname);
	}

}
