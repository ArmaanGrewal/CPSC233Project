package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {
	
	Stage loginStage;

    @FXML
    private TextField passwordTextfield;

    @FXML
    private TextField usernameTextfield;

    @FXML
    void createUserAccount(ActionEvent event) {
    	
    }

    @FXML
    void signIntoUserAccount(ActionEvent event) {
    	System.out.println("Sign In pressed");

    }

}

