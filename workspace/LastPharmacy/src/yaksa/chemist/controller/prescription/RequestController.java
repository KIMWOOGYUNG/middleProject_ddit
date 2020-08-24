package yaksa.chemist.controller.prescription;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.chemist.service.prescription.PharmServiceImpl;
import yaksa.chemist.util.AlertUtil;
import yaksa.chemist.vo.prescription.InboxVO;

public class RequestController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane content;

    @FXML
    private TableView<InboxVO> table;

    @FXML
    private TableColumn<InboxVO, Integer> colNum;

    @FXML
    private TableColumn<InboxVO, String> colDate;

    @FXML
    private TableColumn<InboxVO, String> colMemId;

    @FXML
    void clickTable(MouseEvent event) {    	
    	if(table.getSelectionModel().isEmpty()) {
    		AlertUtil.warnMsg("경고", "처방전을 선택하세요.");
    		return;
    	}else {
			try {
				Stage dialog = new Stage();
				dialog.initModality(Modality.WINDOW_MODAL);
				
				FXMLLoader fxml =  new FXMLLoader(getClass().getResource("../../fxml/prescription/PrescriptPreview.fxml"));
				Parent childRoot = fxml.load();
				Scene childScene = new Scene(childRoot);
				
				PreviewController prev = fxml.getController();
				InboxVO vo = table.getSelectionModel().getSelectedItem();
				prev.setVo(vo);
				
				prev.init();
							
				dialog.initStyle(StageStyle.TRANSPARENT);
								
				childScene.setFill(Color.TRANSPARENT);
				dialog.setScene(childScene);
				dialog.show();
				
				
				
	    	} catch (Exception e) {
				e.printStackTrace();
			}	
    	}
    }

    
    @FXML
    void initialize() {
    	List<InboxVO> prescriptionList = PharmServiceImpl.getInstance().getAllPrescription();
    	List<InboxVO> prescriptionList1 = new ArrayList<InboxVO>();
    	
    	
    	for(int i = 0; i < prescriptionList.size(); i++) {
    		String phar_chk = prescriptionList.get(i).getPhar_check();
    		    		
    		if(phar_chk.equals("0")) {
    			prescriptionList1.add(prescriptionList.get(i));
    		}
    	}
    	
    	ObservableList<InboxVO> data = FXCollections.observableArrayList(prescriptionList1);
    	
    	colNum.setCellValueFactory(new PropertyValueFactory<InboxVO, Integer>("phar_messnum"));
    	colDate.setCellValueFactory(new PropertyValueFactory<InboxVO, String>("phar_inboxdate"));
    	colMemId.setCellValueFactory(new PropertyValueFactory<InboxVO, String>("phar_memid"));
    	
    	table.setItems(data);
    	
    }
}
