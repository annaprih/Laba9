package Task2_2;

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
            Socket soket = new Socket("127.0.0.1", 5285);
            DataInputStream inputStream = new DataInputStream(soket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(soket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                int num = Integer.valueOf(reader.readLine());
                        outputStream.write(num);
                        outputStream.flush();
                        if (inputStream.readBoolean() == true) {
                            System.out.println("Вы угадали");
                        }
                        else {
                            System.out.println("Вы не угадали");
                        }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
