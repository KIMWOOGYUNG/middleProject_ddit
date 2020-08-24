package yaksa.chemist.controller.inventory;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yaksa.chemist.service.inventory.IPharmService;
import yaksa.chemist.service.inventory.PharmServiceImpl;
import yaksa.chemist.vo.inventory.insertVO;
import yaksa.chemist.vo.inventory.invVO;

public class a888Controller {

	
	invVO vo;
 

    @FXML
    private URL location;

    @FXML
    private TextField inputbtn;

    @FXML
    private Button btnOk;

    @FXML
    void btnCloseClick(ActionEvent event) {

    	insertVO insertvo = new insertVO();
    
    	insertvo.setInsert_inventory(vo.getInven_num());
    	insertvo.setInsert_cnt(  Integer.parseInt( inputbtn.getText()));
    	
    	IPharmService service = PharmServiceImpl.getInstance();
    	service.insertMedicine(insertvo);
    	
    	Stage stage = (Stage) btnOk.getScene().getWindow();    
        stage.close();
    	
    	
    	
    }

    

    @FXML
    void initialize() {
        assert inputbtn != null : "fx:id=\"inputbtn\" was not injected: check your FXML file 'a88_prodInput.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'a88_prodInput.fxml'.";

    }

	public void setMainConterolloer( invVO vo) {
	
		this.vo = vo;
		
	}
}
