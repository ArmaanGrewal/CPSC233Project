package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {
	
	Stage loginStage;

    @FXML
    private TextField passwordTextfield;
    

    @FXML
    private TextField usernameTextfield;
    
    @FXML
    void createUserAccount(ActionEvent event) throws IOException {
    	Parent root1 = FXMLLoader.load(getClass().getResource("CreateAccountScene.fxml"));
    	loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene createAccountScene = new Scene(root1, 450, 225);
    	loginStage.setScene(createAccountScene);
    	loginStage.show();
    }

    @FXML
    void signIntoUserAccount(ActionEvent event) throws IOException {
    	Parent root1 = FXMLLoader.load(getClass().getResource("BankAccountScene.fxml"));
    	loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene createAccountScene = new Scene(root1, 450, 225);
    	loginStage.setScene(createAccountScene);
    	loginStage.show();
    }
}

