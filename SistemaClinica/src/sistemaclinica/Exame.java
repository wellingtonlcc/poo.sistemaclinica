
package sistemaclinica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exame {
   private List<Paciente> pacientes;
   private String tipoExame;
   private String diaSemana;
   private String periodo;
   private String dataExame;
   
   public Exame(){
       this.pacientes = new ArrayList<Paciente>();
   }
   public Exame(String tipoExame,String diaSemana,String periodo, String dataExame){
       this.tipoExame = tipoExame;
       this.diaSemana = diaSemana;
       this.periodo = periodo;
       this.dataExame = dataExame;
       this.pacientes = new ArrayList<Paciente>();
   }
   public Exame(String tipoExame,String diaSemana,String periodo){
       this.tipoExame = tipoExame;
       this.diaSemana = diaSemana;
       this.periodo = periodo;
       this.pacientes = new ArrayList<Paciente>();
   }
   public List<Paciente> getPaciente(){
       return pacientes;
   }
   public void adicionaPaciente(Paciente paci){
       this.pacientes.add(paci);
   }
   public String getTipoExame(){
       return tipoExame;
   }
   public String getSemana() {
       return diaSemana;
   }
   public void setSemana(String semana) {
       this.diaSemana = semana;
   }
   public String getPeriodo() {
	   return periodo;
   }
   public void setPeriodo(String periodo) {
	   this.periodo = periodo;
   }
   public String getDataExame() {
		return dataExame;
   }
   public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
   }
    
   public String toString(){
       return "Exame: "+this.tipoExame;
   }
   public String toImprimir(){
       return "Pacientes Agendados \n"+
               "Exames: "+this.tipoExame+"\n"+this.pacientes+"\n"+this.diaSemana+"\n"+this.periodo+"\n";
   }
   public String toNomes(){
	   String texto = "";
	   for(Paciente p: pacientes){
		   texto += p.getNome()+"\n";
	   }
	   return texto;
   }
   public String salvar(){
   	try{
   		FileWriter fw = new FileWriter("exame.txt",true);
   		PrintWriter pw = new PrintWriter(fw);
   		pw.println("Nome do Exame: "+this.tipoExame);
   		pw.flush();
   		pw.close();
   		fw.close();

   	}catch(IOException ex){
   		Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE,null,ex);
   	}
   	return "Cadastrado com sucesso";

   }

}
