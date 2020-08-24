package yaksa.chemist.controller.join;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yaksa.chemist.service.join.ChemistServiceImpl;
import yaksa.chemist.util.AlertUtil;
import yaksa.chemist.vo.join.ChemistVO;

public class ChemistSearchIdController {
	
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
			ChemistServiceImpl service = ChemistServiceImpl.getInstance();
			ChemistVO SearchId = null;
			
			String email1 = mail1Tf.getText();
    		String pname = PnameTf.getText();
    		String name = nameTf.getText();
    		String pnum = PNumTf.getText(); 
    		
    		if(email1.isEmpty()||pname.isEmpty()||name.isEmpty()||pnum.isEmpty()) {
        		AlertUtil.errorMsg("입력오류", "빈 항목이 있습니다.");
    			return;
        	}
    		
    		Map<String, String> searchMap = new HashMap<String, String>();
    		
    		searchMap.put("pharm_chname", name);
    		searchMap.put("pharm_name", pname);
    		searchMap.put("pharm_email1", email1);
    		searchMap.put("pharm_corpor_num", pnum);
    		
    		SearchId = service.SearchChemistId(searchMap);
    		
    		if(SearchId != null) {
    			MimeMessage message = new MimeMessage(session);
    			message.setFrom(new InternetAddress(user));
    			message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(mail1Tf.getText() + "@" + mail2Tf.getText()));
    			
				// 메일 제목
				message.setSubject("안녕하세요");
				
				// 메일 내용
				message.setText("회원님의 아이디는" + SearchId.getPharm_id() + "입니다.");
				
				// 메일 보내기
				Transport.send(message);
				System.out.println("메일 전송 완료!");
    		} else {
    			AlertUtil.infoMsg("메일전송 실패!", name + "님의 일치하는 회원정보가 없습니다.");
    			System.out.println("메일 전송 실패!");
    		}
    		
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    		
    }
    
//-------------------------------------------------------------------------------------------------------------

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button okBtn;

    @FXML
    private Button cancleBtn;

    @FXML
    private TextField PnameTf;

    @FXML
    private TextField nameTf;

    @FXML
    private TextField PNumTf;

    @FXML
    private TextField mail1Tf;

    @FXML
    private TextField mail2Tf;

    @FXML
    void NotSubmit(ActionEvent event) {
    	Stage stage = (Stage) cancleBtn.getScene().getWindow();      
        stage.close();
    }

    @FXML
    void Submit(ActionEvent event) {
    	try {
			ChemistServiceImpl service = ChemistServiceImpl.getInstance();
			ChemistVO chemist = new ChemistVO();
			
			String pharmName = PnameTf.getText();
			String ChemistName = nameTf.getText();
			String PNum = PNumTf.getText();
			
			int loginCheck;
			
			chemist.setPharm_chname(pharmName);
			chemist.setPharm_name(ChemistName);
			chemist.setPharm_corpor_num(PNum);
			loginCheck = service.SearchPharmName(pharmName);
			loginCheck = service.SearchChemistName(ChemistName);
			loginCheck = service.SerchRegChemist(PNum);
			
			if(loginCheck == 1) {
				MailSend();
				AlertUtil.infoMsg("메일전송 완료!", ChemistName + "님의 id를 메일로 전송하였습니다:)");
				((Stage)okBtn.getScene().getWindow()).close(); // 현재창 종료
			}else {
				AlertUtil.infoMsg("메일전송 실패!", ChemistName + "님의 회원정보가 일치하지 않습니다.");				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	// 약국이름
        PnameTf.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("^[A-Za-z가-힣]*$")) {
    			if(!newValue.matches("\\d*")) {
    				PnameTf.setText(newValue.replaceAll("^[A-Za-z가-힣]*$", ""));
    			}
    		}else if(newValue.matches("^[A-Za-z가-힣]*$")) {
    		}
    	});
        
        // 약사이름
        nameTf.textProperty().addListener((Observable, oldValue, newValue) -> {
    		if(!newValue.matches("^[A-Za-z가-힣]*$")) {
    			if(!newValue.matches("\\d*")) {
    				nameTf.setText(newValue.replaceAll("^[A-Za-z가-힣]*$", ""));
    			}
    		}
    	});
    }
}