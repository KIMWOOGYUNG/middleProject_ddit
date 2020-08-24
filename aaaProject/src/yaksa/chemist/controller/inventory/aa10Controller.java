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
    private Button inbtn;

    @FXML
    private Button outbtn;

    @FXML
    private TableColumn<invVO, String> no;

    @FXML
    private TableColumn<invVO, String> code;

    @FXML
    private TableColumn<invVO, String> name;

    @FXML
    private TableColumn<invVO, String> count;

    @FXML
    private Button inoutbtn;

    @FXML
    private Button medibtn;

    @FXML
    void in_btn(ActionEvent event) {
    	Stage stage = (Stage) inbtn.getScene().getWindow();    
        stage.close();

    	try {
    		Stage parentStage =(Stage)inbtn.getScene().getWindow();
    		
    		Stage inStage = new Stage(StageStyle.TRANSPARENT);
    		inStage.initModality(Modality.WINDOW_MODAL);
    		inStage.initOwner(parentStage);
    		
    		FXMLLoader loader = new FXMLLoader(
    				aa10Controller.class.getResource("../../fxml/inventory/a8_prod.fxml")
    				);
    		
    		Parent addRoot = loader.load();
    		
    		a8Controller inController = loader.getController();
    		
    		inController.setMainConterolloer(this);
    		
    		Scene scene = new Scene(addRoot);
    		scene.setFill(Color.TRANSPARENT);
    		inStage.setScene(scene);
    		inStage.setTitle("추가");
    		inStage.show();
	    	
    	} catch(IOException e) {
    		e.printStackTrace();    		
    	}

    }

   

	@FXML
    void in_out_btn(ActionEvent event) {
		
    }

    @FXML
    void medi_btn(ActionEvent event) {
    	

    	try {
    		Stage parentStage =(Stage)medibtn.getScene().getWindow();
    		
    		Stage mediStage = new Stage(StageStyle.TRANSPARENT);
    		mediStage.initModality(Modality.WINDOW_MODAL);
    		mediStage.initOwner(parentStage);
    		
    		FXMLLoader loader = new FXMLLoader(
    				aa10Controller.class.getResource("../../fxml/inventory/aa11_prod.fxml")
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
    void out_btn(ActionEvent event) {
    	Stage stage = (Stage) outbtn.getScene().getWindow();    
        stage.close();

    	try {
    		Stage parentStage =(Stage)outbtn.getScene().getWindow();
    		
    		Stage outStage = new Stage(StageStyle.TRANSPARENT);
    		outStage.initModality(Modality.WINDOW_MODAL);
    		outStage.initOwner(parentStage);
    		
    		FXMLLoader loader = new FXMLLoader(
    				aa10Controller.class.getResource("../../fxml/inventory/a9_prod.fxml")
    				);
    		
    		Parent addRoot = loader.load();
    		
    		a9Controller outController = loader.getController();
    		
    		outController.setMainConterolloer(this);
    		
    		Scene scene = new Scene(addRoot);
    		scene.setFill(Color.TRANSPARENT);
    		outStage.setScene(scene);
    		outStage.setTitle("추가");
    		outStage.show();
	    	
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
    	
    	
    	
    	
        assert inbtn != null : "fx:id=\"inbtn\" was not injected: check your FXML file 'aa10_prod.fxml'.";
        assert outbtn != null : "fx:id=\"outbtn\" was not injected: check your FXML file 'aa10_prod.fxml'.";
        assert no != null : "fx:id=\"no\" was not injected: check your FXML file 'aa10_prod.fxml'.";
        assert code != null : "fx:id=\"code\" was not injected: check your FXML file 'aa10_prod.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'aa10_prod.fxml'.";
        assert count != null : "fx:id=\"count\" was not injected: check your FXML file 'aa10_prod.fxml'.";
        assert inoutbtn != null : "fx:id=\"inoutbtn\" was not injected: check your FXML file 'aa10_prod.fxml'.";
        assert medibtn != null : "fx:id=\"medibtn\" was not injected: check your FXML file 'aa10_prod.fxml'.";

    }

	public void setMainConterolloer(a8Controller a8Controller) {
		// TODO Auto-generated method stub
		
	}
	public void setMainConterolloer(a9Controller a9Controller) {
		// TODO Auto-generated method stub
		
	}
	 private void setMainConterolloer(aa10Controller aa10Controller) {
			// TODO Auto-generated method stub
			
		}
	
}
