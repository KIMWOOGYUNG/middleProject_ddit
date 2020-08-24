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
import yaksa.member.service.join.MemberServiceImpl;
import yaksa.member.service.prescription.MemServiceImpl;
import yaksa.member.util.prescription.AlertUtil;
import yaksa.member.vo.prescription.Mem_InboxVO;

public class ReceiptController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<Mem_InboxVO> table;

    @FXML
    private TableColumn<Mem_InboxVO, String> colRcNum;

    @FXML
    private TableColumn<Mem_InboxVO, String> colPharmName;

    @FXML
    private TableColumn<Mem_InboxVO, String> colDate;
    
    @FXML
    private TableColumn<Mem_InboxVO, String> colStar;

    @FXML
    private TableColumn<Mem_InboxVO, String> colRead;

    @FXML
    void tableClick(MouseEvent event) {
    	if(table.getSelectionModel().isEmpty()) {
    		AlertUtil.warnMsg("경고", "영수증을 선택하세요.");
    		return;
    	}else {
    		try {
				Stage dialog = new Stage();
				dialog.initModality(Modality.WINDOW_MODAL);
				
				FXMLLoader fxml =  new FXMLLoader(getClass().getResource("/yaksa/member/fxml/prescription/ReceiptDetail.fxml"));
				Parent childRoot = fxml.load();
				Scene childScene = new Scene(childRoot);
				
				ReceiptDetailController rcDetail = fxml.getController();
				Mem_InboxVO vo = table.getSelectionModel().getSelectedItem();
				rcDetail.setVo(vo);
				rcDetail.init();
				System.out.println(vo.toString());
							
				dialog.initStyle(StageStyle.TRANSPARENT);
								
				childScene.setFill(Color.TRANSPARENT);
				dialog.setScene(childScene);
				dialog.show();
				
				
				//영수증 열람여부
				MemServiceImpl.getInstance().updatePersue(vo.getInbox_file());
				
				
	    	} catch (Exception e) {
				e.printStackTrace();
			}	
    	}
    }

    @FXML
    void initialize() {
       List<Mem_InboxVO> receiptList = MemServiceImpl.getInstance().getAllReceipt();
       System.out.println(receiptList.toString());
       ObservableList<Mem_InboxVO> data = FXCollections.observableArrayList(receiptList);
       
       for(int i = 0; i < data.size(); i++) {
    	   
    	   System.out.println(data.get(i).getPharm_name());
    	   colRcNum.setCellValueFactory(new PropertyValueFactory<Mem_InboxVO, String>("inbox_num"));
    	   colPharmName.setCellValueFactory(new PropertyValueFactory<Mem_InboxVO, String>("pharm_name"));
    	   colDate.setCellValueFactory(new PropertyValueFactory<Mem_InboxVO, String>("inbox_date"));

    	   System.out.println(data.get(i).getStar_rate());
    	   
    	   if(data.get(i).getStar_rate() == null){
    		   return;
    	   }else {
    		   if(data.get(i).getStar_rate().equals("1")) {
    			   data.get(i).setStar_rate("★");
    		   }else if(data.get(i).getStar_rate().equals("2")) {
    			   data.get(i).setStar_rate("★★");
    		   }else if(data.get(i).getStar_rate().equals("3")) {
    			   data.get(i).setStar_rate("★★★");
    		   }else if(data.get(i).getStar_rate().equals("4")) {
    			   data.get(i).setStar_rate("★★★★");
    		   }else if(data.get(i).getStar_rate().equals("5")) {
    			   data.get(i).setStar_rate("★★★★★");
    		   }
    		   
    	   }
       }

       colStar.setCellValueFactory(new PropertyValueFactory<Mem_InboxVO, String>("star_rate"));
       colRead.setCellValueFactory(new PropertyValueFactory<Mem_InboxVO, String>("persue"));
       table.setItems(data);
    }
    
}
