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

// Controller for the withdraw window. (WithdrawScene.fxml)
// Note: Lines 49-56 come from the YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode

public class WithdrawController {
	
	private Stage withdrawStage;
    private ArrayList<BankAccount> existingAccounts = new ArrayList<BankAccount>();
    private BankAccount theAccount;
    
    @FXML
    private TextField withdrawalTextfield;
    
    @FXML
    private Label withdrawAmountErrorLabel;
	
    /**
     * Calls the withdrawAmount (in BankAccountInfo class) method on theAccount and if there 
     * is an error, then that will be displayed on the withdraw error label. 
     * @param event
     * The clicking of the 'Withdraw' button
     * @throws IOException
     */
	@FXML
	void backtoAccountBalance(ActionEvent event) throws IOException {
		// Initially set the withdraw error label text to blank. 
		withdrawAmountErrorLabel.setText("");
		
		// Call the withdrawAmount method from theAccount and only move back to the account
		// balance screen if the error label is blank. 
		withdrawAmountErrorLabel.setText(theAccount.withdrawAmount(withdrawalTextfield.getText()));
		if (withdrawAmountErrorLabel.getText() == "") {
			// The following block of code comes from this YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode
			// (until line 56)
			FXMLLoader loader1 = new FXMLLoader(getClass().getResource("BankAccountScene.fxml"));
			Parent root1 = loader1.load();
	    	withdrawStage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	bankSceneController controller1 = loader1.getController();
	    	controller1.setUserAccount(existingAccounts, theAccount);
	    	Scene bankAccountScene = new Scene(root1, 500, 315);
	    	withdrawStage.setScene(bankAccountScene);
	    	withdrawStage.show();
		}
	}
	
	/**
	 * This method is used by other scenes to set the existing accounts ArrayList and the current account
	 * being used. 
	 * @param anAccountList
	 * The existing accounts list. 
	 * @param accountUsed
	 * The current account being used. 
	 */
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    }

}
