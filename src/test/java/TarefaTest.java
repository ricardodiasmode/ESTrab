import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.junit.platform.runner.JUnitPlatform;
@SuppressWarnings({ "unused", "deprecation" })
class TarefaTest {

    public static final int NAO_INICIADA = 0;
	public static final int EM_PROGRESSO = 1;
	public static final int FINALIZADA = 2;

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    Tarefa task = new Tarefa();
	
    @Before
    public void init() {
        this.task.setTitulo("Tarefa Teste");
        this.task.setDescricao("Tarefa criada para testes");
        this.task.setDataDeCriacao(LocalDate.now());
        this.task.setPrazoEmDias(30);
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
	void testIniciaTarefa() {
        this.task.setSituacao(NAO_INICIADA);
		this.task.iniciaTarefa();

        assertEquals(EM_PROGRESSO, this.task.getSituacao());
	}

    @Test
	void testFinalizaTarefa() {
        this.task.setSituacao(EM_PROGRESSO);
		this.task.finalizaTarefa();

        assertEquals(FINALIZADA, this.task.getSituacao());
	}

    @Test
	void testIniciaTarefaIniciada() {
        this.task.setSituacao(EM_PROGRESSO);
		this.task.iniciaTarefa();

        assertEquals("Essa tarefa já foi iniciada\n", getOutput());
	}

    @Test
	void testIniciaTarefaFinalizada() {
        this.task.setSituacao(FINALIZADA);
		this.task.iniciaTarefa();

        assertEquals("Essa tarefa já foi finalizada\n", getOutput());
	}

    @Test
	void testFinalizaTarefaFinalizada() {
        this.task.setSituacao(FINALIZADA);
		this.task.iniciaTarefa();

        assertEquals("Essa tarefa já foi finalizada\n", getOutput());
	}
}
