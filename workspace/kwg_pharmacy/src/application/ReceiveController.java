package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import service.PharmServiceImpl;
import vo.PrescriptionVO;

public class ReceiveController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane content;

    @FXML
    private TableView<PrescriptionVO> table;

    @FXML
    private TableColumn<PrescriptionVO, Integer> colNum;

    @FXML
    private TableColumn<PrescriptionVO, String> colDate;

    @FXML
    private TableColumn<PrescriptionVO, String> colMemId;

    @FXML
    void clickTable(ActionEvent event) {

    }

	/*
	 * List<PrescriptionVO> prescriptioinList =
	 * PharmServiceImpl.getInstance().getAllPrescription();
	 * ObservableList<PrescriptionVO> data =
	 * FXCollections.observableArrayList(prescriptioinList);
	 */
    @FXML
    void initialize() {
		/*
		 * table.setItems(data);
		 * 
		 * colNum.setCellValueFactory(new PropertyValueFactory<PrescriptionVO,
		 * Integer>("phar_messnum")); colDate.setCellValueFactory(new
		 * PropertyValueFactory<PrescriptionVO, String>("phar_inboxdate"));
		 * colMemId.setCellValueFactory(new PropertyValueFactory<PrescriptionVO,
		 * String>("pharm_id"));
		 */
    }
}
