import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
