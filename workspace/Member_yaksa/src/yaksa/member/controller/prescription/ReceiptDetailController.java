package yaksa.member.controller.prescription;

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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.member.vo.prescription.Mem_InboxVO;
import yaksa.server.rmiCommon.prescription.ICommon;


public class ReceiptDetailController {
	String fileName;
	File selectedFile;
	
	byte[] data = null;
	Mem_InboxVO vo;
	
	ICommon common;

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
    private Button btnStarRate;
    
    @FXML
    void setRate(ActionEvent event) {
    	try {
			Stage dialog = new Stage();
			dialog.initModality(Modality.WINDOW_MODAL);
			FXMLLoader fxml = new FXMLLoader(getClass().getResource("/yaksa/member/fxml/prescription/Rating.fxml"));
			Parent childRoot = fxml.load();
			Scene childScene = new Scene(childRoot);
			
			RatingController rct = fxml.getController();
			rct.setVO(vo);
			
			dialog.initStyle(StageStyle.TRANSPARENT);
			childScene.setFill(Color.TRANSPARENT);
			dialog.setScene(childScene);
			dialog.show();
			
    	} catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
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
    		common = (ICommon)reg.lookup("common");
    	} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
    	try {
    		data = common.receiveReceipt(fileName);
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

    }
	

}
