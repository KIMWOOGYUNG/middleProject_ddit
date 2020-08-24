package yaksa.chemist.controller.prescription;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yaksa.chemist.util.AlertUtil;
import yaksa.chemist.vo.prescription.InboxVO;
import yaksa.chemist.vo.prescription.InventoryVO;
import yaksa.chemist.vo.prescription.ReceiptVO;
import yaksa.chemist.vo.prescription.SaleVO;

public class AddMedicineController {
	
	InventoryVO invVo;
	InboxVO presVo;
	String mediCode;
	int total_cnt;
	static List<Integer> priceList;
		
	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button btnAdd;

	    @FXML
	    private Button btnCancel;

	    @FXML
	    private TextField prladmin;

	    @FXML
	    private TextField admin_day;

	    @FXML
	    private TextField total_admin;

	    @FXML
	    private TextField taking_time;

    @FXML
    void add(ActionEvent event) {
    	addReceipt();
    	
    }

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }
    
    void setMediCode(String mediCode, InboxVO presVo, InventoryVO invVo){
    	this.invVo = invVo;
    	this.mediCode = mediCode;
    	this.presVo = presVo;
    }
    
    void addReceipt() {
    	if(total_admin.getText().equals("") || prladmin.getText().equals("") || admin_day.getText().equals("") || taking_time.getText().equals("")) {
    		AlertUtil.warnMsg("경고", "빈 항목이 있습니다.");
    		return;
    	}else {
    		//영수증에 추가
    		ReceiptVO rcVo = new ReceiptVO();
    		String file = presVo.getPhar_file();
    		rcVo.setMedi_name(invVo.getInven_YakName());
    		rcVo.setPhpres_code(file);
    		rcVo.setPhpres_medlcode(mediCode);
    		rcVo.setPhpres_total_admin(Integer.parseInt(total_admin.getText())); 
    		rcVo.setPhpres_taking_time(taking_time.getText());
    		rcVo.setPhpres_prladmin(Integer.parseInt(prladmin.getText()));
    		rcVo.setPhpres_admin_day(Integer.parseInt(admin_day.getText()));
    		total_cnt = Integer.parseInt(prladmin.getText()) * Integer.parseInt(admin_day.getText()) * Integer.parseInt(total_admin.getText());
    		rcVo.setPhpres_salecnt(total_cnt);
    		PreviewController.rctList.add(rcVo);
    		
    		//saleVO에 추가
    		SaleVO saleVo = new SaleVO();
    		
    		int sum_price = total_cnt * Integer.parseInt(invVo.getInven_outprice());
    		
    		saleVo.setSale_cnt(total_cnt);
    		saleVo.setSale_sumprice(sum_price);
    		saleVo.setSale_inventory(invVo.getInven_num());
    		PreviewController.saleList.add(saleVo);
    		
    		Stage stage = (Stage) btnCancel.getScene().getWindow();
        	stage.close();
    	}

    }
    
    @FXML
    void initialize() {
        
    	
    }
}
