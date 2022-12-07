import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class ClientTest {
	
	@Test
	void testSolicitarSoftware() throws Exception {
		final String nameTask = "First Task";
		final String descTask = "Creating My First Task";
		final String deadlineTask = "30";
		
		Client clientTest = new Client();
		Demanda	newDemanda = new Demanda();
		newDemanda = clientTest.solicitarSoftware();
		when(Client.Digita()).thenReturn(nameTask);
		when(Client.Digita()).thenReturn(descTask);
		when(Client.Digita()).thenReturn(deadlineTask);
		
		assertEquals(nameTask, newDemanda.getTitulo());
		assertEquals(descTask, newDemanda.getDescricao());
		assertEquals(deadlineTask, newDemanda.getPrazoEmDias());
	}

}
