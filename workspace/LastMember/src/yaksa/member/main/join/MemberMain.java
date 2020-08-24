package yaksa.member.main.join;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MemberMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(MemberMain.class.getResource("../../fxml/join/a0_login.fxml"));
		primaryStage.initStyle(StageStyle.TRANSPARENT); //
		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("로그인");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}