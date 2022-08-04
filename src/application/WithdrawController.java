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

//Note: Lines 35-42 come from the YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode

public class WithdrawController {
	
	private Stage withdrawStage;
    private ArrayList<BankAccount> existingAccounts = new ArrayList<BankAccount>();
    private BankAccount theAccount;
    
    @FXML
    private TextField withdrawalTextfield;
    
    @FXML
    private Label withdrawAmountErrorLabel;
	
	@FXML
	void backtoAccountBalance(ActionEvent event) throws IOException {
		withdrawAmountErrorLabel.setText("");
		withdrawAmountErrorLabel.setText(theAccount.withdrawAmount(withdrawalTextfield.getText()));
		if (withdrawAmountErrorLabel.getText() == "") {
			FXMLLoader loader1 = new FXMLLoader(getClass().getResource("BankAccountScene.fxml"));
			Parent root1 = loader1.load();
	    	withdrawStage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	bankSceneController controller1 = loader1.getController();
	    	controller1.setUserAccount(existingAccounts, theAccount);
	    	Scene createAccountScene = new Scene(root1, 500, 300);
	    	withdrawStage.setScene(createAccountScene);
	    	withdrawStage.show();
		}
	}
	
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    }

}
