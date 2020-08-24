package yaksa.chemist.controller.join;

import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import netscape.javascript.JSObject;
import yaksa.chemist.service.join.ChemistServiceImpl;
import yaksa.chemist.service.join.IChemistService;
import yaksa.chemist.util.AlertUtil;
import yaksa.chemist.vo.join.ChemistVO;

public class ChemistJoinController {
	
	private JSObject javascriptConnector;
	private JavaConnector javaConnector = new JavaConnector();

	IChemistService service;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button okBtn;			// 가입완료 버튼 (데이터 전송)

    @FXML
    private Button cancleBtn;		// 취소버튼 (가입 취소)

    @FXML
    private TextField idTf;			// id 입력

    @FXML
    private Button idsameCBtn;		// id 중복체크 확인
    
    @FXML
    private Label idCheck;

    @FXML
    private PasswordField pwTf;		// pw 입력
    
    @FXML
    private Label pwCheck;

    @FXML
    private PasswordField pwCTf;	// pw 일치 확인
    
    @FXML
    private Label pwSameCheck;

    @FXML
    private TextField PnameTf1;		// 약국이름 입력

    @FXML
    private Label PnameCheck;
    
    @FXML
    private TextField CnameTf;		// 약사이름 입력
    
    @FXML
    private Label cNameCheck;

    @FXML
    private TextField reg1Tf;		// 주민번호 앞자리 입력

    @FXML
    private PasswordField regTf2;		// 주민번호 뒷자리 입력
    
    @FXML
    private Label refNumCheck;

    @FXML
    private TextField cheminumTf;	// 약사면허 번호 입력
    
    @FXML
    private Label ChemistNumCheck;

    @FXML
    private TextField ParNumTf;		// 사업자 번호 입력

    @FXML
    private Button ParNumOk;		// 사업자 번호 조회

    @FXML
    private TextField mail1Tf;		// 메일 앞자리 입력

    @FXML
    private TextField mail2Tf;		// 메일 뒷자리 입력

    @FXML
    private Button mailOkBtn;		// 메일 인증
    
    @FXML
    private TextField mailNum;

    @FXML
    private Button mailOK;

    @FXML
    private TextField zipNumTf;		// 우편번호 입력

    @FXML
    private Button lookZipBtn;		// 주소 찾기

    @FXML
    private TextField add1Tf;		// 주소 입력

    @FXML
    private TextField add2Tf;		// 상세주소 입력

    @FXML
    private TextField telTf;		// 전화번호 입력

    @FXML
    private Button TelOk;			// 전화번호 인증
    
    @FXML
    private TextField telNumTf;

    @FXML
    private Button TelNumOk;
    
    @FXML
    private Label TelCheck;

    @FXML
    private CheckBox agreeBox;		// 회원약관 동의
    
    @FXML
    private Label AgreeCheck;
    
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
			message.setText(("인증번호는" + confirmNumber +"입니다."));
			
			// 메일 보내기
			Transport.send(message);
			System.out.println("메일 전송 완료!");

    		
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    		
    }
    
 //-------------------------------------------------------------------------------------------------------------------
    
 //-------------------------------------------------사업자 등록번호 인증 API--------------------------------------------------

	 public void api() {
		try {
			
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=qnaELql83KStqGk%2BxkwKLIG1Eu7fqqqIZFLuzcTnMxMz32A6jnT6XP7SsmQNFN5mil8MoyEFW1j87n2SGpEjLA%3D%3D"); /*Service Key*/
//    	        urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_dg_cd","UTF-8") + "=" + URLEncoder.encode("41", "UTF-8")); /*시도(행정자치부 법정동 주소코드 참조)*/
//    	        urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_sggu_cd","UTF-8") + "=" + URLEncoder.encode("117", "UTF-8")); /*시군구(행정자치부 법정동 주소코드 참조)*/
//    	        urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_sggu_emd_cd","UTF-8") + "=" + URLEncoder.encode("101", "UTF-8")); /*읍면동(행정자치부 법정동 주소코드 참조)*/
	        urlBuilder.append("&" + URLEncoder.encode("wkpl_nm","UTF-8") + "=" + URLEncoder.encode("삼성전자", "UTF-8")); /*사업장명*/
	        urlBuilder.append("&" + URLEncoder.encode("bzowr_rgst_no","UTF-8") + "=" + URLEncoder.encode("124815", "UTF-8")); /*사업자등록번호(앞에서 6자리)*/
//    	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*페이지번호*/
//    	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*행갯수*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    
//-------------------------------------------------------------------------------------------------------------

//-------------------------------------------------주소찾기 API---------------------------------------------------
    
    public class JavaConnector{
        public void toLowerCase(String zipcode,String addr) {
        
           // kakaozipcode와 연결되어서 webview에 입력된 값을 그대로 가져와 pharmvo에 업데이트 시킨다. 
           // zipcode, add1, add2
        	ChemistVO ChemistVO = new ChemistVO();
           ChemistServiceImpl service = ChemistServiceImpl.getInstance();
           zipNumTf.setText(zipcode);
           add1Tf.setText(addr);
           
           ChemistVO.setPharm_zip_code(Integer.parseInt(zipcode));
           ChemistVO.setPharm_add1(addr);
           
           service.updateZipNum(ChemistVO);
           
        }
     }
    
    private void initFX() {

    	JFrame frame = new JFrame("FX");

    	frame.getContentPane().setLayout(null);

    	final JFXPanel fxPanel = new JFXPanel();

    	frame.add(fxPanel);
    	frame.setVisible(true);

    	fxPanel.setSize(new Dimension(300, 300));
    	fxPanel.setLocation(new Point(0, 27));

    	frame.getContentPane().setPreferredSize(new Dimension(300, 327));
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

    @FXML
    void CheckId(ActionEvent event) {
    	try {
			  
    		ChemistServiceImpl service = ChemistServiceImpl.getInstance(); 
			ChemistVO chemist = new ChemistVO();
			  
			String id = idTf.getText(); 
			  
			int userCheck;

			chemist.setPharm_id(id); 
			userCheck = service.SelectChemist(id);
			  
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
    void EmailNumOk(ActionEvent event) {
    	 if(mailNum.getText().equals(confirmNumber)) {
             //일치했을때
             AlertUtil.infoMsg("입력하신 인증번호가 ", "일치합니다!");
         }else {
             //일치하지 않을때
        	 AlertUtil.infoMsg("입력하신 인증번호가 ", "일치하지 않습니다.");
         }

    }

    @FXML
    void NotSubmit(ActionEvent event) {
    	Stage stage = (Stage) cancleBtn.getScene().getWindow();      
        stage.close();
    }
    
    @FXML
    void checkAgree(ActionEvent event) {
    	if(agreeBox.isSelected()) {
    		AgreeCheck.setText("");
    		okBtn.setDisable(false);
  	  	}else {
  	  		AgreeCheck.setText("약관에 동의해 주세요");
  	  		okBtn.setDisable(true);
  	  	}
    }

    @FXML
    void ParNumOk(ActionEvent event) {
    	api();
    }

    @FXML
    void Submit(ActionEvent event) {
    	
    	// 입력값 받아오기(약국정보)
    	String id = idTf.getText();
    	String pw = pwTf.getText();
    	String pwC = pwCTf.getText();
    	String pharmName = PnameTf1.getText();
    	String ChemistName = CnameTf.getText();
    	String reg1 = reg1Tf.getText();
    	String reg2 = regTf2.getText();
    	String CheNum = cheminumTf.getText();
    	String ParNum = ParNumTf.getText();
    	String mail1 = mail1Tf.getText();
    	String mail2 = mail2Tf.getText();
//    	int zipNum = Integer.parseInt(zipNumTf.getText());
    	String add1 = add1Tf.getText();
    	String add2 = add2Tf.getText();
    	String tel = telTf.getText();
    	
    	if(id.isEmpty()||pw.isEmpty()||pwC.isEmpty()||pharmName.isEmpty()||ChemistName.isEmpty()||reg1.isEmpty()||reg2.isEmpty()||CheNum.isEmpty()||ParNum.isEmpty()||mail1.isEmpty()||mail2.isEmpty()||add1.isEmpty()||add2.isEmpty()||tel.isEmpty()) {
			AlertUtil.errorMsg("입력오류", "빈 항목이 있습니다.");
			return;
    	}
    	
    	// 입력값 넣어주기(insert)
    	ChemistVO chemist = new ChemistVO();
    	chemist.setPharm_id(id);
    	chemist.setPharm_pw(pw);
    	chemist.setPharm_name(pharmName);
    	chemist.setPharm_chname(ChemistName);
    	chemist.setPharm_regno1(reg1);
    	chemist.setPharm_regno2(reg2);
    	chemist.setPharm_license_num(CheNum);
    	chemist.setPharm_corpor_num(ParNum);
    	chemist.setPharm_email1(mail1);
    	chemist.setPharm_email2(mail2);
    	chemist.setPharm_zip_code(1);
    	chemist.setPharm_add1(add1);
    	chemist.setPharm_add2(add2);
    	chemist.setPharm_tel(tel);
    	
    	service.addPharm(chemist);
    	
    	Stage stage = (Stage) okBtn.getScene().getWindow();
    	stage.close();
    	
    	// 가입 완료 알람
    	AlertUtil.confirm("작업결과", id + "님의 회원가입이 완료되었습니다.");
    	
    }
    
    @FXML
    void TelNumOk(ActionEvent event) {
    	if(telNumTf.getText().equals(confirmNumber2)) {
            //일치했을때
            AlertUtil.infoMsg("입력하신 인증번호가 ", "일치합니다!");
        }else {
            //일치하지 않을때
       	 AlertUtil.infoMsg("입력하신 인증번호가 ", "일치하지 않습니다.");
        }

    }

    @FXML
    void TelOk(ActionEvent event) {
    	sms(); 
    }

    @FXML
    void emailOk(ActionEvent event) {
    	MailSend();
    }

    @FXML
    void lookZip(ActionEvent event) {
    	initFX();

    }

    @FXML
    void initialize() {
        service = ChemistServiceImpl.getInstance();
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
    	
    	// 약국이름
        PnameTf1.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("^[A-Za-z가-힣]*$")) {
    			if(!newValue.matches("\\d*")) {
    				PnameTf1.setText(newValue.replaceAll("^[A-Za-z가-힣]*$", ""));
    				PnameCheck.setText("정확한 이름을 입력해 주세요.");
    			}
    		}else if(newValue.matches("^[A-Za-z가-힣]*$")) {
    			PnameCheck.setText(" ");
    		}
    	});
        
        // 약사이름
        CnameTf.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("^[A-Za-z가-힣]*$")) {
    			if(!newValue.matches("\\d*")) {
    				CnameTf.setText(newValue.replaceAll("^[A-Za-z가-힣]*$", ""));
    				cNameCheck.setText("정확한 이름을 입력해 주세요.");
    			}
    		}else if(newValue.matches("^[A-Za-z가-힣]*$")) {
    			cNameCheck.setText(" ");
    		}
    	});
        
     // 주민등록번호
    	reg1Tf.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("[0-9]{8}")) {
    			if(!newValue.matches("\\d*")) {
    				reg1Tf.setText(newValue.replaceAll("[0-9]{8}", ""));
    				refNumCheck.setText("숫자만 입력해 주세요.(ex.19960328)");
    			}
    		}else if(newValue.matches("[0-9]{8}")) {
    			refNumCheck.setText(" ");
    		}
    	});
    	regTf2.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("[0-9]{7}")) {
    			if(!newValue.matches("\\d*")) {
    				regTf2.setText(newValue.replaceAll("[0-9]{7}", ""));
    				refNumCheck.setText("숫자만 입력해 주세요.");
    			}
    		}else if(newValue.matches("[0-9]{7}")){
    			refNumCheck.setText(" ");
    		}
    	});
    	
    	// 약사면허번호
    	cheminumTf.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("[0-9]{8}")) {
    			if(!newValue.matches("\\d*")) {
    				cheminumTf.setText(newValue.replaceAll("[0-9]{8}", ""));
    				ChemistNumCheck.setText("숫자만 입력해 주세요.(ex.19960328)");
    			}
    		}else if(newValue.matches("[0-9]{8}")) {
    			ChemistNumCheck.setText(" ");
    		}
    	});
    	
		// 전화번호
		telTf.textProperty().addListener((Observable, oldValue, newValue) -> {
			if(!newValue.matches("[0-9]{11}")) {
				if(!newValue.matches("\\d*")) {
					telTf.setText(newValue.replaceAll("[0-9]{11}", ""));
					TelCheck.setText("숫자만 입력해주세요.");
				}
			}else if(newValue.matches("[0-9]{11}")) {
				TelCheck.setText(" ");
			}
		});
    	
// ---------------------------------------------------------------------------------------------------------------    	

        

    }
}

