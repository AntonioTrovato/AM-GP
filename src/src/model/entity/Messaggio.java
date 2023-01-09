package model.entity;


public class Messaggio {
	
	public Messaggio(int id, String oggetto, String corpo,Utente mittente, Utente destinatario){
		//controllo parametri
		checkOggetto(oggetto);
		checkCorpo(corpo);
		checkUtente(mittente);
		checkUtente(destinatario);
		
		this.id = id;
		this.oggetto = oggetto;
		this.corpo = corpo;
		this.mittente = mittente;
		this.destinatario = destinatario;
	}
	
	public Messaggio() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto){
		checkOggetto(oggetto);
		this.oggetto = oggetto;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo){
		checkCorpo(corpo);
		this.corpo = corpo;
	}

	public Utente getMittente() {
		return mittente;
	}

	public void setMittente(Utente mittente){
		checkUtente(mittente);
		this.mittente = mittente;
	}
	
	
	public Utente getDestinatario() {
		return destinatario;
	}
	
	public void setDestinatario(Utente destinatario){
		checkUtente(destinatario);
		this.destinatario = destinatario;
	}
	
	private void checkOggetto(String oggetto){
		if((oggetto == null) || (oggetto == "")) {
			throw new IllegalArgumentException("oggetto vuoto o nullo");
		}
		if(oggetto.length()>30)
			throw new IllegalArgumentException("oggetto troppo lungo!");
	}
	
	private void checkCorpo(String corpo) {
		if((corpo == null)) {
			throw new IllegalArgumentException("corpo nullo");
		}
		if(corpo.length()>16777215)
			throw new IllegalArgumentException("corpo troppo lungo!");
	}
	
	private void checkUtente(Utente u) {
		if(u == null) {
			throw new IllegalArgumentException("utente inesistente");
		}
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
		if (corpo == null) {
			if (other.corpo != null)
				return false;
		} else if (!corpo.equals(other.corpo))
			return false;
		if (destinatario == null) {
			if (other.destinatario != null)
				return false;
		} else if (!destinatario.equals(other.destinatario))
			return false;
		if (id != other.id)
			return false;
		if (mittente == null) {
			if (other.mittente != null)
				return false;
		} else if (!mittente.equals(other.mittente))
			return false;
		if (oggetto == null) {
			if (other.oggetto != null)
				return false;
		} else if (!oggetto.equals(other.oggetto))
			return false;
		return true;
	}


	private int id;
	private String oggetto;
	private String corpo;
	private Utente mittente;
	private Utente destinatario;
}
