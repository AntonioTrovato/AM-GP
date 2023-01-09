package model.entity;

public class Setup {
	
	public Setup(int id, double caricoAerodinamicoAnteriore, double caricoAerodinamicoPosteriore, double campanaturaAnteriore,
			double campanaturaPosteriore, double convergenzaAnteriore, double convergenzaPosteriore, double pressioneFreni,
			double barraAntirollioPosteriore, double barraAntirollioAnteriore,Tecnico autore,Circuito circuito, String date){
		
		checkCaricoAerodinamico(caricoAerodinamicoAnteriore);
		checkCaricoAerodinamico(caricoAerodinamicoPosteriore);
		checkCampanatura(campanaturaAnteriore);
		checkCampanatura(campanaturaPosteriore);
		checkConvergenza(convergenzaAnteriore);
		checkConvergenza(convergenzaPosteriore);
		checkPressioneFreni(pressioneFreni);
		checkBarraAntirollio(barraAntirollioPosteriore);
		checkBarraAntirollio(barraAntirollioAnteriore);
		checkAutore(autore);
		checkCircuito(circuito);
		
		this.date=date;
		this.id = id;
		this.caricoAerodinamicoAnteriore = caricoAerodinamicoAnteriore;
		this.caricoAerodinamicoPosteriore = caricoAerodinamicoPosteriore;
		this.campanaturaAnteriore = campanaturaAnteriore;
		this.campanaturaPosteriore = campanaturaPosteriore;
		this.convergenzaAnteriore = convergenzaAnteriore;
		this.convergenzaPosteriore = convergenzaPosteriore;
		this.pressioneFreni = pressioneFreni;
		this.barraAntirollioPosteriore = barraAntirollioPosteriore;
		this.barraAntirollioAnteriore = barraAntirollioAnteriore;
		this.circuito=circuito;
		this.autore = autore;
	}
	
	public Setup(double caricoAerodinamicoAnteriore, double caricoAerodinamicoPosteriore, double campanaturaAnteriore,
			double campanaturaPosteriore, double convergenzaAnteriore, double convergenzaPosteriore, double pressioneFreni,
			double barraAntirollioPosteriore, double barraAntirollioAnteriore,Tecnico autore,Circuito circuito, String date){
		
		checkCaricoAerodinamico(caricoAerodinamicoAnteriore);
		checkCaricoAerodinamico(caricoAerodinamicoPosteriore);
		checkCampanatura(campanaturaAnteriore);
		checkCampanatura(campanaturaPosteriore);
		checkConvergenza(convergenzaAnteriore);
		checkConvergenza(convergenzaPosteriore);
		checkPressioneFreni(pressioneFreni);
		checkBarraAntirollio(barraAntirollioPosteriore);
		checkBarraAntirollio(barraAntirollioAnteriore);
		checkAutore(autore);
		checkCircuito(circuito);
		
		this.date=date;
		this.caricoAerodinamicoAnteriore = caricoAerodinamicoAnteriore;
		this.caricoAerodinamicoPosteriore = caricoAerodinamicoPosteriore;
		this.campanaturaAnteriore = campanaturaAnteriore;
		this.campanaturaPosteriore = campanaturaPosteriore;
		this.convergenzaAnteriore = convergenzaAnteriore;
		this.convergenzaPosteriore = convergenzaPosteriore;
		this.pressioneFreni = pressioneFreni;
		this.barraAntirollioPosteriore = barraAntirollioPosteriore;
		this.barraAntirollioAnteriore = barraAntirollioAnteriore;
		this.circuito=circuito;
		this.autore = autore;
	}	
	
	public Setup() {
		
	}
	
	
	public String getDate() {
		return date;
	}
	
	
	public void setDate(String date) {
		 this.date=date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getCaricoAerodinamicoAnteriore() {
		return caricoAerodinamicoAnteriore;
	}
	
	public void setCaricoAerodinamicoAnteriore(double caricoAerodinamicoAnteriore){
		checkCaricoAerodinamico(caricoAerodinamicoAnteriore);
		this.caricoAerodinamicoAnteriore = caricoAerodinamicoAnteriore;
	}
	public double getCaricoAerodinamicoPosteriore() {
		return caricoAerodinamicoPosteriore;
	}
	public void setCaricoAerodinamicoPosteriore(double caricoAerodinamicoPosteriore){
		checkCaricoAerodinamico(caricoAerodinamicoPosteriore);
		this.caricoAerodinamicoPosteriore = caricoAerodinamicoPosteriore;
	}
	public double getCampanaturaAnteriore() {
		return campanaturaAnteriore;
	}
	public void setCampanaturaAnteriore(double campanaturaAnteriore){
		checkCampanatura(campanaturaAnteriore);
		this.campanaturaAnteriore = campanaturaAnteriore;
	}
	public double getCampanaturaPosteriore() {
		return campanaturaPosteriore;
	}
	public void setCampanaturaPosteriore(double campanaturaPosteriore){
		checkCampanatura(campanaturaPosteriore);
		this.campanaturaPosteriore = campanaturaPosteriore;
	}
	public double getConvergenzaAnteriore() {
		return convergenzaAnteriore;
	}
	public void setConvergenzaAnteriore(double convergenzaAnteriore){
		checkConvergenza(convergenzaAnteriore);
		this.convergenzaAnteriore = convergenzaAnteriore;
	}
	public double getConvergenzaPosteriore() {
		return convergenzaPosteriore;
	}
	public void setConvergenzaPosteriore(double convergenzaPosteriore){
		checkConvergenza(convergenzaPosteriore);
		this.convergenzaPosteriore = convergenzaPosteriore;
	}
	public double getPressioneFreni() {
		return pressioneFreni;
	}
	
	public void setPressioneFreni(double pressioneFreni){
		checkPressioneFreni(pressioneFreni);
		this.pressioneFreni = pressioneFreni;
	}
	
	public double getBarraAntirollioPosteriore() {
		return barraAntirollioPosteriore;
	}
	
	public void setBarraAntirollioPosteriore(double barraAntirollioPosteriore){
		checkBarraAntirollio(barraAntirollioPosteriore);
		this.barraAntirollioPosteriore = barraAntirollioPosteriore;
	}
	
	public double getBarraAntirollioAnteriore() {
		return barraAntirollioAnteriore;
	}
	
	public void setBarraAntirollioAnteriore(double barraAntirollioAnteriore){
		checkBarraAntirollio(barraAntirollioAnteriore);
		this.barraAntirollioAnteriore = barraAntirollioAnteriore;
	}

	public Circuito getCircuito() {
		return circuito;
	}

	public void setCircuito(Circuito circuito){
		checkCircuito(circuito);
		this.circuito = circuito;
	}

	
	public Utente getAutore() {
		return autore;
	}

	public void setAutore(Tecnico autore){
		checkAutore(autore);
		if(this.autore != autore) {
			Tecnico vecchioAutore = this.autore;
			this.autore = autore;
			if(autore != null)
				autore.addSetup(this);
			if(vecchioAutore != null)
				vecchioAutore.removeSetup(this);
		}
	}
	
	private void checkCaricoAerodinamico(double carico) {
		if((carico < 1) || (carico > 10)) {
			throw new IllegalArgumentException("carico fuori dominio");
		}
	}
	
	private void checkCampanatura(double campanatura) {
		if((campanatura < -5) || (campanatura > 5)) {
			throw new IllegalArgumentException("campanatura fuori dominio");
		}
	}
	
	private void checkConvergenza(double convergenza) {
		if((convergenza < -1) || (convergenza > 1)) {
			throw new IllegalArgumentException("convergenza fuori dominio");
		}
	}
	
	private void checkPressioneFreni(double pressione) {
		if((pressione < 0) || (pressione > 100)) {
			throw new IllegalArgumentException("pressione fuori dominio");
		}
	}
	
	private void checkBarraAntirollio(double barra) {
		if((barra < 1) || (barra > 10)) {
			throw new IllegalArgumentException("barra fuori dominio");
		}
	}
	
	private void checkAutore(Tecnico autore) {
		if(autore == null) {
			throw new IllegalArgumentException("autore inesistente");
		}
	}
	
	private void checkCircuito(Circuito circuito) {
		if(circuito == null) {
			throw new IllegalArgumentException("circuito inesistente");
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
		Setup other = (Setup) obj;
		if (autore == null) {
			if (other.autore != null)
				return false;
		} else if (!autore.equals(other.autore))
			return false;
		if (Double.doubleToLongBits(barraAntirollioAnteriore) != Double
				.doubleToLongBits(other.barraAntirollioAnteriore))
			return false;
		if (Double.doubleToLongBits(barraAntirollioPosteriore) != Double
				.doubleToLongBits(other.barraAntirollioPosteriore))
			return false;
		if (Double.doubleToLongBits(campanaturaAnteriore) != Double.doubleToLongBits(other.campanaturaAnteriore))
			return false;
		if (Double.doubleToLongBits(campanaturaPosteriore) != Double.doubleToLongBits(other.campanaturaPosteriore))
			return false;
		if (Double.doubleToLongBits(caricoAerodinamicoAnteriore) != Double
				.doubleToLongBits(other.caricoAerodinamicoAnteriore))
			return false;
		if (Double.doubleToLongBits(caricoAerodinamicoPosteriore) != Double
				.doubleToLongBits(other.caricoAerodinamicoPosteriore))
			return false;
		if (circuito == null) {
			if (other.circuito != null)
				return false;
		} else if (!circuito.equals(other.circuito))
			return false;
		if (Double.doubleToLongBits(convergenzaAnteriore) != Double.doubleToLongBits(other.convergenzaAnteriore))
			return false;
		if (Double.doubleToLongBits(convergenzaPosteriore) != Double.doubleToLongBits(other.convergenzaPosteriore))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(pressioneFreni) != Double.doubleToLongBits(other.pressioneFreni))
			return false;
		return true;
	}


	private int id;
	private String date;
	private double caricoAerodinamicoAnteriore;
	private double caricoAerodinamicoPosteriore;
	private double campanaturaAnteriore;
	private double campanaturaPosteriore;
	private double convergenzaAnteriore;
	private double convergenzaPosteriore;
	private double pressioneFreni;
	private double barraAntirollioPosteriore;
	private double barraAntirollioAnteriore;
	private Tecnico autore;
	private Circuito circuito;
}
