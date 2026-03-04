package atv8_filaMercado;

public class Cliente {
	private String nome;
	private int horaChegou;
	private int tempoServico;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getHoraChegou() {
		return horaChegou;
	}
	public void setHoraChegou(int horaChegou) {
		this.horaChegou = horaChegou;
	}
	public int getTempoServico() {
		return tempoServico;
	}
	public void setTempoServico(int tempoServico) {
		this.tempoServico = tempoServico;
	}
		
	public Cliente(String nome, int horaChegou, int tempoServico) {
		this.nome = nome;
		this.horaChegou = horaChegou;
		this.tempoServico=tempoServico;
	}
	
	
	

}
