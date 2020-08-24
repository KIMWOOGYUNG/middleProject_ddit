package yaksa.member.controller.map.wait;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import yaksa.member.util.prescription.AlertUtil;
import yaksa.member.vo.join.SessionVO;
import yaksa.server.rmiCommon.prescription.Controller;
import yaksa.server.rmiCommon.prescription.ObWaitScreen;
import yaksa.server.rmiCommon.prescription.ServerConnect;

public class WaitScreenController implements ObWaitScreen {

	private ObWaitScreen obwaitscreen;
	private Controller controller;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainwait;
    
    public void setId(String id) {
    	
    	System.out.println("셋아이디" + id);
    	
    	try {
    		
			controller.popupYaksa(SessionVO.loginMember.getMem_id(), id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void initialize() {
    	System.out.println("인이졀");
    	
        try {
			obwaitscreen = new WaitScreenimpl(this);
			controller = ServerConnect.getServerConnector().getController();
			controller.addWaitFX(SessionVO.loginMember.getMem_id(), obwaitscreen);// id지정
			
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        
    }

	@Override
	public boolean Accept(String ClientId) throws RemoteException { // 채팅 fxml 실행
		
		
		
	System.out.println("Accept 성공");
	
	Platform.runLater( () ->{
		
		
		
		
		
		Stage stage = (Stage) mainwait.getScene().getWindow(); 	
		stage.close();
		
		
	});
		return false;
	}

	@Override
	public boolean Reject(String ClientId) throws RemoteException { // 거절 alert 실행 
		
		Platform.runLater( () ->{
			
			AlertUtil.infoMsg("현재 사용자", ClientId+"님이 채팅을 거부했습니다.");
			Stage stage = (Stage) mainwait.getScene().getWindow();      
			stage.close();
			
		});
		
		
		
		return false;
	}
}
