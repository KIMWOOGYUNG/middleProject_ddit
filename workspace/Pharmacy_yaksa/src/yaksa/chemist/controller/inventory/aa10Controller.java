package yaksa.chemist.controller.inventory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.chemist.service.inventory.IPharmService;
import yaksa.chemist.service.inventory.PharmServiceImpl;
import yaksa.chemist.vo.inventory.invVO;

public class aa10Controller {

	IPharmService service;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<invVO> meditable;

    @FXML
    private TableColumn<invVO, String> no;

    @FXML
    private TableColumn<invVO, String> code;

    @FXML
    private TableColumn<invVO, String> name;

    @FXML
    private TableColumn<invVO, String> count;

    @FXML
    private Button medibtn;

    @FXML
    void medi_btn(ActionEvent event) {
    	

    	try {
    		Stage parentStage =(Stage)medibtn.getScene().getWindow();
    		
    		Stage mediStage = new Stage(StageStyle.TRANSPARENT);
    		mediStage.initModality(Modality.WINDOW_MODAL);
    		mediStage.initOwner(parentStage);
    		
    		FXMLLoader loader = new FXMLLoader(
    				aa10Controller.class.getResource("/yaksa/chemist/fxml/inventory/aa11_prod.fxml")
    				);
    		
    		Parent addRoot = loader.load();
    		
    		aa11Controller mediController = loader.getController();
    		
    		mediController.setMainConterolloer(this);
    		
    		Scene scene = new Scene(addRoot);
    		scene.setFill(Color.TRANSPARENT);
    		mediStage.setScene(scene);
    		mediStage.setTitle("추가");
    		mediStage.show();
	    	
    	} catch(IOException e) {
    		e.printStackTrace();    		
    	}

    }

    @FXML
    void initialize() {	// 가져오고싶은 약이름/ 
    	
    	service = PharmServiceImpl.getInstance();
    	
    	List<invVO> invList = service.getMedical_inventory();
    	ObservableList<invVO> invList1 = FXCollections.observableArrayList(invList);
     

    	code.setCellValueFactory(new PropertyValueFactory<>("inven_code"));
    	name.setCellValueFactory(new PropertyValueFactory<>("medi_name"));
    	count.setCellValueFactory(new PropertyValueFactory<>("inven_remain"));
    	
    	meditable.setItems(invList1);
 
    }

	public void setMainConterolloer(a8Controller a8Controller) {
		// TODO Auto-generated method stub
		
	}
	public void setMainConterolloer(a9Controller a9Controller) {
		// TODO Auto-generated method stub
		
	}
//	 private void setMainConterolloer(aa10Controller aa10Controller) {
//			// TODO Auto-generated method stub
//			
//	}
	
}
