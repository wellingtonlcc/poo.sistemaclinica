

package sistemaclinica;

public class Paciente {
    private String nome;
    private String rg;
    private String sexo;
    private String dataNascimento;
    private String telefone;
    private Endereco endereco;
    
    public Paciente(){
        this.nome = "Sem Nome";
        this.rg = "Não Informado";
        this.sexo = "Não definido";
        this.telefone = "Sem telefone";
        this.dataNascimento = "00/00/0000";
        this.endereco = new Endereco();
    }
    public Paciente(String nome, String rg, String telefone,String sexo, String dataNascimento, Endereco endereco){
        this.nome = nome;
        this.rg = rg;
        this.sexo = sexo;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getSexo() {
        return sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
   
    public String toString(){

    	return "Nome: "+this.nome+"\n"+
    			" RG: "+this.rg+"\n"+" Sexo: "+this.sexo+"\n"+
    			" Data nascimento: "+this.dataNascimento+
    			" Telefone: "+this.telefone+"\n"+
    			" Endereço: "+this.endereco.toString();
    }
    @Override
    public boolean equals(Object obj) {
    	if(obj==null) {
    		return false;
    	}else {
    		if(obj instanceof Paciente) {
    			Paciente p = (Paciente) obj;
    			if(p.getRg().equals(this.rg)) {
    				return true;
    			}else {
    				return false;
    			}
    		}else {
    			return false;
    		}
    	}
    	
    }
}
