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

public class a88Controller {
	
	IPharmService service;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<invVO> meditable;

    @FXML
    private TableColumn<invVO, String> code;

    @FXML
    private TableColumn<invVO, String> name;

    @FXML
    private TableColumn<invVO, String> count;

    @FXML
    private Button addbtn;
    
    
    @FXML
    private Button closebtn;

    @FXML
    void add_btn(ActionEvent event) {
    	try {
    		Stage parentStage =(Stage)addbtn.getScene().getWindow();
    		
    		Stage addStage = new Stage(StageStyle.TRANSPARENT);
    		addStage.initModality(Modality.WINDOW_MODAL);
    		addStage.initOwner(parentStage);

    		FXMLLoader loader = new FXMLLoader(
    				a88Controller.class.getResource("/yaksa/chemist/fxml/inventory/a88_prodInput.fxml")
    				);
    		
    		Parent addRoot = loader.load();
    		
    		a888Controller addController = loader.getController();
    		
    		
    		addController.setMainConterolloer(meditable.getSelectionModel().getSelectedItem());
    		
    		
    		
    		Scene scene = new Scene(addRoot);
    		scene.setFill(Color.TRANSPARENT);
    		addStage.setScene(scene);
    		addStage.setTitle("추가");
    		addStage.show();
	    	
    	} catch(IOException e) {
    		e.printStackTrace();    		
    	}
    }

    @FXML
    void close_btn(ActionEvent event) {
    	Stage stage = (Stage) closebtn.getScene().getWindow();    
        stage.close();
    }

    @FXML
    void initialize() {
    	
service = PharmServiceImpl.getInstance();
    	
    	List<invVO> invList = service.getMedical_inventory();
    	ObservableList<invVO> invList1 = FXCollections.observableArrayList(invList);
     
    	
    	code.setCellValueFactory(new PropertyValueFactory<>("inven_code"));
    	name.setCellValueFactory(new PropertyValueFactory<>("medi_name"));
    	count.setCellValueFactory(new PropertyValueFactory<>("inven_remain"));
    	
    	meditable.setItems(invList1);
    	
        assert meditable != null : "fx:id=\"meditable\" was not injected: check your FXML file 'a8_prodinput.fxml'.";
        assert code != null : "fx:id=\"code\" was not injected: check your FXML file 'a8_prodinput.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'a8_prodinput.fxml'.";
        assert count != null : "fx:id=\"count\" was not injected: check your FXML file 'a8_prodinput.fxml'.";
        assert addbtn != null : "fx:id=\"addbtn\" was not injected: check your FXML file 'a8_prodinput.fxml'.";
        assert closebtn != null : "fx:id=\"closebtn\" was not injected: check your FXML file 'a8_prodinput.fxml'.";

    }

	public void setMainConterolloer(a8Controller a8Controller) {
		// TODO Auto-generated method stub
		
	}
}
