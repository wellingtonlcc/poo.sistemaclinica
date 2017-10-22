package interfaces;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import sistemaclinica.Arquivo;
import sistemaclinica.Exame;
import sistemaclinica.ExameJaCadastradoException;
import sistemaclinica.ExameNaoCadastradoException;
import sistemaclinica.Paciente;
import sistemaclinica.PacienteCadastradoException;
import sistemaclinica.PacienteNaoCadastradoException;
import sistemaclinica.SistemaList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


public class CadAgendamento extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private Arquivo arq;
	private static SistemaList agenda = new SistemaList();

	public CadAgendamento() {
		
		arq = new Arquivo();
		List<Exame> listaExa = new ArrayList<Exame>();
		listaExa = arq.recuperaExame();
		for(Exame e: listaExa){
			try{
				agenda.addExame(e);
			}catch(ExameJaCadastradoException err){	
			}
		}
		
		List<Paciente> listaPar = new ArrayList<Paciente>();
		listaPar = arq.recuperaPaciente();
		for(Paciente p: listaPar){
			try{
				agenda.addPaciente(p);
			}catch(PacienteCadastradoException err){
			}
		}
		
		setTitle("Agenda de Exames");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try{
					String titulos = "";
					for(Exame e: agenda.getListaExame()){
						titulos += e.getTipoExame()+"\n";
					}
					String titulo = JOptionPane.showInputDialog("              Exames Disponiveis: \n"+titulos+"\n");
					titulo = titulo.toUpperCase();
					String rg = JOptionPane.showInputDialog("Rg do Paciente ");
					rg = rg.toUpperCase();
					agenda.AgendarExame(rg, titulo);
					JOptionPane.showMessageDialog(null,"Agendamento realizado");
				}catch(PacienteNaoCadastradoException e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}catch(ExameNaoCadastradoException e){
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		btnAgendar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		btnAgendar.setBounds(29, 68, 146, 50);
		contentPane.add(btnAgendar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				String titulos = "";
				for(Exame e: agenda.getListaExame()){
					titulos += e.getTipoExame()+"\n";
				}
				if(agenda.getListaExame().size()>0){
					String titulo = JOptionPane.showInputDialog("             Digite o exame: \n"+titulos+"\n").toUpperCase();
					for(Exame e: agenda.getListaExame()){
						if(e.getTipoExame().equals(titulo)){
							JOptionPane.showMessageDialog(null,e.getSemana()+" ++ "+e.getPeriodo()+" \n"+e.getDataExame()+"\n"+e.toNomes(),"+  "+e.getTipoExame()+"  +",1);
						}
					}	
				}else{
					JOptionPane.showMessageDialog(null, "Agenda está vazia");
				}
					
				
				
			}
		});
		btnListar.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		btnListar.setBounds(244, 68, 146, 50);
		contentPane.add(btnListar);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CadAgendamento.class.getResource("/imagens/listar.png")));
		label_1.setBounds(250, 0, 122, 118);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.GREEN);
		label.setBackground(Color.BLACK);
		label.setEnabled(false);
		label.setIcon(new ImageIcon(CadAgendamento.class.getResource("/imagens/agendamento.png")));
		label.setBounds(41, 0, 146, 86);
		contentPane.add(label);
	}
}
