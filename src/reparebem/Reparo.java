package reparebem;

public class Reparo {
	private String id;
	private String descricao;
	private double preco;
	
	
	public Reparo(String id, String descricao, double preco) {
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	
	public String getId() {
		return this.id;
	}

	
	public double getPreco() {
		return this.preco;
	}
	
	
	public void reajustarPreco(double percentual) {
		this.preco = preco * percentual;
	}
}
