import java.time.LocalDate; // import the LocalDate class
import java.util.Vector; 

class Demanda {
    private String Titulo;
    private String Descricao;
    private String Situacao = "NAO INICIADA";
    private String Prioridade = "DESPRIORIZADO";
    private LocalDate DataDeCriacao;
    private LocalDate DataDeEncerramento;
    private int PrazoEmDias;
    private Vector<Tarefa> Tarefas;
    
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
	
	public LocalDate getDataDeEncerramento() {
		return DataDeEncerramento;
	}
	
	public void setDataDeEncerramento(LocalDate dataDeEncerramento) {
		DataDeEncerramento = dataDeEncerramento;
	}
	
	public int getPrazoEmDias() {
		return PrazoEmDias;
	}
	
	public void setPrazoEmDias(int prazoEmDias) {
		PrazoEmDias = prazoEmDias;
	}
	
	public Vector<Tarefa> getTarefas() {
		return Tarefas;
	}
	
	public void setTarefas(Tarefa tarefas) {
		Tarefas.add(tarefas);
	}
 
}