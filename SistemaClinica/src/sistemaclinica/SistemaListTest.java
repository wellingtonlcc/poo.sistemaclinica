package sistemaclinica;

import static org.junit.Assert.*;

import org.junit.Test;

public class SistemaListTest {

	@Test
	public void testaddPaciente() {
		SistemaList sistema = new SistemaList();
		Paciente p = new Paciente();
		try{
			sistema.addPaciente(p);
		}catch(PacienteCadastradoException e){
			fail("N�o deveria ter lan�ado excess�o");
		}
	}

}
