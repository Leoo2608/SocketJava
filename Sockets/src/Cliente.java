import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
public class Cliente {
	private Socket socket=null;
    private DataInputStream input=null;
    private DataOutputStream out=null;
    public Cliente(String address,int port) {
        try {
            socket=new Socket(address,port);
            System.out.println("Conectado...");
            input=new DataInputStream(System.in);
            out=new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            // TODO: handle exception
            System.out.println(u);
        }catch (IOException i) {
            // TODO: handle exception
            System.out.println(i);
        }
        String line="";
        while(!line.equals("s")){
            try {
                line=input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                // TODO: handle exception
                System.out.println(i);
            }
        }
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            // TODO: handle exception
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Cliente cliente=new Cliente("127.0.0.1",5050);
    }
}
