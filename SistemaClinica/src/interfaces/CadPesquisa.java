package interfaces;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import sistemaclinica.Arquivo;
import sistemaclinica.Paciente;
import sistemaclinica.PacienteJaCadastradoException;

import sistemaclinica.SistemaList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import java.awt.Color;


public class CadPesquisa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Arquivo arq;
	private SistemaList sistema = new SistemaList();
	
	public CadPesquisa() {
		setResizable(false);
		
		arq = new Arquivo();
		List<Paciente> l = new ArrayList<Paciente>();
		l = arq.recuperaPaciente();
		for(Paciente e: l){
			try{
				sistema.addPaciente(e);
			}catch(PacienteJaCadastradoException err){	
			}
		}
		
		
		setTitle("OP\u00C7\u00C3O DA PESQUISA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Estado");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PesEstado janelaEstado = new PesEstado();
				janelaEstado.setVisible(true);
				janelaEstado.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 19));
		btnNewButton.setBounds(262, 43, 105, 53);
		contentPane.add(btnNewButton);
		
		JButton btnPacientePorEstado = new JButton("RG");
		btnPacientePorEstado.setForeground(Color.BLUE);
		btnPacientePorEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesRg janelaRG = new PesRg();
				janelaRG.setVisible(true);
				janelaRG.setLocationRelativeTo(null);
			}
		});
		btnPacientePorEstado.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 19));
		btnPacientePorEstado.setBounds(134, 43, 104, 53);
		contentPane.add(btnPacientePorEstado);
		
		JLabel label = new JLabel("");
		label.setEnabled(false);
		label.setIcon(new ImageIcon(CadPesquisa.class.getResource("/imagens/pesquisa.png")));
		label.setBounds(-1, 0, 125, 120);
		contentPane.add(label);
	}
}
