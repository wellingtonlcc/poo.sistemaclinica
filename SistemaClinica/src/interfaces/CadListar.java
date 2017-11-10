package interfaces;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import sistemaclinica.Arquivo;
import sistemaclinica.Exame;
import sistemaclinica.ExameJaCadastradoException;
import sistemaclinica.Paciente;
import sistemaclinica.PacienteJaCadastradoException;
import sistemaclinica.SistemaList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CadListar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Arquivo arq;
	private SistemaList sistema = new SistemaList();
	
	public CadListar() {
		arq = new Arquivo();
		List<Paciente> l = new ArrayList<Paciente>();
		l = arq.recuperaPaciente();
		for(Paciente e: l){
			try{
				sistema.addPaciente(e);
			}catch(PacienteJaCadastradoException err){	
			}
		}
		List<Exame> listaExa = new ArrayList<Exame>();
		listaExa = arq.recuperaExame();
		for(Exame e: listaExa){
			try{
				sistema.addExame(e);
			}catch(ExameJaCadastradoException err){	
			}
		}
		
		setResizable(false);
		setTitle("Op\u00E7\u00E3o de Listar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Paciente");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> cadastrados = new ArrayList<String>();
				if(sistema.getListaPaciente().size()== 0){
					JOptionPane.showMessageDialog(null,"Sem Pacientes");
				}else{
					for(Paciente p: sistema.getListaPaciente()){
						cadastrados.add(p.toString()+"\n++++++++++++++++++++++++++++\n");
					}
					Collections.sort(cadastrados);
					for(String l:cadastrados){
						JOptionPane.showMessageDialog(null,l);
					}
				}
			}
			
		});
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		btnNewButton.setBounds(24, 41, 139, 50);
		contentPane.add(btnNewButton);
		
		JButton btnExame = new JButton("Exame");
		btnExame.setForeground(Color.BLUE);
		btnExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> cadastrados = new ArrayList<String>();
				if(sistema.getListaExame().size()== 0){
					JOptionPane.showMessageDialog(null,"Sem Exames");
				}else{
					for(Exame e: sistema.getListaExame()){
						cadastrados.add(e.toString()+"\n++++++++++++++++++++++++++++\n");
					}
					Collections.sort(cadastrados);
					for(String l:cadastrados){
						JOptionPane.showMessageDialog(null,l);
					}
				}
			}
		});
		btnExame.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		btnExame.setBounds(268, 41, 139, 50);
		contentPane.add(btnExame);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadListar.class.getResource("/imagens/13230.png")));
		label.setBounds(173, 28, 85, 85);
		contentPane.add(label);
	}
}
