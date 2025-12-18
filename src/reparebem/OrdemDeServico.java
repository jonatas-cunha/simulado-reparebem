package reparebem;

public class OrdemDeServico {
	private String cliente;
	private String telefone;
	private String roupa;
	
	private Reparo[] reparos;
	private int iReparos;
	private String status;
	
	
	public OrdemDeServico(String cliente, String telefone, String roupa) {
		this.cliente = cliente;
		this.telefone = telefone;
		this.roupa = roupa;
		this.reparos = new Reparo[10];
		this.status = "Não iniciada";
	}
	
	
	@Override
	public String toString() {
		return "cliente: " + this.cliente + "; " +
				"roupa: " + this.roupa + "; " +
				"reparos: " + this.reparos.length + "; " +
				"total: R$" + this.getPreco();
	}
	
	
	public double getPreco() {
		double soma = 0;
		for (Reparo r : this.reparos) {
			if (r == null) continue;
			
			soma += r.getPreco();
		}
		
		return soma;
	}
	
	
	public String getStatus() {
		return this.status;
	}
	
	
	public void incluirReparo(Reparo reparo) {
		this.reparos[iReparos] = reparo;
	}
	
	
	public void alterarStatus(String novo) {
		this.status = novo;
	}
	
}