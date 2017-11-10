package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;




import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

import javax.swing.ImageIcon;

import sistemaclinica.Arquivo;
import sistemaclinica.Paciente;
import sistemaclinica.PacienteJaCadastradoException;
import sistemaclinica.PacienteNaoCadastradoException;
import sistemaclinica.SistemaList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PacienteRemove extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRg;
	
	private Arquivo arq;
	private static SistemaList sistema = new SistemaList();
	
	public PacienteRemove() {
		setResizable(false);	
		arq = new Arquivo();
		List<Paciente> listaPar = new ArrayList<Paciente>();
		listaPar = arq.recuperaPaciente();
		for(Paciente p: listaPar){
			try{
				sistema.addPaciente(p);
			}catch(PacienteJaCadastradoException err){
			}
		}
		setTitle("Remo\u00E7\u00E3o de Paciente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 405, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRg = new JLabel("Digite o RG");
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRg.setBounds(159, 26, 94, 20);
		contentPane.add(lblRg);

		txtRg = new JTextField();
		txtRg.setBounds(146, 57, 121, 20);
		contentPane.add(txtRg);
		txtRg.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PacienteRemove.class.getResource("/imagens/logo.png")));
		label.setBounds(10, 28, 94, 68);
		contentPane.add(label);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(sistema.getListaPaciente().size()==0){
						JOptionPane.showMessageDialog(null, "Nenhum paciente cadastrado");
					}
					String rgRemove = txtRg.getText();
					sistema.removePaciente(rgRemove);
					arq.gravaPaciente(sistema.getListaPaciente());
					JOptionPane.showMessageDialog(null, "Paciente removido");
					txtRg.setText("");
				}catch(PacienteNaoCadastradoException erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
					txtRg.setText("");
				}
			}
		});
		btnOk.setBounds(164, 88, 89, 23);
		contentPane.add(btnOk);
		
		
		
		
	}
}
