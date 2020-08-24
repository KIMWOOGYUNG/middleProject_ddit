package yaksa.member.controller.join;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

public class AlertController {

	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label OKLB;

    @FXML
    private Label detailLb;

    @FXML
    private Button OKbtn;

    @FXML
    void Ok(ActionEvent event) {
    	
    }
    
    public static void infoMsg(String head, String msg) {
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("정보창");
		info.setHeaderText(head);
		info.setContentText(msg);
		info.showAndWait();
	}
    
    //OK버튼을 누르면  true, 그렇지 않으면 false반환
  	public static boolean confirm(String head, String msg) {
  		Alert confir = new Alert(AlertType.CONFIRMATION);
  		confir.setTitle("정보창");
  		confir.setHeaderText(head);
  		confir.setContentText(msg);
  		ButtonType result = confir.showAndWait().get();
  		
  		boolean select = false;
  		if(result == ButtonType.OK) {
  			select = true;
  		}
  		return select;
  	}
  	
  	// 사용자로부터 값을 입력받아 그 값을 문자열로 반환하는 메서드
 	// 취소버튼을 누르거나, 창을 그냥 닫으면 null값 반환
 	public static String prompt(String msg) {
 		String strResult = null;
 		TextInputDialog dailog = new TextInputDialog(msg);
 		dailog.setTitle("입력창");
 		dailog.setHeaderText(msg);
 		dailog.setContentText("입력 : ");
 		
 		Optional<String> result = dailog.showAndWait();
 		
 		if(result.isPresent()) {
 			strResult = result.get();
 		}
 		
 		return strResult;
 	}

    @FXML
    void initialize() {
    	

    }
}