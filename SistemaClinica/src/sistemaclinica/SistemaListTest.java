package sistemaclinica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaListTest {
	SistemaList sistema;
	@Before
	public void setUp() throws Exception{
		sistema = new SistemaList();
	}
	
	@Test
	public void testaddPaciente() {
		String rua = "Aldeia";
		String numero = "00";
		String cidade = "Marcação";
		String estado = "PB";
		
		String nome = "Wellington";
		String rg = "1234";
		String telefone = "(83)99399-9999";
		String sexo = "M";
		String dataNascimento = "03/03/1988";
		
		
		Endereco end = new Endereco(rua,numero,cidade,estado);
		Paciente p = new Paciente(nome,rg,telefone,sexo,dataNascimento,end);
		try{
			sistema.addPaciente(p);
		}catch(PacienteJaCadastradoException e){
			fail("Não deveria ter lançado excessão");
		}
	}
	public void testaddExame(){
		String exame = "RAIOX";
		String semana = "Segunda";
		String periodo = "Manhã";
		String data = "10/11/2017";
		
		Exame e = new Exame(exame,semana,periodo,data);
		
		try{
			sistema.addExame(e);
		}catch(ExameJaCadastradoException err){
			fail("Não deveria ter lançado excessão");
		}
	}
	

}
