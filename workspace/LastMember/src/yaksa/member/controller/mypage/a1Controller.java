package yaksa.member.controller.mypage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.member.controller.main.MainController;
import yaksa.member.service.mypage.MemServiceImpl;
import yaksa.member.vo.join.SessionVO;
import yaksa.member.vo.mypage.MemVo;

public class a1Controller {
	private MainController a00Controller;
	
	private MainController getA00Controller() {
		return a00Controller;
	}
	public void setMainConterolloer(MainController mainController) {
		this.a00Controller = mainController;
		
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text Mem_Name;
    

    @FXML
    private Button Mem_Info_Update;

    @FXML
    private Text Mem_Info;
    //id 생일 성별 이메일  
    
    @FXML
    private Text Mem_Info1;

    @FXML
    private Text Mem_Info2;

    @FXML
    private Text Mem_Info3;

    @FXML
    private Text Mem_Info4;
    
    @FXML
    private Button Mem_Delet;

    @FXML
    private Button Mem_Visit;
    
    @FXML
    private Button cancleBtn;

    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage) cancleBtn.getScene().getWindow();    
        stage.close();
    }

    @FXML
    void memDeletClick(ActionEvent event) {
    	
    	try {
    		Stage parentStage =(Stage)Mem_Delet.getScene().getWindow();
    		
    		Stage deletStage= new Stage(StageStyle.TRANSPARENT);
    		deletStage.initModality(Modality.WINDOW_MODAL);
    		deletStage.initOwner(parentStage);
    		
    		FXMLLoader loader = new FXMLLoader(
    				a1Controller.class.getResource("../../fxml/mypage/a2_IdDelet.fxml")
    				);
    		Parent addRoot = loader.load();
    		
    		a2Controller deletController = loader.getController();
    		
    		deletController.setMainConterolloer(this);
    		
    		Scene scene = new Scene(addRoot);
    		scene.setFill(Color.TRANSPARENT);
    		deletStage.setScene(scene);
    		deletStage.setTitle("추가");
    		deletStage.show();
	    	
    		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void memInfoUpdateClick(ActionEvent event) {
    	try {
    		Stage parentStage =(Stage)Mem_Info.getScene().getWindow();
    		
    		Stage updateStage = new Stage(StageStyle.TRANSPARENT);
    		updateStage.initModality(Modality.WINDOW_MODAL);
    		updateStage.initOwner(parentStage);
    		
    		FXMLLoader loader = new FXMLLoader(
    				a1Controller.class.getResource("../../fxml/mypage/a11_infoUpdate.fxml")
    				);
    		Parent addRoot = loader.load();
    		
    		a11Controller updateController = loader.getController();
    		
    		updateController.setMainConterolloer(this);
    		
    		Scene scene = new Scene(addRoot);
    		scene.setFill(Color.TRANSPARENT);
    		updateStage.setScene(scene);
    		updateStage.setTitle("추가");
    		updateStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void memVisitClick(ActionEvent event) {
    	try {
			Stage parentStage =(Stage)Mem_Visit.getScene().getWindow();
			
			Stage visitStage = new Stage(StageStyle.TRANSPARENT);
			visitStage.initModality(Modality.WINDOW_MODAL);
			visitStage.initOwner(parentStage);
			
			FXMLLoader loader = new FXMLLoader(
    				a1Controller.class.getResource("../../fxml/mypage/a4_visit.fxml")
    				);
			
			Parent addRoot = loader.load();
			
			a4Controller  visitController = loader.getController();
			visitController.setMainConterolloer(this);
			
			Scene scene = new Scene(addRoot);
    		scene.setFill(Color.TRANSPARENT);
    		visitStage.setScene(scene);
    		visitStage.setTitle("추가");
    		visitStage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

		MemVo memVo = null;
		MemServiceImpl service = null;
		
    @FXML
    void initialize() {
        
        Mem_Name.setText(SessionVO.loginMember.getMem_name()+" 님");
        Mem_Info.setText(SessionVO.loginMember.getMem_id());
        Mem_Info1.setText(SessionVO.loginMember.getMem_regno1());
        Mem_Info2.setText(SessionVO.loginMember.getMem_gender());
        Mem_Info3.setText(SessionVO.loginMember.getMem_email1());
        Mem_Info4.setText(SessionVO.loginMember.getMem_email2());
        
    }

}

