package model.entity;

import java.util.ArrayList;
import java.util.Collection;

public class Tecnico extends Utente {

	public Tecnico() {
		setupList = new ArrayList<Setup>();
	}
	
	public Tecnico(String id, String password, String ruolo, String nome, String cognome,
			Mailbox mailbox) {
		super(id, password,ruolo,nome,cognome,mailbox);
		setupList = new ArrayList<Setup>();
	}
	
	
	
	public Collection<Setup> getSetupList() {
		return setupList;
	}



	public void setSetupList(Collection<Setup> setupList){
		checkSetupList(setupList);
		this.setupList = setupList;
	}
	
	public void addSetup(Setup s){
		checkSetup(s);
		setupList.add(s);
		s.setAutore(this);
	}
	
	public void removeSetup(Setup s){
		checkSetup(s);
		setupList.remove(s);
		s.setAutore(this);
	}
	
	private void checkSetup(Setup s){
		if(s == null) {
			throw new IllegalArgumentException("setup inesistente");
		}
	}
	
	private void checkSetupList(Collection<Setup> setupList) {
		if(setupList == null) {
			throw new IllegalArgumentException("setupList inesistente");
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
		Tecnico other = (Tecnico) obj;
		if (setupList == null) {
			if (other.setupList != null)
				return false;
		} else if (!setupList.equals(other.setupList))
			return false;
		return true;
	}



	private Collection<Setup> setupList;
	

}
