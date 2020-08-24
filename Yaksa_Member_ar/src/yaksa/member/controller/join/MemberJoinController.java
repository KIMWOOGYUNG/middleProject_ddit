package yaksa.member.controller.join;

import java.awt.Dimension;
import java.awt.Point;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import netscape.javascript.JSObject;
import yaksa.member.server.join.IMemberService;
import yaksa.member.server.join.MemberServiceImpl;
import yaksa.member.vo.join.MemberVO;
import yaksa.util.AlertUtil;


public class MemberJoinController {
	
	private JSObject javascriptConnector;
	private JavaConnector javaConnector = new JavaConnector();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button okBtn;				// 가입완료 버튼 (데이터 전송)

    @FXML
    private Button cancleBtn;			// 취소 버튼 (가입 취소)

    @FXML
    private TextField idTf;				// id 입력란

    @FXML
    private Button idsameCBtn;			// id 중복체크 확인 버튼
    
    @FXML
    private Label idCheck;				// id 정규식불일치시 경고창메시지를 띄울 label

    @FXML
    private PasswordField pwTf;			// pw 입력란
    
    @FXML
    private Label pwCheck;				// pw 정규식 불일치시 경고창메시지를 띄울 label

    @FXML
    private PasswordField pwCTf;		// pw 일치 확인란
    
    @FXML
    private Label pwSameCheck;			// pw 불일치시 경고창메시지를 띄울 label

    @FXML
    private TextField nameTf;			// 이름 입력란
    
    @FXML
    private Label nameCheck;			// 이름 정규식 불일치시 경고창메시지를 띄울 label

    @FXML
    private TextField reg1Tf;			// 주민번호 앞자리 입력란

    @FXML
    private TextField regTf2;			// 주민번호 뒷자리 입력란
    
    @FXML
    private Label regCheck;				// 주민번호 정규식 불일치시 경고창메시지를 띄울 label
    
    @FXML
    private ToggleGroup gender;			// 성별 그룹
    
    @FXML
    private RadioButton gender_male; 	// 성별 : 남성

    @FXML
    private RadioButton gender_Female;	// 성별 : 여성
    
    @FXML
    private Label genderCheck;			// 성별 미체크시 체크해달라는 경고메시지를 띄울 label

    @FXML
    private TextField mail1Tf;			// 메일 앞자리 입력란

    @FXML
    private TextField mail2Tf;			// 메일 뒷자리 입력란

    @FXML
    private Button mailOkBtn;			// 메일유무 확인버튼
    
    @FXML
    private TextField MailNumOk;

    @FXML
    private Button MailNumBtn;
    
    @FXML
    private Label mailCheck;			// 메일 정규식 불일치시 경고창메시지를 띄울 label

    @FXML
    private TextField zipNumTf;			// 우편번호 입력란

    @FXML
    private Button lookZipBtn;			// 주소찾기 버튼

    @FXML
    private TextField add1Tf;			// 주소 입력란

    @FXML
    private TextField add2Tf;			// 상세주소 입력란

    @FXML
    private TextField telTf;			// 전화번호 입력란

    @FXML
    private Button TelOk;				// 전화번호 인증버튼
    
    @FXML
    private TextField nameTf1;
    
    @FXML
    private Button TelNumOk;
    
    @FXML
    private Label telCheck;				// 전화번호 정규식 불일치시 경고창메시지를 띄울 label

    @FXML
    private CheckBox agreeBox;			// 약관동의
    
    @FXML
    private Label agreeCheck;			// 약관동의 미체크시 경고메시지를 띄울 label
    
    private static String confirmNumber ="";	//랜덤번호 생성
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
        params.put("from", "01056223165"); // 발신번호
        params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
        params.put("text", "인증번호는" + confirmNumber2 +"입니다."); // 문자내용    
        params.put("app_version", "JAVA SDK v1.2"); // application name and version

        
        // Optional parameters for your own needs
        // params.put("image", "desert.jpg"); // image for MMS. type must be set as "MMS"
        // params.put("image_encoding", "binary"); // image encoding binary(default), base64 
        // params.put("mode", "test"); // 'test' 모드. 실제로 발송되지 않으며 전송내역에 60 오류코드로 뜹니다. 차감된 캐쉬는 다음날 새벽에 충전 됩니다.
        // params.put("delay", "10"); // 0~20사이의 값으로 전송지연 시간을 줄 수 있습니다.
        // params.put("force_sms", "true"); // 푸시 및 알림톡 이용시에도 강제로 SMS로 발송되도록 할 수 있습니다.
        // params.put("refname", ""); // Reference name
        // params.put("country", "KR"); // Korea(KR) Japan(JP) America(USA) China(CN) Default is Korea
        // params.put("sender_key", "5554025sa8e61072frrrd5d4cc2rrrr65e15bb64"); // 알림톡 사용을 위해 필요합니다. 신청방법 : http://www.coolsms.co.kr/AboutAlimTalk
        // params.put("template_code", "C004"); // 알림톡 template code 입니다. 자세한 설명은 http://www.coolsms.co.kr/AboutAlimTalk을 참조해주세요. 
        // params.put("datetime", "20140106153000"); // Format must be(YYYYMMDDHHMISS) 2014 01 06 15 30 00 (2014 Jan 06th 3pm 30 00)
        // params.put("mid", "mymsgid01"); // set message id. Server creates automatically if empty
        // params.put("gid", "mymsg_group_id01"); // set group id. Server creates automatically if empty
        // params.put("subject", "Message Title"); // set msg title for LMS and MMS
        // params.put("charset", "euckr"); // For Korean language, set euckr or utf-8
        // params.put("app_version", "Purplebook 4.1") // 어플리케이션 버전

        try {
          JSONObject obj = (JSONObject) coolsms.send(params);
          System.out.println(obj.toString());
        } catch (CoolsmsException e) {
          System.out.println(e.getMessage());
          System.out.println(e.getCode());
        }
    	
   
	}
    
//---------------------------------------------------------------------------------------------------------------

//-------------------------------------------------이메일 보내기 API--------------------------------------------------
   
    public void MailSend() {
    	
    	String host = "smtp.naver.com";
    	String user = "cssyaksa@naver.com";	// 계정
    	String password = "yaksa2020";			// 패스워드
    	
    	// SMTP 서버 정보를 설정
    	Properties props =new Properties();
    	props.put("mail.smtp.host", host);
    	props.put("mail.smtp.port", 587);
    	props.put("mail.smtp.auth", "true");
    	
    	Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(user, password);
    		}
    	});
    	
    	try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(mail1Tf.getText() + "@" + mail2Tf.getText()));
			
			// 메일 제목
			message.setSubject("안녕하세요");
			
			for(int i = 0; i < 6; i++) {
		        int a =(int)(Math.random()*10);
		        confirmNumber+=a+"";
	        }
			
			// 메일 내용
			message.setText("인증번호는" + confirmNumber +"입니다.");
			
			// 메일 보내기
			Transport.send(message);
			System.out.println("메일 전송 완료!");

    		
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    		
    }
    
//-------------------------------------------------------------------------------------------------------------

//-------------------------------------------------주소찾기 API---------------------------------------------------
   
    public class JavaConnector{
        public void toLowerCase(String zipcode,String addr) {
        
           // kakaozipcode와 연결되어서 webview에 입력된 값을 그대로 가져와 pharmvo에 업데이트 시킨다. 
           // zipcode, add1, add2
           MemberVO memberVO = new MemberVO();
           MemberServiceImpl service = MemberServiceImpl.getInstance();
           zipNumTf.setText(zipcode);
           add1Tf.setText(addr);
           
           memberVO.setMem_zip_code(Integer.parseInt(zipcode));
           memberVO.setMem_add1(addr);
           
           service.updateZipNum(memberVO);
           
        }
     }
    
    private void initFX() {

    	JFrame frame = new JFrame("FX");

    	frame.getContentPane().setLayout(null);

    	final JFXPanel fxPanel = new JFXPanel();

    	frame.add(fxPanel);
    	frame.setVisible(true);

    	fxPanel.setSize(new Dimension(380, 420));
    	fxPanel.setLocation(new Point(0, 27));

    	frame.getContentPane().setPreferredSize(new Dimension(300, 420));
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

    	webView.setMinSize(380, 420);
    	webView.setMaxSize(380, 420);
    	
    	WebEngine webEngine = webView.getEngine();

    	webEngine.load("http://localhost:8081/YakSa_zipCode/memZIp.html");
    	
    	   // kakaozipcode의 webview와 연동되어서 값을 가져오는 부분 
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue)->{
        if(Worker.State.SUCCEEDED==newValue) {
           JSObject window = (JSObject) webEngine.executeScript("window");
           window.setMember("javaConnector", javaConnector);
           javascriptConnector = (JSObject) webEngine.executeScript("getJsConnector()");
        }
        });
        
    }

//-------------------------------------------------------------------------------------------------------------

    
    boolean CheckId;
    
    @FXML
    void CheckId(ActionEvent event) {	// id 중복체크 버튼 클릭시
		try {
		  			  
			MemberServiceImpl service = MemberServiceImpl.getInstance(); 
			MemberVO member = new MemberVO();
			  
			String id = idTf.getText(); 
			  
			int userCheck;

			member.setMem_id(id); 
			userCheck = service.SelectMember(id);
			  
			if(userCheck == 1) { 
				AlertUtil.infoMsg("사용 불가능!", id + "중복 또는 탈퇴한 아이디 입니다!"); 
			}else { 
				AlertUtil.infoMsg("사용 가능!", id + "사용가능한 아이디 입니다!");
			}
		  
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		
		

    }
    
    @FXML
    void MailNumBtn(ActionEvent event) {
    	if(MailNumOk.getText().equals(confirmNumber)) {
            //일치했을때
    		AlertUtil.infoMsg("입력하신 인증번호가 ", "일치합니다!");
        }else {
            //일치하지 않을때
        	AlertUtil.infoMsg("입력하신 인증번호가 ", "일치하지 않습니다.");
        }
    }

    @FXML
    void NotSubmit(ActionEvent event) {	// 취소버튼을 클릭시
    	Stage stage = (Stage) cancleBtn.getScene().getWindow();      
        stage.close();
    }


    @FXML
    void Submit(ActionEvent event) {	// 확인버튼을 클릭시(데이터 전송, 가입완료)
    	RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();	// 선택된 성별
    	
    	// 입력값 받아오기(회원정보)
    	String id = idTf.getText();
    	String pw = pwTf.getText();
    	String pwck = pwCTf.getText();
    	String name = nameTf.getText();
    	String reg1 = reg1Tf.getText();
    	String reg2 = regTf2.getText();
    	String gender = selectedRadioButton.getText();
    	String email1 = mail1Tf.getText();
    	String email2 = mail2Tf.getText();
    	int zipNum = Integer.parseInt(zipNumTf.getText());
    	String add1 = add1Tf.getText();
    	String add2 = add2Tf.getText();
    	String tel = telTf.getText();
    	
    	if(id.isEmpty()||pw.isEmpty()||pwck.isEmpty()||name.isEmpty()||reg1.isEmpty()||reg2.isEmpty()||gender.isEmpty()||email1.isEmpty()||email2.isEmpty()||zipNumTf.isDisable()||add1.isEmpty()||add2.isEmpty()||tel.isEmpty()) {
    		AlertUtil.errorMsg("입력오류", "빈 항목이 있습니다.");
			return;
    	}
    	//if(CheckId == true) {	// ID중복확인이 됐을때 INSERT 진행
    	
    	// 입력값 넣어주기(insert)
    	MemberVO member = new MemberVO();
    	member.setMem_id(id);
    	member.setMem_pw(pw);
    	member.setMem_name(name);
    	member.setMem_regno1(reg1);
    	member.setMem_regno2(reg2);
    	member.setMem_gender(gender);
    	member.setMem_email1(email1);
    	member.setMem_email2(email2);
    	member.setMem_zip_code(zipNum);
    	member.setMem_add1(add1);
    	member.setMem_add2(add2);
    	member.setMem_tel(tel);
	
		
	
    	IMemberService service = MemberServiceImpl.getInstance();
    	service.addMember(member);
    	
    	// 가입완료 알람
    	AlertUtil.infoMsg("작업결과", id + "님의 회원가입이 완료되었습니다.");
    	//}
    }
    
    @FXML
    void TelNumOk(ActionEvent event) {
    	if(nameTf1.getText().equals(confirmNumber2)) {
            //일치했을때
    		AlertUtil.infoMsg("입력하신 인증번호가 ", "일치합니다!");
        }else {
            //일치하지 않을때
        	AlertUtil.infoMsg("입력하신 인증번호가 ", "일치하지 않습니다.");
        }
    }

    @FXML
    void TelOk(ActionEvent event) {	// 전화번호 인증 기능구현
    	sms();   	
    }

    @FXML
    void checkAgree(ActionEvent event) {
    	if(agreeBox.isSelected()) {
    		agreeCheck.setText("");
    		okBtn.setDisable(false);
  	  	}else {
  	  		agreeCheck.setText("약관에 동의해 주세요");
  	  		okBtn.setDisable(true);
  	  	}
    }	
    
    @FXML
    void emailOk(ActionEvent event) {	// 이메일 인증 기능구현
    	MailSend();
    }
    
    @FXML
    void lookZip(ActionEvent event) {	// 우편번호찾기 
    	initFX();
    }

    @FXML
    void initialize() {
    	
// 정규식---------------------------------------------------------------------------------------------------------    	

    	// 아이디
        idTf.textProperty().addListener((Observable, oldValue, newValue) -> {
        	if(!newValue.matches("[A-Za-z0-9_-]{5,20}")) {
        		if(!newValue.matches("\\d*")) {
        			idTf.setText(newValue.replaceAll("[A-Za-z0-9_-]{5,20}", ""));
        			idCheck.setText("5-20자의 영문자와 숫자 사용");
        		}
        	}else if(newValue.matches("[A-Za-z0-9_-]{5,20}")) {
        		idCheck.setText("");
        	}
        });
        
        // 패스워드
        pwTf.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("[A-Za-z0-9_-]{5,20}")) {
    			if(!newValue.matches("\\d*")) {
    				pwTf.setText(newValue.replaceAll("[A-Za-z0-9_-]{5,20}", ""));
    				pwCheck.setText("5-20자의 영문자, 숫자만 가능");
    			}
    		} else if(newValue.matches("[A-Za-z0-9_-]{5,20}")) {
    			pwCheck.setText(" ");
    		}
    	});
        
        // 패스워드 일치
        pwCTf.textProperty().addListener((Observable, oldValue, newValue) -> {
	    	if(!newValue.equals(pwTf.getText())) {
	    		pwSameCheck.setText("비밀번호가 일치하지 않습니다.");	
	    	}else if (newValue.equals(pwTf.getText())) {
	    		pwSameCheck.setText("");	
	    		
	    	}
        });
    	
    	// 이름
        nameTf.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("^[A-Za-z가-힣]*$")) {
    			if(!newValue.matches("\\d*")) {
    				nameTf.setText(newValue.replaceAll("^[A-Za-z가-힣]*$", ""));
    				nameCheck.setText("정확한 이름을 입력해 주세요.");
    			}
    		}else if(newValue.matches("^[A-Za-z가-힣]*$")) {
    			nameCheck.setText(" ");
    		}
    	});
    	
    	// 주민등록번호
    	reg1Tf.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("[0-9]{8}")) {
    			if(!newValue.matches("\\d*")) {
    				reg1Tf.setText(newValue.replaceAll("[0-9]{8}", ""));
    				regCheck.setText("숫자만 입력해 주세요.(ex.19960328)");
    			}
    		}else if(newValue.matches("[0-9]{8}")) {
    			regCheck.setText(" ");
    		}
    	});
    	regTf2.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("[0-9]{7}")) {
    			if(!newValue.matches("\\d*")) {
    				regTf2.setText(newValue.replaceAll("[0-9]{7}", ""));
    				regCheck.setText("숫자만 입력해 주세요.");
    			}
    		}else if(newValue.matches("[0-9]{7}")){
    			regCheck.setText(" ");
    		}
    	});
    	
    	// 전화번호
    	telTf.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("[0-9]{11}")) {
    			if(!newValue.matches("\\d*")) {
    				telTf.setText(newValue.replaceAll("[0-9]{11}", ""));
    				telCheck.setText("숫자만 입력해주세요.");
    			}
    		}else if(newValue.matches("[0-9]{11}")) {
    			telCheck.setText(" ");
    		}
    	});
    	
    	// 패스워드 일치
    	agreeBox.textProperty().addListener((Observable, oldValue, newValue) -> {
	    	if(agreeBox.isSelected()) {
	    		agreeCheck.setText(" ");	
	    	}else {
	    		agreeCheck.setText("약관에 동의해 주세요!");	
	    		
	    	}
        });
    	
    	//agreeCheck.setText(agreeBox.isSelected() ? "동의완료!" : "약관에 동의해 주세요!");

    	
// ---------------------------------------------------------------------------------------------------------------    	

    }
}