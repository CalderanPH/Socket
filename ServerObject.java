import java.io.*;
import java.net.*;

public class ServerObject {

    private static Socket socket;
    private  static ServerSocket server;

    private static DataInputStream input;
    private static DataOutputStream out;


    public static void main(String[] args) {
        try{
            server =  new ServerSocket(5555);
            socket = server.accept();

            input = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            int value = input.readInt();
            System.out.println(value);

            boolean result;
            if (value > 0)
                result = true;
            else
                result = false;

            out.writeUTF(String.valueOf(result));
            socket.close();


        } catch (Exception e){
        }
    }
}
