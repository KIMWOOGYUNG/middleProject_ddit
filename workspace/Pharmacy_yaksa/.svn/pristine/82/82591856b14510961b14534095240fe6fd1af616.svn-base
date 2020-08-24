package yaksa.chemist.controller.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainCenterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane centerPane;

    @FXML
    private Button btnPrescription;

    @FXML
    private Button btnPharmacy;

    @FXML
    private Button btnStatics;

    @FXML
    private Button btnMedicine;

    @FXML
    void medicine(MouseEvent event) {
    	try {
			Parent childRoot = FXMLLoader.load(MainController.class.getResource("/yaksa/chemist/fxml/inventory/Inventory.fxml"));
			((BorderPane)btnStatics.getScene().getRoot()).setCenter(childRoot);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void medicine2(ActionEvent event) {
    	try {
			Parent childRoot = FXMLLoader.load(MainController.class.getResource("/yaksa/chemist/fxml/inventory/Inventory.fxml"));
			((BorderPane)btnStatics.getScene().getRoot()).setCenter(childRoot);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void pharmacy(MouseEvent event) {
    	try {
			Parent childRoot = FXMLLoader.load(MainController.class.getResource("/yaksa/chemist/fxml/manage/YKManage.fxml"));
			((BorderPane)btnStatics.getScene().getRoot()).setCenter(childRoot);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void pharmacy2(ActionEvent event) {
    	try {
			Parent childRoot = FXMLLoader.load(MainController.class.getResource("/yaksa/chemist/fxml/manage/YKManage.fxml"));
			((BorderPane)btnStatics.getScene().getRoot()).setCenter(childRoot);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void prescription(MouseEvent event) {
    	try {
			Parent childRoot = FXMLLoader.load(MainController.class.getResource("/yaksa/chemist/fxml/prescription/PrescriptManage.fxml"));
			((BorderPane)btnStatics.getScene().getRoot()).setCenter(childRoot);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void prescription2(ActionEvent event) {
    	try {
			Parent childRoot = FXMLLoader.load(MainController.class.getResource("/yaksa/chemist/fxml/prescription/PrescriptManage.fxml"));
			((BorderPane)btnStatics.getScene().getRoot()).setCenter(childRoot);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void statics(MouseEvent event) {
    	try {
			Parent childRoot = FXMLLoader.load(MainController.class.getResource("/yaksa/chemist/fxml/chart/YKChart.fxml"));
			((BorderPane)btnStatics.getScene().getRoot()).setCenter(childRoot);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void statics2(ActionEvent event) {
    	try {
			Parent childRoot = FXMLLoader.load(MainController.class.getResource("/yaksa/chemist/fxml/chart/YKChart.fxml"));
			((BorderPane)btnStatics.getScene().getRoot()).setCenter(childRoot);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert centerPane != null : "fx:id=\"centerPane\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert btnPrescription != null : "fx:id=\"btnPrescription\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert btnPharmacy != null : "fx:id=\"btnPharmacy\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert btnStatics != null : "fx:id=\"btnStatics\" was not injected: check your FXML file 'MainCenter.fxml'.";
        assert btnMedicine != null : "fx:id=\"btnMedicine\" was not injected: check your FXML file 'MainCenter.fxml'.";

    }
}
