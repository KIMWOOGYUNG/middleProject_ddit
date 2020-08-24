package yaksa.chemist.controller.prescription;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.json.simple.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
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

    public void sms() {
    	System.out.println(PresOfChemiController.tel_mem);
    	 String api_key = "NCSUOU07S4TKISUC";
         String api_secret = "CMSAPV91CCMI7EL2VKRISSW1BBS8ADTX";
    	Message coolsms = new Message(api_key, api_secret);
    	
    	
    	// 4 params(to, from, type, text) are mandatory. must be filled
    	HashMap<String, String> params = new HashMap<String, String>();
    	params.put("to", PresOfChemiController.tel_mem); // 수신번호
    	params.put("from", "01024830328"); // 발신번호
    	params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
    	params.put("text", tf.getText()); // 문자내용    
    	params.put("app_version", "JAVA SDK v1.2"); // application name and version
    	
    	try {
    		JSONObject obj = (JSONObject) coolsms.send(params);
    		System.out.println(obj.toString());
    	} catch (CoolsmsException e) {
    		System.out.println(e.getMessage());
    		System.out.println(e.getCode());
    	}
    	
    	
    }
    
    @FXML
    void send(ActionEvent event) {
    	sms();
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
