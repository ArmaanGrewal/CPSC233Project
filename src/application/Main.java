package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/ApplicationScene.fxml"));
			loginController controller = (loginController) loader.getController();
			controller.loginStage = primaryStage;
			Scene scene = new Scene(root,450,225);
			primaryStage.setScene(scene);
			primaryStage.setTitle("J & A Banking Institution");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
