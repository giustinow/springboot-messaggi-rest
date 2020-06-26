package it.dstech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.model.Messaggio;
import it.dstech.model.Persona;
import it.dstech.service.MessaggioServiceDAO;
import it.dstech.service.PersonaServiceDAO;


@RestController
public class RestControllerEsercizio {
	@Autowired
	private PersonaServiceDAO personaService;
	@Autowired
	private MessaggioServiceDAO messaggioService;

	@RequestMapping("/")
	public List<Persona> getAllPeople() {
		return personaService.findAll();
	}
	
	@RequestMapping(value = ("/add"), method = RequestMethod.POST)
	public boolean addNewPersona(@RequestBody Persona persona) {
//		if(!personaService.findPersona(persona.getNickname())) {
			return personaService.add(persona);
//		}return false;
	}
	
	@RequestMapping(value = ("/remove"), method = RequestMethod.POST)
	public void removePersona(@RequestBody Persona persona) {
		 personaService.remove(persona);
	}
	
	@RequestMapping(value = ("/listPersone"))
	public List<Persona> listAllPersona() {
		return personaService.findAll();
	}
	@RequestMapping(value = ("/listAllMessaggi"))
	public List<Messaggio> listAllMessaggi() {
		return messaggioService.findAll();
	}
	
	@RequestMapping(value = ("/listSentReceived"), method = RequestMethod.POST)
	public List<Messaggio> listSentReceived(@RequestBody Persona persona, @RequestBody boolean tipo) {
		return messaggioService.findSentReceived(persona, tipo);
	}
		
	@RequestMapping(value = ("/sendMessage"), method = RequestMethod.POST)
	public boolean sendMessage(@RequestBody Messaggio messaggio) {
		return messaggioService.addMessage(messaggio);
	}
	
}
