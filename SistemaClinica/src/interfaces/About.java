package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class About extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public About() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDesenvolvedorDoProjeto = new JLabel("Desenvolvedor do Projeto");
		lblDesenvolvedorDoProjeto.setFont(new Font("Palatino Linotype", Font.BOLD, 19));
		lblDesenvolvedorDoProjeto.setBounds(154, 11, 235, 30);
		contentPane.add(lblDesenvolvedorDoProjeto);
		
		JLabel lblWellingtonDeLima = new JLabel("Wellington de Lima Soares ");
		lblWellingtonDeLima.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 18));
		lblWellingtonDeLima.setBounds(164, 39, 225, 22);
		contentPane.add(lblWellingtonDeLima);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(About.class.getResource("/imagens/Logo_ufpb.png")));
		label.setBounds(-30, 22, 197, 212);
		contentPane.add(label);
		
		JLabel lblProfessora = new JLabel("Professora:");
		lblProfessora.setFont(new Font("Palatino Linotype", Font.BOLD, 19));
		lblProfessora.setBounds(124, 72, 103, 30);
		contentPane.add(lblProfessora);
		
		JLabel lblAylaRebouas = new JLabel("Ayla D\u00E9bora Dantas de S. R.");
		lblAylaRebouas.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 16));
		lblAylaRebouas.setBounds(227, 76, 197, 22);
		contentPane.add(lblAylaRebouas);
		
		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setFont(new Font("Palatino Linotype", Font.BOLD, 19));
		lblTutor.setBounds(151, 109, 68, 30);
		contentPane.add(lblTutor);
		
		JLabel lblMichelFear = new JLabel("Michael Fear");
		lblMichelFear.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 16));
		lblMichelFear.setBounds(255, 113, 116, 22);
		contentPane.add(lblMichelFear);
		
		JLabel lblImagensReferentes = new JLabel("Imagens Retiradas:");
		lblImagensReferentes.setFont(new Font("Palatino Linotype", Font.BOLD, 19));
		lblImagensReferentes.setBounds(190, 162, 191, 30);
		contentPane.add(lblImagensReferentes);
		
		JLabel lblWwwclinnetcombr = new JLabel("www.clinnet.com.br");
		lblWwwclinnetcombr.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 16));
		lblWwwclinnetcombr.setBounds(212, 190, 149, 22);
		contentPane.add(lblWwwclinnetcombr);
		
		JLabel lblHttpsbrdepositphotoscom = new JLabel("https://br.depositphotos.com");
		lblHttpsbrdepositphotoscom.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 16));
		lblHttpsbrdepositphotoscom.setBounds(180, 212, 209, 22);
		contentPane.add(lblHttpsbrdepositphotoscom);
	}
}
