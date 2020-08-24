package yaksa.member.controller.main;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.member.controller.mypage.a1Controller;
import yaksa.member.vo.join.MemberVO;
import yaksa.member.vo.join.SessionVO;

public class MainController {

	public static MemberVO memVO;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane outerBoarderPane;

    @FXML
    private ImageView logo;

    @FXML
    private Label labelMenu;

    @FXML
    private Button btnFindPharm;

    @FXML
    private Button btnShowPres;

    @FXML
    private Button btnShowReceipt;

    @FXML
    private Button btnSearchMedi;

    @FXML
    private BorderPane innerBoardPane;

    @FXML
    private ImageView btnChatting;

    @FXML
    private Button btnMypage;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnCalendar;

    @FXML
    private Button btnSchedule;

    @FXML
    private Button btnFamousSaying;

    @FXML
    private Button btnMap;
    
    @FXML
    private Pane topPane;
    
    @FXML
    private Pane centerPane;
    
    @FXML
    private Label lblTime;
    
    @FXML
    private Label namelb;

    @FXML
    void calendar(ActionEvent event) {

    }

    @FXML
    void chatting(MouseEvent event) {

    }

    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage) btnClose.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void famousSaying(ActionEvent event) {

    }

    @FXML
    void findPharm(ActionEvent event) {
    	try {
			Parent childroot = FXMLLoader.load(getClass().getResource("/yaksa/member/fxml/map/YKSearch.fxml"));
    		outerBoarderPane.setCenter(childroot);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	labelMenu.setText("약국 찾기");
    }
    
    @FXML
    void gotoMain(MouseEvent event) {
    	try {
			Parent childroot = FXMLLoader.load(getClass().getResource("/yaksa/member/fxml/main/MainCenter.fxml"));
    		outerBoarderPane.setCenter(childroot);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	labelMenu.setText("Main Page");
    }

    @FXML
    void logout(ActionEvent event) {
    	SessionVO.loginMember = null;
    	Stage stage = (Stage) btnClose.getScene().getWindow();      
        stage.close();
    }

    @FXML
    void mypage(ActionEvent event) {
    	try {
    		Stage parentStage =(Stage)btnMypage.getScene().getWindow();
    		
    		Stage myPageStage = new Stage(StageStyle.TRANSPARENT);
    		myPageStage.initModality(Modality.WINDOW_MODAL);
    		myPageStage.initOwner(parentStage);
    		
    		FXMLLoader loader = new FXMLLoader(
    				getClass().getResource("/yaksa/member/fxml/mypage/a1_pMyPage.fxml")
    				);
    		Parent addRoot = loader.load();
    		
    		a1Controller myPageController = loader.getController();
    		
    		myPageController.setMainConterolloer(this);
    		
    		Scene scene = new Scene(addRoot);
    		scene.setFill(Color.TRANSPARENT);
    		myPageStage.setScene(scene);
    		myPageStage.setTitle("추가");
    		myPageStage.show();
	    	
    	} catch(IOException e) {
    		e.printStackTrace();    		
    	}

    }


    @FXML
    void searchMedi(ActionEvent event) {
    	try {
			Parent childroot = FXMLLoader.load(getClass().getResource("/yaksa/member/fxml/pillSearch/SearchPill.fxml"));
    		outerBoarderPane.setCenter(childroot);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	labelMenu.setText("약 검색");
    }

    @FXML
    void showPres(ActionEvent event) {
    	try {
			Parent childroot = FXMLLoader.load(getClass().getResource("/yaksa/member/fxml/prescription/Prescription.fxml"));
    		outerBoarderPane.setCenter(childroot);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	labelMenu.setText("처방전 보기");
    }

    @FXML
    void showReceipt(ActionEvent event) {
    	try {
			Parent childroot = FXMLLoader.load(getClass().getResource("/yaksa/member/fxml/prescription/Receipt.fxml"));
    		outerBoarderPane.setCenter(childroot);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	labelMenu.setText("영수증 보기");
    }

    @FXML
    void initialize() {
    	// ~님 환영합니다 부분
    	if(MainController.memVO!=null) {
    		namelb.setText(memVO.getMem_name());
    	}else {
    		namelb.setText("");
    	}
    	
    	try {
			Parent childroot = FXMLLoader.load(getClass().getResource("/yaksa/member/fxml/main/MainCenter.fxml"));
    		outerBoarderPane.setCenter(childroot);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	Thread th = new Thread() {
    		@Override
    		public void run() {
    			//시간 출력 형식 설정
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			
    			while(true) {
    				//현재 시스템의 시간 정보를 가져와 시간 출력 형식에 맞는 문자열을 구한다.
    				String strTime = sdf.format(new Date());
    				
    				//일반 쓰레드에서 javaFX의 UI컨트롤의 내용을 변경하려면
    				//Platform.runLater()메서드를 이용해서 출력해야 한다.
    				//이 메서드에는 Runnable인터페이스를 구현한 구현체가 매개값으로 들어간다.
    				
    				Platform.runLater(() -> {	//매개변수 없음
    					//이 영역에 UI컨트롤을 변경하는 명령을 사용한다.
    					lblTime.setText(strTime);
    				});			
    				
    				try {Thread.sleep(100);} catch (InterruptedException e) {}
    			}
    		}
    	};//쓰레드 끝...
    	th.setDaemon(true);
    	th.start();
    }
}
