package yaksa.chemist.controller.prescription;

import java.io.ByteArrayInputStream;
import java.io.File;
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
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import yaksa.chemist.vo.prescription.Mem_InboxVO;
import yaksa.server.rmiCommon.prescription.ICommon2;

public class SendDetailController {

	String fileName;
	File selectedFile;
	
	byte[] data = null;
	Mem_InboxVO vo;
	
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
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void imgZoom(MouseEvent event) {

    }

    @FXML
    void rotate(ActionEvent event) {
    	img.setRotate(img.getRotate() + 90);
    }

    @FXML
    void save(ActionEvent event) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"), new ExtensionFilter("JPG 파일(.jpg)", "*.jpg"), new ExtensionFilter("PNG 파일(.png)", "*.png"));
    	
    	//열기할 폴더 지정
		File showDir = new File("C:\\Users\\PC-18\\Desktop\\OpenDialog");
		fileChooser.setInitialDirectory(showDir);
    	
		
    	saveReceipt();	
    }
    
    public void saveReceipt() {
    	FileOutputStream fout = null;
		DirectoryChooser chooser = new DirectoryChooser();
		selectedFile = chooser.showDialog(null);
		String dir = selectedFile.getAbsolutePath().toString();
		
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
    
    public void setVo(Mem_InboxVO vo) {
    	this.vo = vo;
    	this.fileName = vo.getInbox_file();  	
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
    		data = common2.receiveReceipt(fileName);
    		System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		Image image = new Image(new ByteArrayInputStream(data));
		
		img.setLayoutX(0);
		img.setLayoutY(0);
		
		img.setFitWidth(499);
		img.setFitHeight(451);
		
		img.setImage(image);
		img.setEffect(null);
		
		
    }

    @FXML
    void initialize() {
        assert imgpane != null : "fx:id=\"imgpane\" was not injected: check your FXML file 'SendDetail.fxml'.";
        assert img != null : "fx:id=\"img\" was not injected: check your FXML file 'SendDetail.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'SendDetail.fxml'.";
        assert btnRotate != null : "fx:id=\"btnRotate\" was not injected: check your FXML file 'SendDetail.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'SendDetail.fxml'.";

    }
}
