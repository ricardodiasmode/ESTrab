import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.After;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


import org.junit.platform.runner.JUnitPlatform;
@SuppressWarnings({ "unused", "deprecation" })
class ClientTest {

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
	void testSolicitarSoftware() throws Exception {
		final String nameTask = "First Task";
		final String descTask = "Creating My First Task";
		final int deadlineTask = 30;
		
		Client clientTest = new Client();
		Demanda	newDemanda = new Demanda();

		// Realizar mock das entradas do usuário 
		newDemanda = clientTest.solicitarSoftware();
			when(Client.lerInput()).thenReturn(nameTask);
			when(Client.lerInput()).thenReturn(descTask);
			when(Client.lerInputInteiro()).thenReturn(deadlineTask);
		
		assertEquals(nameTask, newDemanda.getTitulo());
		assertEquals(descTask, newDemanda.getDescricao());
		assertEquals(deadlineTask, newDemanda.getPrazoEmDias());
	}

	@Test
	void testClientLoopException() throws Exception {
		provideInput("6");
		Client cliente = new Client();
		cliente.clientLoop();
		
		String output = getOutput();
		assertTrue(output.contains("Ola Cliente. O que deseja?"));
		assertTrue(output.contains("[1] Solicitar software\n[2] Consultar demanda\n[3] Entrar no chat\n[4] Voltar para menu"));
		assertTrue(output.contains("Error character Typed: 6\n"));
	}
}
