package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.ImageIcon;

import sistemaclinica.Arquivo;
import sistemaclinica.Endereco;
import sistemaclinica.Paciente;
import sistemaclinica.PacienteJaCadastradoException;
import sistemaclinica.SistemaList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PacienteCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtRg;
	private JTextField txtData;
	private JTextField txtRua;
	private JTextField txtTelefone;
	private JTextField txtN;
	private JTextField txtCidade;
	
	private Arquivo arq;
	private static SistemaList agendamento = new SistemaList();
	
	public PacienteCadastro() {	
		arq = new Arquivo();
		List<Paciente> listaPar = new ArrayList<Paciente>();
		listaPar = arq.recuperaPaciente();
		for(Paciente p: listaPar){
			try{
				agendamento.addPaciente(p);
			}catch(PacienteJaCadastradoException err){
			}
		}
		setResizable(false);
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 537, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDadosPaciente = new JLabel("Dados Paciente");
		lblDadosPaciente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDadosPaciente.setBounds(207, 0, 108, 25);
		contentPane.add(lblDadosPaciente);

		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(24, 42, 46, 14);
		contentPane.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(70, 36, 233, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRg.setBounds(24, 70, 26, 14);
		contentPane.add(lblRg);

		txtRg = new JTextField();
		txtRg.setBounds(70, 64, 94, 20);
		contentPane.add(txtRg);
		txtRg.setColumns(10);

		JLabel lblSexo = new JLabel("SEXO");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBounds(184, 67, 38, 14);
		contentPane.add(lblSexo);

		JLabel lblDataNasc = new JLabel("DATA NASC.");
		lblDataNasc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataNasc.setBounds(313, 36, 80, 14);
		contentPane.add(lblDataNasc);

		txtData = new JTextField();
		txtData.setBounds(403, 36, 86, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);

		JLabel lblTel = new JLabel("TEL");
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTel.setBounds(340, 67, 26, 14);
		contentPane.add(lblTel);

		JLabel lblRua = new JLabel("RUA");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRua.setBounds(24, 116, 36, 14);
		contentPane.add(lblRua);

		txtRua = new JTextField();
		txtRua.setBounds(70, 110, 233, 20);
		contentPane.add(txtRua);
		txtRua.setColumns(10);

		JLabel lblN = new JLabel("N\u00BA");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblN.setBounds(340, 113, 26, 14);
		contentPane.add(lblN);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(376, 65, 134, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		txtN = new JTextField();
		txtN.setBounds(376, 111, 35, 20);
		contentPane.add(txtN);
		txtN.setColumns(10);

		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstado.setBounds(310, 149, 56, 14);
		contentPane.add(lblEstado);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(70, 143, 233, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		JComboBox<Object> CBEstado = new JComboBox<Object>();
		CBEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		CBEstado.setBounds(364, 142, 48, 25);
		contentPane.add(CBEstado);
		
		JComboBox<Object> CBSexo = new JComboBox<Object>();
		CBSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CBSexo.setModel(new DefaultComboBoxModel<Object>(new String[] {"", "FEMININO", "MASCULINO"}));
		CBSexo.setBounds(232, 61, 71, 25);
		contentPane.add(CBSexo);
		
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String estado = (String) CBEstado.getSelectedItem();
				String sexo = (String) CBSexo.getSelectedItem();
				
				Endereco end = new Endereco();
				end.setRua(txtRua.getText().toUpperCase());
				end.setNumero(txtN.getText().toUpperCase());
				end.setEstado(estado);
				end.setCidade(txtCidade.getText().toUpperCase());

				Paciente p = new Paciente();
				p.setNome(txtNome.getText().toUpperCase());
				p.setRg(txtRg.getText().toUpperCase());
				p.setDataNascimento(txtData.getText().toUpperCase());
				p.setTelefone(txtTelefone.getText().toUpperCase());
				p.setSexo(sexo);
				p.setEndereco(end);

				try {
					agendamento.addPaciente(p);
					arq.gravaPaciente(agendamento.getListaPaciente());
					JOptionPane.showMessageDialog(null, "Paciente cadastrado");
					
				} catch (PacienteJaCadastradoException err) {
					JOptionPane.showMessageDialog(null, err.getMessage());
				}

				txtNome.setText("");
				txtRg.setText("");
				txtData.setText("");
				txtTelefone.setText("");
				txtRua.setText("");
				txtN.setText("");
				txtCidade.setText("");
				CBEstado.setSelectedIndex(0);
				CBSexo.setSelectedIndex(0);
				dispose();
			}
		});
		btnCadastrar.setBounds(422, 136, 106, 34);
		contentPane.add(btnCadastrar);

		JLabel lblcidade = new JLabel("Cidade");
		lblcidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblcidade.setBounds(24, 148, 46, 14);
		contentPane.add(lblcidade);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PacienteCadastro.class.getResource("/imagens/logo.png")));
		label.setBounds(209, 174, 94, 68);
		contentPane.add(label);
		
		
		
		
	}
}
