package rmiServer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RemoteInterface{
	
	//������
	public Server() throws RemoteException {}

	@Override
	public void setFile(PrescriptionVO psVo) throws RemoteException {
		FileOutputStream fos = null;
		BufferedOutputStream bos= null;
		String dir = "C:\\Users\\PC-18\\Desktop\\ó���� ���� ����� �׽�Ʈ\\";
		System.out.println("������ ���� ���� ����...");
		
		try {
			fos = new FileOutputStream(dir + psVo.getFileName());
			bos = new BufferedOutputStream(fos);
			
			bos.write(psVo.getFileData());	//���� ����
			
			bos.flush();
			bos.close();
			System.out.println("������ ���� ���� �Ϸ�...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//RMI�� ��ü�� Ŭ���̾�Ʈ���� ����� �� �ֵ��� RMIȯ���� �����Ѵ�.
		
		try {
			//RMI�� �������̽��� ������ RMI�� Ŭ������ �ν��Ͻ��� �����Ѵ�.
			RemoteInterface inf = new Server();
			
			//������ ��ü�� Ŭ���̾�Ʈ�� ã�� �� �ֵ��� �����ϴ� Registry ��ü�� �����Ѵ�.
			Registry reg = LocateRegistry.createRegistry(8888);
			
			reg.rebind("server", inf);
			
			System.out.println("���� �غ� �Ϸ�...");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
