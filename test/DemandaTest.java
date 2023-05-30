import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DemandaTest {

    public static final int NAO_INICIADA = 0;
	public static final int EM_PROGRESSO = 1;
	public static final int FINALIZADA = 2;

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    Demanda demanda = new Demanda();
	
    @Before
    public void init() {
        this.demanda.setTitulo("Demanda Teste");
        this.demanda.setDescricao("Demanda criada para testes");
        this.demanda.setDataDeCriacao(LocalDate.now());
        this.demanda.setPrazoEmDias(30);
    }

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
	void testIniciaDemanda() {
        this.demanda.setSituacao(NAO_INICIADA);
		this.demanda.iniciaDemanda();

        assertEquals(EM_PROGRESSO, this.demanda.getSituacao());
	}

    @Test
	void testFinalizaDemanda() {
        this.demanda.setSituacao(EM_PROGRESSO);
		this.demanda.finalizaDemanda();

        assertEquals(FINALIZADA, this.demanda.getSituacao());
	}

    @Test
	void testIniciaDemandaIniciada() {
        this.demanda.setSituacao(EM_PROGRESSO);
		this.demanda.iniciaDemanda();

        assertEquals("Essa demanda já foi iniciada\n", getOutput());
	}

    @Test
	void testIniciaDemandaFinalizada() {
        this.demanda.setSituacao(FINALIZADA);
		this.demanda.iniciaDemanda();

        assertEquals("Essa demanda já foi finalizada\n", getOutput());
	}

    @Test
	void testFinalizaDemandaFinalizada() {
        this.demanda.setSituacao(FINALIZADA);
		this.demanda.iniciaDemanda();

        assertEquals("Essa demanda já foi finalizada\n", getOutput());
	}
}
