package yaksa.chemist.controller.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainAcceptCOntroller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public Button Accept;

    @FXML
    public Button Reject;

    @FXML
    void Acceptbtn(ActionEvent event) {

    }

    @FXML
    void rejectbtn(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Accept != null : "fx:id=\"Accept\" was not injected: check your FXML file 'MainAccept.fxml'.";
        assert Reject != null : "fx:id=\"Reject\" was not injected: check your FXML file 'MainAccept.fxml'.";

    }
}
