import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class Usuario {
    protected Vector<Demanda> demandas = new Vector<Demanda>();

    public Vector<Demanda> getDemandas() {
		return this.demandas;
	}

	public void setDemandas(Demanda demandas) {
		this.demandas.add(demandas);
	}

	public void printarDemandas() throws Exception {
        for(int i=0;i<demandas.size();i++)
        {
            System.out.println("[" + i + "] " + demandas.get(i).getTitulo());
        }
    }

    public void consultarDemanda() throws Exception  {
        System.out.println("Voce tem " + demandas.size() + " demandas cadastradas:");
        printarDemandas();
        if(demandas.size() > 0) {
            int indexDemandaSelecionada = lerInputInteiro();
            Demanda demandaSelecionada = demandas.get(indexDemandaSelecionada);
            System.out.println("Titulo: " + demandaSelecionada.getTitulo());
            System.out.println("Descricao: " + demandaSelecionada.getDescricao());
            System.out.println("Prazo em dias: " + demandaSelecionada.getPrazoEmDias());
            System.out.println("Prioridade: " + demandaSelecionada.getPrioridade());
            System.out.println("Situacao: " + demandaSelecionada.getSituacao());
            System.out.println("Data de criacao: " + demandaSelecionada.getDataDeCriacao());
            System.out.println("Data de encerramento: " + demandaSelecionada.getDataDeEncerramento());
            if(this instanceof Desenvolvedor) {
                System.out.println("Tarefas: ");
                for(int i=0;i<demandaSelecionada.getTarefas().size();i++) {
                    System.out.println("[" + i + "]" + demandaSelecionada.getTarefas().get(i).getTitulo());
                }
            }
        }
        System.out.println("-------");
    }

    public static String lerInput() throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String entradaDoTeclado = buff.readLine();

        return entradaDoTeclado;
    }
    
    public static int lerInputInteiro() throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        int entradaDoTeclado = buff.read();

        return entradaDoTeclado-48;
    }

    public static void loopDoUsuario() throws Exception {
        while (true) {
            System.out.println("Quem eh voce?\n[1] Cliente\n[2] Avaliador\n[3] Desenvolvedor");
            int escolha = lerInputInteiro();
            if(escolha == 1) {
                Client newClient = new Client();
                newClient.clientLoop();
            } else if(escolha == 2) {
                Avaliador newAvaliador = new Avaliador();
                newAvaliador.avaliadorLoop();
            }  else if(escolha == 3) {
                Desenvolvedor newDesenvolvedor = new Desenvolvedor();
                newDesenvolvedor.desenvolvedorLoop();
            } else {
                System.out.println("Error character Typed: " + escolha);
                break;
            }
        }
    }
}
