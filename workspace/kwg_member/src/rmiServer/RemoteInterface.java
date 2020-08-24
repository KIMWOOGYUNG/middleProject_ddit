package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote{
	//파일 전송용 메서드
	public void setFile(PrescriptionVO psVo) throws RemoteException;
}
