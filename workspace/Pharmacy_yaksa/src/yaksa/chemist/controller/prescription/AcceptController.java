package yaksa.chemist.controller.prescription;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.json.simple.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import yaksa.chemist.service.prescription.IpharmService;
import yaksa.chemist.service.prescription.PharmServiceImpl;
import yaksa.chemist.vo.prescription.PrescriptionVO;
import yaksa.chemist.vo.prescription.ReceiptVO;
import yaksa.chemist.vo.prescription.SaleVO;
import yaksa.server.rmiCommon.prescription.ICommon2;

public class AcceptController {
	int phar_messnum;
    IpharmService service;
    byte[] data;
    ICommon2 common2;
    PrescriptionVO presVo;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea tf;

    @FXML
    private Button btnSend;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOk;
    
    @FXML
    private TextArea time;
    
    @FXML
    private TextArea price;
    
    
 
    
  //-------------------------------------------------문자전송 API------------------------------------------------------------------------------    
    public void sms() {
    	System.out.println(PresOfChemiController.tel_mem);
    	 String api_key = "NCSUOU07S4TKISUC";
         String api_secret = "CMSAPV91CCMI7EL2VKRISSW1BBS8ADTX";
        Message coolsms = new Message(api_key, api_secret);

        
        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", PresOfChemiController.tel_mem); // 수신번호
        params.put("from", "01024830328"); // 발신번호
        params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
        params.put("text", "요청하신 처방전의 소요시간은 " + time.getText() + "이고, 가격은 " + price.getText() + " 입니다. 감사합니다."); // 문자내용    
        params.put("app_version", "JAVA SDK v1.2"); // application name and version

        try {
          JSONObject obj = (JSONObject) coolsms.send(params);
          System.out.println(obj.toString());
        } catch (CoolsmsException e) {
          System.out.println(e.getMessage());
          System.out.println(e.getCode());
        }
    	
   
	}

  //---------------------------------------------------------------------------------------------------------------

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }
    
    @FXML
    void ok(ActionEvent event) {
    	
    	service.acceptPrescription(phar_messnum);
    	
    	//prescription테이블 insert
    	service.insertPrescription(PreviewController.presVo);
    	
    	//판매테이블 insert
    	//히스토리 테이블 insert
    	List<SaleVO> saleVoList = PreviewController.saleList;
    	List<ReceiptVO> receiptList = PreviewController.rctList;
    	
    	for(int i = 0; i < saleVoList.size(); i++) {
    		service.insertMediSale(saleVoList.get(i));
    		service.insertHistory(receiptList.get(i));
    	}
   	
    	PreviewController.saleList = null;
    	PreviewController.rctList = null;
    	
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    	
    	presVo = PreviewController.presVo;
    	String mem_id = presVo.getMem_id();
    	String pharm_id = presVo.getPharm_id();
    	String pres_code = presVo.getPhpres_code();

    	try {	
    		common2.sendReceipt(mem_id, pharm_id, pres_code, data);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void send(ActionEvent event) {
    	sms();
    }
    
    //선택된 처방전 번호 가져옴
    void selected_messNum(int phar_messnum) {
    	this.phar_messnum = phar_messnum;
    }
    
    void getImgData(byte[] data) {
    	this.data = data;
    }
    
    @FXML
    void initialize() throws NotBoundException{
    	service = PharmServiceImpl.getInstance();
    	presVo = new PrescriptionVO();
    	
    	try {
    		Registry reg = LocateRegistry.getRegistry("localhost",8888);
    		common2 = (ICommon2)reg.lookup("common2");
    	} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

    }

	
}