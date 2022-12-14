import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	
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
	void testDigita() throws Exception {
		String input = "Teste Digitação";
		
		provideInput(input);

		assertEquals(input, User.Digita());
	}
	
	@Test
	void testDigitaInt() throws Exception {
		String input = "9";

		provideInput(input);

		assertEquals(9, User.DigitaInt());
	}

	@Test
	void testPrintarDemandas() throws Exception {
		User usuario = new User();
		Demanda demandaEx = new Demanda();
		String titulo = "Titulo Demanda";
		
		demandaEx.setTitulo(titulo);
		usuario.setDemandas(demandaEx);
		
		usuario.printarDemandas();
		
		assertEquals("[0] "+titulo+"\n", getOutput());
	}
	
	@Test
	void testUserLoopException() throws Exception {
		provideInput("9");
		User.userLoop();
		
		String output = getOutput();
		assertTrue(output.contains("Quem eh voce?\n[1] Cliente\n[2] Avaliador\n[3] Desenvolvedor"));
		assertTrue(output.contains("Error character Typed: 9\n"));
	}
}
