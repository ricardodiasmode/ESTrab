import java.time.LocalDate;

class Avaliador extends Usuario {

    public void editarDemanda() throws Exception  {
        System.out.println("Editar demanda:");
        printarDemandas();
        int demandaSelecionada = lerInputInteiro();

        Demanda SoftwareAtual = demandas.get(demandaSelecionada);
        System.out.println("Informe o titulo do software:");
        SoftwareAtual.setTitulo(lerInput());
        System.out.println("Informe a descricao do software:");
        SoftwareAtual.setDescricao(lerInput());
        SoftwareAtual.setDataDeCriacao(LocalDate.now());
        System.out.println("Informe o prazo em dias:");
        SoftwareAtual.setPrazoEmDias(lerInputInteiro());
        demandas.insertElementAt(SoftwareAtual, demandaSelecionada);
        demandas.remove(demandaSelecionada+1);
    }

    public void deletarDemanda() throws Exception  {
        System.out.println("Deletar demanda: " + demandas.size());
        for(int i=0;i<demandas.size();i++)
        {
            System.out.println("[" + i + "] " + demandas.get(i).getTitulo());
        }
        int demandaSelecionada = lerInputInteiro();
        demandas.remove(demandaSelecionada);
    }

    public void avaliadorLoop() throws Exception  {

        while(true) {
            System.out.println("Ola Avaliador. O que deseja?");
            System.out.println("[1] Visualizar demanda\n[2] Cancelar demanda\n[3] Editar demanda\n[4] Entrar no chat\n[5] Voltar para menu");
            
            int escolha = lerInputInteiro();
            if(escolha == 1) {
                this.consultarDemanda();
            } else if (escolha == 2) {
                this.deletarDemanda();
            }  else if (escolha == 3) {
                this.editarDemanda();
            } else if (escolha == 4){ 
                System.out.println("Comming Soon!");
                break;
            } else if (escolha == 5){
                break;
            } else {
            	System.out.println("Error character Typed: " + escolha);
                break;
            }
        }
    }
}
