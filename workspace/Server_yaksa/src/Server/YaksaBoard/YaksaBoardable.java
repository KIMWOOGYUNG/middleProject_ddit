package Server.YaksaBoard;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import yaksa.server.rmiCommon.prescription.ObYakSaBoard;



public class YaksaBoardable {

	private final Map<String, ObYakSaBoard> YaksaBoardList = new HashMap<>(); // 약사아이디, yaksa Board
	
	public boolean CheckYaksa(String name) {
		
		System.out.println(name);
		
		if(YaksaBoardList.containsKey(name)) {
			
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean addYaksa(String name, ObYakSaBoard obyaksaboard) {
		
		System.out.println(name);
		
		YaksaBoardList.put(name,obyaksaboard);
		
		return true;
		
	}
	
	public boolean popup(String Client, String YakId) throws RemoteException {
		
		System.out.println("YaksaBoard");
		return YaksaBoardList.get(YakId).Popup(Client);
	}
	
	
	
	
	
}
