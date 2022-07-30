package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {
	
	Stage loginStage;

    @FXML
    private TextField passwordTextfield;
    

    @FXML
    private TextField usernameTextfield;
    
    @FXML
    private Label usernameErrorLabel;
    
    @FXML
    private Label passwordErrorLabel;
    
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
    	usernameErrorLabel.setText("");
    	passwordErrorLabel.setText("");
    	String usernameEntered = usernameTextfield.getText();
    	String passwordEntered = passwordTextfield.getText();
    	boolean noSignInErrors = true; 
    	BankAccount userAccount = new BankAccount();
    	usernameErrorLabel.setText(userAccount.setUsername(usernameEntered));
    	passwordErrorLabel.setText(userAccount.setPassword(passwordEntered));
    	if (!usernameErrorLabel.getText().equals("") || !passwordErrorLabel.getText().equals("")) {
    		noSignInErrors = false;
    	}
    	if (noSignInErrors) {
        	Parent root1 = FXMLLoader.load(getClass().getResource("BankAccountScene.fxml"));
        	loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	Scene createAccountScene = new Scene(root1, 450, 225);
        	loginStage.setScene(createAccountScene);
        	loginStage.show();
    	}
    }
}

