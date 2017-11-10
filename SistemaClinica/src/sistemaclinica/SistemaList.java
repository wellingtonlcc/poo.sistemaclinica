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
    
    public void addPaciente(Paciente paciente)throws PacienteJaCadastradoException{
    	
        for(Paciente p: this.pacientes){
        	if(p.equals(paciente)){
                throw new PacienteJaCadastradoException("Paciente Já cadastrado");
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
    
    
    public void removePaciente(String rg)throws PacienteNaoCadastradoException{
		boolean erro = true;
    	for(Paciente part: this.pacientes){
			if(part.getRg().equals(rg)){
				this.pacientes.remove(part);
				erro = false;
				break;
			}
    	}
		if(erro){
			throw new PacienteNaoCadastradoException ("Paciente Não Cadastrado");
		}
	}
    public void removeExame(String exame)throws ExameNaoCadastradoException{
		boolean erro = true;
    	for(Exame e: this.exames){
			if(e.getTipoExame().equals(exame)){
				this.exames.remove(e);
				erro = false;
				break;
			}
    	}
		if(erro){
			throw new ExameNaoCadastradoException ("Exame Não Cadastrado");
		}
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
    
    
    
    public List<Paciente> pesquisaPacienteRg(String rg)throws PacienteNaoCadastradoException {
		ArrayList<Paciente> resultado = new ArrayList<Paciente>();
		for(Paciente p: this.pacientes){
			if(p.getRg().equals(rg)){
				resultado.add(p);
			}
		}
		if(resultado.size()==0){
			throw new PacienteNaoCadastradoException ("Não existe Paciente com esse RG");
		}else{
			return resultado;
		}
	}
    
    
    
    public List<Paciente> pesquisaPacienteEstado(String estado)throws PacienteNaoCadastradoException {
		ArrayList<Paciente> resultado = new ArrayList<Paciente>();
		for(Paciente p: this.pacientes){
			if(p.getEndereco().getEstado().equals(estado)){
				resultado.add(p);
			}
		}
		if(resultado.size()==0){
			throw new PacienteNaoCadastradoException ("Não existe Paciente nesse Estado");
		}else{
			return resultado;
		}
	}
    
    
    
    public List<Paciente> getListaPaciente(){
        return this.pacientes;
    }
    
    
    
    public List<Exame> getListaExame(){
        return this.exames;
    } 
}
