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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PesEstado extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Arquivo arq;
	private SistemaList sistema = new SistemaList();

	public PesEstado() {
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
		
		JComboBox<Object> CBEstado = new JComboBox<Object>();
		CBEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"---", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		CBEstado.setBounds(131, 41, 55, 20);
		contentPane.add(CBEstado);
		
		JLabel lblSelecioneOEstado = new JLabel("Selecione o Estado");
		lblSelecioneOEstado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelecioneOEstado.setBounds(86, 11, 160, 28);
		contentPane.add(lblSelecioneOEstado);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String estado = (String) CBEstado.getSelectedItem();
				List<Paciente> listap = new ArrayList<Paciente>();
				try{
					listap = sistema.pesquisaPacienteEstado(estado);
				}catch(PacienteNaoCadastradoException erro){
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
				estado = "";
				for(Paciente l:listap){
					estado += l.toString()+"\n********************************\n";
				}
				if(estado.length() > 0){
					JOptionPane.showMessageDialog(null, estado);
				}
				dispose();
			}
		});
		btnOk.setBounds(131, 73, 55, 20);
		contentPane.add(btnOk);
	}
}
