package yaksa.publicChatClient.main;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import yaksa.publicChatClient.ui.controller.ChatRoom;
import yaksa.publicChatCommon.model.User;

/**
 * Created by oshan on 19-Nov-17.
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
//
    	
    	URL fxmlPath = new File("src/yaksa/publicChatClient/ui/fxml/ChatRoom.fxml").toURL();
        FXMLLoader loader = new FXMLLoader(fxmlPath);

        primaryStage.setScene(new Scene(loader.load()));
        ChatRoom chatRoom=loader.getController();
       
        User user = new User("이약사", "약국");
        
        chatRoom.setUsername(user);
      
        primaryStage.show();

//        FXMLLoader fxmlLoader1=new FXMLLoader(getClass().getResource("../ui/fxml/ChatRoom.fxml"));
//        Stage stage=new Stage();
//        stage.setScene(new Scene(fxmlLoader1.load()));
//
//        ChatRoom chatRoom1=fxmlLoader.getController();
//        chatRoom1.setUsername("user 2");
//
//        stage.show();
//
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        
//        
//        URL fxmlPath = new File("src/yaksa/publicChatClient/ui/fxml/ChatRoom.fxml").toURL();
//     
//        
//        
//        FXMLLoader loader = new FXMLLoader(fxmlPath);
//        
//        Parent root= loader.load();
//        
//        Scene scene=new Scene(root);
//         
//        scene.setFill(Color.TRANSPARENT);
//        primaryStage.setScene(scene);
//        primaryStage.show();

    }
    
    public static void main(String[] args) {
		launch(args);
	}
    
    
}
