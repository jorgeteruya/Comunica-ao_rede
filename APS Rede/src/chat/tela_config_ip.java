package chat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class tela_config_ip {

	private JFrame frame;
	private JTextField textFieldIPhost;
	private JTextField textFieldPorta;
	private JTextField textFieldNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_config_ip window = new tela_config_ip();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tela_config_ip() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIpHost = new JLabel("IP host:");
		lblIpHost.setBounds(49, 60, 46, 14);
		frame.getContentPane().add(lblIpHost);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(49, 97, 46, 14);
		frame.getContentPane().add(lblPorta);
		
		textFieldIPhost = new JTextField();
		textFieldIPhost.setBounds(136, 57, 131, 20);
		frame.getContentPane().add(textFieldIPhost);
		textFieldIPhost.setColumns(10);
		
		textFieldPorta = new JTextField();
		textFieldPorta.setColumns(10);
		textFieldPorta.setBounds(136, 94, 131, 20);
		frame.getContentPane().add(textFieldPorta);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(49, 137, 46, 14);
		frame.getContentPane().add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(136, 134, 131, 20);
		frame.getContentPane().add(textFieldNome);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(161, 193, 89, 23);
		frame.getContentPane().add(btnEntrar);
		
		JPanel panel = new JPanel();
		panel.setBounds(291, 50, 133, 166);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel image = new JLabel("New label");
		image.setIcon(new ImageIcon(tela_config_ip.class.getResource("/meio_ambientep.png")));
		image.setBounds(10, 11, 113, 144);
		panel.add(image);
	}
}
