package yaksa.server.main.prescription;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import yaksa.server.rmiCommon.prescription.Common2Impl;
import yaksa.server.rmiCommon.prescription.CommonImpl;
import yaksa.server.rmiCommon.prescription.ICommon;
import yaksa.server.rmiCommon.prescription.ICommon2;

public class Main {
	public static void main(String[] args) {
	      try {
	         
	    	  ICommon common = CommonImpl.getInstance();
	    	  ICommon2 common2 = Common2Impl.getInstance();
	         
	         Registry reg = LocateRegistry.createRegistry(8888);

	         reg.rebind("common",common);
	         reg.rebind("common2",common2);
	         
	         System.out.println("서버가 준비되었습니다.");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

	   }
}
