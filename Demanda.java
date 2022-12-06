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
        return this.Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescricao() {
        return this.Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getSituacao() {
        return this.Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public String getPrioridade() {
        return this.Prioridade;
    }

    public void setPrioridade(String Prioridade) {
        this.Prioridade = Prioridade;
    }

    public LocalDate getDataDeCriacao() {
        return this.DataDeCriacao;
    }

    public void setDataDeCriacao(LocalDate DataDeCriacao) {
        this.DataDeCriacao = DataDeCriacao;
    }

    public LocalDate getDataDeEncerramento() {
        return this.DataDeEncerramento;
    }

    public void setDataDeEncerramento(LocalDate DataDeEncerramento) {
        this.DataDeEncerramento = DataDeEncerramento;
    }

    public int getPrazoEmDias() {
        return this.PrazoEmDias;
    }

    public void setPrazoEmDias(int PrazoEmDias) {
        this.PrazoEmDias = PrazoEmDias;
    }

    public Vector<Tarefa> getTarefas() {
        return this.Tarefas;
    }

    public void setTarefas(Vector<Tarefa> Tarefas) {
        this.Tarefas = Tarefas;
    }

}