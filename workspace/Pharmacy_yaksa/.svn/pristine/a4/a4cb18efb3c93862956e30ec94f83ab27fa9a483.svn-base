package yaksa.chemist.controller.join;

import java.net.URL;
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

public class ChemistSearchPwController {
   
   private static String confirmNumber ="";
   
   //-------------------------------------------------이메일 보내기 API--------------------------------------------------
      
    public void MailSend() {
       
       String host = "smtp.naver.com";
       String user = "cssyaksa@naver.com";   // 계정
       String password = "yaksa2020";         // 패스워드
       
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
         message.setText("임시비밀번호는 " + confirmNumber + "입니다.");
         
         // 메일 보내기
         Transport.send(message);
         System.out.println("메일 전송 완료!");

          
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
    private Button okBtn;      // 이메일 전송 버튼

    @FXML
    private Button cancleBtn;   // 취소 버튼

    @FXML
    private TextField idTf;      // id 입력

    @FXML
    private TextField PnameTf;   // 약국이름 입력

    @FXML
    private TextField CnameTf;   // 약사이름 입력

    @FXML
    private TextField PNumTf;   // 사업자등록번호 입력

    @FXML
    private TextField mail1Tf;   // 이메일 입력

    @FXML
    private TextField mail2Tf;   // 이메일입력

    @FXML
    void NotSubmit(ActionEvent event) {   // 취소 버튼
       Stage stage = (Stage) cancleBtn.getScene().getWindow();      
        stage.close();
    }

    @FXML
    void Submit(ActionEvent event) {   // 이메일 전송 버튼
       try {
          
         ChemistServiceImpl service = ChemistServiceImpl.getInstance();
         ChemistVO chemist = new ChemistVO();
         
         String id = idTf.getText();
         String pharmName = PnameTf.getText();
         String ChemistName = CnameTf.getText();
         String PNum = PNumTf.getText();
         String email1 = mail1Tf.getText();
         String email2 = mail2Tf.getText();
         
         if(id.isEmpty()||pharmName.isEmpty()||ChemistName.isEmpty()||PNum.isEmpty()||email1.isEmpty()||email2.isEmpty()) {
              AlertUtil.errorMsg("입력오류", "빈 항목이 있습니다.");
             return;
           }
         
         int loginCheck;
         
         chemist.setPharm_id(id);
         chemist.setPharm_chname(pharmName);
         chemist.setPharm_name(ChemistName);
         chemist.setPharm_corpor_num(PNum);
         loginCheck = service.SearchPharmName(pharmName);
         loginCheck = service.SearchChemistName(ChemistName);
         loginCheck = service.SerchRegChemist(PNum);
         
         if(loginCheck == 1) {
            MailSend();
            AlertUtil.infoMsg("메일전송 완료!", ChemistName + "님의 임시비밀번호를 메일로 전송하였습니다:)");
            // 이메일을 전송하면 사용자의 비밀번호가 임시비밀번호로 바뀐다.
            chemist.setPharm_pw(confirmNumber);
            service.ModifyPw(chemist);
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
       // 아이디
        idTf.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!newValue.matches("[A-Za-z0-9_-]{5,20}")) {
              if(!newValue.matches("\\d*")) {
                 idTf.setText(newValue.replaceAll("[A-Za-z0-9_-]{5,20}", ""));
              }
           }else if(newValue.matches("[A-Za-z0-9_-]{5,20}")) {
           }
        });
        
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
        CnameTf.textProperty().addListener((Observable, oldValue, newValue) -> {
          if(!newValue.matches("^[A-Za-z가-힣]*$")) {
             if(!newValue.matches("\\d*")) {
                CnameTf.setText(newValue.replaceAll("^[A-Za-z가-힣]*$", ""));
             }
          }
       });

    }
}