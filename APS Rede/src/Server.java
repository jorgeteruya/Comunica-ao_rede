import java.awt.im.InputContext;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//Servidor tcp
	
	public static void main(String[] args) throws IOException{
		
		ServerSocket servidor = new ServerSocket();
		
		//recebe dados
		Socket conexao = servidor.accept(); // espera a conexão ser estabelecida
		InputStream is = conexao.getInputStream(); //tudo o que é enviado do cliente
		System.out.println("Recebido do Cliente: " + (char) is.read());
		
		//Enviado
		OutputStream enviaAoCliente = conexao.getOutputStream();
		DataOutputStream dos = new DataOutputStream(enviaAoCliente);
		dos.write(66);//66 = letra 'B' em ascii (write int)
		dos.writeChars("teste"); //writeChars String 
		
		servidor.close();
		conexao.close();
		
		
	}

}
