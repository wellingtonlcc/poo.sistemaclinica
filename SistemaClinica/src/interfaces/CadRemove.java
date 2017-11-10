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

public class CadRemove extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public CadRemove() {
		setResizable(false);
		setTitle("OP\u00C7\u00C3O REMO\u00C7\u00C3O");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 442, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Paciente");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PacienteRemove remove = new PacienteRemove();
				remove.setVisible(true);
				remove.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		btnNewButton.setBounds(37, 68, 146, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(CadRemove.class.getResource("/imagens/remover.png")));
		lblNewLabel.setBounds(58, 0, 132, 100);
		contentPane.add(lblNewLabel);
		
		JButton btnExame = new JButton("Exame");
		btnExame.setForeground(Color.RED);
		btnExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExameRemove remove = new ExameRemove();
				remove.setVisible(true);
				remove.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnExame.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		btnExame.setBounds(252, 68, 146, 50);
		contentPane.add(btnExame);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CadRemove.class.getResource("/imagens/exames.png")));
		label.setBounds(217, 0, 199, 118);
		contentPane.add(label);
	}

}
