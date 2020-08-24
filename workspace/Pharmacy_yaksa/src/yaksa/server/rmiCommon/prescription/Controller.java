package yaksa.server.rmiCommon.prescription;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Controller extends Remote {
	
	boolean CheckYaksa(String name) throws RemoteException; // 사용자가 1:1 채팅을 누르면 해당된 약사가 있는지 검사한다.
	
	boolean addYaksa(String name, ObYakSaBoard obyaksaboard) throws RemoteException;
	// 그냥 약사보드FX를  서버에 접속하자마자 줘버리면 좋을 듯
	
	
	boolean popupYaksa(String ClientId, String YaksaId) throws RemoteException; // 약사 대시보드에 수락거절 등장 
	// CheckYaksa를 한 후에, client측에서 popupyaksa를 보내면, 약사 대시보드 fxml의 rmi함수가 실행되어서
	// 수락거절 창이 등장한다.
	
	
	boolean rejectClient(String ClientId,String YaksaId) throws RemoteException;
	// 약사가 거절을 택하면 Client의 대기FXML에 거절이라는 팝업을 뛰우고,
	// 약사가 승인을 하면 채팅창이 팝업된다. 
	
	
	boolean ApproveClient(String ClientId, String YaksaId) throws RemoteException; // 약사측에서 동의하게 되면,
	// 서버에서 해당된 fxml들에 connectChat로 도입한다.
	
	boolean addWaitFX(String ClientId,ObWaitScreen waitScreen) throws RemoteException;
	// 해당된 waitScreen FX를 추가하게됨
	
	
	
}
