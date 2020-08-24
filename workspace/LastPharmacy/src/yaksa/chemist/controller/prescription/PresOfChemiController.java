package yaksa.chemist.controller.prescription;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import yaksa.chemist.service.prescription.IpharmService;
import yaksa.chemist.service.prescription.PharmServiceImpl;
import yaksa.chemist.vo.prescription.InboxVO;
import yaksa.chemist.vo.prescription.MemberVO;
import yaksa.chemist.vo.prescription.PharmVO;
import yaksa.chemist.vo.prescription.ReceiptVO;

public class PresOfChemiController {
	
	String MemId;
	String Pharm_id;
	
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	Date currentDate = new Date();
	
	String dateStr = format1.format(currentDate);
	
	IpharmService service;
	
	@FXML
    private Pane presPane;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text code;

    @FXML
    private Text date;

    @FXML
    private Text publisher;

    @FXML
    private TableView<ReceiptVO> table;

    @FXML
    private TableColumn<ReceiptVO, String> colMediName;

    @FXML
    private TableColumn<ReceiptVO, Integer> colPrladmin;

    @FXML
    private TableColumn<ReceiptVO, Integer> colAdminDay;

    @FXML
    private TableColumn<ReceiptVO, Integer> colTotalAdmin;

    @FXML
    private TableColumn<ReceiptVO, String> colTakingTime;

    @FXML
    private Text memName;

    @FXML
    private Text memRegNo;

    @FXML
    private Text pharmName;

    @FXML
    private Text chemiName;

    @FXML
    private Text tel;

    @FXML
    private Text email;

    @FXML
    private Text addr1;
    
    @FXML
    private Text addr2;

    @FXML
    private Text payDate;

    @FXML
    private Text price;

    @FXML
    private Text payMethod;
    
    @FXML
    private Text paycode;
 
    void setID(InboxVO vo) {
    	this.MemId = vo.getPhar_memid();
    	this.Pharm_id = vo.getPharm_id();    	
    	service = PharmServiceImpl.getInstance();
    	
    	PharmVO pharVo = new PharmVO();
    	MemberVO memVo = new MemberVO();
    	
    	pharVo = service.getPharmacy(Pharm_id);
    	memVo = service.getMember(MemId);
    	

    	publisher.setText(pharVo.getPharm_name());
    	memName.setText(memVo.getMem_name());
    	memRegNo.setText(memVo.getMem_regno1() + "-" + memVo.getMem_regno2());
    	pharmName.setText(pharVo.getPharm_name());
    	chemiName.setText(pharVo.getPharm_chname());
    	email.setText(pharVo.getPharm_email1() + "@" + pharVo.getPharm_email2());
    	code.setText(vo.getPhar_file());
    	System.out.println(pharVo.getPharm_tel());
    	tel.setText(pharVo.getPharm_tel());
    	addr1.setText(pharVo.getPharm_add1());
    	addr2.setText(pharVo.getPharm_add2());
    	date.setText(dateStr);
 	
    }
    

    @FXML
    void initialize() {
    	
    	ObservableList<ReceiptVO> data = FXCollections.observableArrayList(PreviewController.rctList);
    	
    	colMediName.setCellValueFactory(new PropertyValueFactory<ReceiptVO,String>("medi_name"));
    	colPrladmin.setCellValueFactory(new PropertyValueFactory<ReceiptVO,Integer>("phpres_prladmin"));
    	colAdminDay.setCellValueFactory(new PropertyValueFactory<ReceiptVO,Integer>("phpres_admin_day"));
    	colTotalAdmin.setCellValueFactory(new PropertyValueFactory<ReceiptVO,Integer>("phpres_total_admin"));
    	colTakingTime.setCellValueFactory(new PropertyValueFactory<ReceiptVO,String>("phpres_taking_time"));
    	table.setItems(data);
    	
    }
}
