package model.entity;


public class Pilota extends Utente {
	
	public Pilota(String id, String password, String ruolo, String nome, String cognome,
			Mailbox mailbox, int punteggio, int numeroVittorie, int numeroPole, int numeroPiazzamenti, int numeroRitiri){
		//controllo parametri
		super(id, password, ruolo, nome, cognome, mailbox);
		checkPunteggio(punteggio);
		checkNumeroVittorie(numeroVittorie);
		checkNumeroPole(numeroPole);
		checkNumeroPiazzamenti(numeroPiazzamenti);
		checkNumeroRitiri(numeroRitiri);
		
		this.punteggio = punteggio;
		this.numeroVittorie = numeroVittorie;
		this.numeroPole = numeroPole;
		this.numeroPiazzamenti = numeroPiazzamenti;
		this.numeroRitiri = numeroRitiri;
	}
	
	public Pilota() {
		
	}
	
	public int getPunteggio() {
		return punteggio;
	}
	
	public void setPunteggio(int punteggio){
		checkPunteggio(punteggio);
		this.punteggio = punteggio;
	}
	
	public int getNumeroVittorie() {
		return numeroVittorie;
	}
	
	public void setNumeroVittorie(int numeroVittorie){
		checkNumeroVittorie(numeroVittorie);
		this.numeroVittorie = numeroVittorie;
	}
	public int getNumeroPole() {
		return numeroPole;
	}
	public void setNumeroPole(int numeroPole){
		checkNumeroPole(numeroPole);
		this.numeroPole = numeroPole;
	}
	public int getNumeroPiazzamenti() {
		return numeroPiazzamenti;
	}
	public void setNumeroPiazzamenti(int numeroPiazzamenti){
		checkNumeroPiazzamenti(numeroPiazzamenti);
		this.numeroPiazzamenti = numeroPiazzamenti;
	}
	public int getNumeroRitiri() {
		return numeroRitiri;
	}
	public void setNumeroRitiri(int numeroRitiri){
		checkNumeroRitiri(numeroRitiri);
		this.numeroRitiri = numeroRitiri;
	}
	
	private void checkPunteggio(int punteggio){
		if(punteggio < 0 || punteggio > 575) {
			throw new IllegalArgumentException("punteggio minore di 0");
		}
	}
	
	private void checkNumeroVittorie(int vittorie) {
		if(vittorie < 0 || vittorie > 24) {
			throw new IllegalArgumentException("numeroVittorie minore di 0");
		}
	}
	
	private void checkNumeroPole(int numeroPole) {
		if(numeroPole < 0 || numeroPole > 24) {
			throw new IllegalArgumentException("numeroPole minore di 0");
		}
	}
	
	private void checkNumeroPiazzamenti(int numeroPiazzamenti) {
		if(numeroPiazzamenti < 0 || numeroPiazzamenti > 24) {
			throw new IllegalArgumentException("numeroPiazzamenti minore di 0");
		}
	}
	
	private void checkNumeroRitiri(int numeroRitiri) {
		if(numeroRitiri < 0 || numeroPiazzamenti > 24) {
			throw new IllegalArgumentException("numeroRitiri minore di 0");
		}
	}
	
	private int punteggio;
	private int numeroVittorie;
	private int numeroPole;
	private int numeroPiazzamenti;
	private int numeroRitiri;
}
