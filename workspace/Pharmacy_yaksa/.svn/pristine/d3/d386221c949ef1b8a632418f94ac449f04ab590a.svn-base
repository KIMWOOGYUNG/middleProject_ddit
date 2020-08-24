package yaksa.chemist.controller.prescription;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.chemist.vo.prescription.InboxVO;
import yaksa.chemist.vo.prescription.PrescriptionVO;
import yaksa.chemist.vo.prescription.ReceiptVO;
import yaksa.chemist.vo.prescription.SaleVO;
import yaksa.server.rmiCommon.prescription.ICommon2;

public class PreviewController {

	static List<ReceiptVO> rctList;
	static List<SaleVO> saleList; 
	static PrescriptionVO presVo;
	String fileName;
	int fileNum;
	byte[] data;
	byte[] data2;
	InboxVO vo;
	PresOfChemiController pcc;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane borderPane;
    
    @FXML
    private Pane imgpane;

    @FXML
    private ImageView img;

    @FXML
    private Button btnCancel;
    
    @FXML
    private Button btnReject;

    @FXML
    private Button btnAccept;

    @FXML
    private Button btnRotate;

    @FXML
    private Pane rightPane;
    
    @FXML
    private Button btnInventory;

    @FXML
    private Button btnWrtPres;
    
    @FXML
    private Button btnPresDone;
    
    
    @FXML
    void accept(ActionEvent event) {
    	try {
			Stage dialog = new Stage();
			dialog.initModality(Modality.WINDOW_MODAL);
			FXMLLoader fxml = new FXMLLoader(getClass().getResource("/yaksa/chemist/fxml/prescription/Accept.fxml"));
			Parent childRoot = fxml.load();
			dialog.initStyle(StageStyle.TRANSPARENT);
			
			AcceptController ac = fxml.getController();
			ac.selected_messNum(fileNum);
			ac.getImgData(data2);
			
						
			Scene childScene = new Scene(childRoot);
			childScene.setFill(Color.TRANSPARENT);
			dialog.setScene(childScene);
			dialog.show();
			
			Stage stage = (Stage) btnCancel.getScene().getWindow();
	    	stage.close();
			
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void reject(ActionEvent event) {
    	try {
			Stage dialog = new Stage();
			dialog.initModality(Modality.WINDOW_MODAL);
			FXMLLoader fxml = new FXMLLoader(getClass().getResource("/yaksa/chemist/fxml/prescription/Reject.fxml"));
			Parent childRoot = fxml.load();
			dialog.initStyle(StageStyle.TRANSPARENT);
					
			RejectController rc = fxml.getController();
			rc.selected_messNum(fileNum);
			
			Scene childScene = new Scene(childRoot);
			childScene.setFill(Color.TRANSPARENT);
			dialog.setScene(childScene);
			dialog.show();
			
			Stage stage = (Stage) btnCancel.getScene().getWindow();
	    	stage.close();
			
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void imgZoom(MouseEvent event) {
    	try {
    		Stage dialog = new Stage();
			dialog.initModality(Modality.WINDOW_MODAL);
			//dialog.initStyle(StageStyle.TRANSPARENT);
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("/yaksa/chemist/fxml/prescription/PresZoom.fxml"));
			Parent childRoot = fxml.load();
			
			PresZoomController pzc = fxml.getController();
			pzc.setData(data);
			
			Scene childScene = new Scene(childRoot);
			//childScene.setFill(Color.TRANSPARENT);
			dialog.setScene(childScene);
			dialog.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void rotate(ActionEvent event) {
    	img.setRotate(img.getRotate() + 90);
    }
    
    @FXML
    void inventory(ActionEvent event) {
    	try {
    		borderPane.setRight(null);
    		borderPane.setCenter(null);
    		
    		FXMLLoader fxml = new FXMLLoader(getClass().getResource("/yaksa/chemist/fxml/prescription/Inventory.fxml"));
			Parent childroot = fxml.load();
			
			InventoryController inven = fxml.getController();
			inven.setPresVO(vo);
			
			borderPane.setCenter(childroot);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    private void createEncodedString(Node node) {
    	//SnapshotParameters para = new SnapshotParameters();
    	//WritableImage imgSize = new WritableImage(600, 900);
        WritableImage image = node.snapshot(new SnapshotParameters(), null);
        String base64String = encodeImageToString(SwingFXUtils.fromFXImage(image, null), "png");
        System.out.println("Base64 String : " + base64String);
    }
    
    private String encodeImageToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            data2 = bos.toByteArray();
            imageString = Base64.getEncoder().encodeToString(data2);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
    
    Pane prePane;
    @FXML
    void wrtPres(ActionEvent event) {
    	try {
    		
    		borderPane.setMinWidth(1000);
    		borderPane.setRight(null);
    		borderPane.setCenter(null);
    		
    		FXMLLoader fxml =  new FXMLLoader(getClass().getResource("/yaksa/chemist/fxml/prescription/PresOfChemi.fxml"));
			Parent childRoot = fxml.load();
			pcc = fxml.getController();
		
			pcc.setID(vo);
			borderPane.setCenter(childRoot);
			
			prePane = (Pane)childRoot.lookup("#presPane");
			createEncodedString(prePane);
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void presDone(ActionEvent event) {
    	btnAccept.setDisable(false);
    	btnReject.setDisable(false);
    	setPresVO();    	
    	
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }
    
    public void setVo(InboxVO vo) {
    	this.vo = vo;
    	this.fileName = vo.getPhar_file();
    	this.fileNum = vo.getPhar_messnum();
    	
    	
    }
    
    public void setPresVO() {

    	presVo.setPhpres_code(fileName);
    	presVo.setMem_id(vo.getPhar_memid());
    	presVo.setPharm_id(vo.getPharm_id());
    	
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
		img.setLayoutY(25);
		
		img.setFitHeight(430);
		img.setFitWidth(310);
		
		img.setImage(image);
		img.setEffect(null);
		
		
    }
    
    ICommon2 common2;
    @FXML
    void initialize(){   	
    	rctList = new ArrayList<ReceiptVO>();
    	saleList = new ArrayList<SaleVO>();
    	presVo = new PrescriptionVO();
    	btnAccept.setDisable(true);
    	btnReject.setDisable(true);
    }
}
