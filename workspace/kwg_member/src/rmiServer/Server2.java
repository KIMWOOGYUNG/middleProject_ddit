package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server2 {
	public static void main(String[] args) {
	      try {
	         IService service = ServiceImpl.getInstance();
	         
	         Registry reg = LocateRegistry.createRegistry(9999);
	         reg.rebind("Serverservice", service);
	         
	         System.out.println("서버가 준비되었습니다.");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	   }
}
