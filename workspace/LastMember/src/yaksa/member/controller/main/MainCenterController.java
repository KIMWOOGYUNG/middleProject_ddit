package yaksa.member.controller.main;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.member.controller.join.MemMainController;
import yaksa.member.main.main.calendar.GNCalendarTile;
import yaksa.member.service.say.SayServiceImpl;
import yaksa.member.vo.join.SessionVO;
import yaksa.member.vo.say.SayVO;

public class MainCenterController {
	
	
	private SayVO svo = null;
	private SayServiceImpl service = null;
	private List<SayVO> sList = null;
	
	int i;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane centerPane;

    @FXML
    private Button btnCalendar;
    
    @FXML
    private StackPane Calendar;

    @FXML
    private Button btnSchedule;

    @FXML
    private Button btnMap;
    

    @FXML
    private ImageView mapImg;
    
    @FXML
	private Label LBSay;

	@FXML
	private Label LBCelebrity;

	@FXML
	private Button PreBtn;

	@FXML
	private Button NextBtn;
	
	@FXML
    private AnchorPane MemoP;
	
	@FXML
	private Label nameLb;
	
	@FXML
    private Label daylb;

    @FXML
    private Label monthlb;

    @FXML
    private Label daylylb;

    @FXML
    private Label daylb2;

    @FXML
    void MapView(MouseEvent event) {
    	try {
			Parent childRoot = FXMLLoader.load(MemMainController.class.getResource("../../fxml/map/YKSearch.fxml"));
			((BorderPane)btnMap.getScene().getRoot()).setCenter(childRoot);
    	} catch (Exception e) {
			e.printStackTrace();
		}

    	
    }

    @FXML
    void calendar(ActionEvent event) {
//    	try {
//    		Stage dialog = new Stage();
//			Parent childRoot = FXMLLoader.load(MemMainController.class.getResource("../../fxml/join/calendar.fxml"));
//			dialog.initStyle(StageStyle.TRANSPARENT); 
//			Scene childScene = new Scene(childRoot);
//			childScene.setFill(Color.TRANSPARENT);	
//			
//			dialog.setScene(childScene);
//			dialog.setTitle("calendar");
//			dialog.showAndWait();
//    	} catch (Exception e) {
//			e.printStackTrace();
//		}
    }

    @FXML
    void map(ActionEvent event) {
    	try {
			Parent childRoot = FXMLLoader.load(MemMainController.class.getResource("../../fxml/map/YKSearch.fxml"));
			((BorderPane)btnMap.getScene().getRoot()).setCenter(childRoot);
    	} catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    @FXML
	void NextPage(ActionEvent event) {
		i++;
		if(i==sList.size()-1) {
			i = 0;
		}
		LBSay.setText(sList.get(i).getSay_famous());
		LBCelebrity.setText(sList.get(i).getSay_man());
		
	}

	@FXML
	void PrevPage(ActionEvent event) {
		i--;
		
		if(i<0) {
			i = sList.size()-1;
		}
		LBSay.setText(sList.get(i).getSay_famous());
		LBCelebrity.setText(sList.get(i).getSay_man());
	}

    @FXML
    void initialize() {
    	
    	GNCalendarTile btnCalendar = new GNCalendarTile();
    	
    	Calendar.getChildren().add(btnCalendar);
    	
    	svo = new SayVO();
		service = SayServiceImpl.getInstance();
		sList = service.getAllSay();
		i = 0;
		System.out.println(sList.get(i).getSay_famous());
		LBSay.setText(sList.get(i).getSay_famous());
		LBCelebrity.setText(sList.get(i).getSay_man());
		
		//스케줄
		if(MainController.memVO!=null) {
			System.out.println(111);
			System.out.println(MainController.memVO.getMem_name());
    		nameLb.setText(MainController.memVO.getMem_name());
    	}
		
		Date d = new Date();
		int month = d.getMonth() + 1;
		int date = d.getDate();
		int day2 = d.getDay();	//요일(숫자)
		String day = null;
		
		monthlb.setText(Integer.toString(month));
		daylylb.setText(Integer.toString(date));
		if(day2 == 1) {
			day = "월";
		}else if(day2 == 2){
			day = "화";
		}else if(day2 == 3){
			day = "수";
		}else if(day2 == 4){
			day = "목";
		}else if(day2 == 5){
			day = "금";
		}else if(day2 == 6){
			day = "토";
		}else if(day2 == 0){
			day = "일";
		}
		daylb2.setText(day);
		
		String regno = SessionVO.loginMember.getMem_regno1().substring(1,2);
		System.out.println(regno);
		
		if(regno.equals("1") || regno.equals("6")) {
			daylb.setText("월");
		}else if(regno.equals("2") || regno.equals("7")){
			daylb.setText("화");
		}else if(regno.equals("3") || regno.equals("8")){
			daylb.setText("수");
		}else if(regno.equals("4") || regno.equals("9")){
			daylb.setText("목");
		}else if(regno.equals("5") || regno.equals("0")){
			daylb.setText("금");
		}

//		
//		@FXML
//	    private Label daylb;

		

    	
    }
}
