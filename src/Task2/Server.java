package Task2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Anna on 15.04.2017.
 */
public class Server extends Thread{
   static public ArrayList<InputStream> listInput = new ArrayList<InputStream>();
   static public ArrayList<OutputStream> listOut = new ArrayList<OutputStream>();
   static public ArrayList<InetAddress> listAdress = new ArrayList<InetAddress>();

   public InputStream inputStream;
   public OutputStream outputStream;
   public InetAddress inetAddress;
   public Server(Socket socket){
       try {
           inputStream = new DataInputStream(socket.getInputStream());
           outputStream = new DataOutputStream(socket.getOutputStream());
           inetAddress = socket.getInetAddress();
       } catch (IOException e) {
           //e.printStackTrace();
       }
   }
   @Override
    public void run(){
       while(true) {
           try {
               if ("Get List".equals(((DataInputStream) inputStream).readUTF())) {
                   ((DataOutputStream)outputStream).writeBoolean(true);
                   ((DataOutputStream)outputStream).writeInt(listAdress.size());
                   outputStream.flush();
                   int responseNumber = ((DataInputStream) inputStream).readInt();
                   String reponseText = ((DataInputStream) inputStream).readUTF();
                   listOut.get(responseNumber - 1).write(reponseText.getBytes("UTF-8"));
                   listOut.get(responseNumber - 1).flush();
                   System.out.println("Message: " + reponseText + "sent to client №" + responseNumber);
               }
               else {
                   ((DataOutputStream)outputStream).writeBoolean(false);
               }
           }
           catch (IOException ex){
               ex.printStackTrace();
           }
       }


   }
}
