package it.dstech.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.model.Messaggio;
import it.dstech.model.Persona;
import it.dstech.repository.MessaggioRepository;
import it.dstech.repository.PersonaRepository;

@Service
public class PersonaServiceDAOImpl implements PersonaServiceDAO {
	@Autowired
	private PersonaRepository personaRepo;
	
	@Autowired
	private MessaggioRepository messaggioRepo;

	@Override
	public boolean addMessage(Messaggio m) {
		Persona mittente = personaRepo.findPersonaByID(m.getMittente().getNickname());
		Persona destinatario = personaRepo.findPersonaByID(m.getDestinatario().getNickname());
		LocalDateTime now = LocalDateTime.now();
		m.setDateTime(now);
		m.setDestinatario(destinatario);
		messaggioRepo.save(m);
		mittente.getMessaggi().add(m);
		personaRepo.save(mittente);
		Messaggio duplicato = new Messaggio();
		duplicato.setTipo(!m.isTipo());
		duplicato.setDestinatario(mittente);
		duplicato.setDateTime(now);
		duplicato.setMessage(m.getMessage());
		destinatario.getMessaggi().add(duplicato);
		personaRepo.save(destinatario);
		return true;
	}

	@Override
	public boolean add(Persona p) {
		Persona save = personaRepo.save(p);
		return save != null;
	}

	@Override
	public List<Persona> findAll() {
		return personaRepo.findAll();
	}

	@Override
	public void remove(Persona p) {
		personaRepo.delete(p);
		
	}

	@Override
	public boolean findPersona(String p) {
		if(personaRepo.findById(p) != null) {
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
		return personaRepo.findPersonaByID(nickname);
	}

}
