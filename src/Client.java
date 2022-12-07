import java.time.LocalDate;

class Client extends User {
    
    public Demanda solicitarSoftware() throws Exception  {
        Demanda SoftwareAtual = new Demanda();

        System.out.println("Informe o titulo do software:");
        SoftwareAtual.setTitulo(Digita());
        System.out.println("Informe a descricao do software:");
        SoftwareAtual.setDescricao(Digita());
        SoftwareAtual.setDataDeCriacao(LocalDate.now());
        System.out.println("Informe o prazo em dias:");
        SoftwareAtual.setPrazoEmDias(DigitaInt());

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
            	System.out.println("Error character Typed: " + Choice);
                break;
            }
        }
    }
}