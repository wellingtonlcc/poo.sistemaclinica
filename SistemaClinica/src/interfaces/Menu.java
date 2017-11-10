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
import java.awt.Toolkit;


public class Menu extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static CadCadastro opcao;
	
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagens/logo.png")));
		setResizable(false);
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
		
		JButton btnCd = new JButton("Cadastrar");
		btnCd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opcao = new CadCadastro();
				opcao.setVisible(true);
				opcao.setLocationRelativeTo(null);
				
			}
		});
		btnCd.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnCd.setBounds(334, 101, 122, 27);
		contentPane.add(btnCd);
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadAgendamento agendamento = new CadAgendamento();
				agendamento.setVisible(true);
				agendamento.setLocationRelativeTo(null);
			}
		});
		btnAgendar.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnAgendar.setBounds(334, 215, 122, 27);
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
		btnExibir.setBounds(224, 328, 80, 25);
		contentPane.add(btnExibir);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Menu.class.getResource("/imagens/logo.png")));
		label_1.setBounds(210, 142, 94, 84);
		contentPane.add(label_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadPesquisa janelaPesquisa = new CadPesquisa();
				janelaPesquisa.setVisible(true);
				janelaPesquisa.setLocationRelativeTo(null);
				
			}
		});
		btnPesquisar.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnPesquisar.setBounds(334, 177, 122, 27);
		contentPane.add(btnPesquisar);
		
		JButton btnR = new JButton("Remover");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadRemove janelaRemover = new CadRemove();
				janelaRemover.setVisible(true);
				janelaRemover.setLocationRelativeTo(null);
			}
		});
		btnR.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnR.setBounds(334, 139, 122, 27);
		contentPane.add(btnR);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadListar janelaListar = new CadListar();
				janelaListar.setVisible(true);
				janelaListar.setLocationRelativeTo(null);
			}
		});
		btnListar.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnListar.setBounds(334, 253, 122, 27);
		contentPane.add(btnListar);
	}
}
