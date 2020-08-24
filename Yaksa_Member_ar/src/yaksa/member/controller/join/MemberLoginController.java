package yaksa.member.controller.join;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.member.server.join.MemberServiceImpl;
import yaksa.member.vo.join.MemberVO;
import yaksa.util.AlertUtil;

public class MemberLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField idTf;		// id 입력란

    @FXML
    private Button loginBtn;	// 로그인 버튼

    @FXML
    private Button JoinBtn;		// 회원가입 버튼

    @FXML
    private Button lookIdBtn;	// id찾기 버튼

    @FXML
    private Button lookPwBtn;	// pw찾기 버튼

    @FXML
    private PasswordField pwTf;	// pw 입력란
    
    @FXML
    private Button close;

    @FXML
    void CloseBtn(ActionEvent event) {
    	Stage stage = (Stage) close.getScene().getWindow();      
        stage.close();
    }
    
    @FXML
    void Join(ActionEvent event) {		// 회원가입 창 불러오기
    	try {
			
    		Stage dialog = new Stage();
    		Parent childRoot = FXMLLoader.load(MemberLoginController.class.getResource("../../fxml/join/Agree.fxml"));
    		dialog.initStyle(StageStyle.TRANSPARENT); //
    		Scene childScene = new Scene(childRoot);
    		childScene.setFill(Color.TRANSPARENT);	//
    		
    		dialog.setScene(childScene);
    		dialog.setTitle("약관동의");
    		dialog.showAndWait();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void Login(ActionEvent event) {		// 로그인 하기
		
		try {
			MemberServiceImpl service = MemberServiceImpl.getInstance(); 
			MemberVO mem = new MemberVO();
			MemberVO loginMember = null ;
			  
			String id = idTf.getText();
			String pw = pwTf.getText();
			
//			int loginCheck;
			
			mem.setMem_id(id);
			mem.setMem_pw(pw);
//			loginCheck = service.SelectMember(id);
//			loginCheck = service.LoginMember(pw);
//			
			Map<String,String> searchMap = new HashMap<String, String>();
			
			searchMap.put("mem_pw",pw);
			searchMap.put("mem_id",id);
			
			loginMember = service.getMember(searchMap);
			
			if(loginMember!=null) {
//			if(loginCheck == 1) {
				AlertUtil.infoMsg("로그인 성공!", id + "님 반갑습니다:)");
				MemMainController.memVO = loginMember;
				Stage dialog = new Stage();
				FXMLLoader insert = new FXMLLoader(MemberLoginController.class.getResource("../../fxml/join/Main.fxml"));
				
				Parent childRoot = insert.load();
				dialog.initStyle(StageStyle.TRANSPARENT); //
	    		Scene childScene = new Scene(childRoot);
	    		childScene.setFill(Color.TRANSPARENT);	//
				
//				MemMainController main = insert.getController();
//				main.login(member);
				
				dialog.setScene(childScene);
				dialog.setTitle("Main");
				dialog.showAndWait();
				
			}else {
				AlertUtil.infoMsg("로그인 실패!", id + "아이디 또는 패스워드를 확인해 주세요!"); 
			}
			
			
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		 
    }

    @FXML
    void LookId(ActionEvent event) {	// 아이디 찾기 구현
    	try {
    		
	    	Stage dialog = new Stage();
			Parent childRoot = FXMLLoader.load(MemberLoginController.class.getResource("../../fxml/join/SearchMemId.fxml"));
			dialog.initStyle(StageStyle.TRANSPARENT); //
    		Scene childScene = new Scene(childRoot);
    		childScene.setFill(Color.TRANSPARENT);	//
			
			dialog.setScene(childScene);
			dialog.setTitle("아이디 찾기");
			dialog.showAndWait();
			
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    	
    }

    @FXML
    void LookPwd(ActionEvent event) {	// 비밀번호 찾기 구현
    	try {
    		
	    	Stage dialog = new Stage();
			Parent childRoot = FXMLLoader.load(MemberLoginController.class.getResource("../../fxml/join/SearchMemPw.fxml"));
			dialog.initStyle(StageStyle.TRANSPARENT); //
    		Scene childScene = new Scene(childRoot);
    		childScene.setFill(Color.TRANSPARENT);	//
			
			dialog.setScene(childScene);
			dialog.setTitle("비밀번호 찾기");
			dialog.showAndWait();
			
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	

    }
}
