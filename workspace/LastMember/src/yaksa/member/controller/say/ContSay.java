package yaksa.member.controller.say;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import yaksa.member.service.say.SayServiceImpl;
import yaksa.member.vo.say.SayVO;

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
	
	private SayVO svo = null;
	private SayServiceImpl service = null;
	private List<SayVO> sList = null;

	int i;
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
//		LBSay.setText(sList.get(h).getSay_famous());
//		LBCelebrity.setText(sList.get(h).getSay_man());
		i--;
		
		if(i<0) {
			i = sList.size()-1;
		}
		LBSay.setText(sList.get(i).getSay_famous());
		LBCelebrity.setText(sList.get(i).getSay_man());
	}
	
	@FXML
	void initialize() {
		svo = new SayVO();
		service = SayServiceImpl.getInstance();
		sList = service.getAllSay();
		i = 0;
		LBSay.setText(sList.get(i).getSay_famous());
		LBCelebrity.setText(sList.get(i).getSay_man());
	}
}
