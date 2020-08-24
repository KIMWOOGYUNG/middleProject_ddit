package yaksa.server.rmiCommon.prescription;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObWaitScreen extends Remote{
	
	boolean Accept(String ClientId) throws RemoteException; // 수락이 되면, 해당된 fxml에서 Chatroom이 load된다 
	boolean Reject(String ClientId) throws RemoteException;; // 거절이 되면, 해당된 fxml에서 Alert로 거절이되었다라고 뜬다.
	
	
	

}
