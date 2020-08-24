package yaksa.member.controller.mypage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import yaksa.member.controller.main.MainController;
import yaksa.member.service.mypage.MemServiceImpl;
import yaksa.member.vo.join.SessionVO;
import yaksa.member.vo.mypage.PharmPresVO;

public class a4Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Pane CharView;
    
    @FXML
    private Text namelb;
    
    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage) CharView.getScene().getWindow();    
        stage.close();
    }

    @FXML
    void initialize() {
    	
    	if(MainController.memVO!=null) {
            namelb.setText(SessionVO.loginMember.getMem_name());
         }else {
            namelb.setText("");
         }
    	
    	CharView.getChildren().add(barChart());
    }
    
    BarChart<String, Number> barChart(){
    	//환자가 방문한 약국 통계
    	CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis();
        BarChart<String, Number> bc = new BarChart<String, Number>(x, y);
    	
    	// 사용되는 vo => phprvo        
        
        XYChart.Series<String, Number> ser =  new XYChart.Series<String, Number>();
        ser.setName("2020년 4월");
        
        List<PharmPresVO> pList = MemServiceImpl.getInstance().ykvisit("nar0328");
        
        for(int i=0;i<pList.size();i++) {
           ser.getData().add(new XYChart.Data<String, Number>(pList.get(i).getPharm_name(),pList.get(i).getCnt()));
        }
        
        bc.getData().add(ser);
        return bc;
    }

	public void setMainConterolloer(a1Controller a1Controller) {
		// TODO Auto-generated method stub
		
	}
}
