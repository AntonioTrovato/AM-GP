package model.entity;


import java.util.ArrayList;
import java.util.Collection;

public class Mailbox {
	
	public Mailbox(Collection<Messaggio> messaggiRicevuti, Collection<Messaggio> messaggiInviati){
		//controllo parametri
		checkMessaggi(messaggiRicevuti);
		checkMessaggi(messaggiInviati);
		this.messaggiRicevuti = messaggiRicevuti;
		this.messaggiInviati = messaggiInviati;
	}
	
	
	
	public Mailbox() {
		super();
		this.messaggiInviati = new ArrayList<Messaggio>();
		this.messaggiRicevuti = new ArrayList<Messaggio>();
	}

	public Collection<Messaggio> getMessaggiRicevuti() {
		return messaggiRicevuti;
	}
	public void setMessaggiRicevuti(Collection<Messaggio> messaggiRicevuti){
		checkMessaggi(messaggiRicevuti);
		this.messaggiRicevuti = messaggiRicevuti;
	}
	public Collection<Messaggio> getMessaggiInviati() {
		return messaggiInviati;
	}
	public void setMessaggiInviati(Collection<Messaggio> messaggiInviati){
		checkMessaggi(messaggiInviati);
		this.messaggiInviati = messaggiInviati;
	}
	
	private void checkMessaggi(Collection<Messaggio> messaggi) {
		if(messaggi == null) {
			throw new IllegalArgumentException("collezione di messaggi inesistente");
		}
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messaggiInviati == null) ? 0 : messaggiInviati.hashCode());
		result = prime * result + ((messaggiRicevuti == null) ? 0 : messaggiRicevuti.hashCode());
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
		Mailbox other = (Mailbox) obj;
		if (messaggiInviati == null) {
			if (other.messaggiInviati != null)
				return false;
		} else if (!messaggiInviati.equals(other.messaggiInviati))
			return false;
		if (messaggiRicevuti == null) {
			if (other.messaggiRicevuti != null)
				return false;
		} else if (!messaggiRicevuti.equals(other.messaggiRicevuti))
			return false;
		return true;
	}



	private Collection<Messaggio> messaggiRicevuti;
	private Collection<Messaggio> messaggiInviati;
}
