package yaksa.member.controller.join;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.member.calendar.join.GNCalendarTile;
import yaksa.member.vo.join.MemberVO;

public class MemMainController {
	
	static MemberVO memVO;
	
//	public void login(MemberVO memVO) {
//       this.memVO = memVO;
//       // main에서 선택된 정보를 가지고 와서 정보를 보여준다.     
//       
//       namelb.setText(memVO.getMem_name()); 
//    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane outerBoarderPane;

    @FXML
    private BorderPane innerBoardPane;
    
    @FXML
    private Button logout;

    @FXML
    private Button close;

    @FXML
    private Label namelb;

    @FXML
    private Button calendar;
    
    
    @FXML
    private StackPane btnCalendar;
    
    
    @FXML
    void CloseBtn(ActionEvent event) {
    	Stage stage = (Stage) close.getScene().getWindow();      
        stage.close();
    }
    
    @FXML
    void calendarClick(ActionEvent event) {
    	try {
	    	Stage dialog = new Stage();
			Parent childRoot = FXMLLoader.load(MemMainController.class.getResource("../../fxml/join/calendar.fxml"));
			dialog.initStyle(StageStyle.TRANSPARENT); 
			Scene childScene = new Scene(childRoot);
			childScene.setFill(Color.TRANSPARENT);	
			
			dialog.setScene(childScene);
			dialog.setTitle("calendar");
			dialog.showAndWait();
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void logoutBtn(ActionEvent event) {
    	Stage stage = (Stage) close.getScene().getWindow();      
        stage.close();
    }

    @FXML
    void initialize() {
    	if(MemMainController.memVO!=null) {
    		namelb.setText(memVO.getMem_name());
    	}else {
    		namelb.setText("");
    	}
    	
    	GNCalendarTile calendar = new GNCalendarTile();
    	
    	btnCalendar.getChildren().add(calendar);
    	
    	
    	
    }
}
