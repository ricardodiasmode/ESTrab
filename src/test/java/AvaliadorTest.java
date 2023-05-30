import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.After;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.junit.platform.runner.JUnitPlatform;
@SuppressWarnings({ "unused", "deprecation" })
class AvaliadorTest {
	
	private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
	
    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }
    
    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
	
	@Test
	void testAvaliadorLoopException() throws Exception {
		provideInput("0");
		Avaliador avaliador = new Avaliador();
		avaliador.avaliadorLoop();
		
		String output = getOutput();
		assertTrue(output.contains("Ola Avaliador. O que deseja?"));
		assertTrue(output.contains("[1] Visualizar demanda\n[2] Cancelar demanda\n[3] Editar demanda\n[4] Entrar no chat\n[5] Voltar para menu"));
		assertTrue(output.contains("Error character Typed: 0"));
	}

    @Test
	void testDeletarDemandas() throws Exception {
		Avaliador avaliador = new Avaliador();
		Demanda demandaEx = new Demanda();
		String titulo = "Titulo Demanda";
		
		demandaEx.setTitulo(titulo);
		avaliador.setDemandas(demandaEx);
		
        provideInput("0");
		avaliador.deletarDemanda();
		
        String output = getOutput();
		assertTrue(output.contains("Deletar demanda: 1"));
		assertTrue(output.contains("[0] "+titulo+"\n"));
		assertEquals(0, avaliador.getDemandas().size());
	}

	@Test
	void testEditarSoftware() throws Exception {
		final String nameTask = "First Task";
		final String descTask = "Creating My First Task";
		final int deadlineTask = 60;
		
		Client clientTest = new Client();
		Demanda	newDemanda = new Demanda();
        newDemanda.setTitulo("Demanda Teste");
        newDemanda.setDescricao("Demanda criada para testes");
        newDemanda.setPrazoEmDias(30);

		// Realizar mock das entradas do usuário 
		clientTest.solicitarSoftware();
        when(Client.lerInput()).thenReturn(nameTask);
        when(Client.lerInput()).thenReturn(descTask);
        when(Client.lerInputInteiro()).thenReturn(deadlineTask);

        // Validar se as alterações foram relamente feitas
		assertEquals(nameTask, newDemanda.getTitulo());
		assertEquals(descTask, newDemanda.getDescricao());
		assertEquals(deadlineTask, newDemanda.getPrazoEmDias());
	}
}
