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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.chemist.service.inventory.IPharmService;
import yaksa.chemist.service.inventory.PharmServiceImpl;
import yaksa.chemist.util.AlertUtil;
import yaksa.chemist.vo.inventory.invVO;
import yaksa.chemist.vo.inventory.medVO;

public class aa11Controller {

	IPharmService service;
	List<medVO> medList2 = new ArrayList<>();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<medVO> medicine;
    
    @FXML
    private TableView<medVO> medicine1;

 
    @FXML
    private TableColumn<medVO, String> code;

    @FXML
    private TableColumn<medVO, String> madi;

    @FXML
    private TableColumn<medVO, String> com;

    @FXML
    private Button addbtn;

    @FXML
    private Button savebtn;

    @FXML
    private TableColumn<medVO, String> code1;

    @FXML
    private TableColumn<medVO, String> madi1;

    @FXML
    private TableColumn<medVO, String> com1;

    @FXML
    private Button cancelbtn;

    @FXML
    private Button deletebtn;

    @FXML
    void add_btn(ActionEvent event) {
    	if(medicine.getSelectionModel().isEmpty()) {
    		return;
    	}
    	
    	
    	try {
    		Stage parentstage = (Stage)addbtn.getScene().getWindow();
    		Stage stage = new Stage();
    		stage.initStyle(StageStyle.TRANSPARENT);
    		stage.initOwner(parentstage);
    		
    		
    		Parent parent = FXMLLoader.load(aa11Controller.class.getResource("../../fxml/inventory/Price.fxml"));
    		Button add = (Button)parent.lookup("#btn");
    		
    		add.setOnAction(e->{
    			
    			
    			TextField outprice = (TextField)parent.lookup("#outprice");
    			TextField inprice = (TextField)parent.lookup("#inprice");
    			
    			String a = outprice.getText();
    			String b = inprice.getText();
    			add(a,b);
    			
    			Stage stage1 = (Stage)outprice.getScene().getWindow();
    			
    			stage1.close();
    			
    			
    		});
    				
    				
    		Scene scene = new Scene(parent);
    		stage.setScene(scene);
    		stage.show();
		
		} catch (IOException e) {
			e.printStackTrace();
		} 	
    }
    
    void add(String outprice, String inprice) {
    	
    	medVO medVo = medicine.getSelectionModel().getSelectedItem();
    	System.out.println(medVo.getMedi_code());
    	medVo.setMedi_inprice(inprice);		// 입고가격
    	medVo.setMedi_outprcie(outprice);	// 출고가격
    	medList2.add(medVo);
    	ObservableList<medVO> medList1 = FXCollections.observableArrayList(medList2);
    	
    	
    	
    	code1.setCellValueFactory(new PropertyValueFactory<>("medi_code"));
    	madi1.setCellValueFactory(new PropertyValueFactory<>("medi_name"));
    	com1.setCellValueFactory(new PropertyValueFactory<>("medi_com"));
    	
    	medicine1.setItems(medList1);
    	
    	
    	
    	
    }

    @FXML
    void cancel_btn(ActionEvent event) {
    	Stage stage = (Stage) cancelbtn.getScene().getWindow();    
        stage.close();
    }

    @FXML
    void delete_btn(ActionEvent event) {
    	if(medicine1.getSelectionModel().isEmpty()) {
    		return;
    	}
    	
    	medVO medVo = medicine1.getSelectionModel().getSelectedItem();
    	
    	System.out.println(medVo.toString());
    	medList2.remove(medVo);
    	
    	ObservableList<medVO> medList1 = FXCollections.observableArrayList(medList2);
    	medicine1.setItems(medList1);
    }

    @FXML
    void save_btn(ActionEvent event) { //들어갈곳
    	
    	
    	List<invVO> invList = new ArrayList<invVO>();
    	
    	for(medVO med:medList2) {
    		invList.add(new invVO("a001", med.getMedi_code(), med.getMedi_inprice(), med.getMedi_outprcie()));
    		
    		
    	}
    	
    	service.insertMedicine_inventory(invList);
    	
    	
    	Stage stage = (Stage) savebtn.getScene().getWindow();    
        stage.close();
    	
    

    }


    @FXML
    void initialize() {
    	
    	service = PharmServiceImpl.getInstance();
    	
    	
    	List<medVO> medList = service.getMedicine();
    	ObservableList<medVO> medList1 = FXCollections.observableArrayList(medList);
    	
    	
    	code.setCellValueFactory(new PropertyValueFactory<>("medi_code"));
    	madi.setCellValueFactory(new PropertyValueFactory<>("medi_name"));
    	com.setCellValueFactory(new PropertyValueFactory<>("medi_com"));
    	
    	medicine.setItems(medList1);
    	
    	 
    	
      

    }

	public void setMainConterolloer(aa10Controller aa10Controller) {
		// TODO Auto-generated method stub
		
	}
}
