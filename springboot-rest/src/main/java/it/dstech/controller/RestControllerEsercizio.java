package it.dstech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.dstech.model.Messaggio;
import it.dstech.model.Persona;
import it.dstech.service.MessaggioServiceDAO;
import it.dstech.service.PersonaServiceDAO;
import it.dstech.webbeans.SentReceivedMessage;


@RestController
public class RestControllerEsercizio {
	@Autowired
	private PersonaServiceDAO personaService;
	@Autowired
	private MessaggioServiceDAO messaggioService;

	@RequestMapping(value ="/", method = RequestMethod.GET)
	@ApiOperation(value = "Stampa la lista di tutti gli utenti", notes = "In questo metodo avremo la lista degli utenti")
	public List<Persona> getAllPeople() {
		return personaService.findAll();
	}
	
	@RequestMapping(value = ("/add"), method = RequestMethod.POST)
	@ApiOperation(value = "Aggiunta di un nuovo utente", notes = "In questo metodo permette la registrazione di un utente")
	public boolean addNewPersona(@ApiParam(value ="Nuovo oggetto Persona", name="persona")@RequestBody Persona persona) {
//		if(!personaService.findPersona(persona.getNickname())) {
			return personaService.add(persona);
//		}return false;
	}
	
	@RequestMapping(value = ("/remove"), method = RequestMethod.POST)
	@ApiOperation(value = "Rimuovi persona", notes = "In questo metodo abbiamo la possibilità di rimuovere una persona")
	public void removePersona(@ApiParam(value="Rimozione oggetto persona", name="Rimuovi persona")@RequestBody Persona persona) {
		 personaService.remove(persona);
	}

	@RequestMapping(value = "/listAllMessaggi", method = RequestMethod.GET)
	@ApiOperation(value= "Stampa la lista dei messaggi", notes = "In questo metodo stampiamo la lista di tutti i messaggi")
	public List<Messaggio> listAllMessaggi() {
		return messaggioService.findAll();
	}
	
	@RequestMapping(value = ("/listSentReceived"), method = RequestMethod.POST)
	@ApiOperation(value = "Stampa la lista dei messaggi inviati o ricevuti", notes = "Questo metodo stampa la lista dei messaggi inviati in base al boolean")
	public List<Messaggio> listSentReceived(@ApiParam(value = "Stampa la lista dei messaggi inviati o ricevuti grazie al nome e a un boolean", name = "Lista messaggi inviati o ricevuti")
	@RequestBody SentReceivedMessage messaggio) {
		return messaggioService.findSentReceived(messaggio.getPersona(), messaggio.isSentReceived());
	}
		
	@RequestMapping(value = ("/sendMessage"), method = RequestMethod.POST)
	@ApiOperation(value = "Invio del messaggio", notes = "In questo metodo inviamo un messaggio all'utente")
	public boolean sendMessage(@ApiParam(value= "Invio del messaggio ad un utente", name="Invio messaggio")@RequestBody Messaggio messaggio) {
		return personaService.addMessage(messaggio);
	}
	
}
