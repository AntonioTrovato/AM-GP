package model.entity;



public class Rettilineo {
	
	public Rettilineo(int id, String nome, double lunghezza){
		//controllo parametri
		checkNome(nome);
		checkLunghezza(lunghezza);

		this.id = id;
		this.nome = nome;
		this.lunghezza = lunghezza;
	}
	
	public Rettilineo(String nome, double lunghezza) {
		this.nome=nome;
		this.lunghezza=lunghezza;
	}
	
	public Rettilineo() {
		
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome){
		checkNome(nome);
		this.nome = nome;
	}
	public double getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(double lunghezza){
		checkLunghezza(lunghezza);
		this.lunghezza = lunghezza;
	}
	
	private void checkNome(String nome) {
		if((nome == null) || (nome == "")) {
			throw new IllegalArgumentException("nome inesistente o nullo");
		}
	}
	
	private void checkLunghezza(double lunghezza) {
		if(lunghezza < 0) {
			throw new IllegalArgumentException("lunghezza minore di 0");
		}
	}
	
	
	public boolean equals(Object o)
	{
		if(o==null) return false;
		if(!(o.getClass()==getClass())) return false;
		Rettilineo  r= (Rettilineo) o;
		return this.getNome().equals(r.getNome()) && this.lunghezza==r.getLunghezza() && this.id == r.getId();
	}
	
	private int id;
	private String nome;
	private double lunghezza;
}
