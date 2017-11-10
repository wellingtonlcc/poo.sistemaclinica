package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CadCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PacienteCadastro cadastro = new PacienteCadastro();

	public CadCadastro() {
		setResizable(false);
		setTitle("Op\u00E7\u00E3o de Cadastro");
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
				cadastro.setVisible(true);
				cadastro.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		btnNewButton.setBounds(37, 68, 146, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadCadastro.class.getResource("/imagens/adicionar.png")));
		lblNewLabel.setBounds(58, 0, 132, 100);
		contentPane.add(lblNewLabel);
		
		JButton btnExame = new JButton("Exame");
		btnExame.setForeground(Color.BLUE);
		btnExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExameCadastro examecad = new ExameCadastro();
				examecad.setVisible(true);
				examecad.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnExame.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		btnExame.setBounds(252, 68, 146, 50);
		contentPane.add(btnExame);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadCadastro.class.getResource("/imagens/exames.png")));
		label.setBounds(217, 0, 199, 118);
		contentPane.add(label);
	}

}
