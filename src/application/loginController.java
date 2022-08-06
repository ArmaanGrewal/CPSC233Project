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

// Controller for the login window. 
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
    
    // the ArrayList of existing accounts and the account currently being used. 
    private ArrayList<BankAccount> existingAccounts = new ArrayList<BankAccount>();
    private BankAccount theAccount;
    
    /**
     * Go to the create account window and pass the information of existing accounts and the current account being used. 
     * @param event
     * Clicking the 'Create Account' button on the login window. 
     * @throws IOException
     */
    @FXML
    void createUserAccount(ActionEvent event) throws IOException {	
    	FXMLLoader loader1 = new FXMLLoader(getClass().getResource("CreateAccountScene.fxml"));
    	Parent root1 = loader1.load();
    	CreateAccountController controller1 = loader1.getController();
    	controller1.setUserAccount(existingAccounts, theAccount);
    	loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene createAccountScene = new Scene(root1, 550, 315);
    	loginStage.setScene(createAccountScene);
    	loginStage.show();
    }

    /**
     * Check if the user-name exists and if it does, check if the password matches the password stored for the existing user-name. 
     * @param event
     * Clicking the 'Sign In' button on the login window. 
     * @throws IOException
     */
    @FXML
    void signIntoUserAccount(ActionEvent event) throws IOException {
    	// set both the error labels as blank.
    	usernameErrorLabel.setText("");
    	passwordErrorLabel.setText("");
    	String usernameEntered = usernameTextfield.getText();
    	String passwordEntered = passwordTextfield.getText();
    	boolean usernameMatch = true;
    	int matchIndex = 0;
    	boolean noSignInErrors = true; 
    	
    	// If the size of the existingAccount ArrayList is greater than 1, check if the the user-name entered exists in the ArrayList.
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
    	
    	// If the size of the existingAccount ArrayList is < 1, then prompt the user to 'Create Account'.
    	else {
    		usernameMatch = false;
    	}
    	
    	// If the user-name entered matches one of the accounts in the existingAccounts ArrayList, then check if the password entered is the
    	// same as the password stored on the account.
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
    	
    	// if the the error labels aren't blank, then the noSignInErrors variable is set to false indicating that there are sign in errors. 
    	if (!usernameErrorLabel.getText().equals("") || !passwordErrorLabel.getText().equals("")) {
    		noSignInErrors = false;
    	}
    	
    	// if there are no sign in errors, then switch to the main bank account scene passing the existing accounts and the current account
    	// information. 
    	if (noSignInErrors) {
    		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("BankAccountScene.fxml"));
        	Parent root2 = loader2.load();
        	bankSceneController controller2 = loader2.getController();
        	controller2.setUserAccount(existingAccounts, theAccount);
        	loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	Scene createAccountScene = new Scene(root2, 500, 315);
        	loginStage.setScene(createAccountScene);
        	loginStage.show();
    	}
    }
    
    /**
     * Set the existing accounts ArrayList and the current account being used (a method used by other scenes). 
     * @param anAccountList
     * The ArrayList of existing accounts. 
     * @param accountUsed
     * The current account being used. 
     */
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    }
}

