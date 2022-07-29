package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class loginController {
	
	Stage loginStage;

    @FXML
    private TextField passwordTextfield;

    @FXML
    private TextField usernameTextfield;

    @FXML
    void createUserAccount(ActionEvent event) {
    	FXMLLoader loader1 = new FXMLLoader();
    	VBox root1 = new VBox();
    	try {
			root1 = loader1.load(new FileInputStream("src/application/CreateAccountScene.fxml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Scene createAccountScene = new Scene(root1, 450, 225);
    	loginStage.setScene(createAccountScene);
    }

    @FXML
    void signIntoUserAccount(ActionEvent event) {
    	System.out.println("Sign In pressed");

    }

}

