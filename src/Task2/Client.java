package Task2;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringJoiner;

import static Task2.Server.listAdress;
import static Task2.Server.listInput;
import static Task2.Server.listOut;

/**
 * Created by Anna on 20.04.2017.
 */
public class Client {

    public static void main(String[] args){
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            Socket soket = new Socket(inetAddress, 8030);
            DataInputStream inputStream = new DataInputStream(soket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(soket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while(true) {

                System.out.println("1 - Show new message");
                System.out.println("2 - Send message");
                switch (Integer.valueOf(reader.readLine())) {
                    case 1: {
                        byte[] message = new byte[255];
                        inputStream.read(message);
                        System.out.println(new String(message, "UTF-8"));
                        break;
                    }
                    case 2: {
                        String str = reader.readLine();
                        outputStream.writeUTF(str);
                        outputStream.flush();
                        if (inputStream.readBoolean()) {
                            int numberOfClient = inputStream.readInt();
                            System.out.println(numberOfClient);
                            int client = Integer.valueOf(reader.readLine());
                            outputStream.writeInt(client);
                            outputStream.flush();
                            str = reader.readLine();
                            outputStream.writeUTF(str);
                            outputStream.flush();
                        }
                        else {
                            System.out.println("Rewrite string");
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
