package yaksa.chemist.controller.prescription;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.chemist.service.prescription.PharmServiceImpl;
import yaksa.chemist.util.AlertUtil;
import yaksa.chemist.vo.prescription.InboxVO;
import yaksa.chemist.vo.prescription.InventoryVO;

public class InventoryController {
	
	InboxVO vo;
	static InventoryVO ivVO;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField tf;

    @FXML
    private TableView<InventoryVO> table;
    
    @FXML
    private TableColumn<InventoryVO, String> colMediCode;

    @FXML
    private TableColumn<InventoryVO, Integer> colRemain;    

    @FXML
    private TableColumn<InventoryVO, String> colMedi_Name;

    @FXML
    void search(ActionEvent event) {
    	String medicine_name = tf.getText();
    	List<InventoryVO> invList = PharmServiceImpl.getInstance().searchMedicine(medicine_name);
    	ObservableList<InventoryVO> data = FXCollections.observableArrayList(invList);
    	table.setItems(data);
    	
    }
    
    @FXML
    void tableClick(MouseEvent event) {
    	if(table.getSelectionModel().isEmpty()) {
    		AlertUtil.warnMsg("경고", "잘못 선택하셨습니다.");
    		return;
    	}else {
			try {

				Stage dialog = new Stage();
				dialog.initModality(Modality.WINDOW_MODAL);
				
				FXMLLoader fxml =  new FXMLLoader(getClass().getResource("/yaksa/chemist/fxml/prescription/AddMedicine.fxml"));
				Parent childRoot = fxml.load();
				Scene childScene = new Scene(childRoot);
				
				AddMedicineController adc = fxml.getController();
				String mediCode = table.getSelectionModel().getSelectedItem().getInven_code();
				ivVO = table.getSelectionModel().getSelectedItem();
				adc.setMediCode(mediCode, vo, ivVO);
				
							
				dialog.initStyle(StageStyle.TRANSPARENT);
								
				childScene.setFill(Color.TRANSPARENT);
				dialog.setScene(childScene);
				dialog.show();	
				
							
	    	} catch (Exception e) {
				e.printStackTrace();
			}	
    	}
    }
    void setPresVO(InboxVO vo) {
    	this.vo = vo;
    }

    @FXML
    void initialize() {
    	List<InventoryVO> invList = PharmServiceImpl.getInstance().getAllInventory();
    	ObservableList<InventoryVO> data = FXCollections.observableArrayList(invList);
    	
    	System.out.println(invList.toString());
    	
    	colMedi_Name.setCellValueFactory(new PropertyValueFactory<InventoryVO, String>("inven_YakName"));
    	colMediCode.setCellValueFactory(new PropertyValueFactory<InventoryVO, String>("inven_code"));
    	colRemain.setCellValueFactory(new PropertyValueFactory<InventoryVO, Integer>("inven_remain"));
    	table.setItems(data);
    	
    }
}
