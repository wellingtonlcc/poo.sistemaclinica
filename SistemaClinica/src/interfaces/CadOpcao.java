package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadOpcao extends JFrame {

	private JPanel contentPane;
	private static PacienteCadastro cadastro = new PacienteCadastro();

	public CadOpcao() {
		setTitle("OP\u00C7\u00C3O");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Paciente");
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
		lblNewLabel.setIcon(new ImageIcon(CadOpcao.class.getResource("/imagens/adicionar.png")));
		lblNewLabel.setBounds(58, 0, 132, 100);
		contentPane.add(lblNewLabel);
		
		JButton btnExame = new JButton("Exame");
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
		label.setIcon(new ImageIcon(CadOpcao.class.getResource("/imagens/exames.png")));
		label.setBounds(217, 0, 199, 118);
		contentPane.add(label);
	}

}
