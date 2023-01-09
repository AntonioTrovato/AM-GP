package model.entity;


public class Curva {
	
	public Curva(int id, String nome, float angolo){
		//controllo parametri
		checkNome(nome);
		checkAngolo(angolo);
		
		this.id = id;
		this.nome = nome;
		this.angolo = angolo;
	}	
	
	public Curva(){
		
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
	public float getAngolo() {
		return angolo;
	}
	public void setAngolo(float angolo){
		checkAngolo(angolo);
		this.angolo = angolo;
	}
	
	private void checkNome(String nome) {
		if((nome == null) || (nome == "")) {
			throw new IllegalArgumentException("nome nullo o vuoto");
		}
	}
	
	private void checkAngolo(float angolo) {
		if(angolo < 0) {
			throw new IllegalArgumentException("angolo minore di 0");
		}
	}
	
	
	public boolean equals(Object o)
	{
		if(o==null) return false;
		if(!(o.getClass()==getClass())) return false;
		Curva c= (Curva) o;
		return this.getNome().equals(c.getNome()) && this.getId() == this.id && this.getAngolo()==this.angolo;
	}
	private int id;
	private String nome;
	private float angolo;
}
