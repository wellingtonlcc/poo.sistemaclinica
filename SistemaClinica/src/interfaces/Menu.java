package interfaces;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static CadOpcao opcao;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane.showConfirmDialog(null ,"Tem certeza que deseja sair?", "Saída",JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					repaint();
				}
			}
		});
		setBounds(100, 100, 524, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Menu.class.getResource("/imagens/medical.png")));
		label.setBounds(10, 69, 213, 273);
		contentPane.add(label);
		
		JLabel lblSistemaClnica = new JLabel("Sistema Cl\u00EDnica");
		lblSistemaClnica.setForeground(Color.BLUE);
		lblSistemaClnica.setFont(new Font("Eras Bold ITC", Font.PLAIN, 30));
		lblSistemaClnica.setBounds(135, 11, 245, 35);
		contentPane.add(lblSistemaClnica);
		
		JButton btnNewButton = new JButton("Cadastro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcao = new CadOpcao();
				opcao.setVisible(true);
				opcao.setLocationRelativeTo(null);
				
			}
		});
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnNewButton.setBounds(334, 134, 112, 27);
		contentPane.add(btnNewButton);
		
		JButton btnAgendar = new JButton("Agenda");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadAgendamento opagendamento = new CadAgendamento();
				opagendamento.setVisible(true);
				opagendamento.setLocationRelativeTo(null);
			}
		});
		btnAgendar.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnAgendar.setBounds(334, 186, 112, 27);
		contentPane.add(btnAgendar);
		
		JButton btnExibir = new JButton("About");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About sobre = new About();
				sobre.setVisible(true);
				sobre.setLocationRelativeTo(null);
			}
		});
		btnExibir.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnExibir.setBounds(350, 317, 82, 25);
		contentPane.add(btnExibir);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Menu.class.getResource("/imagens/logo.png")));
		label_1.setBounds(210, 142, 94, 84);
		contentPane.add(label_1);
	}
}
