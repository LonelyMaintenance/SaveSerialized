import java.io.*;
import java.net.*;

public class Server {

   public static void main(String[] arg) {

      PersistentTime time = null;

      try {

         ServerSocket serverSocket = new ServerSocket(11111);

         System.out.println("Server Waiting");

         Socket clientSocket = serverSocket.accept();

         ObjectInputStream in = new    
            ObjectInputStream(clientSocket.getInputStream());

         ObjectOutputStream out = new 
            ObjectOutputStream(clientSocket.getOutputStream());

         time = (PersistentTime )in.readObject();
         
         System.out.println("Date from client= "
                 + time.getTime().toString());

         out.writeObject(time);

         in.close();
         out.close();


      }  catch(Exception e) {System.out.println(e); 
      }
   }

}