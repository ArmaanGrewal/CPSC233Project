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

public class LoanController {
	
	Stage loanStage;
	
    private ArrayList<BankAccount> existingAccounts = new ArrayList<BankAccount>();
    private BankAccount theAccount;

    @FXML
    void goToMain(ActionEvent event) throws IOException {
    	FXMLLoader loader1 = new FXMLLoader(getClass().getResource("BankAccountScene.fxml"));
    	Parent root1 = loader1.load();
    	loanStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	bankSceneController controller1 = loader1.getController();
    	controller1.setUserAccount(existingAccounts, theAccount);
    	Scene createAccountScene = new Scene(root1, 450, 225);
    	loanStage.setScene(createAccountScene);
    	loanStage.show();
    }
    
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    }

}
