import java.time.LocalDate; // import the LocalDate class

class Tarefa {
    private String Titulo;
    private String Descricao;
    private String Situacao = "NAO INICIADA";
    private String Prioridade = "DESPRIORIZADO";
    private LocalDate DataDeCriacao;
    private int PrazoEmDias;
    
	public String getTitulo() {
		return Titulo;
	}
	
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	
	public String getDescricao() {
		return Descricao;
	}
	
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	public String getSituacao() {
		return Situacao;
	}
	
	public void setSituacao(String situacao) {
		Situacao = situacao;
	}
	
	public String getPrioridade() {
		return Prioridade;
	}
	
	public void setPrioridade(String prioridade) {
		Prioridade = prioridade;
	}
	
	public LocalDate getDataDeCriacao() {
		return DataDeCriacao;
	}
	
	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		DataDeCriacao = dataDeCriacao;
	}
	
	public int getPrazoEmDias() {
		return PrazoEmDias;
	}
	
	public void setPrazoEmDias(int prazoEmDias) {
		PrazoEmDias = prazoEmDias;
	}
}