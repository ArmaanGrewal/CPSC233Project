package application;

import java.io.IOException;
import java.util.ArrayList;

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
	
	private CreateAccountController account = new CreateAccountController();

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
    	Scene createAccountScene = new Scene(root1, 450, 275);
    	loginStage.setScene(createAccountScene);
    	loginStage.show();
    }

    @FXML
    void signIntoUserAccount(ActionEvent event) throws IOException {
    	usernameErrorLabel.setText("");
    	passwordErrorLabel.setText("");
    	String usernameEntered = usernameTextfield.getText();
    	String passwordEntered = passwordTextfield.getText();
    	ArrayList<BankAccount> accounts = account.getExistingAccounts();
    	boolean usernameMatch = true;
    	int matchIndex = 0;
    	boolean noSignInErrors = true; 
    	if (accounts.size() > 0) {
    		for (int accountIndex = 0; accountIndex < accounts.size(); accountIndex++) {
        		if (!accounts.get(accountIndex).getUsername().equals(usernameEntered)) {
        			usernameMatch = false;
        		}
        		else {
        			usernameMatch = true;
        			matchIndex = accountIndex;
        			break;
        		}
        	}
    	}
    	else {
    		usernameMatch = false;
    	}
    	if (usernameMatch) {
    		if (!accounts.get(matchIndex).getPassword().equals(passwordEntered)) {
    			passwordErrorLabel.setText("Incorrect password, please try again.");
    		}
    	}
    	else {
    		usernameErrorLabel.setText("This username does not exist, "
    				+ "please proceed to the 'Create Account' option.");
    	}
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

