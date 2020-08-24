package yaksa.chemist.controller.prescription;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import yaksa.chemist.service.prescription.IpharmService;
import yaksa.chemist.service.prescription.PharmServiceImpl;

public class RejectController {
	int phar_messnum;
	IpharmService service;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea tf;

    @FXML
    private Button btnSend;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOk;

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void ok(ActionEvent event) {

    	service.rejectPrescription(phar_messnum);
   	
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void send(ActionEvent event) {

    }

    //선택된 처방전 번호 가져옴
    void selected_messNum(int phar_messnum) {
    	this.phar_messnum = phar_messnum;
    }
    
    @FXML
    void initialize() {
    	service = PharmServiceImpl.getInstance();
    }
}
