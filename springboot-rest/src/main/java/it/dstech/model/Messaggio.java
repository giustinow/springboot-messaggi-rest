package it.dstech.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "messaggio")
public class Messaggio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Persona mittente;
	@ManyToOne
	private Persona destinatario;
	private boolean tipo;
	private String message;
	@JsonFormat(pattern="DD-MM-YYYY-hh-mm-ss")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDateTime dateTime;
	
	
	
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Persona getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Persona destinatario) {
		this.destinatario = destinatario;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Persona getMittente() {
		return mittente;
	}
	public void setMittente(Persona mittente) {
		this.mittente = mittente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((destinatario == null) ? 0 : destinatario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((mittente == null) ? 0 : mittente.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Messaggio other = (Messaggio) obj;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (destinatario == null) {
			if (other.destinatario != null)
				return false;
		} else if (!destinatario.equals(other.destinatario))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (mittente == null) {
			if (other.mittente != null)
				return false;
		} else if (!mittente.equals(other.mittente))
			return false;
		return false;
	}
	
}
