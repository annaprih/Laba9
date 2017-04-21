package Task2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static Task2.Server.listAdress;
import static Task2.Server.listInput;
import static Task2.Server.listOut;

/**
 * Created by Anna on 15.04.2017.
 */
public class SeverMain {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8030);
            while(true) {
                Socket client = serverSocket.accept();
                listInput.add(client.getInputStream());
                listOut.add(client.getOutputStream());
                listAdress.add(client.getInetAddress());
                System.out.println("Client is connected");
                Server server = new Server(client);
                server.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
