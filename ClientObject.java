import org.w3c.dom.ls.LSOutput;

import java.net.*;
import java.io.*;

public class ClientObject {

    private static Socket socket;
    private static DataInputStream input;
    private static DataOutputStream exit;


    public static void main(String[] args) {

        try {
            socket = new Socket("127.0.0.1", 5555);

            input = new DataInputStream(socket.getInputStream());
            exit = new DataOutputStream(socket.getOutputStream());

            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite seu CPF: ");
            int valor = Integer.parseInt(buf.readLine());

            exit.writeInt(valor);

            String resultado = input.readUTF();

            System.out.println(resultado);

            socket.close();
        }catch (Exception e){

        }

    }
}
