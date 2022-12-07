import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class User {
    protected Vector<Demanda> Demandas = new Vector<Demanda>();

    public Vector<Demanda> getDemandas() {
		return Demandas;
	}

	public void setDemandas(Demanda demandas) {
		Demandas.add(demandas);
	}

	public void printarDemandas() throws Exception {
        for(int i=0;i<Demandas.size();i++)
        {
            System.out.println("[" + i + "] " + Demandas.get(i).getTitulo());
        }
    }

    public void consultarDemanda() throws Exception  {
        System.out.println("Voce tem " + Demandas.size() + " demandas cadastradas:");
        printarDemandas();
        if(Demandas.size() > 0) {
            int IndexDemandaSelecionada = DigitaInt();
            Demanda DemandaSelecionada = Demandas.get(IndexDemandaSelecionada);
            System.out.println("Titulo: " + DemandaSelecionada.getTitulo());
            System.out.println("Descricao: " + DemandaSelecionada.getDescricao());
            System.out.println("Prazo em dias: " + DemandaSelecionada.getPrazoEmDias());
            System.out.println("Prioridade: " + DemandaSelecionada.getPrioridade());
            System.out.println("Situacao: " + DemandaSelecionada.getSituacao());
            System.out.println("Data de criacao: " + DemandaSelecionada.getDataDeCriacao());
            System.out.println("Data de encerramento: " + DemandaSelecionada.getDataDeEncerramento());
            if(this instanceof Desenvolvedor) {
                System.out.println("Tarefas: ");
                for(int i=0;i<DemandaSelecionada.getTarefas().size();i++) {
                    System.out.println("[" + i + "]" + DemandaSelecionada.getTarefas().get(i).getTitulo());
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
