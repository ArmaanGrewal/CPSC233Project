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

//Note: Lines 39-46, and 89-96 come from the YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode

public class loginController {
	
	private Stage loginStage;

    @FXML
    private TextField passwordTextfield;
    
    @FXML
    private TextField usernameTextfield;
    
    @FXML
    private Label usernameErrorLabel;
    
    @FXML
    private Label passwordErrorLabel;
    
    private ArrayList<BankAccount> existingAccounts = new ArrayList<BankAccount>();
    private BankAccount theAccount;
    
    @FXML
    void createUserAccount(ActionEvent event) throws IOException {	
    	FXMLLoader loader1 = new FXMLLoader(getClass().getResource("CreateAccountScene.fxml"));
    	Parent root1 = loader1.load();
    	CreateAccountController controller1 = loader1.getController();
    	controller1.setUserAccount(existingAccounts, theAccount);
    	loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene createAccountScene = new Scene(root1, 550, 275);
    	loginStage.setScene(createAccountScene);
    	loginStage.show();
    }

    @FXML
    void signIntoUserAccount(ActionEvent event) throws IOException {
    	usernameErrorLabel.setText("");
    	passwordErrorLabel.setText("");
    	String usernameEntered = usernameTextfield.getText();
    	String passwordEntered = passwordTextfield.getText();
    	boolean usernameMatch = true;
    	int matchIndex = 0;
    	boolean noSignInErrors = true; 
    	if (existingAccounts.size() > 0) {
    		for (int accountIndex = 0; accountIndex < existingAccounts.size(); accountIndex++) {
        		if (!existingAccounts.get(accountIndex).getUsername().equals(usernameEntered)) {
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
    		if (!existingAccounts.get(matchIndex).getPassword().equals(passwordEntered)) {
    			passwordErrorLabel.setText("Incorrect password, please try again.");
    		}
    		else {
    			theAccount = existingAccounts.get(matchIndex);
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
    		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("BankAccountScene.fxml"));
        	Parent root2 = loader2.load();
        	bankSceneController controller2 = loader2.getController();
        	controller2.setUserAccount(existingAccounts, theAccount);
        	loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	Scene createAccountScene = new Scene(root2, 500, 300);
        	loginStage.setScene(createAccountScene);
        	loginStage.show();
    	}
    }
    
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    }
}

