import java.time.LocalDate;

class Client extends Usuario {
    
    public Demanda solicitarSoftware() throws Exception  {
        Demanda softwareAtual = new Demanda();

        System.out.println("Informe o titulo do software:");
        softwareAtual.setTitulo(lerInput());
        System.out.println("Informe a descricao do software:");
        softwareAtual.setDescricao(lerInput());
        softwareAtual.setDataDeCriacao(LocalDate.now());
        System.out.println("Informe o prazo em dias:");
        softwareAtual.setPrazoEmDias(lerInputInteiro());

        return softwareAtual;
    }

    public void clientLoop() throws Exception  {

        while(true) {
            System.out.println("Ola Cliente. O que deseja?");
            System.out.println("[1] Solicitar software\n[2] Consultar demanda\n[3] Entrar no chat\n[4] Voltar para menu");
            
            int escolha = lerInputInteiro();
            if(escolha == 1) {
                demandas.add(this.solicitarSoftware());
            } else if (escolha == 2){
                this.consultarDemanda();
            } else if (escolha == 3){ 
                System.out.println("Comming Soon!");
                break;
            } else if (escolha == 4){
                break;
            } else {
            	System.out.println("Error character Typed: " + escolha);
                break;
            }
        }
    }
}