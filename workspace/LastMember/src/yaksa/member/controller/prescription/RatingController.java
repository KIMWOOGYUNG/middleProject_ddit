package yaksa.member.controller.prescription;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.controlsfx.control.Rating;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import yaksa.member.service.join.MemberServiceImpl;
import yaksa.member.service.prescription.MemServiceImpl;
import yaksa.member.vo.prescription.Mem_InboxVO;


public class RatingController implements Initializable {
	static String rate;
	Mem_InboxVO selectedVO;
	
	Mem_InboxVO mvo;
	
	@FXML
	Rating rating;
	
	@FXML 
	Label msg;
	
	@FXML
	Button btnOk;
	
	@FXML
	void ok(ActionEvent event) {
		
		Map<String, String> amap = new HashMap<String,String>();
		
		
		
		System.out.println(msg.getText());
		System.out.println(selectedVO.getInbox_file());
		
		amap.put("a", rate);
		amap.put("b", selectedVO.getInbox_file());			
		
		MemServiceImpl.getInstance().updateRate(amap);
		
		
		Stage stage = (Stage) btnOk.getScene().getWindow();
    	stage.close();
    	
    	
	}
	
	void setVO(Mem_InboxVO mvo) {
		selectedVO = mvo;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		rating.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
              msg.setText(t1.toString() + "점");
      		  rate = t1.toString();
            }
        });
		
        		
	}

}
