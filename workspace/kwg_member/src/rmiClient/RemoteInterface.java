package rmiClient;

import java.rmi.RemoteException;

public interface RemoteInterface {
	//���� ���ۿ� �޼���
	public void setFile(PrescriptionVO psVo) throws RemoteException;
}
