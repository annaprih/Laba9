package Task3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Anna on 21.04.2017.
 */
public class ClientUDP {
    public static void main(String[] args) {
        try{
            DatagramSocket datagramSocket = new DatagramSocket(7888);
            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(new byte[1000], 1000);
                datagramSocket.receive(datagramPacket);
                System.out.println(new String(datagramPacket.getData()));
            }
        }
        catch (Exception ex){
            ex.getMessage();
        }
    }
    }

