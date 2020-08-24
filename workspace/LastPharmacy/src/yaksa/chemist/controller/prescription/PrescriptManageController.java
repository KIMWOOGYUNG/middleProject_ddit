package yaksa.chemist.controller.prescription;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import yaksa.chemist.main.prescription.PrescriptManageMain;

public class PrescriptManageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRequest;

    @FXML
    private Button btnReceiveBox;

    @FXML
    private Button btnSendBox;

    @FXML
    private BorderPane outerpane;
    
    @FXML
    void clickRequest(ActionEvent event) {
    	outerpane.setCenter(null);
    	try {
    		Parent childroot = FXMLLoader.load(getClass().getResource("../../fxml/prescription/Pharm_Manage_Request.fxml"));
    		outerpane.setCenter(childroot);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void clickReceive(ActionEvent event) {
    	outerpane.setCenter(null);
    	try {
			Parent childroot = FXMLLoader.load(PrescriptManageMain.class.getResource("../../fxml/prescription/Pharm_Manage_Receive.fxml"));
			outerpane.setCenter(childroot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
 
    @FXML
    void clickSend(ActionEvent event) {
    	outerpane.setCenter(null);
    	try {
			Parent childroot = FXMLLoader.load(PrescriptManageMain.class.getResource("../../fxml/prescription/Pharm_Manage_Send.fxml"));
			outerpane.setCenter(childroot);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void initialize() throws IOException {
    	
    }
}
