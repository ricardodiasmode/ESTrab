// Sistema de gestão de demandas de software
import java.time.LocalDate; // import the LocalDate class
import java.util.*; 

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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

class Tarefa {
    String Titulo;
    String Descricao;
    String Situacao = "NAO INICIADA";
    String Prioridade = "DESPRIORIZADO";
    LocalDate DataDeCriacao;
    int PrazoEmDias;
}

class Client extends User {
    public Demanda solicitarSoftware() throws Exception  {
        Demanda SoftwareAtual = new Demanda();

        System.out.println("Informe o titulo do software:");
        SoftwareAtual.Titulo = Digita();
        System.out.println("Informe a descricao do software:");
        SoftwareAtual.Descricao = Digita();
        SoftwareAtual.DataDeCriacao = LocalDate.now();
        System.out.println("Informe o prazo em dias:");
        SoftwareAtual.PrazoEmDias = DigitaInt();

        return SoftwareAtual;
    }

    public void clientLoop() throws Exception  {

        while(true) {
            System.out.println("Ola Cliente. O que deseja?");
            System.out.println("[1] Solicitar software\n[2] Consultar demanda\n[3] Entrar no chat\n[4] Voltar para menu");
            
            int Choice = DigitaInt();
            if(Choice == 1) {
                Demandas.add(this.solicitarSoftware());
            } else if (Choice == 2){
                this.consultarDemanda();
            } else {
                break;
            }
        }
    }
}

class Avaliador extends User {

    public void editarDemanda() throws Exception  {
        System.out.println("Editar demanda:");
        printarDemandas();
        int DemandaSelecionada = DigitaInt();

        Demanda SoftwareAtual = Demandas.get(DemandaSelecionada);
        System.out.println("Informe o titulo do software:");
        SoftwareAtual.Titulo = Digita();
        System.out.println("Informe a descricao do software:");
        SoftwareAtual.Descricao = Digita();
        SoftwareAtual.DataDeCriacao = LocalDate.now();
        System.out.println("Informe o prazo em dias:");
        SoftwareAtual.PrazoEmDias = DigitaInt();
        Demandas.insertElementAt(SoftwareAtual, DemandaSelecionada);
        Demandas.remove(DemandaSelecionada+1);
    }

    public void deletarDemanda() throws Exception  {
        System.out.println("Deletar demanda: " + Demandas.size());
        for(int i=0;i<Demandas.size();i++)
        {
            System.out.println("[" + i + "] " + Demandas.get(i).Titulo);
        }
        int DemandaSelecionada = DigitaInt();
        Demandas.remove(DemandaSelecionada);
    }

    public void avaliadorLoop() throws Exception  {

        while(true) {
            System.out.println("Ola Avaliador. O que deseja?");
            System.out.println("[1] Visualizar demanda\n[2] Cancelar demanda\n[3] Editar demanda\n[4] Entrar no chat\n[5] Voltar para menu");
            
            int Choice = DigitaInt();
            if(Choice == 1) {
                this.consultarDemanda();
            } else if (Choice == 2) {
                this.deletarDemanda();
            }  else if (Choice == 3) {
                this.editarDemanda();
            } else {
                break;
            }
        }
    }
}

class Desenvolvedor extends User {

    public void criarTarefaDaDemanda() throws Exception  {
        System.out.println("Escolha uma demanda para criar tarefa:");
        printarDemandas();
        int DemandaSelecionada = DigitaInt();
        Tarefa TarefaAtual = new Demanda();
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
            }  else if (Choice == 3) {
                this.editarDemanda();
            } else {
                break;
            }
        }
    }
}

class User {
    Vector<Demanda> Demandas = new Vector<Demanda>();

    public void printarDemandas() throws Exception {
        for(int i=0;i<Demandas.size();i++)
        {
            System.out.println("[" + i + "] " + Demandas.get(i).Titulo);
        }
    }

    public void consultarDemanda() throws Exception  {
        System.out.println("Voce tem " + Demandas.size() + " demandas cadastradas:");
        printarDemandas();
        int IndexDemandaSelecionada = DigitaInt();
        Demanda DemandaSelecionada = Demandas.get(IndexDemandaSelecionada);
        System.out.println("Titulo: " + DemandaSelecionada.Titulo);
        System.out.println("Descricao: " + DemandaSelecionada.Descricao);
        System.out.println("Prazo em dias: " + DemandaSelecionada.PrazoEmDias);
        System.out.println("Prioridade: " + DemandaSelecionada.Prioridade);
        System.out.println("Situacao: " + DemandaSelecionada.Situacao);
        System.out.println("Data de criacao: " + DemandaSelecionada.DataDeCriacao);
        System.out.println("Data de encerramento: " + DemandaSelecionada.DataDeEncerramento);
        if(this instanceof Desenvolvedor) {
            System.out.println("Tarefas: ");
            for(int i=0;i<DemandaSelecionada.Tarefas.size();i++) {
                System.out.println("[" + i + "]" + DemandaSelecionada.Tarefas.get(i).Titulo);
            }
        }
        System.out.println("-------");
    }

    public static String Digita() throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String entradaDoTeclado = buff.readLine();

        return entradaDoTeclado;
    }
    public static int DigitaInt() throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int entradaDoTeclado = buff.read();

        return entradaDoTeclado-48;
    }

    public static void userLoop() throws Exception {
        while (true) {
            System.out.println("Quem eh voce?\n[1] Cliente\n[2] Avaliador\n[3] Desenvolvedor");
            int Choice = DigitaInt();
            if(Choice == 1) {
                Client newClient = new Client();
                newClient.clientLoop();
            } else if(Choice == 2) {
                Avaliador newAvaliador = new Avaliador();
                newAvaliador.avaliadorLoop();
            }  else if(Choice == 3) {
                Desenvolvedor newDesenvolvedor = new Desenvolvedor();
                newDesenvolvedor.desenvolvedorLoop();
            } else {
                System.out.println("Error character Typed: " + Choice);
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        userLoop();
    }
}