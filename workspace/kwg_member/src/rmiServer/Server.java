package rmiServer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RemoteInterface{
	
	//생성자
	public Server() throws RemoteException {}

	@Override
	public void setFile(PrescriptionVO psVo) throws RemoteException {
		FileOutputStream fos = null;
		BufferedOutputStream bos= null;
		String dir = "C:\\Users\\PC-18\\Desktop\\처방전 서버 저장용 테스트\\";
		System.out.println("서버에 파일 저장 시작...");
		
		try {
			fos = new FileOutputStream(dir + psVo.getFileName());
			bos = new BufferedOutputStream(fos);
			
			bos.write(psVo.getFileData());	//파일 저장
			
			bos.flush();
			bos.close();
			System.out.println("서버에 파일 저장 완료...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//RMI용 객체를 클라이언트에서 사용할 수 있도록 RMI환경을 설정한다.
		
		try {
			//RMI용 인터페이스를 구현한 RMI용 클래스의 인스턴스를 생성한다.
			RemoteInterface inf = new Server();
			
			//구현한 객체를 클라이언트가 찾을 수 있도록 관리하는 Registry 객체를 생성한다.
			Registry reg = LocateRegistry.createRegistry(8888);
			
			reg.rebind("server", inf);
			
			System.out.println("서버 준비 완료...");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
