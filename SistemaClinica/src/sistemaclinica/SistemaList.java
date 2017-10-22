package sistemaclinica;

import java.util.ArrayList;
import java.util.List;

public class SistemaList {
    private List<Paciente> pacientes;
    private List<Exame> exames;
   
    
    public SistemaList(){
        this.pacientes = new ArrayList<Paciente>();
        this.exames = new ArrayList<Exame>();
    }
    public void addPaciente(Paciente paciente)throws PacienteCadastradoException{
    	
        for(Paciente p: this.pacientes){
        	if(p.equals(paciente)){
                throw new PacienteCadastradoException("Paciente Já cadastrado");
            }
        }
        this.pacientes.add(paciente);
    }
    public void addExame(Exame exame)throws ExameJaCadastradoException{
    	for(Exame e:this.exames){
    		if(e.getTipoExame().equals(exame.getTipoExame())){
    			throw new ExameJaCadastradoException("Exame já Cadastrado");
    		}
    	}
    	this.exames.add(exame);	
    }
    public void AgendarExame(String rg, String exameDisp)  throws PacienteNaoCadastradoException,ExameNaoCadastradoException{
    	boolean erro = true;
    	boolean erro2 = true;
    	for(Paciente p: this.pacientes){
           if(p.getRg().equals(rg)){
        	   erro = false;
               for(Exame e:this.exames){
                   if(e.getTipoExame().equals(exameDisp)){
                	   erro2 = false;
                	   e.adicionaPaciente(p);
                   }
               }
           }
       }
    	if(erro){
    		throw new PacienteNaoCadastradoException("Paciente não cadastrado");
    	}
    	if(erro2){
    		throw new ExameNaoCadastradoException("Exame não cadastrado");
    	}
    }
    public boolean pesquisaPaciente(String rg)throws PacienteNaoCadastradoException{
        for(Paciente p: this.pacientes){
            if(p.getRg().equals(rg)){
                return true;
            }
            else{
            	throw new PacienteNaoCadastradoException("Paciente não cadastrado");
            }
        }
        return false;
    }
    public List<Paciente> getListaPaciente(){
        return this.pacientes;
    }
    public List<Exame> getListaExame(){
        return this.exames;
    } 
}
