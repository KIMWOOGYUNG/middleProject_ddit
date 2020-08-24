package yaksa.chemist.controller.inventory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.chemist.service.inventory.IPharmService;
import yaksa.chemist.service.inventory.PharmServiceImpl;
import yaksa.chemist.vo.inventory.insertVO;

public class a8Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> no;

    @FXML
    private TableColumn<?, ?> code;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> incount;

    @FXML
    private TableColumn<?, ?> day;

    @FXML
    private TableColumn<?, ?> inprice;

    @FXML
    private Button addbtn;
    
    @FXML
    private TableView<insertVO> table;
    
    @FXML
    private Button btnClose;

    @FXML
    void add_btn(ActionEvent event) {

    	try {
    		Stage parentStage =(Stage)addbtn.getScene().getWindow();
    		
    		Stage addStage = new Stage(StageStyle.TRANSPARENT);
    		addStage.initModality(Modality.WINDOW_MODAL);
    		addStage.initOwner(parentStage);
    		
    		FXMLLoader loader = new FXMLLoader(
    				a8Controller.class.getResource("../../fxml/inventory/a8_prodInput.fxml")
    				);
    		
    		
    		Parent addRoot = loader.load();
    		
    		a88Controller addController = loader.getController();
    		
    		addController.setMainConterolloer(this);
    		
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
    void initialize() {
      
    	
    	IPharmService service = PharmServiceImpl.getInstance();
    	
    	List<insertVO> insert1 = new ArrayList<insertVO>();
    	
    	insert1 = service.getMedicine_insert("1");
    	
    	ObservableList<insertVO> insert2 = FXCollections.observableArrayList(insert1);
    	
    	
    	code.setCellValueFactory(new PropertyValueFactory<>("inven_code"));
    	name.setCellValueFactory(new PropertyValueFactory<>("medi_name"));
    	incount.setCellValueFactory(new PropertyValueFactory<>("insert_cnt"));
    	day.setCellValueFactory(new PropertyValueFactory<>("insert_date"));
    	inprice.setCellValueFactory(new PropertyValueFactory<>("inven_inprice"));

    	table.setItems(insert2);
    	
    	

    }

	public void setMainConterolloer(a9Controller a9Controller) {
		// TODO Auto-generated method stub
		
	}
	public void setMainConterolloer(aa10Controller aa10Controller) {
		// TODO Auto-generated method stub
		
	}
}
