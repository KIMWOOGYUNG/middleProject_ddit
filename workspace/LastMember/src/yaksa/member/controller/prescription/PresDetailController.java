package yaksa.member.controller.prescription;

import java.io.ByteArrayInputStream;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import yaksa.member.vo.prescription.Mem_InboxVO;
import yaksa.member.vo.prescription.Phar_InboxVO;
import yaksa.server.rmiCommon.prescription.ICommon;

public class PresDetailController {
	
	ICommon common;
	byte[] data = null;
	String fileName;
	
	Phar_InboxVO vo;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancel;

    @FXML
    private Pane imgpane;

    @FXML
    private ImageView img;

    @FXML
    private Button btnRotate;

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void rotate(ActionEvent event) {
    	img.setRotate(img.getRotate() + 90);
    }

    public void setVo(Phar_InboxVO vo) {
    	this.vo = vo;
    	this.fileName = vo.getPhar_file();  	
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
    		data = common.receivePres(fileName);
    		System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		Image image = new Image(new ByteArrayInputStream(data));
		
		img.setLayoutX(0);
		img.setLayoutY(0);
		
		img.setFitHeight(435);
		img.setFitWidth(325);
		
		img.setImage(image);
		img.setEffect(null);
		
		
    }

    
    @FXML
    void initialize() {
      
    }
}
