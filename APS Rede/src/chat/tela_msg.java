package chat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tela_msg {

	private JFrame frame;
	private JTextField textFieldMensagem;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_msg window = new tela_msg();
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
	public tela_msg() {
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
		
		textFieldMensagem = new JTextField();
		textFieldMensagem.setText("Digite sua mensagem");
		textFieldMensagem.setBounds(38, 178, 351, 28);
		frame.getContentPane().add(textFieldMensagem);
		textFieldMensagem.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSair.setBounds(48, 227, 89, 23);
		frame.getContentPane().add(btnSair);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(300, 227, 89, 23);
		frame.getContentPane().add(btnEnviar);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(38, 26, 351, 141);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSecretariaDoMeio = new JLabel("Secretaria do Meio Ambiente");
		lblSecretariaDoMeio.setBounds(151, 11, 143, 14);
		frame.getContentPane().add(lblSecretariaDoMeio);
	}
}
