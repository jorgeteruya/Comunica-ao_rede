import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	//Client TCP
	
	public static void main(String[] args) {
		
		byte[] data = null;
		
		try {
			
			Socket client = new Socket("127.0.0.1", 12345);
			
			//enviando
			OutputStream enviaAoServidor = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(enviaAoServidor);
			dos.write(65);
			
			//recebendo
			InputStream is = client.getInputStream();
			System.out.println("Recebendo do servidor: " + (char)is.read());
			
			client.close();
			
		}catch(Exception e){
			System.out.println("Erro: ");
			e.getStackTrace();
			e.getMessage();
			
		}
	}

}
