import java.time.LocalDate;

class Desenvolvedor extends Usuario {

    public void criarTarefaDaDemanda() throws Exception  {
        System.out.println("Escolha uma demanda para criar tarefa:");
        printarDemandas();
        int demandaSelecionada = lerInputInteiro();
        Tarefa tarefaAtual = new Tarefa();
        System.out.println("Digite o nome da tarefa:");
        tarefaAtual.setTitulo(lerInput());
        System.out.println("Informe a descricao da tarefa:");
        tarefaAtual.setDescricao(lerInput());
        tarefaAtual.setDataDeCriacao(LocalDate.now());
        System.out.println("Informe o prazo em dias:");
        tarefaAtual.setPrazoEmDias(lerInputInteiro());
        demandas.get(demandaSelecionada).setTarefas(tarefaAtual);
    }

    public void desenvolvedorLoop() throws Exception  {

        while(true) {
            System.out.println("Ola Desenvolvedor. O que deseja?");
            System.out.println("[1] Visualizar demanda\n[2] Criar tarefa da demanda\n[3] Entrar no chat\n[4] Voltar para menu");
            
            int choice = lerInputInteiro();
            if(choice == 1) {
                this.consultarDemanda();
            } else if (choice == 2) {
                this.criarTarefaDaDemanda();
            } else if (choice == 3){ 
                System.out.println("Comming Soon!");
                break;
            } else if (choice == 4){
                break;
            } else {
            	System.out.println("Error character Typed: " + choice);
                break;
            }
        }
    }
}
