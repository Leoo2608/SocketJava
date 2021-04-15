import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	private Socket socket=null;
    private ServerSocket server=null;
    private DataInputStream in=null;
    public Server(int port) throws IOException{
        server=new ServerSocket(port);
        System.out.println("Server Iniciado...");
        socket=server.accept();
        System.out.println("Cliente Aceptado..");
        in=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String line="";
        while(!line.equals("s")){
            try {
                line=in.readUTF();
                System.out.println(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }
        System.out.println("Cerrando la conexi�n");
        socket.close();
        in.close();
    }
    public static void main(String[] args) throws IOException {
        Server server=new Server(5050);
    }
}
