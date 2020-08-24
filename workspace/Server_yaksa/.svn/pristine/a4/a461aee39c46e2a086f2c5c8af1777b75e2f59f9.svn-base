package yaksa.server.rmiCommon.prescription;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICommon extends Remote{
	
	//환자가 처방전 전송
	public void requestPres(String mem_id, String pharm_id, byte[] data) throws RemoteException; //환자->서버
	
	//약사가 보낸 영수증 받음
	public byte[] receiveReceipt(String fileName) throws RemoteException;
	
	//서버에 저장된 환자가 보낸 처방전 다시 받음
	public byte[] receivePres(String fileName) throws RemoteException;
}
