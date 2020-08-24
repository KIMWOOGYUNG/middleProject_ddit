package yaksa.member.controller.mypage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class a222Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ok;

    @FXML
    void okClick(ActionEvent event) {
    	
			
    		Platform.exit(); //전부 종료
    
		
    	
    
    }

    @FXML
    void initialize() {
        assert ok != null : "fx:id=\"ok\" was not injected: check your FXML file 'a222_IdDelet.fxml'.";

    }

	public void setMainConterolloer(a2Controller a2Controller) {
		// TODO Auto-generated method stub
		
	}
}
