import java.time.LocalDate; // import the LocalDate class
import java.util.Vector; 

class Demanda {
    String Titulo;
    String Descricao;
    String Situacao = "NAO INICIADA";
    String Prioridade = "DESPRIORIZADO";
    LocalDate DataDeCriacao;
    LocalDate DataDeEncerramento;
    int PrazoEmDias;
    Vector<Tarefa> Tarefas;
}