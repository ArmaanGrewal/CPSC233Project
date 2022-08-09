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

// Controller for the create account window. (CreateAccountScene.fxml)
// Note: Lines 143-150 and 166-173 come from the YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode

public class CreateAccountController {
	
	private Stage createAccountStage;
	
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
    
    @FXML 
    private Label usersNameError;
    
    /**
     * Check if the user enters their name, a valid card number, a valid password meeting all 
     * requirements, and if the confirm password field matches the password that the user initially
     * set. 
     * @param event
     * The clicking of the 'Create Account' button.
     * @throws IOException
     */
    @FXML
    void goToLoans(ActionEvent event) throws IOException {
    	// Initially set all of the error messages to blank. 
    	cardErrorLabel.setText("");
    	passwordErrorLabel.setText("");
    	confirmPasswordErrorLabel.setText("");
    	usersNameError.setText("");
    	
    	// Get all of the text from each TextField and store them into variables. 
    	String nameEntered = "";
    	String usernameEntered = "";
    	String passwordEntered = "";
    	String passwordConfirmed = "";
    	nameEntered = usersNameTextfield.getText();
    	usernameEntered = cardNumberTextfield.getText();
    	passwordEntered = passwordTextfield.getText();
    	passwordConfirmed = confirmPasswordTextfield.getText();
    	
    	// Check if the account already exists in the existingAccounts ArrayList, if it does prompt
    	// the user to 'Sign In'
    	boolean noCreateAccountErrors = true;
    	if (existingAccounts.size() > 0) {
    		for (int accountIndex = 0; accountIndex < existingAccounts.size(); accountIndex++) {
    			if (usernameEntered.equals(existingAccounts.get(accountIndex).getUsername())) {
    				noCreateAccountErrors = false;
    			}
    		}
    		if (!noCreateAccountErrors) {
    			cardErrorLabel.setText("Account already exists, please proceed to the 'Sign In' option.");
    		}
    	}
    	
    	// Ensure that the user has at least entered something for each of the fields. 
    	if (noCreateAccountErrors) {
    	 	if (nameEntered == "") {
        		usersNameError.setText("Please enter a name!");
        		noCreateAccountErrors = false;
        	}
        	if (usernameEntered == "") {
        		cardErrorLabel.setText("Please enter your card information!");
        		noCreateAccountErrors = false;
        	}
        	if (passwordEntered == "") {
        		passwordErrorLabel.setText("Please set your account password!");
        		noCreateAccountErrors = false;
        	}
        	if (passwordConfirmed == "") {
        		confirmPasswordErrorLabel.setText("Please confirm your password!");
        		noCreateAccountErrors = false;
        	}
    	}
    	
    	// If all the preliminary conditions above are met, then check to see if the user follows all
    	// of the guidelines for the card number, the password, and the password confirmation. 
    	if (noCreateAccountErrors) {
        	BankAccount userAccount = new BankAccount();
        	
        	// Call the setUsername and setPassword methods which each return error messages and check
        	// if the guidelines are met for each field. 
        	cardErrorLabel.setText(userAccount.setUsername(usernameEntered));
        	passwordErrorLabel.setText(userAccount.setPassword(passwordEntered));
        	if (!passwordEntered.equals(passwordConfirmed)) {
        		confirmPasswordErrorLabel.setText("Error: Passwords do not match. Please try again!");
        	}
        	if (nameEntered == "") {
        		usersNameError.setText("Please enter a name!");
        	}
        	
        	// Only move to the next screen if all the error labels are blank. 
        	if (!cardErrorLabel.getText().equals("") || !passwordErrorLabel.getText().equals("") || 
        			!confirmPasswordErrorLabel.getText().equals("") || !usersNameError.getText().equals("")) {
        		noCreateAccountErrors = false;
        	}
        	
        	// If all the conditions are met, then add the account to existingAccounts, set theAccount,
        	// and set the account name entered by the user. Also, move to the next screen by passing the 
        	// existingAccounts information and the current account being used. 
        	else {
        		existingAccounts.add(userAccount);
        		theAccount = userAccount;
        		theAccount.setName(nameEntered);
        	}
        	if (noCreateAccountErrors) {
        		// The following block of code comes from this YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode
        		// (until line 150). 
        		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("loansScene.fxml"));
        	  	Parent root1 = loader1.load();
            	createAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            	LoanController controller1 = loader1.getController();
            	controller1.setUserAccount(existingAccounts, theAccount);
            	Scene enterLoansScene = new Scene(root1, 450, 250);
            	createAccountStage.setScene(enterLoansScene);
            	createAccountStage.show();
        	}
    	}
    }
    
    /**
     * Switch to the login window by clicking the 'Sign In button and pass the existingAccounts and 
     * current account information. 
     * @param event
     * The clicking of the 'Sign In' method. 
     * @throws IOException
     */
    @FXML
    void login(ActionEvent event) throws IOException {
    	// The following block of code comes from this YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode
    	// (until line 173).
    	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
    	Parent root2 = loader2.load();
    	createAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	loginController controller2 = loader2.getController();
    	controller2.setUserAccount(existingAccounts, theAccount);
    	Scene loginScene = new Scene(root2, 475, 250);
    	createAccountStage.setScene(loginScene);
    	createAccountStage.show();
    }
    
    /**
     * This is a method to be used by other scenes to pass the existingAccounts ArrayList and the current
     * account being used. 
     * @param anAccountList
     * The existingAccounts ArrayList. 
     * @param accountUsed
     * The current account being used. 
     */
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    }

}
