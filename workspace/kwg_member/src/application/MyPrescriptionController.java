package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyPrescriptionController {

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
    private Button btnSave;

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void save(ActionEvent event) {
    	
    	FileChooser fileChooser = new FileChooser();
    	File file = fileChooser.showSaveDialog(imgpane.getScene().getWindow());
    	if(file != null) {
    		WritableImage image = new WritableImage(326,436);
    		imgpane.snapshot(null, image);
    		File imageFile = file;
    		try {
    			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", imageFile);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }

	@FXML
    void initialize() {
        
    }
}
