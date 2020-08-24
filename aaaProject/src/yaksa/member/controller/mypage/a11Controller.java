package yaksa.member.controller.mypage;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.json.simple.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import yaksa.member.service.mypage.MemServiceImpl;
import yaksa.member.util.mypage.AlrtUtil;
import yaksa.member.vo.mypage.MemVo;

public class a11Controller {
    @FXML
    private Label pwch1;

	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button hp;
    
    @FXML
    private Button okBtn;

    @FXML
    private Button cancleBtn;

    @FXML
    private TextField idTf;

    @FXML
    private Button idsameCBtn;

    @FXML
    private TextField pwTf;

    @FXML
    private TextField pwCTf;

    @FXML
    private TextField nameTf;

    @FXML
    private TextField reg1Tf;

    
    @FXML
    private RadioButton a;
    
    @FXML
    private RadioButton b;
    @FXML
    private TextField regTf2;

    @FXML
    private TextField mail1Tf;

    @FXML
    private TextField mail2Tf;

    @FXML
    private Button mailOkBtn;


    @FXML
    private Button telNumbtn;
    
    @FXML
    private TextField telNumTf;
    
    @FXML
    private TextField zipNumTf;

    @FXML
    private Button lookZipBtn;

    @FXML
    private TextField add1Tf;

    @FXML
    private TextField add2Tf;

    @FXML
    private TextField telTf;



    private static String confirmNumber2 ="";	//랜덤번호 생성
//-------------------------------------------------문자전송 API------------------------------------------------------------------------------    
    
    public void sms() {
    	
    	String api_key = "NCS4U8SRQXZCNESZ";
        String api_secret = "RYMOLFR24UI6J2ZOMKVGKIGUV85ZCM0J";
        Message coolsms = new Message(api_key, api_secret);
        
        for(int i = 0; i < 6; i++) {
	        int a =(int)(Math.random()*10);
	        confirmNumber2+=a+"";
        }

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", telTf.getText()); // 수신번호
        params.put("from", "01064733782"); // 발신번호
        params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
        params.put("text", "인증번호는" + confirmNumber2 +"입니다."); // 문자내용    
        params.put("app_version", "JAVA SDK v1.2"); // application name and version

        try {
          JSONObject obj = (JSONObject) coolsms.send(params);
          System.out.println(obj.toString());
        } catch (CoolsmsException e) {
          System.out.println(e.getMessage());
          System.out.println(e.getCode());
        }
    	
   
	}
    
//---------------------------------------------------------------------------------------------------------------
    

    @FXML
    void tel_Num_btn(ActionEvent event) {

    	if(telNumTf.getText().equals(confirmNumber2)) {
            //일치했을때
            AlrtUtil.infoMsg("입력하신 인증번호가 ", "일치합니다!");
        }else {
            //일치하지 않을때
       	 AlrtUtil.infoMsg("입력하신 인증번호가 ", "일치하지 않습니다.");
        }
    }
    @FXML
    void CheckId(ActionEvent event) {

    }

    @FXML
    void NotSubmit(ActionEvent event) {
    	Stage stage = (Stage) cancleBtn.getScene().getWindow();    
        stage.close();

    }
    @FXML
    private ToggleGroup gender;

    
    @FXML
    void Submit(ActionEvent event) {
    	String mem_pw = pwTf.getText();
    	String mem_zipNumTf =zipNumTf.getText();
    	String mem_add1Tf = add1Tf.getText();
    	String mem_add2Tf = add2Tf.getText();
    	String mem_telTf = telTf.getText();
    	
    	
    	memVo.setMem_pw(mem_pw);
    	memVo.setMem_zip_code(mem_zipNumTf);
    	memVo.setMem_add1(mem_add1Tf);
    	memVo.setMem_add2(mem_add2Tf);
    	memVo.setMem_tel(mem_telTf);
    
    	service.updateMember(memVo);
    	
    	
    	Stage stage = (Stage) okBtn.getScene().getWindow();    
        stage.close();
    	
    }

    @FXML
    void TelOk(ActionEvent event) {
    	sms();
    }

    @FXML
    void emailOk(ActionEvent event) {

    }

    
   MemVo memVo =null;
   MemServiceImpl service = null; 

    @FXML
    void initialize() {
    	assert okBtn != null : "fx:id=\"okBtn\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert cancleBtn != null : "fx:id=\"cancleBtn\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert idTf != null : "fx:id=\"idTf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert idsameCBtn != null : "fx:id=\"idsameCBtn\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert pwTf != null : "fx:id=\"pwTf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert pwCTf != null : "fx:id=\"pwCTf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert nameTf != null : "fx:id=\"nameTf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert reg1Tf != null : "fx:id=\"reg1Tf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert regTf2 != null : "fx:id=\"regTf2\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert a != null : "fx:id=\"a\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert gender != null : "fx:id=\"gender\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert b != null : "fx:id=\"b\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert mail1Tf != null : "fx:id=\"mail1Tf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert mail2Tf != null : "fx:id=\"mail2Tf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert mailOkBtn != null : "fx:id=\"mailOkBtn\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert zipNumTf != null : "fx:id=\"zipNumTf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert lookZipBtn != null : "fx:id=\"lookZipBtn\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert add1Tf != null : "fx:id=\"add1Tf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert add2Tf != null : "fx:id=\"add2Tf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
        assert telTf != null : "fx:id=\"telTf\" was not injected: check your FXML file 'a11_infoUpdate.fxml'.";
       
        
        // 패스워드 일치
        pwCTf.textProperty().addListener((Observable, oldValue, newValue) -> {
	    	if(!newValue.equals(pwTf.getText())) {
	    		pwch1.setText("비밀번호가 일치하지 않습니다.");	
	    	}else if (newValue.equals(pwTf.getText())) {
	    		pwch1.setText("");	
	    		
	    	}
        });
        service = service.getInstance();
        List<MemVo> memList = service.getAllMember();
        memVo = memList.get(0);
        
        idTf.setText(memVo.getMem_id());
        pwTf.setText(memVo.getMem_pw());
        pwCTf.setText(memVo.getMem_pw());
        nameTf.setText(memVo.getMem_name());
        reg1Tf.setText(memVo.getMem_regno1());
        regTf2.setText(memVo.getMem_regno2());
        if(memVo.getMem_gender().equals("남")) {
        	a.setSelected(true);
        }else {
        	b.setSelected(true);
        }
        mail1Tf.setText(memVo.getMem_email1());
        mail2Tf.setText(memVo.getMem_email2());
        zipNumTf.setText(memVo.getMem_zip_code());
        add1Tf.setText(memVo.getMem_add1());
        add2Tf.setText(memVo.getMem_add2());
        telTf.setText(memVo.getMem_tel());
        
        
        
        
    }

	public void setMainConterolloer(a1Controller a1Controller) {
		
		
	}
}
