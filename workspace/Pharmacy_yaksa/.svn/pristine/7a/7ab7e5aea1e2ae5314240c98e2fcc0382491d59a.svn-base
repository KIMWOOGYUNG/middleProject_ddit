package yaksa.chemist.controller.prescription;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PresZoomController {
	byte[] data;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView img;

    @FXML
    void imgClick(MouseEvent event) {

    }
    
    void setData(byte[] data) {
    	this.data = data;
    	System.out.println(data);
    	
    	Image image = new Image(new ByteArrayInputStream(data));
		
		img.setLayoutX(0);
		img.setLayoutY(0);
		
		img.setFitHeight(967.5);
		img.setFitWidth(697.5);
		
		img.setImage(image);
		img.setEffect(null);
    }
    
    
    
    @FXML
    void initialize() {

    }
}
