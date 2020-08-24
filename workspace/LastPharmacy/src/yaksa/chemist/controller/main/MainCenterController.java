
package yaksa.chemist.controller.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainCenterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane centerPane;

    @FXML
    private Button btnCalendar;

    @FXML
    private Button btnSchedule;

    @FXML
    private Button btnFamousSaying;

    @FXML
    private Button btnMap;

    @FXML
    void calendar(ActionEvent event) {

    }

    @FXML
    void famousSaying(ActionEvent event) {

    }

    @FXML
    void map(ActionEvent event) {

    }

    @FXML
    void schedule(ActionEvent event) {
//    	outerpane.setCenter(null);
//    	try {
//    		Parent childroot = FXMLLoader.load(getClass().getResource("../../fxml/prescription/Pharm_Manage_Request.fxml"));
//    		outerpane.setCenter(childroot);
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}
    }

    @FXML
    void initialize() {


    }
}
