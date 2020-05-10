package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	/*
	 * Classe responsavel por conectar a maquina ao servidor
	 * do chat.
	 * */
	tela_config_ip login = new tela_config_ip();

	private String host;
	private int porta;
	
	public static void main(String[] args) 
			throws UnknownHostException,	IOException {
		//IP e Porta para conecatr no servidor
		new Cliente("192.168.15.12", 5524).executa();
	}

	public Cliente(String host2, int porta2) {
		this.host = host2;
		this.porta = porta2;
	}

	public void executa() throws UnknownHostException, IOException {
		try(
				//objeto cliente para pegar o ip e porta do host inserido na main
				Socket cliente = new Socket(this.host, this.porta); 
				
				//Capta as teclas digitadas
				Scanner teclado = new Scanner(System.in);
				
				//objeto responsavel por mandar a mensagem
				PrintStream saida = new PrintStream(cliente.getOutputStream())) {
			
			//identifica a maquina, vou tentar mudar pra ficar automático
			System.out.println("Maquina 1 conectou ao servidor!");
			
		
			RecebedorDeMensagemDoServidor r = new RecebedorDeMensagemDoServidor(cliente.getInputStream());
			
			//para cada nova maquina cria uma nova thread dessa forma possibilidando varias maquina no mesmo chat
			new Thread(r).start();
	
			//laço para quebra de linha entre mensagens
			while (teclado.hasNextLine()) {
				saida.println(teclado.nextLine());
			}
		}
	}
}