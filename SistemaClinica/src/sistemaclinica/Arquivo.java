package sistemaclinica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

	public List<String> recuperaTextoDeArquivo(String nomeArquivo)throws IOException {    
		BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<String>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine(); // lê a próxima linha do arquivo
				if (texto != null){
                       textoLido.add(texto);
                }
			} while(texto != null); //vai ser null quando chegar no fim do arquivo
		} finally {
			if (leitor!=null){
				leitor.close(); //fecha o stream(fluxo) de leitura
			}
		}
		return textoLido;
	}
	public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo)throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
                        for (String s: texto){
                              gravador.write(s+"\n");
                        }
		} finally {
			if (gravador!=null){
				gravador.close(); //fecha o stream(fluxo) de escrita
			}
		}
	}
	public void gravaPaciente(List<Paciente> texto){
		List<String> lista = new ArrayList<String>();
		for(Paciente p:texto){
			lista.add(p.getNome());
			lista.add(p.getRg());
			lista.add(p.getTelefone());
			lista.add(p.getSexo());
			lista.add(p.getDataNascimento());
			lista.add(p.getEndereco().getRua());
			lista.add(p.getEndereco().getNumero());
			lista.add(p.getEndereco().getCidade());
			lista.add(p.getEndereco().getEstado());
		}
		try {
			gravaTextoEmArquivo(lista,"pacientes.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void gravaExame(List<Exame> texto){
		List<String> lista = new ArrayList<String>();
		for(Exame e:texto){
			lista.add(e.getTipoExame());
			lista.add(e.getSemana());
			lista.add(e.getPeriodo());
			lista.add(e.getDataExame());
		}
		try {
			gravaTextoEmArquivo(lista,"exames.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Paciente> recuperaPaciente(){
		List<Paciente> texto = new ArrayList<Paciente>();
		try {
			List<String> lista = recuperaTextoDeArquivo("pacientes.txt");
			for(int x=0;x<lista.size();x++){
				String nome = lista.get(x);
				x++;
				String rg = lista.get(x);
				x++;
				String telefone = lista.get(x);
				x++;
				String sexo = lista.get(x);
				x++;
				String dataNascimento = lista.get(x);
				x++;
				String rua = lista.get(x);
				x++;
				String numero = lista.get(x);
				x++;
				String cidade = lista.get(x);
				x++;
				String estado = lista.get(x);
				
				Endereco end = new Endereco(rua,numero,cidade,estado);
				Paciente p = new Paciente(nome,rg,telefone,sexo,dataNascimento,end);
				texto.add(p);
			}
			return texto;
		} catch (IOException e) {
			
		}
		return texto;
	}
	public List<Exame> recuperaExame(){
		List<Exame> texto = new ArrayList<Exame>();
		try {
			List<String> lista = recuperaTextoDeArquivo("exames.txt");
			for(int x=0;x<lista.size();x++){
				String tipo = lista.get(x);
				x++;
				String diaSemana = lista.get(x);
				x++;
				String periodo = lista.get(x);
				x++;
				String data = lista.get(x);
				
				Exame exa = new Exame(tipo,diaSemana,periodo,data);
				texto.add(exa);
			}
			return texto;
		} catch (IOException e) {
			
		}
		return texto;
	}
}
