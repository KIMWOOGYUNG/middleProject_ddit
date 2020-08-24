package Server.WaitScreen;



import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import yaksa.server.rmiCommon.prescription.ObWaitScreen;




public class WaitScreenable {
	
	private final Map<String, ObWaitScreen> WiatScreenList = new HashMap<>();
	
	
	public boolean addWaitFX(String ClientId,ObWaitScreen waitScreen) {
		
		System.out.println(ClientId);
		WiatScreenList.put(ClientId,waitScreen);
		
		
		return true;
	}

	
	public boolean rejectClient(String ClientId, String YaksaId) throws RemoteException {
		
		
		WiatScreenList.get(ClientId).Reject(YaksaId);
		
		
		return true;
	}
	
	public boolean ApproveClient(String ClientId, String YaksaId) throws RemoteException {
		
		WiatScreenList.get(ClientId).Accept(YaksaId);
		
		return true;
		
	}
	
}
