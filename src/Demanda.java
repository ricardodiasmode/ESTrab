import java.time.LocalDate; // import the LocalDate class
import java.util.Vector; 

class Demanda {

	public static final int NAO_INICIADA = 0;
	public static final int EM_PROGRESSO = 1;
	public static final int FINALIZADA = 2;

	public static final int BACKLOG = 0;
	public static final int BAIXA = 1;
	public static final int MEDIA = 2;
	public static final int ALTA = 3;

    private String Titulo;
    private String Descricao;
    private int Situacao = NAO_INICIADA;
    private int Prioridade = BACKLOG;
    private LocalDate DataDeCriacao;
    private LocalDate DataDeEncerramento;
    private int PrazoEmDias;
    private Vector<Tarefa> Tarefas;
    
	public String getTitulo() {
		return this.Titulo;
	}
	
	public void setTitulo(String titulo) {
		this.Titulo = titulo;
	}
	
	public String getDescricao() {
		return this.Descricao;
	}
	
	public void setDescricao(String descricao) {
		this.Descricao = descricao;
	}
	
	public int getSituacao() {
		return this.Situacao;
	}
	
	public void setSituacao(int situacao) {
		this.Situacao = situacao;
	}
	public int getPrioridade() {
		return this.Prioridade;
	}
	
	public void setPrioridade(int prioridade) {
		this.Prioridade = prioridade;
	}
	
	public LocalDate getDataDeCriacao() {
		return this.DataDeCriacao;
	}
	
	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		this.DataDeCriacao = dataDeCriacao;
	}
	
	public LocalDate getDataDeEncerramento() {
		return this.DataDeEncerramento;
	}
	
	public void setDataDeEncerramento(LocalDate dataDeEncerramento) {
		this.DataDeEncerramento = dataDeEncerramento;
	}
	
	public int getPrazoEmDias() {
		return this.PrazoEmDias;
	}
	
	public void setPrazoEmDias(int prazoEmDias) {
		this.PrazoEmDias = prazoEmDias;
	}
	
	public Vector<Tarefa> getTarefas() {
		return this.Tarefas;
	}
	
	public void setTarefas(Tarefa tarefas) {
		this.Tarefas.add(tarefas);
	}
 
	public void iniciaDemanda() {
		if (this.Situacao == NAO_INICIADA) {
			this.Situacao = EM_PROGRESSO;
		} else if (this.Situacao == EM_PROGRESSO) {
			System.out.println("Essa demanda já foi iniciada");
		} else if (this.Situacao == FINALIZADA) {
			System.out.println("Essa demanda já foi finalizada");
		}
	}

	public void finalizaDemanda() {
		if (this.Situacao == NAO_INICIADA || this.Situacao == EM_PROGRESSO) {
			this.Situacao = FINALIZADA;
		} else if (this.Situacao == FINALIZADA) {
			System.out.println("Essa demanda já foi finalizada");
		}
	}
}