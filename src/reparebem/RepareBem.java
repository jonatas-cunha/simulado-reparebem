package reparebem;

public class RepareBem {
	public Reparo[] reparos;
	public int iReparos;
	public OrdemDeServico[] servicos;
	public int iServicos;
	
	public RepareBem() {
		this.reparos = new Reparo[100];
		this.servicos = new OrdemDeServico[500];
	}
	
	
	private Reparo getReparo(String idReparo) {
		for (Reparo r : this.reparos) {
			if (r.getId().equals(idReparo)) {
				return r;
			}
		}
		throw new IllegalArgumentException();
	}
	
	private void existeServico(int idOS) throws Exception {
		if (0 < idOS || 499 < idOS || this.servicos[idOS] == null) {
			throw new IllegalArgumentException();
		}
	}
	
	
	public void cadastrarReparo(String id, String descricao, double preco) {
		if (iReparos < 0 || 99 < iReparos) return;
		
		Reparo novo = new Reparo(id, descricao, preco);
		this.reparos[iReparos] = novo;
		iReparos++;
	}
	
	
	public void reajustarPrecoReparo(String idReparo, double percentual) {
		this.getReparo(idReparo).reajustarPreco(percentual);
	}
	
	
	public int cadastrarOrdemDeServico(String cliente, String telefone, String roupa) {
		if (iServicos < 0 || 499 < iServicos) return -1;
		
		OrdemDeServico nova = new OrdemDeServico(cliente, telefone, roupa);
		this.servicos[iServicos] = nova;
		iServicos++;
		return iServicos + 1;
	}
	
	
	public String exibirOrdemDeServico(int idOS) throws Exception {
		this.existeServico(idOS);
		return "#" + idOS + "; " + this.servicos[idOS - 1].toString();
	}
	
	
	public void incluirReparoOrdemDeServico(int idOS, String idReparo) throws Exception {
		this.existeServico(idOS);
		this.servicos[iServicos].incluirReparo(this.getReparo(idReparo));
	}
	
	
	public void mudarStatusOrdemDeServico(int idOS, String status) throws Exception {
		this.existeServico(idOS);
		this.servicos[idOS - 1].alterarStatus(status);
	}
	
	
	public double obterValorOrdemServico(int idOS) throws Exception {
		this.existeServico(idOS);
		return this.servicos[idOS - 1].getPreco();
	}
	
	
	public String listarOrdemDeServico(String status) {
		String concat = "Ordens de Serviço - " + status + "\n\n";
		for (int i = 0; i < iServicos; i++) {
			if (this.servicos[i].getStatus().equals(status)) {
				concat += "#" + (i + 1) + "; " + this.servicos[i].toString() + "\n";
			}
		}
		return concat;
	}
	
	
	public String listarOrdemDeServico() {
		String concat = "Ordens de Serviço\n\n";
		for (int i = 0; i < iServicos; i++) {
			concat += "#" + (i + 1) + "; " + this.servicos[i].toString() + "\n";
		}
		return concat;
	}
	
}
