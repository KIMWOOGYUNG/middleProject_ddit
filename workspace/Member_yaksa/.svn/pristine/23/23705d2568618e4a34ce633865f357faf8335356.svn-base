package yaksa.member.controller.join;

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
import yaksa.member.service.join.MemberServiceImpl;
import yaksa.member.util.prescription.AlertUtil;
import yaksa.member.vo.join.MemberVO;


public class MemberSearchPwController {
   
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
    private Button okBtn;      // 메일전송 버튼

    @FXML
    private Button cancleBtn;   // 취소 버튼

    @FXML
    private TextField nameTf1;   // id 입력

    @FXML
    private TextField nameTf;   // 이름 입력

    @FXML
    private TextField reg1Tf;   // 생년월일 입력

    @FXML
    private TextField mail1Tf;   // 이메일 입력

    @FXML
    private TextField mail2Tf;   // 이메일 입력

    @FXML
    void NotSubmit(ActionEvent event) {   // 취소버튼
       Stage stage = (Stage) cancleBtn.getScene().getWindow();      
        stage.close();
    }

    @FXML
    void Submit(ActionEvent event) {   // 메일전송버튼
       try {
         MemberServiceImpl service = MemberServiceImpl.getInstance();
         MemberVO member = new MemberVO();
         
         String id = nameTf1.getText();
         String name = nameTf.getText();
         String reg = reg1Tf.getText();
         String mail1 = mail1Tf.getText();
         String mail2 = mail2Tf.getText();
         
         if(id.isEmpty()||name.isEmpty()||reg.isEmpty()||mail1.isEmpty()||mail2.isEmpty()) {
              AlertUtil.errorMsg("입력오류", "빈 항목이 있습니다.");
             return;
           }
         
         int loginCheck;
         
         member.setMem_id(id);
         member.setMem_name(name);
         member.setMem_regno1(reg);
         loginCheck = service.SearchNameMember(name);
         loginCheck = service.SearchRegMember(reg);
         
         if(loginCheck == 1) {
            MailSend();
            AlertUtil.infoMsg("메일전송 완료!", id + "님의 임시비밀번호를 메일로 전송하였습니다:)");
            // 이메일을 전송하면 사용자의 비밀번호가 임시비밀번호로 바뀐다.
            member.setMem_pw(confirmNumber);
            service.ModifyPw(member);
            ((Stage)okBtn.getScene().getWindow()).close(); // 현재창 종료
            
         }else {
            AlertUtil.infoMsg("메일전송 실패!", id + "님의 회원정보가 일치하지 않습니다.");
         }
         
         
      } catch (Exception e) {
         e.printStackTrace();
      }
    }

    @FXML
    void initialize() {
       // 아이디
       nameTf1.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!newValue.matches("[A-Za-z0-9_-]{5,20}")) {
              if(!newValue.matches("\\d*")) {
                 nameTf1.setText(newValue.replaceAll("[A-Za-z0-9_-]{5,20}", ""));
              }
           }
        });
       
       // 이름
        nameTf.textProperty().addListener((Observable, oldValue, newValue) -> {
          if(!newValue.matches("^[A-Za-z가-힣]*$")) {
             if(!newValue.matches("\\d*")) {
                nameTf.setText(newValue.replaceAll("^[A-Za-z가-힣]*$", ""));
             }
          }
       });
        
        // 생년월일
        reg1Tf.textProperty().addListener((Observable, oldValue, newValue) -> {
          if(!newValue.matches("[0-9]{6}")) {
             if(!newValue.matches("\\d*")) {
                reg1Tf.setText(newValue.replaceAll("[0-9]{6}", ""));
             }
          }
       });


    }
}