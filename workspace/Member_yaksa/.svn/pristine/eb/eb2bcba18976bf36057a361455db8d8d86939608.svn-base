package yaksa.member.controller.mypage;

import java.awt.Dimension;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import org.json.simple.JSONObject;

import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import netscape.javascript.JSObject;
import yaksa.member.controller.main.MainController;
import yaksa.member.service.join.MemberServiceImpl;
import yaksa.member.service.mypage.MemServiceImpl;
import yaksa.member.util.prescription.AlertUtil;
import yaksa.member.vo.join.SessionVO;
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
            AlertUtil.infoMsg("입력하신 인증번호가 ", "일치합니다!");
        }else {
            //일치하지 않을때
       	 AlertUtil.infoMsg("입력하신 인증번호가 ", "일치하지 않습니다.");
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
    
    MemVo mvo = new MemVo();

    
    @FXML
    void Submit(ActionEvent event) {
       
       mvo = new MemVo();
       
       String mem_pw = pwTf.getText();
       String mem_zipNumTf =zipNumTf.getText();
       String mem_add1Tf = add1Tf.getText();
       String mem_add2Tf = add2Tf.getText();
       String mem_telTf = telTf.getText();
       
       if(mem_pw.isEmpty()||mem_zipNumTf.isEmpty()||mem_add1Tf.isEmpty()||mem_add2Tf.isEmpty()||mem_telTf.isEmpty()) {
          AlertUtil.errorMsg("입력오류", "빈 항목이 있습니다.");
          return;
       }
       
       mvo.setMem_id(idTf.getText());
       mvo.setMem_pw(pwTf.getText());
       mvo.setMem_zip_code(zipNumTf.getText());
       mvo.setMem_add1(add1Tf.getText());
       mvo.setMem_add2(add2Tf.getText());
       mvo.setMem_tel(telTf.getText());
//       memVo.setMem_pw(mem_pw);
//       memVo.setMem_zip_code(mem_zipNumTf);
//       memVo.setMem_add1(mem_add1Tf);
//       memVo.setMem_add2(mem_add2Tf);
//       memVo.setMem_tel(mem_telTf);
    
       service.updateMember(mvo);
       
       AlertUtil.infoMsg("확인", "정보가 변경되었습니다");
       
       
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

//-------------------------------------------------주소찾기 API---------------------------------------------------
    
    private JSObject javascriptConnector;
    private JavaConnector javaConnector = new JavaConnector();
    
    public class JavaConnector{
        public void toLowerCase(String zipcode,String addr) {
        
           // kakaozipcode와 연결되어서 webview에 입력된 값을 그대로 가져와 pharmvo에 업데이트 시킨다. 
           // zipcode, add1, add2
           SessionVO.loginMember.getMem_id();
           MemberServiceImpl service = MemberServiceImpl.getInstance();
           zipNumTf.setText(zipcode);
           add1Tf.setText(addr);
           
           SessionVO.loginMember.setMem_zip_code((Integer.parseInt(zipcode)));
           SessionVO.loginMember.setMem_add1(addr);
           
           service.updateZipNum(SessionVO.loginMember);
           
           
           
        }
     }
    
    private void initFX() {

       JFrame frame = new JFrame("FX");

       frame.getContentPane().setLayout(null);

       final JFXPanel fxPanel = new JFXPanel();

       frame.add(fxPanel);
       frame.setVisible(true);

       fxPanel.setSize(new Dimension(600, 700));
//       fxPanel.setLocation(new Point(0, 27));

       frame.getContentPane().setPreferredSize(new Dimension(600, 700));
       frame.pack();
       frame.setResizable(false);

       Platform.runLater(new Runnable() {

          public void run() {

             initAndLoadWebView(fxPanel);

          }

       });
    }

    private void initAndLoadWebView(final JFXPanel fxPanel) {

       Group group = new Group();
       Scene scene = new Scene(group);

       fxPanel.setScene(scene);

       WebView webView = new WebView();

       group.getChildren().add(webView);

       webView.setMinSize(600, 700);
       webView.setMaxSize(600, 700);
       
       WebEngine webEngine = webView.getEngine();

//       webEngine.load("http://localhost:8081/YakSa_zipCode/memZIp.html");
       webEngine.load("file:///D:/A_TeachingMaterial/4.MiddleProject/workspace/Zipcode/memZIp.html");
       
          // kakaozipcode의 webview와 연동되어서 값을 가져오는 부분 
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue)->{
        if(Worker.State.SUCCEEDED==newValue) {
           JSObject window = (JSObject) webEngine.executeScript("window");
           window.setMember("javaConnector", javaConnector);
           javascriptConnector = (JSObject) webEngine.executeScript("getJsConnector()");
        }
        
     });
        

    }

    //------------------------------------------------------------------------------
    
    @FXML
    void addrFind(ActionEvent event) {
    	initFX();
    	
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
        System.out.println(999 + MainController.memVO.getMem_id());
        List<MemVo> memList = service.getAllMember(MainController.memVO.getMem_id());
        System.out.println(111 + memList.toString());
        memVo = memList.get(0);
        System.out.println(222 + memVo.getMem_id());
        
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
