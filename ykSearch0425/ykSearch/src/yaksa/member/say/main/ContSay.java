package yaksa.member.say.main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import yaksa.member.say.service.SayServiceImpl;
import yaksa.member.say.vo.SayVO;

public class ContSay {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label LBSay;

    @FXML
    private Label LBCelebrity;

    @FXML
    private Button PreBtn;

    @FXML
    private Button NextBtn;

    @FXML
    void NextPage(ActionEvent event) {

    }

    @FXML
    void PrevPage(ActionEvent event) {

    }

    private SayVO svo = null;
    private SayServiceImpl service = null;
    
    @FXML
    void initialize() {
    	svo = new SayVO();
    	service = SayServiceImpl.getInstance();
    	
    	List<SayVO> sList = new ArrayList<>();
    	
    	sList = service.getAllSay();
    	
    		LBSay.setText(sList.get(0).getSay_famous());
    		LBCelebrity.setText(sList.get(0).getSay_man());
    	
    		
    		

    }
}
