package yaksa.publicChatServer.main;

import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import yaksa.publicChatServer.control.ChatControllerImpl;

/**
 * Created by oshan on 18-Nov-17.
 */
public class ServerMain {

    public static void main(String[] args) {
      
        try {
           
            System.out.println(System.getProperty("user.dir"));
          


            Registry registry= LocateRegistry.createRegistry(8888);
            registry.rebind("ChatServer",new ChatControllerImpl());

            System.out.println("Server Started...");
          
       

            String[] ar={"cmd","/c","start","powershell.exe","-command","Read-Host"," Server Started","Press Enter to Exit......"};

            Process process=Runtime.getRuntime().exec(ar);
            InputStream stderr = process.getErrorStream ();

            BufferedReader reader = new BufferedReader (new InputStreamReader(stderr));

            reader.readLine();
            System.out.println("Exiting...");
            reader.close();
            process.destroy();
//            System.exit(0);

            Runtime.getRuntime().exit(0);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
