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

public class DepositController {
	
	Stage depositStage;
    private ArrayList<BankAccount> existingAccounts = new ArrayList<BankAccount>();
    private BankAccount theAccount;
    
    @FXML
    private TextField depositTextfield;
    
    @FXML
    private Label depositErrorLabel;

    @FXML
    void backToBalance(ActionEvent event) throws IOException {
    	depositErrorLabel.setText("");
    	depositErrorLabel.setText(theAccount.depositAmount(depositTextfield.getText()));
    	if (depositErrorLabel.getText() == "" ) {
        	FXMLLoader loader1 = new FXMLLoader(getClass().getResource("BankAccountScene.fxml"));
        	Parent root1 = loader1.load();
        	depositStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	bankSceneController controller1 = loader1.getController();
        	controller1.setUserAccount(existingAccounts, theAccount);
        	Scene createAccountScene = new Scene(root1, 450, 300);
        	depositStage.setScene(createAccountScene);
        	depositStage.show();
    	}
    }
    
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    }
    
}
