package rmiClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IService extends Remote{

	public void requestPres(String mem_id, String pharm_id, byte[] data) throws RemoteException; 

}
