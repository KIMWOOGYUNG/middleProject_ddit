package yaksa.chemist.controller.join;

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
import yaksa.chemist.controller.main.MainController;
import yaksa.chemist.service.join.ChemistServiceImpl;
import yaksa.chemist.util.AlertUtil;
import yaksa.chemist.vo.join.ChemistVO;
import yaksa.chemist.vo.join.SessionVO;

public class ChemistLoginController {
	static boolean login_state = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField idTf;

    @FXML
    private Button loginBtn;

    @FXML
    private Button JoinBtn;

    @FXML
    private Button lookIdBtn;

    @FXML
    private Button lookPwBtn;

    @FXML
    private PasswordField pwTf;
    
    @FXML
    private Button close;

    @FXML
    void exit(ActionEvent event) {
    	Stage stage = (Stage) close.getScene().getWindow();      
        stage.close();
    }

    @FXML
    void Join(ActionEvent event) {
    	try {
			
    		Stage dialog = new Stage();
    		Parent childRoot = FXMLLoader.load(ChemistLoginController.class.getResource("../../fxml/join/Agree.fxml"));
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
    void Login(ActionEvent event) {
    	
    	try {
			ChemistServiceImpl service = ChemistServiceImpl.getInstance();
			ChemistVO chemist = new ChemistVO();
			ChemistVO loginChemist = null;
			
			String id = idTf.getText();
			String pw = pwTf.getText();
			
//			int loginCheck;
//			
			chemist.setPharm_id(id);
			chemist.setPharm_pw(pw);
//			loginCheck = service.SelectChemist(id);
//			loginCheck = service.LoginChemist(pw);
			
			Map<String, String> searchMap = new HashMap<String, String>();
			
			searchMap.put("pharm_id", id);
			searchMap.put("pharm_pw", pw);
			
			loginChemist = service.getChemist(searchMap);
			
			if(loginChemist != null) {
				
				//세션에 저장
				if(SessionVO.loginChemist != null) {
					login_state = true;
				}
				
				SessionVO.loginChemist = loginChemist;

				AlertUtil.infoMsg("로그인 성공!", id + "님 반갑습니다:)");
				System.out.println("***"+SessionVO.loginChemist);
				MainController.cheVO = loginChemist;
				Stage dialog = new Stage();
				FXMLLoader insert = new FXMLLoader(ChemistLoginController.class.getResource("../../fxml/main/Main.fxml"));
				
				Parent childRoot = insert.load();
				dialog.initStyle(StageStyle.TRANSPARENT);
				Scene childScene = new Scene(childRoot);
				childScene.setFill(Color.TRANSPARENT);
				
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
    void LookId(ActionEvent event) {
    	try {
    		
	    	Stage dialog = new Stage();
			Parent childRoot = FXMLLoader.load(ChemistLoginController.class.getResource("../../fxml/join/SearchChemistId.fxml"));
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
    void LookPwd(ActionEvent event) {
    	try {
    		
	    	Stage dialog = new Stage();
			Parent childRoot = FXMLLoader.load(ChemistLoginController.class.getResource("../../fxml/join/SearchChemistPw.fxml"));
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
    void initialize() {

    }
}
