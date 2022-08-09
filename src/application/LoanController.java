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

// Controller for the input loans window. (loansScene.fxml)
//Note: Lines 68-75 come from the YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode

public class LoanController {
	
	private Stage loanStage;
	
    private ArrayList<BankAccount> existingAccounts = new ArrayList<BankAccount>();
    private BankAccount theAccount;
    
    @FXML
    private TextField bankLoanTextfield;
    
    @FXML 
    private TextField carLoanTextfield;
    
    @FXML
    private TextField mortgageTextfield;
    
    @FXML
    private Label bankLoanError;
    
    @FXML 
    private Label carLoanError;
    
    @FXML
    private Label mortgageError;

    /**
     * Check if the user inputed  decimal numbers for the bank loan, car loan, and mortgage in the 
     * respective text-fields. If the user inputs something that is not a decimal, then the appropriate
     * error message will be displayed. 
     * @param event
     * The clicking of the 'Get Started!' button. 
     * @throws IOException
     */
    @FXML
    void goToMain(ActionEvent event) throws IOException {
    	// Initially set all of the error labels to blank. 
    	bankLoanError.setText("");
    	carLoanError.setText("");
    	mortgageError.setText("");
    	
    	// Call the 'setBankLoan' method, the 'setCarLoan' method, and the 'setMortgage' method which return
    	// an error message (if there is one) and display it on the respective error labels. Only move
    	// to the main bank account scene if all of the error labels are blank. 
    	bankLoanError.setText(theAccount.setBankLoan(bankLoanTextfield.getText()));
    	carLoanError.setText(theAccount.setCarLoan(carLoanTextfield.getText()));
    	mortgageError.setText(theAccount.setMortgage(mortgageTextfield.getText()));
    	if (bankLoanError.getText() == "" && carLoanError.getText() == "" && mortgageError.getText() == "" ) {
    		// The following block of code comes from this YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode
    		// (until line 75).
        	FXMLLoader loader1 = new FXMLLoader(getClass().getResource("BankAccountScene.fxml"));
        	Parent root1 = loader1.load();
        	loanStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	bankSceneController controller1 = loader1.getController();
        	controller1.setNewUserAccount(existingAccounts, theAccount);
        	Scene bankAccountScene = new Scene(root1, 500, 315);
        	loanStage.setScene(bankAccountScene);
        	loanStage.show();
    	}
    }
    
    /**
     * This method is to be used by other scenes to set the existingAccounts ArrayList and the current
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
