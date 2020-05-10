package chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
	
	/*
	 * Classe que criar um servidor de acordo com a porta disponivel
	 * */
	
	public static void main(String[] args) throws IOException {
		//porta para o servidor
		new Servidor(5524).executa();
		System.out.println("Servidor on ");
	}

	private int porta;
	private List<Socket> clientes;

	public Servidor(int porta) {
		this.porta = porta;
		this.clientes = new ArrayList<>();
	}
	

	//Metodo sobe um servidor para os cliente entrarem no mesmo chat
	public void executa() throws IOException  {
		try(ServerSocket servidor = new ServerSocket(this.porta)){
			System.out.println("Porta " + porta + " aberta");
	
			//fica aguardando um cliente se conectar
			while (true) {
				Socket cliente = servidor.accept();
				//pega o endereço da maquina
				System.out.println("Nova conexão com o cliente " + 
						cliente.getInetAddress().getHostAddress());
	
				//adiciona o cliente no array
				this.clientes.add(cliente);
	
				TratadorDeMensagemDoCliente tc = new TratadorDeMensagemDoCliente(cliente, this);
				new Thread(tc).start();
			}
		}catch (Exception e) {
			// Tratamento de exceçao
			System.out.println("Erro: Porta em uso");
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

	public void distribuiMensagem(Socket clienteQueEnviou, String msg) {
		for (Socket cliente : this.clientes) {
			if(!cliente.equals(clienteQueEnviou)){
				try {
					PrintStream ps = new PrintStream(cliente.getOutputStream());
					ps.println(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
