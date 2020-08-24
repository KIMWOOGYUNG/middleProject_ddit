package yaksa.member.controller.map;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.member.controller.map.wait.WaitScreenController;
import yaksa.member.service.map.SearchServiceImpl;
import yaksa.member.util.prescription.AlertUtil;
import yaksa.member.vo.map.PharmVO;
import yaksa.server.rmiCommon.prescription.Controller;
import yaksa.server.rmiCommon.prescription.ServerConnect;

public class ContYKDetail {
	

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label LaPharmNM;

	@FXML
	private Label LaAdd1;

	@FXML
	private Label LaAdd2;

	@FXML
	private Label LaTel;

	@FXML
	private Label LaOPTime;

	@FXML
	private Label LaCLTime;

	@FXML
	private Label LaStar;

	@FXML
	private Button CloseBtn;

	@FXML
	private Button ChatBtn;

	@FXML
	private Button PcSendBtn;

	private SearchServiceImpl service;
	private PharmVO pvo;
	private Controller controller;
	
	public static PharmVO pvo2;

	@FXML
	void PrecSend(ActionEvent event) {
		// 처방전 전송 버튼 눌렀을 때
		try {
			Stage dialog = new Stage();
			dialog.initModality(Modality.WINDOW_MODAL);
			Parent childRoot = FXMLLoader.load(getClass().getResource("../../fxml/prescription/PresUpload.fxml"));
			dialog.initStyle(StageStyle.TRANSPARENT);
			
			Scene childScene = new Scene(childRoot);
			childScene.setFill(Color.TRANSPARENT);
			dialog.setScene(childScene);
			dialog.setTitle("사진 업로드 완료");
			dialog.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void Chat(ActionEvent event) {
		// 채팅버튼 눌렀을 때
		
		System.out.println(pvo.getPharm_id());
		System.out.println(pvo2.getPharm_id());

		//
				try {
					if(controller.CheckYaksa(pvo.getPharm_id()) ) {
//						
				
						Stage primaryStage = (Stage) ChatBtn.getScene().getWindow();
						FXMLLoader detail = new FXMLLoader(
								ContYKSearch.class.getResource("./wait/WaitScreen.fxml"));
						Parent childRoot;
							childRoot = detail.load();
						Stage detailStage = new Stage();
						
						WaitScreenController screen = detail.getController();
						
						screen.setId(pvo.getPharm_id());
//							Stage detailStage = new Stage(StageStyle.DECORATED);
//							detailStage.initModality(Modality.WINDOW_MODAL);
						detailStage.initOwner(primaryStage);

						Scene scene = new Scene(childRoot);

						detailStage.setScene(scene);
						detailStage.setTitle("대기중");
						detailStage.show();
						} 
						
					else {
						
						AlertUtil.infoMsg("현재 사용자", "사용자가 접속하지 않았습니다.");
					}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//				} catch (RemoteException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}catch (IOException e) {
//					// TODO: handle exception
//				}
	}

	@FXML
	void Close(ActionEvent event) {
		Stage currentStage = (Stage) CloseBtn.getScene().getWindow();
		currentStage.close();
	}

	void showupdate(PharmVO pvo) {
		this.pvo = pvo;
		LaPharmNM.setText(pvo.getPharm_name());
		LaAdd1.setText(pvo.getPharm_add1());
		LaAdd2.setText(pvo.getPharm_add2());
		LaTel.setText(pvo.getPharm_tel());
		LaOPTime.setText(pvo.getPharm_opentime());
		LaCLTime.setText(pvo.getPharm_closetime());
		LaStar.setText(Integer.toString(pvo.getPharm_starrate()));
		
		pvo2 = pvo;
	}

	
	
	@FXML
	void initialize() {
		service = SearchServiceImpl.getInstance();
		try {
			controller = ServerConnect.getServerConnector().getController();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
