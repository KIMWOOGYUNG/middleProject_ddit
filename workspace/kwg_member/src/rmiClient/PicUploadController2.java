package rmiClient;


import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import application.PreUploadMain;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PicUploadController2 {

	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnUpload;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnOtherPic;

    @FXML
    private ImageView img;
    
    @FXML
    private Pane imgpane;
    
    @FXML
    private Button btnOk;   
    
    @FXML
    private Button btnRotate;
    
    @FXML
    void rotate(ActionEvent event) {
    	img.setRotate(img.getRotate() + 90);
    }
    
    @FXML
    void ok(ActionEvent event) { //서버에 저장시키기
    	
    	long fSize = selectedFile.length();
    	data = new byte[(int)fSize];
    	
    	try {
    		
    		FileInputStream fin = new FileInputStream(selectedFile);
    		fin.read(data);
    		
    		
    		
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
    	try {
    		//서버
    		Registry reg = LocateRegistry.getRegistry("localhost", 9999);
    		serverService = (IService)reg.lookup("serverService");		
    		
    		serverService.requestPres("nar0328", "a001", data);
    	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    	
    	try {
			Stage dialog = new Stage();
			dialog.initModality(Modality.WINDOW_MODAL);
			Parent childRoot = FXMLLoader.load(PreUploadMain.class.getResource("../fxml/alert_re.fxml"));
			dialog.initStyle(StageStyle.TRANSPARENT);
			
			
			
			Scene childScene = new Scene(childRoot);
			childScene.setFill(Color.TRANSPARENT);
			dialog.setScene(childScene);
			dialog.setTitle("사진 업로드 완료");
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
    void selectOtherPic(ActionEvent event) { //다른 사진 선택하기
    	//사진 선택
    	FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"), new ExtensionFilter("JPG 파일(.jpg)", "*.jpg"), new ExtensionFilter("PNG 파일(.png)", "*.png"));
		
		//열기할 폴더 지정
		File showDir = new File("C:\\Users\\PC-18\\Desktop\\OpenDialog");
		fileChooser.setInitialDirectory(showDir);
		
		//열기창 열기
		Stage stage = (Stage)btnCancel.getScene().getWindow();
		
		//파일 선택하기
		selectedFile = fileChooser.showOpenDialog(stage);
		System.out.println(selectedFile.getAbsoluteFile().toURI().toString());
		
		if(selectedFile != null) {
			//이미지파일 생성해서 imageview에 세팅하기
			selectedImg = new Image(selectedFile.getAbsoluteFile().toURI().toString());
			img.setLayoutX(0);
			img.setLayoutY(0);
			
			img.setFitHeight(430);
			img.setFitWidth(320);
			
			img.setImage(selectedImg);
			imgpane.setStyle("-fx-background-color : white");
			img.setEffect(null);
			
		}
		btnOk.setDisable(false);
		btnRotate.setDisable(false);
    }
    
    
    @FXML
    void upload(ActionEvent event) { //사진 선택하기
    	//사진 선택
    	FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"), new ExtensionFilter("JPG 파일(.jpg)", "*.jpg"), new ExtensionFilter("PNG 파일(.png)", "*.png"));
		
		//열기할 폴더 지정
		File showDir = new File("C:\\Users\\PC-18\\Desktop\\OpenDialog");
		fileChooser.setInitialDirectory(showDir);
		
		//열기창 열기
		Stage stage = (Stage)btnCancel.getScene().getWindow();
		
		//파일 선택하기
		selectedFile = fileChooser.showOpenDialog(stage);
		System.out.println(selectedFile.getAbsoluteFile().toURI().toString());
		
		if(selectedFile != null) {
			//이미지파일 생성해서 imageview에 세팅하기
			selectedImg = new Image(selectedFile.getAbsoluteFile().toURI().toString());
			img.setLayoutX(0);
			img.setLayoutY(0);
			
			img.setFitHeight(436);
			img.setFitWidth(326);
			
			img.setImage(selectedImg);		
			imgpane.setStyle("-fx-background-color : white");
			img.setEffect(null);
		}
		btnOk.setDisable(false);
		btnOtherPic.setDisable(false);
		btnRotate.setDisable(false);
		btnUpload.setDisable(true);
		

    }
    
    File selectedFile = null;
    Image selectedImg = null;
    byte[] data;
    
    IService serverService;
    @FXML
    void initialize() {
    	btnOk.setDisable(true);
    	btnOtherPic.setDisable(true);
    	btnRotate.setDisable(true);
    	
    }
}
