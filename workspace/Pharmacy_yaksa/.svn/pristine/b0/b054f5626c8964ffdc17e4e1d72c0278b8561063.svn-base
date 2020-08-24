package yaksa.chemist.controller.inventory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class InventoryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane outerpane;

    @FXML
    private Button btnIn;

    @FXML
    private Button btnOut;

    @FXML
    private Button btnInven;

    @FXML
    void in(ActionEvent event) {
    	outerpane.setCenter(null);
    	try {
    		Parent childroot = FXMLLoader.load(getClass().getResource("../../fxml/inventory/a8_prod.fxml"));
    		outerpane.setCenter(childroot);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void inven(ActionEvent event) {
    	outerpane.setCenter(null);
    	try {
    		Parent childroot = FXMLLoader.load(getClass().getResource("../../fxml/inventory/aa10_prod.fxml"));
    		outerpane.setCenter(childroot);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void out(ActionEvent event) {
    	outerpane.setCenter(null);
    	try {
    		Parent childroot = FXMLLoader.load(getClass().getResource("../../fxml/inventory/a9_prod.fxml"));
    		outerpane.setCenter(childroot);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void initialize() {

    }
}
