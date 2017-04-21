package Task3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.function.DoubleToIntFunction;

/**
 * Created by Anna on 21.04.2017.
 */
public class ServerUDP {
    public static void main(String[] args) {
        try {
            String str = "Привет";
            DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 7888);
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.send(datagramPacket);
            datagramSocket.close();
        }
        catch (Exception ex){
            ex.getMessage();
        }
    }
}
