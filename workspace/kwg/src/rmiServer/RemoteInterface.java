package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote{
	//���� ���ۿ� �޼���
	public void setFile(PrescriptionVO psVo) throws RemoteException;
}
