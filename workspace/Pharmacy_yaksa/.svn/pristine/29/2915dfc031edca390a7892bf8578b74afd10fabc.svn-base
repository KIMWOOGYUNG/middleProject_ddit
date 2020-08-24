package yaksa.server.rmiCommon.prescription;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICommon2 extends Remote{
	
	//환자가 보낸 처방전 받음
	public byte[] requestFile(String fileName) throws RemoteException;
	
	//약사가 영수증 전송
	public void sendReceipt(String mem_id, String pharm_id, String pres_code, byte[] data) throws RemoteException; 

	//약사가 보낸 영수증 받음
	public byte[] receiveReceipt(String fileName) throws RemoteException;
	
}
