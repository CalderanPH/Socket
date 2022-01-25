import java.io.*;
import java.net.*;

public class ServerObject {

    private static Socket socket;
    private  static ServerSocket server;

    private static DataInputStream input;
    private static DataOutputStream exit;


    public static void main(String[] args) {
        try{
            server =  new ServerSocket(5555);
            socket = server.accept();

            input = new DataInputStream(socket.getInputStream());
            exit = new DataOutputStream(socket.getOutputStream());

            int valor = input.readInt();
            System.out.println(valor);

            boolean resultado;
            if (valor > 0)
                resultado = true;
            else
                resultado = false;

            exit.writeUTF(String.valueOf(resultado));
            socket.close();


        } catch (Exception e){
        }
    }
}
