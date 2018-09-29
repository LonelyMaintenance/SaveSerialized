import java.io.*;
import java.net.*;

public class Client {

   public static void main(String[] arg) {
      try {
    	  PersistentTime time = new PersistentTime();

         Socket socket = new Socket("127.0.0.1", 11111);


         ObjectOutputStream out = new
            ObjectOutputStream(socket.getOutputStream());
         ObjectInputStream in = new 
            ObjectInputStream(socket.getInputStream());

         out.writeObject(time);

         time= (PersistentTime)in.readObject();

         System.out.println("Date from server= "
                            + time.getTime().toString());

         out.close();
         in.close();

      } catch (Exception e) {System.out.println(e); }
   }
}
