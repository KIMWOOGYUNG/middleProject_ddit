package yaksa.member.controller.mypage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class a00Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button look;

    @FXML
    private Button My_Page;

    @FXML
    void lookClick(ActionEvent event) {
//    	try {
//    		Stage parentStage =(Stage)look.getScene().getWindow();
//    		
//    		Stage lookStage = new Stage(StageStyle.TRANSPARENT);
//    		lookStage.initModality(Modality.WINDOW_MODAL);
//    		lookStage.initOwner(parentStage);
//    		
//    		FXMLLoader loader = new FXMLLoader(
//    				a00Controller.class.getResource("../fxml/a5_myPrescription.fxml")
//    				);
//			
//    		Parent addRoot = loader.load();
//    		a5Controller lookController = loader.getController();
//    		lookController.setMainConterolloer(this);
//    		
//    		Scene scene = new Scene(addRoot);
//    		scene.setFill(Color.TRANSPARENT);
//    		lookStage.setScene(scene);
//    		lookStage.setTitle("추가");
//    		lookStage.show();
//	    	
//    		
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

    }

    @FXML
    void myPageClick(ActionEvent event) {
    	
    	try {
    		Stage parentStage =(Stage)My_Page.getScene().getWindow();
    		
    		Stage myPageStage = new Stage(StageStyle.TRANSPARENT);
    		myPageStage.initModality(Modality.WINDOW_MODAL);
    		myPageStage.initOwner(parentStage);
    		
    		FXMLLoader loader = new FXMLLoader(
    				a00Controller.class.getResource("../../fxml/mypage/a1_pMyPage.fxml")
    				);
    		
    		Parent addRoot = loader.load();
    		
    		a1Controller myPageController = loader.getController();
    		
    		myPageController.setMainConterolloer(this);
    		
    		Scene scene = new Scene(addRoot);
    		scene.setFill(Color.TRANSPARENT);
    		myPageStage.setScene(scene);
    		myPageStage.setTitle("추가");
    		myPageStage.show();
	    	
    	} catch(IOException e) {
    		e.printStackTrace();    		
    	}

    }

    @FXML
    void initialize() {
        assert look != null : "fx:id=\"look\" was not injected: check your FXML file 'a00_mainPage.fxml'.";
        assert My_Page != null : "fx:id=\"My_Page\" was not injected: check your FXML file 'a00_mainPage.fxml'.";

    }
}
