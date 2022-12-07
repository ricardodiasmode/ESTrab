import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.After;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DesenvolvedorTest {
	
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

    @Ignore
	@Test
	void testCriarTarefaDaDemanda() throws Exception {
		final String nameTask = "First Task";
		final String descTask = "Creating My First Task";
		final String deadlineTask = "30";
		
		Desenvolvedor developer = new Desenvolvedor();

		// Realizar mock das entradas do usuário 
		developer.criarTarefaDaDemanda();
        when(Client.Digita()).thenReturn(nameTask);
        when(Client.Digita()).thenReturn(descTask);
        when(Client.Digita()).thenReturn(deadlineTask);
		
        // Verificar se a tarefa foi criada
		assertEquals(1, developer.getDemandas().size());
	}
	
	@Test
	void testDesenvolvedorLoopException() throws Exception {
		provideInput("7");
		Desenvolvedor dev = new Desenvolvedor();
		dev.desenvolvedorLoop();
		
		String output = getOutput();
		assertTrue(output.contains("Ola Desenvolvedor. O que deseja?"));
		assertTrue(output.contains("[1] Visualizar demanda\n[2] Criar tarefa da demanda\n[3] Entrar no chat\n[4] Voltar para menu"));
		assertTrue(output.contains("Error character Typed: 7\n"));
	}
}
