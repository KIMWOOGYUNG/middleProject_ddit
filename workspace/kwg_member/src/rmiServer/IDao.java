package rmiServer;

import java.io.File;
import java.rmi.RemoteException;

public interface IDao {
	public void requestPres(String mem_id, String pharm_id, byte[] data) throws RemoteException; 
}
