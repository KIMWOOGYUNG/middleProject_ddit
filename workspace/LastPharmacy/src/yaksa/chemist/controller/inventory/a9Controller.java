package yaksa.chemist.controller.inventory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import yaksa.chemist.service.inventory.IPharmService;
import yaksa.chemist.service.inventory.PharmServiceImpl;
import yaksa.chemist.vo.inventory.saleVO;

public class a9Controller {
 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<saleVO> table;
    
    @FXML
    private TableColumn<saleVO, ?> no;

    @FXML
    private TableColumn<saleVO, ?> code;

    @FXML
    private TableColumn<saleVO, ?> name;

    @FXML
    private TableColumn<saleVO, ?> outcount;

    @FXML
    private TableColumn<saleVO, ?> day;

    @FXML
    private TableColumn<saleVO, ?> outprice;

    

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
