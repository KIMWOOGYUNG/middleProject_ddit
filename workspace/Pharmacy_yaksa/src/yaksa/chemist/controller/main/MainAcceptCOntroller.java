package yaksa.chemist.controller.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.chemist.vo.join.SessionVO;
import yaksa.publicChatClient.ui.controller.ChatRoom;
import yaksa.publicChatCommon.model.User;
import yaksa.server.rmiCommon.prescription.Controller;
import yaksa.server.rmiCommon.prescription.ServerConnect;

public class MainAcceptCOntroller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public Button Accept;

    @FXML
    public Button Reject;

    public String ClientName;
    
    Controller controller;
    
    public void setName(String ClientName) {
    	
    this.ClientName = ClientName;
    
    
    }
    
    
    @FXML
    void Acceptbtn(ActionEvent event) {
    	
    
    	
    	try {
			controller.ApproveClient(ClientName, SessionVO.loginChemist.getPharm_id());
		} catch (RemoteException e) {

			e.printStackTrace();
		}
    	
    	try {
			Stage chatstage = new Stage();
			URL fxmlPath = new File("/yaksa/publicChatClient/ui/fxml/ChatRoom.fxml").toURL();
			FXMLLoader loader = new FXMLLoader(fxmlPath);
			
			chatstage.setScene(new Scene(loader.load()));
			chatstage.initStyle(StageStyle.TRANSPARENT);
			ChatRoom chatRoom=loader.getController();
			
			
			
			User user = new User("이약사", "약국");
			
			chatRoom.setUsername(user);
			
			chatstage.show();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
    }

    @FXML
    void rejectbtn(ActionEvent event) {

    	try {
			controller.rejectClient(ClientName, SessionVO.loginChemist.getPharm_id());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
    }

    
    
    @FXML
    void initialize() {
    	
    	try {
    		controller = ServerConnect.getServerConnector().getController();
		
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
