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

//Note: Lines 52-59 come from the YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode

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

    @FXML
    void goToMain(ActionEvent event) throws IOException {
    	bankLoanError.setText("");
    	carLoanError.setText("");
    	mortgageError.setText("");
    	bankLoanError.setText(theAccount.setBankLoan(bankLoanTextfield.getText()));
    	carLoanError.setText(theAccount.setCarLoan(carLoanTextfield.getText()));
    	mortgageError.setText(theAccount.setMortgage(mortgageTextfield.getText()));
    	if (bankLoanError.getText() == "" && carLoanError.getText() == "" && mortgageError.getText() == "" ) {
        	FXMLLoader loader1 = new FXMLLoader(getClass().getResource("BankAccountScene.fxml"));
        	Parent root1 = loader1.load();
        	loanStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	bankSceneController controller1 = loader1.getController();
        	controller1.setNewUserAccount(existingAccounts, theAccount);
        	Scene createAccountScene = new Scene(root1, 500, 300);
        	loanStage.setScene(createAccountScene);
        	loanStage.show();
    	}
    }
    
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    }

}
