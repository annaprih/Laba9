package Task2_2;

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

   public InputStream inputStream;
   public OutputStream outputStream;
   public Server(Socket socket){
       try {
           inputStream = new DataInputStream(socket.getInputStream());
           outputStream = new DataOutputStream(socket.getOutputStream());
       } catch (IOException e) {

       }
   }
   @Override
    public void run(){
       while(true) {
           try {
               int a = inputStream.read();
               if(a == SeverMain.number){
                   ((DataOutputStream)outputStream).writeBoolean(true);
                   outputStream.flush();
               }
                   else  {
                   ((DataOutputStream)outputStream).writeBoolean(false);
                   outputStream.flush();
               }
           }
           catch (IOException ex){
               ex.printStackTrace();
           }
       }


   }
}
