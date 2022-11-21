import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class User {
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
        if(Demandas.size() > 0) {
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
}
