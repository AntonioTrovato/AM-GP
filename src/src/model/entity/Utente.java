package model.entity;

public class Utente {
	
	public Utente() {
		
	}
	
	public Utente(String id, String password, String ruolo, String nome, String cognome,
			Mailbox mailbox){
		//controllo parametri
		checkId(id);
		checkPassword(password);
		checkRuolo(ruolo);
		checkNome(nome);
		checkCognome(cognome);
		checkMailbox(mailbox);
		
		this.id = id;
		this.password = password;
		this.ruolo = ruolo;
		this.nome = nome;
		this.cognome = cognome;
		this.mailbox=mailbox;
	}
		
	public String getId() {
			return id;
	}
		
	public void setId(String id){
			checkId(id);
			this.id = id;
	}
		
	public String getPassword() {
			return password;
	}
		
	public void setPassword(String password){
			checkPassword(password);
			this.password = password;
	}
		
	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo){
		checkRuolo(ruolo);
		this.ruolo = ruolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome){
		checkNome(nome);
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome){
		checkCognome(cognome);
		this.cognome = cognome;
	}

	public Mailbox getMailbox() {
		return mailbox;
	}

	public void setMailbox(Mailbox mailbox){
		checkMailbox(mailbox);
		this.mailbox = mailbox;
	}
	
	
	private void checkId(String id) {
		if((id == null) || (id.length() != 14)) {
			throw new IllegalArgumentException("id inesistente o non di 14 caratteri");
		}
		String pattern = "^[A-Za-z0-9]{14}$";
		if(!id.matches(pattern)) {
			throw new IllegalArgumentException("id");
		}
	}
	
	private void checkPassword(String password) {
		if((password == null) || (password.length() < 8)) {
			throw new IllegalArgumentException("caratteri");
		}
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		if(!password.matches(pattern)) {
			throw new IllegalArgumentException("password");
		}
	}
	
	private void checkRuolo(String ruolo) {
		if((ruolo == null) || (ruolo == "")){
			throw new IllegalArgumentException("ruolo non valido oppure vuoto");
		}
		if((!ruolo.equals("tecnico")) && (!ruolo.equals("pilota"))){
			throw new IllegalArgumentException("ruolo inesistente");
		}
	}
	
	private void checkNome(String nome) {
		if((nome == null) || (nome == "")) {
			throw new IllegalArgumentException("nome vuoto o inesistente");
		}
	}
	
	private void checkCognome(String cognome) {
		if((cognome == null) || (cognome == "")) {
			throw new IllegalArgumentException("cognome vuoto o inesistente");
		}
	}
	
	private void checkMailbox(Mailbox mailbox) {
		if(mailbox == null) {
			throw new IllegalArgumentException("mailbox non esistente");
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
		Utente other = (Utente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mailbox == null) {
			if (other.mailbox != null)
				return false;
		} else if (!mailbox.equals(other.mailbox))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (ruolo == null) {
			if (other.ruolo != null)
				return false;
		} else if (!ruolo.equals(other.ruolo))
			return false;
		return true;
	}


	private String id;
	private String password;
	private String ruolo;
	private String nome;
	private String cognome;
	private Mailbox mailbox;		
}

