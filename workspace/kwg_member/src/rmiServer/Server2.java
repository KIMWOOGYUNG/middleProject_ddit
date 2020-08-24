package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server2 {
	public static void main(String[] args) {
	      try {
	         IService service = ServiceImpl.getInstance();
	         
	         Registry reg = LocateRegistry.createRegistry(9999);
	         reg.rebind("Serverservice", service);
	         
	         System.out.println("������ �غ�Ǿ����ϴ�.");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	   }
}
