import java.time.LocalDate; // import the LocalDate class

class Tarefa {
    private String Titulo;
    private String Descricao;
    private String Situacao = "NAO INICIADA";
    private String Prioridade = "DESPRIORIZADO";
    private LocalDate DataDeCriacao;
    private int PrazoEmDias;

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

    public int getPrazoEmDias() {
        return this.PrazoEmDias;
    }

    public void setPrazoEmDias(int PrazoEmDias) {
        this.PrazoEmDias = PrazoEmDias;
    }

}