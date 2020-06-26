package it.dstech.webbeans;

import it.dstech.model.Persona;

public class SentReceivedMessage {

	private Persona persona;
	private boolean sentReceived;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean isSentReceived() {
		return sentReceived;
	}

	public void setSentReceived(boolean sentReceived) {
		this.sentReceived = sentReceived;
	}
}
