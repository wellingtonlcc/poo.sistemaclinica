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
import sistemaclinica.PacienteNaoCadastradoException;
import sistemaclinica.SistemaList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class PesRg extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Arquivo arq;
	private SistemaList sistema = new SistemaList();
	private JTextField txtRG;

	public PesRg() {
		setResizable(false);
		
		arq = new Arquivo();
		List<Paciente> listaPa = new ArrayList<Paciente>();
		listaPa = arq.recuperaPaciente();
		for(Paciente e: listaPa){
			try{
				sistema.addPaciente(e);
			}catch(PacienteJaCadastradoException err){	
			}
		}
		setTitle("Pesquisa Por Estado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 131);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecioneOEstado = new JLabel("Digite o RG");
		lblSelecioneOEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelecioneOEstado.setBounds(111, 11, 110, 28);
		contentPane.add(lblSelecioneOEstado);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String rg = (txtRG.getText());
					JOptionPane.showMessageDialog(null,sistema.pesquisaPacienteRg(rg));
				}catch(PacienteNaoCadastradoException erro){
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
				dispose();
			}
		});
		btnOk.setBounds(131, 73, 55, 20);
		contentPane.add(btnOk);
		
		txtRG = new JTextField();
		txtRG.setBounds(93, 42, 128, 20);
		contentPane.add(txtRG);
		txtRG.setColumns(10);
	}
}
