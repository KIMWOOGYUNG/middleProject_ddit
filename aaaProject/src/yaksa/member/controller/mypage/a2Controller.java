package yaksa.member.controller.mypage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.member.service.mypage.MemServiceImpl;
import yaksa.member.vo.mypage.MemVo;

public class a2Controller {
	public void setMainConterolloer(a1Controller a1Controller) {
		// TODO Auto-generated method stub
		
	}


    @FXML
    private URL location;

    @FXML
    private Button Btn_Delete;

    @FXML
    private PasswordField Pw_Delete;
    
    @FXML
    private Text pw_wrong;

    MemVo memVo = new MemVo();
    MemServiceImpl service = null; 
    
    @FXML
    void btnDeleteClick(ActionEvent event) {
    	String pw_del = Pw_Delete.getText();
    	
    	 service = service.getInstance();
         List<MemVo> memList = service.getAllMember();
         memVo = memList.get(0);
    	
    	
    		
    		
    		String available = "1";
    	if(memVo.getMem_pw().equals(pw_del)) {
    		
    		memVo.setMem_available(available);
    		service.updateMember(memVo);
    		
    		try {
        		Stage parentStage =(Stage)Btn_Delete.getScene().getWindow();
        		
        		Stage deleteCanle = new Stage(StageStyle.TRANSPARENT);
        		deleteCanle.initModality(Modality.WINDOW_MODAL);
        		deleteCanle.initOwner(parentStage);
        		
        		FXMLLoader loader = new FXMLLoader(
        				a2Controller.class.getResource("../../fxml/mypage/a222_IdDelet.fxml")
        				);
        		
        		Parent addRoot = loader.load();
        		
        		a222Controller myPageController = loader.getController();
        		
        		myPageController.setMainConterolloer(this);
        		
        		Scene scene = new Scene(addRoot);
        		scene.setFill(Color.TRANSPARENT);
        		deleteCanle.setScene(scene);
        		deleteCanle.setTitle("추가");
        		deleteCanle.show();
    	    	
        	} catch(IOException e) {
        		e.printStackTrace();    		
        	}
    	
    		
    	
    	}else {
    		Pw_Delete.clear();
    		
    		try {
        		Stage parentStage =(Stage)Btn_Delete.getScene().getWindow();
        		
        		Stage deleteCanle = new Stage(StageStyle.TRANSPARENT);
        		deleteCanle.initModality(Modality.WINDOW_MODAL);
        		deleteCanle.initOwner(parentStage);
        		
        		FXMLLoader loader = new FXMLLoader(
        				a2Controller.class.getResource("../../fxml/mypage/a22_IdDelet.fxml")
        				);
        		
        		Parent addRoot = loader.load();
        		
        		a22Controller myPageController = loader.getController();
        		
        		myPageController.setMainConterolloer(this);
        		
        		Scene scene = new Scene(addRoot);
        		scene.setFill(Color.TRANSPARENT);
        		deleteCanle.setScene(scene);
        		deleteCanle.setTitle("추가");
        		deleteCanle.show();
    	    	
        	} catch(IOException e) {
        		e.printStackTrace();    		
        	}
    	}
    	
    	
    
    	
    }

    @FXML
    void initialize() { //처음 실행되는 친구
        assert Btn_Delete != null : "fx:id=\"Btn_Delete\" was not injected: check your FXML file 'a2_IdDelet.fxml'.";
        assert Pw_Delete != null : "fx:id=\"Pw_Delete\" was not injected: check your FXML file 'a2_IdDelet.fxml'.";

    }

}
