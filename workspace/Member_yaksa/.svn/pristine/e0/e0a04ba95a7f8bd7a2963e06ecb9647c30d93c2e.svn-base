package yaksa.member.controller.pillSearch;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import yaksa.member.service.pillSearch.PillServiceImpl;
import yaksa.member.vo.pillSearch.PillVO;

public class PillSearchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField SearchTf;

    @FXML
    private Button SearchBtn;

    @FXML
    private TableView<PillVO> table;

    @FXML
    private TableColumn<PillVO, String> pillcode;

    @FXML
    private TableColumn<PillVO, String> pillname;

    @FXML
    private TableColumn<PillVO, String> pillfrom;

    @FXML
    private TableColumn<PillVO, String> pillect;
    
    @FXML
    private ComboBox<String> select;

    @FXML
    void SearchPill(ActionEvent event) {
       String pillname = SearchTf.getText();
       ObservableList<PillVO> data = null;
       
       if(select.getValue().equals("약코드")) {
          List<PillVO> pillList = PillServiceImpl.getInstance().getSearchPillNum(pillname);
           data = FXCollections.observableArrayList(pillList);
       } else if(select.getValue().equals("약이름")) {
          List<PillVO> pillList = PillServiceImpl.getInstance().getSearchPill(pillname);
          data = FXCollections.observableArrayList(pillList);
       } else if(select.getValue().equals("판매처")) {
          List<PillVO> pillList = PillServiceImpl.getInstance().getSearchPillFrom(pillname);
          data = FXCollections.observableArrayList(pillList);
       }
       
       table.setItems(data);
       

    }
    

    @FXML
    void initialize() {
    
       select.getItems().addAll("약코드", "약이름", "판매처");
       select.setValue(select.getItems().get(0));
       
       List<PillVO> pillList = PillServiceImpl.getInstance().getAllPill();
       ObservableList<PillVO> data = FXCollections.observableArrayList(pillList);
       
       table.setItems(data);

       pillcode.setCellValueFactory(new PropertyValueFactory<PillVO, String>("medi_code"));
       pillname.setCellValueFactory(new PropertyValueFactory<PillVO, String>("medi_name"));
       pillfrom.setCellValueFactory(new PropertyValueFactory<PillVO, String>("medi_com"));
       pillect.setCellValueFactory(new PropertyValueFactory<PillVO, String>("medi_etc"));

    }
}