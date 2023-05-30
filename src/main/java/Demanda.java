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
    private String descricao;
    private int situacao = NAO_INICIADA;
    private int prioridade = BACKLOG;
    private LocalDate dataDeCriacao;
    private LocalDate dataDeEncerramento;
    private int prazoEmDias;
    private Vector<Tarefa> tarefas;
    
	public String getTitulo() {
		return this.Titulo;
	}
	
	public void setTitulo(String titulo) {
		this.Titulo = titulo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getSituacao() {
		return this.situacao;
	}
	
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public int getPrioridade() {
		return this.prioridade;
	}
	
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	public LocalDate getDataDeCriacao() {
		return this.dataDeCriacao;
	}
	
	public void setDataDeCriacao(LocalDate dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}
	
	public LocalDate getDataDeEncerramento() {
		return this.dataDeEncerramento;
	}
	
	public void setDataDeEncerramento(LocalDate dataDeEncerramento) {
		this.dataDeEncerramento = dataDeEncerramento;
	}
	
	public int getPrazoEmDias() {
		return this.prazoEmDias;
	}
	
	public void setPrazoEmDias(int prazoEmDias) {
		this.prazoEmDias = prazoEmDias;
	}
	
	public Vector<Tarefa> getTarefas() {
		return this.tarefas;
	}
	
	public void setTarefas(Tarefa tarefas) {
		this.tarefas.add(tarefas);
	}
 
	public void iniciarDemanda() {
		if (this.situacao == NAO_INICIADA) {
			this.situacao = EM_PROGRESSO;
		} else if (this.situacao == EM_PROGRESSO) {
			System.out.println("Essa demanda já foi iniciada");
		} else if (this.situacao == FINALIZADA) {
			System.out.println("Essa demanda já foi finalizada");
		}
	}

	public void finalizarDemanda() {
		if (this.situacao == NAO_INICIADA || this.situacao == EM_PROGRESSO) {
			this.situacao = FINALIZADA;
		} else if (this.situacao == FINALIZADA) {
			System.out.println("Essa demanda já foi finalizada");
		}
	}
}