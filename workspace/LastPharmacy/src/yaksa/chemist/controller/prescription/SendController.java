package yaksa.chemist.controller.prescription;

import java.net.URL;
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
import yaksa.chemist.vo.prescription.Mem_InboxVO;

public class SendController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane content;

    @FXML
    private TableView<Mem_InboxVO> table;

    @FXML
    private TableColumn<Mem_InboxVO, String> colNum;

    @FXML
    private TableColumn<Mem_InboxVO, String> colDate;

    @FXML
    private TableColumn<Mem_InboxVO, String> colMemId;

    @FXML
    void clickTable(MouseEvent  event) {
    	System.out.println(12345);
    	if(table.getSelectionModel().isEmpty()) {
    		AlertUtil.warnMsg("경고", "영수증을 선택하세요.");
    		return;
    	}else {
    		try {
				Stage dialog = new Stage();
				dialog.initModality(Modality.WINDOW_MODAL);
				
				FXMLLoader fxml =  new FXMLLoader(getClass().getResource("../../fxml/prescription/SendDetail.fxml"));
				Parent childRoot = fxml.load();
				Scene childScene = new Scene(childRoot);
				
				
				SendDetailController sendDetail = fxml.getController();
				Mem_InboxVO vo = table.getSelectionModel().getSelectedItem();
				sendDetail.setVo(vo);
				
				sendDetail.init();
							
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
    	List<Mem_InboxVO> rcList = PharmServiceImpl.getInstance().getAllReceipt(); 	
    	ObservableList<Mem_InboxVO> data = FXCollections.observableArrayList(rcList);
    	System.out.println(data);
    	colNum.setCellValueFactory(new PropertyValueFactory<Mem_InboxVO, String>("inbox_num"));
    	colDate.setCellValueFactory(new PropertyValueFactory<Mem_InboxVO, String>("inbox_date"));
    	colMemId.setCellValueFactory(new PropertyValueFactory<Mem_InboxVO, String>("inbox_memid"));
    	table.setItems(data);
    	
    
    }
}
