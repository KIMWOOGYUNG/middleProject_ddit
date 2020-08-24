package yaksa.chemist.controller.prescription;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import yaksa.chemist.vo.prescription.InboxVO;
import yaksa.server.rmiCommon.prescription.ICommon2;

public class PreviewController2 {

	String fileName;

	byte[] data = null;
	InboxVO vo;
	 ICommon2 common2;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane imgpane;

    @FXML
    private ImageView img;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnRotate;

    @FXML
    private Button btnSave;
    
    @FXML
    void imgZoom(MouseEvent event) {
    	img.getOnZoom();
    }

    @FXML
    void rotate(ActionEvent event) {
    	img.setRotate(img.getRotate() + 90);
    }
    
    @FXML
    void save(ActionEvent event) {
    	saveReceipt();	
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }
    
    //약사 컴퓨터에 저장
    public void saveReceipt() {
    	FileOutputStream fout = null;
		String dir = "C:\\Users\\PC-18\\Desktop\\받은 처방전 저장";
		System.out.println("파일 저장 시작...");
		
		try {
			fout = new FileOutputStream(dir + "\\" + fileName + ".jpg");
			
			fout.write(data);	//파일 내용 저장
			fout.flush();
			fout.close();
			System.out.println("파일 저장 완료...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void setVo(InboxVO vo) {
    	this.vo = vo;
    	this.fileName = vo.getPhar_file();  	
    }
    
    public void init() throws IOException {
    	
    	try {
    		Registry reg = LocateRegistry.getRegistry("localhost",8888);
    		common2 = (ICommon2)reg.lookup("common2");
    	} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
    	try {
    		data = common2.requestFile(fileName);
    		System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		Image image = new Image(new ByteArrayInputStream(data));
		
		img.setLayoutX(8);
		img.setLayoutY(20);
		
		img.setFitHeight(430);
		img.setFitWidth(310);
		
		img.setImage(image);
		img.setEffect(null);
		
		
    }
    
   

    @FXML
    void initialize(){   	
    	
    }
}
