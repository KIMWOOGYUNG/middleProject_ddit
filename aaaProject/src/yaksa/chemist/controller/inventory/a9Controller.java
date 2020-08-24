package yaksa.chemist.controller.inventory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import yaksa.chemist.vo.inventory.saleVO;

public class a9Controller {
 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button inbtn;

    @FXML
    private Button outbtn;

    @FXML
    private TableView<saleVO> table;
    
    @FXML
    private TableColumn<?, ?> no;

    @FXML
    private TableColumn<?, ?> code;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> outcount;

    @FXML
    private TableColumn<?, ?> day;

    @FXML
    private TableColumn<?, ?> outprice;

    @FXML
    private Button inoutbtn;

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
    				a9Controller.class.getResource("../../fxml/inventory/a8_prod.fxml")
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
    	Stage stage = (Stage) inoutbtn.getScene().getWindow();    
        stage.close();

    	try {
    		Stage parentStage =(Stage)inoutbtn.getScene().getWindow();
    		
    		Stage inoutStage = new Stage(StageStyle.TRANSPARENT);
    		inoutStage.initModality(Modality.WINDOW_MODAL);
    		inoutStage.initOwner(parentStage);
    		
    		FXMLLoader loader = new FXMLLoader(
    				a9Controller.class.getResource("../../fxml/inventory/aa10_prod.fxml")
    				);
    		
    		Parent addRoot = loader.load();
    		
    		aa10Controller inoutController = loader.getController();
    		
    		inoutController.setMainConterolloer(this);
    		
    		Scene scene = new Scene(addRoot);
    		scene.setFill(Color.TRANSPARENT);
    		inoutStage.setScene(scene);
    		inoutStage.setTitle("추가");
    		inoutStage.show();
	    	
    	} catch(IOException e) {
    		e.printStackTrace();    		
    	}

    }

    @FXML
    void out_btn(ActionEvent event) {

    }

    @FXML
    void initialize() {
       IPharmService service = PharmServiceImpl.getInstance();
       
       List<saleVO> sale = new ArrayList<saleVO>();
       
       sale = service.getMedicine_sale("1");
       
       ObservableList<saleVO> sale1 = FXCollections.observableArrayList(sale);
       

   	code.setCellValueFactory(new PropertyValueFactory<>("inven_code"));
   	name.setCellValueFactory(new PropertyValueFactory<>("medi_name"));
   	outcount.setCellValueFactory(new PropertyValueFactory<>("sale_cnt"));
   	day.setCellValueFactory(new PropertyValueFactory<>("sale_saledate"));
   	outprice.setCellValueFactory(new PropertyValueFactory<>("inven_outprice"));

   	table.setItems(sale1);
    	
    	
    	
    }

    public void setMainConterolloer(aa10Controller aa10Controller) {
		// TODO Auto-generated method stub
		
	}
	public void setMainConterolloer(a8Controller a8Controller) {
		// TODO Auto-generated method stub
		
	}
}
