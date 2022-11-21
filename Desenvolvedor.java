import java.time.LocalDate;

class Desenvolvedor extends User {

    public void criarTarefaDaDemanda() throws Exception  {
        System.out.println("Escolha uma demanda para criar tarefa:");
        printarDemandas();
        int DemandaSelecionada = DigitaInt();
        Tarefa TarefaAtual = new Tarefa();
        System.out.println("Digite o nome da tarefa:");
        TarefaAtual.Titulo = Digita();
        System.out.println("Informe a descricao da tarefa:");
        TarefaAtual.Descricao = Digita();
        TarefaAtual.DataDeCriacao = LocalDate.now();
        System.out.println("Informe o prazo em dias:");
        TarefaAtual.PrazoEmDias = DigitaInt();
        Demandas.get(DemandaSelecionada).Tarefas.add(TarefaAtual);
    }

    public void desenvolvedorLoop() throws Exception  {

        while(true) {
            System.out.println("Ola Desenvolvedor. O que deseja?");
            System.out.println("[1] Visualizar demanda\n[2] Criar tarefa da demanda\n[3] Entrar no chat\n[4] Voltar para menu");
            
            int Choice = DigitaInt();
            if(Choice == 1) {
                this.consultarDemanda();
            } else if (Choice == 2) {
                this.criarTarefaDaDemanda();
            } else {
                break;
            }
        }
    }
}
