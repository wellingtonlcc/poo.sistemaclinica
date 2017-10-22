package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import sistemaclinica.Arquivo;
import sistemaclinica.Exame;
import sistemaclinica.ExameJaCadastradoException;
import sistemaclinica.SistemaList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ExameCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtExame;
	
	private Arquivo arq;
	private SistemaList agendamento = new SistemaList();
	private static Menu menu = new Menu();
	private JTextField txtData;

	public ExameCadastro() {
		
		arq = new Arquivo();
		List<Exame> listaExa = new ArrayList<Exame>();
		listaExa = arq.recuperaExame();
		for(Exame e: listaExa){
			try{
				agendamento.addExame(e);
			}catch(ExameJaCadastradoException err){	
			}
		}
		
		
		setTitle("Exame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExamesACadastrar = new JLabel("Exames a Cadastrar");
		lblExamesACadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExamesACadastrar.setBounds(139, 11, 137, 25);
		contentPane.add(lblExamesACadastrar);
		
		JLabel lblNomeDoExame = new JLabel("Dia da Semana");
		lblNomeDoExame.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomeDoExame.setBounds(38, 83, 105, 14);
		contentPane.add(lblNomeDoExame);
		
		txtExame = new JTextField();
		txtExame.setColumns(10);
		txtExame.setBounds(120, 47, 233, 20);
		contentPane.add(txtExame);
		
		JLabel lblPerodoDisponvel = new JLabel("Per\u00EDodo Dispon\u00EDvel");
		lblPerodoDisponvel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPerodoDisponvel.setBounds(246, 78, 137, 25);
		contentPane.add(lblPerodoDisponvel);
		
		JComboBox CBPeriodo = new JComboBox();
		CBPeriodo.setModel(new DefaultComboBoxModel(new String[] {"<Selecione>", "Manh\u00E3", "Tarde"}));
		CBPeriodo.setBounds(256, 99, 105, 20);
		contentPane.add(CBPeriodo);
		
		JComboBox CBSemana = new JComboBox();
		CBSemana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel label = new JLabel("NOME DO EXAME");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(10, 49, 105, 14);
		contentPane.add(label);
		
		JLabel lblDataDoExame = new JLabel("Data do Exame");
		lblDataDoExame.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataDoExame.setBounds(159, 130, 105, 14);
		contentPane.add(lblDataDoExame);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(139, 154, 137, 20);
		contentPane.add(txtData);
		
		
		CBSemana.setModel(new DefaultComboBoxModel(new String[] {"<Selecione>", "Segunda", "Ter\u00E7a", "Quarta", "Quinta", "Sexta"}));
		CBSemana.setBounds(38, 99, 105, 20);
		contentPane.add(CBSemana);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String semana = (String) CBSemana.getSelectedItem();
				String periodo = (String) CBPeriodo.getSelectedItem();

				Exame exam = new Exame(txtExame.getText().toUpperCase(),semana,periodo,txtData.getText());
				try {
					agendamento.addExame(exam);
					arq.gravaExame(agendamento.getListaExame());
					JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
				} catch (ExameJaCadastradoException err) {
					JOptionPane.showMessageDialog(null,err.getMessage());
				}
				txtExame.setText("");
				txtData.setText("");
				
				dispose();
			}
		});
		btnOk.setBounds(170, 185, 89, 23);
		contentPane.add(btnOk);
		
		
		
		
		
		
	
	}
}
