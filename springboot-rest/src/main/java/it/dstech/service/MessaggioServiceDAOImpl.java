package it.dstech.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.model.Messaggio;
import it.dstech.model.Persona;
import it.dstech.repository.MessaggioRepository;
import it.dstech.repository.PersonaRepository;

@Service
public class MessaggioServiceDAOImpl implements MessaggioServiceDAO {
	@Autowired
	private MessaggioRepository messaggioRepo;
	@Autowired
	private PersonaRepository personaRepo;

	@Override
	public boolean addMessage(Messaggio m) {
		m.setDateTime(LocalDateTime.now());
		Messaggio messaggio = messaggioRepo.save(m);
		Persona mittente = personaRepo.findPersonaByID(m.getMittente().getNickname());
		mittente.getMessaggi().add(messaggio);
		Persona destinatario = personaRepo.findPersonaByID(m.getDestinatario().getNickname());
		destinatario.getMessaggi().add(messaggio);
		return true;
	}

	@Override
	public List<Messaggio> findAll() {
		return messaggioRepo.findAll();
	}

	@Override
	public void remove(Messaggio messaggio) {
		messaggioRepo.delete(messaggio);
		messaggio.getMittente().getMessaggi().remove(messaggio);
		messaggio.getDestinatario().getMessaggi().remove(messaggio);
	}

	public List<Messaggio> findSentReceived(Persona p, boolean tipo) {
		Persona persona = personaRepo.findPersonaByID(p.getNickname());
		if (tipo) {
			List<Messaggio> sent = new ArrayList<Messaggio>();
			for (Messaggio messaggio : persona.getMessaggi()) {
				if (messaggio.getMittente().equals(persona)) {
					sent.add(messaggio);
				}
			}return sent;
		} else {
			List<Messaggio> received = new ArrayList<Messaggio>();
			for (Messaggio messaggio : persona.getMessaggi()) {
				if (messaggio.getMittente().equals(persona)) {
					received.add(messaggio);
				}
			}
			return received;
		}
	}
}
