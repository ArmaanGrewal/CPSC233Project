package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//Note: Lines 75-82 come from the YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode

public class CreateAccountController {
	
	private Stage loanStage;
	
    private ArrayList<BankAccount> existingAccounts = new ArrayList<BankAccount>();
    private BankAccount theAccount;
    
    @FXML
    private TextField usersNameTextfield;
    
    @FXML
    private TextField cardNumberTextfield;
    
    @FXML
    private TextField passwordTextfield;
    
    @FXML
    private TextField confirmPasswordTextfield;
    
    @FXML
    private Label cardErrorLabel;
    
    @FXML
    private Label passwordErrorLabel;
    
    @FXML
    private Label confirmPasswordErrorLabel;
    
    
    public ArrayList<BankAccount> getExistingAccounts() {
    	return existingAccounts;
    }
    
    @FXML
    void goToLoans(ActionEvent event) throws IOException {
    	cardErrorLabel.setText("");
    	passwordErrorLabel.setText("");
    	confirmPasswordErrorLabel.setText("");
    	String usernameEntered = cardNumberTextfield.getText();
    	String passwordEntered = passwordTextfield.getText();
    	String passwordConfirmed = confirmPasswordTextfield.getText();
    	boolean noCreateAccountErrors = true;
    	if (existingAccounts.size() > 0) {
    		for (int accountIndex = 0; accountIndex < existingAccounts.size(); accountIndex++) {
    			if (usernameEntered.equals(existingAccounts.get(accountIndex).getUsername())) {
    				noCreateAccountErrors = false;
    			}
    		}
    	}
    	if (noCreateAccountErrors) {
        	BankAccount userAccount = new BankAccount();
        	cardErrorLabel.setText(userAccount.setUsername(usernameEntered));
        	passwordErrorLabel.setText(userAccount.setPassword(passwordEntered));
        	if (!passwordEntered.equals(passwordConfirmed)) {
        		confirmPasswordErrorLabel.setText("Error: Passwords do not match. Please try again!");
        	}
        	if (!cardErrorLabel.getText().equals("") || !passwordErrorLabel.getText().equals("") || 
        			!confirmPasswordErrorLabel.getText().equals("")) {
        		noCreateAccountErrors = false;
        	}
        	else {
        		existingAccounts.add(userAccount);
        		theAccount = userAccount;
        	}
        	theAccount.setName(usersNameTextfield.getText());
        	if (noCreateAccountErrors) {
        		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("loansScene.fxml"));
        	  	Parent root1 = loader1.load();
            	loanStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            	LoanController controller1 = loader1.getController();
            	controller1.setUserAccount(existingAccounts, theAccount);
            	Scene createAccountScene = new Scene(root1, 450, 250);
            	loanStage.setScene(createAccountScene);
            	loanStage.show();
        	}
    	}
    	else {
    		cardErrorLabel.setText("Account already exists, please proceed to the 'Sign In' option.");
    	}
    }
    
    @FXML
    void login(ActionEvent event) throws IOException {
    	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
    	Parent root2 = loader2.load();
    	loanStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	loginController controller2 = loader2.getController();
    	controller2.setUserAccount(existingAccounts, theAccount);
    	Scene loginScene = new Scene(root2, 475, 250);
    	loanStage.setScene(loginScene);
    	loanStage.show();
    }
    
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    }

}
