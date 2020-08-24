package yaksa.chemist.controller.join;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChemistAgreeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox check;

    @FXML
    private Label Checklb;
    
    @FXML
    private Button OkBtn;

    @FXML
    void AgreeCheck(ActionEvent event) {
    	if(check.isSelected()) {
  		  Checklb.setText("");
  		  OkBtn.setDisable(false);
  	  }else {
  		  Checklb.setText("약관에 동의해 주세요");
  		  OkBtn.setDisable(true);
  	  }
    }

    @FXML
    void OK(ActionEvent event) {
    	try {

    		Stage dialog = new Stage();
    		Parent childRoot = FXMLLoader.load(ChemistAgreeController.class.getResource("/yaksa/chemist/fxml/join/ChemistJoin.fxml"));
    		dialog.initStyle(StageStyle.TRANSPARENT); //
    		Scene childScene = new Scene(childRoot);
    		childScene.setFill(Color.TRANSPARENT);	//
    		
    		dialog.setScene(childScene);
    		dialog.setTitle("회원가입");
    		dialog.showAndWait();
    		
    		Stage stage = (Stage) OkBtn.getScene().getWindow();      
    		stage.close();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	


    }

    @FXML
    void initialize() {
        assert OkBtn != null : "fx:id=\"OkBtn\" was not injected: check your FXML file 'Agree.fxml'.";

    }
}
