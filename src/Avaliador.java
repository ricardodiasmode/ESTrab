import java.time.LocalDate;

class Avaliador extends User {

    public void editarDemanda() throws Exception  {
        System.out.println("Editar demanda:");
        printarDemandas();
        int DemandaSelecionada = DigitaInt();

        Demanda SoftwareAtual = Demandas.get(DemandaSelecionada);
        System.out.println("Informe o titulo do software:");
        SoftwareAtual.setTitulo(Digita());
        System.out.println("Informe a descricao do software:");
        SoftwareAtual.setDescricao(Digita());
        SoftwareAtual.setDataDeCriacao(LocalDate.now());
        System.out.println("Informe o prazo em dias:");
        SoftwareAtual.setPrazoEmDias(DigitaInt());
        Demandas.insertElementAt(SoftwareAtual, DemandaSelecionada);
        Demandas.remove(DemandaSelecionada+1);
    }

    public void deletarDemanda() throws Exception  {
        System.out.println("Deletar demanda: " + Demandas.size());
        for(int i=0;i<Demandas.size();i++)
        {
            System.out.println("[" + i + "] " + Demandas.get(i).getTitulo());
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
            } else if (Choice == 4){ 
                System.out.println("Comming Soon!");
                break;
            } else if (Choice == 5){
                break;
            } else {
            	System.out.println("Error character Typed: " + Choice);
                break;
            }
        }
    }
}
