import java.time.LocalDate; // import the LocalDate class

class Tarefa {

	public static final int NAO_INICIADA = 0;
	public static final int EM_PROGRESSO = 1;
	public static final int FINALIZADA = 2;

	public static final int BACKLOG = 0;
	public static final int BAIXA = 1;
	public static final int MEDIA = 2;
	public static final int ALTA = 3;

    private String titulo;
    private String descricao;
    private int situacao = NAO_INICIADA;
    private int prioridade = BACKLOG;
    private LocalDate dataDeCriacao;
    private int prazoEmDias;
    
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	
	public int getPrazoEmDias() {
		return this.prazoEmDias;
	}
	
	public void setPrazoEmDias(int prazoEmDias) {
		this.prazoEmDias = prazoEmDias;
	}

	public void iniciaTarefa() {
		if (this.situacao == NAO_INICIADA) {
			this.situacao = EM_PROGRESSO;
		} else if (this.situacao == EM_PROGRESSO) {
			System.out.println("Essa tarefa já foi iniciada");
		} else if (this.situacao == FINALIZADA) {
			System.out.println("Essa tarefa já foi finalizada");
		}
	}

	public void finalizaTarefa() {
		if (this.situacao == NAO_INICIADA || this.situacao == EM_PROGRESSO) {
			this.situacao = FINALIZADA;
		} else if (this.situacao == FINALIZADA) {
			System.out.println("Essa tarefa já foi finalizada");
		}
	}
}