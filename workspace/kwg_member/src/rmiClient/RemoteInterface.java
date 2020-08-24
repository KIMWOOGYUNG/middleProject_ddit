package rmiClient;

import java.rmi.RemoteException;

public interface RemoteInterface {
	//파일 전송용 메서드
	public void setFile(PrescriptionVO psVo) throws RemoteException;
}
