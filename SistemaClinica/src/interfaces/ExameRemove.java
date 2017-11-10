package interfaces;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import sistemaclinica.Arquivo;
import sistemaclinica.Exame;
import sistemaclinica.ExameJaCadastradoException;
import sistemaclinica.ExameNaoCadastradoException;
import sistemaclinica.SistemaList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class ExameRemove extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtExame;
	
	private Arquivo arq;
	private SistemaList agendamento = new SistemaList();

	public ExameRemove() {
		setResizable(false);
		
		arq = new Arquivo();
		List<Exame> listaExa = new ArrayList<Exame>();
		listaExa = arq.recuperaExame();
		for(Exame e: listaExa){
			try{
				agendamento.addExame(e);
			}catch(ExameJaCadastradoException err){	
			}
		}
		setTitle("Remo\u00E7\u00E3o de Exame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtExame = new JTextField();
		txtExame.setColumns(10);
		txtExame.setBounds(105, 57, 205, 20);
		contentPane.add(txtExame);
		
		JLabel label = new JLabel("NOME DO EXAME");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(154, 32, 105, 14);
		contentPane.add(label);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(agendamento.getListaExame().size()==0){
						JOptionPane.showMessageDialog(null, "Nenhum Exame cadastrado");
					}
					String exameRemove = txtExame.getText().toUpperCase();
					agendamento.removeExame(exameRemove);
					arq.gravaExame(agendamento.getListaExame());
					JOptionPane.showMessageDialog(null, "Exame Removido");
					txtExame.setText("");
				}catch(ExameNaoCadastradoException erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
					txtExame.setText("");
				}
			}
		});
		btnOk.setBounds(154, 88, 89, 23);
		contentPane.add(btnOk);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ExameRemove.class.getResource("/imagens/logo.png")));
		label_1.setBounds(0, 32, 94, 68);
		contentPane.add(label_1);
	}
}
