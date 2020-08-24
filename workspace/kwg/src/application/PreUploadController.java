package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PreUploadController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnPic;

    @FXML
    private Button btnQR;

    @FXML
    private Button btnCancel;

    @FXML
    void Cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void PicUpload(ActionEvent event) {
    	try {
			Stage dialog = new Stage();
			dialog.initModality(Modality.WINDOW_MODAL);
			Parent childRoot = FXMLLoader.load(PreUploadMain.class.getResource("../fxml/PicUpload.fxml"));
			dialog.initStyle(StageStyle.TRANSPARENT);
			
			Scene childScene = new Scene(childRoot);
			dialog.setScene(childScene);
			dialog.setTitle("���� ���ε�");
			dialog.show();
			
			Stage stage = (Stage) btnCancel.getScene().getWindow();
	    	stage.close();
			
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void QRScan(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnPic != null : "fx:id=\"btnPic\" was not injected: check your FXML file 'PicUpload.fxml'.";
        assert btnQR != null : "fx:id=\"btnQR\" was not injected: check your FXML file 'PicUpload.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'PicUpload.fxml'.";

    }
}
