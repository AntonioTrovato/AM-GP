package model.entity;

import java.util.ArrayList;
import java.util.Collection;

public class Circuito {

	public Circuito(String nome,String sede, long lunghezza, String meteo, long tpm, long rpm,
		int umidita, int numeroGiri, Collection<Curva> curve, Collection<Rettilineo> rettilinei){
		//controllo validit� dei parametri
		checkNome(nome);
		checkSede(sede);
		checkLunghezza(lunghezza);
		checkMeteo(meteo);
		checkTPM(tpm);
		checkRPM(rpm);
		checkUmidita(umidita);
		checkNumeroGiri(numeroGiri);
		checkCurve(curve);
		checkRettilinei(rettilinei);

		this.nome=nome;
		this.sede = sede;
		this.lunghezza = lunghezza;
		this.meteo = meteo;
		this.tpm = tpm;
		this.rpm = rpm;
		this.umidita = umidita;
		this.numeroGiri = numeroGiri;
		this.curve = curve;
		this.rettilinei = rettilinei;
	}



	public Circuito(String nome,String sede, long lunghezza, String meteo, long tpm, long rpm, int umidita, int numeroGiri){
		//controllo parametri
		checkNome(nome);
		checkSede(sede);
		checkLunghezza(lunghezza);
		checkMeteo(meteo);
		checkTPM(tpm);
		checkRPM(rpm);
		checkUmidita(umidita);
		checkNumeroGiri(numeroGiri);

		this.nome=nome;
		this.sede = sede;
		this.lunghezza = lunghezza;
		this.meteo = meteo;
		this.tpm = tpm;
		this.rpm = rpm;
		this.umidita = umidita;
		this.numeroGiri = numeroGiri;
		curve = new ArrayList<Curva>();
		rettilinei = new ArrayList<Rettilineo>();
	}
	
	public Circuito(int id, String nome,String sede, long lunghezza, String meteo, long tpm, long rpm, int umidita, int numeroGiri){
		//controllo parametri
		checkNome(nome);
		checkSede(sede);
		checkLunghezza(lunghezza);
		checkMeteo(meteo);
		checkTPM(tpm);
		checkRPM(rpm);
		checkUmidita(umidita);
		checkNumeroGiri(numeroGiri);

		this.id=id;
		this.nome=nome;
		this.sede = sede;
		this.lunghezza = lunghezza;
		this.meteo = meteo;
		this.tpm = tpm;
		this.rpm = rpm;
		this.umidita = umidita;
		this.numeroGiri = numeroGiri;
		curve = new ArrayList<Curva>();
		rettilinei = new ArrayList<Rettilineo>();
	}



	public Circuito() {
		curve = new ArrayList<Curva>();
		rettilinei = new ArrayList<Rettilineo>();
	}


	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getSede() {
		return sede;
	}

	public void setSede(String newSede){
		checkSede(newSede);
		this.sede = newSede;
	}

	public long getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(long newLunghezza){
		checkLunghezza(newLunghezza);
		this.lunghezza = newLunghezza;
	}

	public String getMeteo() {
		return meteo;
	}

	public void setMeteo(String newMeteo){
		checkMeteo(newMeteo);
		this.meteo = newMeteo;
	}

	public long getTpm() {
		return tpm;
	}

	public void setTpm(long newTpm){
		checkTPM(newTpm);
		this.tpm = newTpm;
	}

	public long getRpm() {
		return rpm;
	}

	public void setRpm(long newRpm){
		checkRPM(newRpm);
		this.rpm = newRpm;
	}

	public long getUmidita() {
		return umidita;
	}

	public void setUmidita(long newUmidita){
		checkUmidita(newUmidita);
		this.umidita = newUmidita;
	}

	public long getNumeroGiri() {
		return numeroGiri;
	}

	public void setNumeroGiri(int newNumeroGiri){
		checkNumeroGiri(newNumeroGiri);
		this.numeroGiri = newNumeroGiri;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Curva> getCurve() {
		return curve;
	}

	public void setCurve(Collection<Curva> newCurve){
		checkCurve(newCurve);
		this.curve = newCurve;
	}

	public Collection<Rettilineo> getRettilinei() {
		return rettilinei;
	}

	public void setRettilinei(Collection<Rettilineo> newRettilinei){
		checkRettilinei(newRettilinei);
		this.rettilinei = newRettilinei;
	}


	private void checkNome(String nome) {
		if((nome == null) || (nome == "")) {
			throw new IllegalArgumentException("nome nullo o vuoto");
		}
	}


	private void checkSede(String newSede) {
		if((newSede == null) || (newSede == "")) {
			throw new IllegalArgumentException("sede nulla o vuota");
		}
	}

	private void checkLunghezza(long newLunghezza) {
		if(newLunghezza < 0) {
			throw new IllegalArgumentException("lunghezza minore di 0");
		}
	}

	private void checkMeteo(String newMeteo) {
		if((newMeteo == null) || (newMeteo == "")) {
			throw new IllegalArgumentException("meteo nullo o vuoto");
		}
	}

	private void checkTPM(long newTpm) {
		if(newTpm < 0) {
			throw new IllegalArgumentException("tpm minore di 0");
		}
	}

	private void checkRPM(long newRPM) {
		if(newRPM < 0) {
			throw new IllegalArgumentException("rpm minore di 0");
		}
	}

	private void checkUmidita(long newUmidita) {
		if(newUmidita < 0) {
			throw new IllegalArgumentException("umidita minore di 0");
		}
	}

	private void checkNumeroGiri(int newNumeroGiri) {
		if(newNumeroGiri < 0) {
			throw new IllegalArgumentException("numeroGiri minore di 0");
		}
	}

	private void checkCurve(Collection<Curva> newCurve) {
		if((newCurve == null) || (newCurve.isEmpty())) {
			throw new IllegalArgumentException("curve inesistenti");
		}
	}

	private void checkRettilinei(Collection<Rettilineo> newRettilinei) {
		if((newRettilinei == null) || (newRettilinei.isEmpty())) {
			throw new IllegalArgumentException("rettilinei inesistenti");
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
		Circuito other = (Circuito) obj;
		if (curve == null) {
			if (other.curve != null)
				return false;
		} else if (!curve.equals(other.curve))
			return false;
		if (id != other.id)
			return false;
		if (lunghezza != other.lunghezza)
			return false;
		if (meteo == null) {
			if (other.meteo != null)
				return false;
		} else if (!meteo.equals(other.meteo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroGiri != other.numeroGiri)
			return false;
		if (rettilinei == null) {
			if (other.rettilinei != null)
				return false;
		} else if (!rettilinei.equals(other.rettilinei))
			return false;
		if (rpm != other.rpm)
			return false;
		if (sede == null) {
			if (other.sede != null)
				return false;
		} else if (!sede.equals(other.sede))
			return false;
		if (tpm != other.tpm)
			return false;
		if (umidita != other.umidita)
			return false;
		return true;
	}




	private int id;
	private String nome;
	private String sede;
	private long lunghezza;
	private String meteo;
	private long tpm;
	private long rpm;
	private long umidita;
	private int numeroGiri;
	private Collection<Curva> curve;
	private Collection<Rettilineo> rettilinei;
}
