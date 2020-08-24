package yaksa.member.controller.prescription;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.member.service.prescription.MemServiceImpl;
import yaksa.member.util.prescription.AlertUtil;
import yaksa.member.vo.prescription.Phar_InboxVO;

public class PresController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<Phar_InboxVO> table;

    @FXML
    private TableColumn<Phar_InboxVO, String> colRcNum;

    @FXML
    private TableColumn<Phar_InboxVO, String> colPharmName;

    @FXML
    private TableColumn<Phar_InboxVO, String> colDate;
    

    @FXML
    void tableClick(MouseEvent event) {
    	if(table.getSelectionModel().isEmpty()) {
    		AlertUtil.warnMsg("경고", "처방전을 선택하세요.");
    		return;
    	}else {
    		try {
				Stage dialog = new Stage();
				dialog.initModality(Modality.WINDOW_MODAL);
				
				FXMLLoader fxml =  new FXMLLoader(getClass().getResource("../../fxml/prescription/PresDetail.fxml"));
				Parent childRoot = fxml.load();
				Scene childScene = new Scene(childRoot);
				
				PresDetailController presDetail = fxml.getController();
				Phar_InboxVO vo = table.getSelectionModel().getSelectedItem();
				presDetail.setVo(vo);
				
				presDetail.init();
							
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
       List<Phar_InboxVO> presList = MemServiceImpl.getInstance().getAllPres();
       ObservableList<Phar_InboxVO> data = FXCollections.observableArrayList(presList);
       
       colRcNum.setCellValueFactory(new PropertyValueFactory<Phar_InboxVO, String>("phar_messnum"));
       colPharmName.setCellValueFactory(new PropertyValueFactory<Phar_InboxVO, String>("pharm_name"));
       colDate.setCellValueFactory(new PropertyValueFactory<Phar_InboxVO, String>("phar_inboxdate"));
       table.setItems(data);
    }
    
}
