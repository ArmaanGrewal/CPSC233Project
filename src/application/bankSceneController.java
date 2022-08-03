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
import javafx.stage.Stage;

public class bankSceneController {

	Stage bankAccountStage;
    private ArrayList<BankAccount> existingAccounts = new ArrayList<BankAccount>();
    private BankAccount theAccount;
    
    @FXML
    private Label accountBalanceLabel;
    
    @FXML
    private Label bankLoanLabel;
    
    @FXML
    private Label carLoanLabel;
    
    @FXML
    private Label mortgageLabel;
	
    @FXML
    void toDepositWindow(ActionEvent event) throws IOException {
    	FXMLLoader loader1 = new FXMLLoader(getClass().getResource("DepositScene.fxml"));
    	Parent root1 = loader1.load();
    	bankAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	DepositController controller1 = loader1.getController();
    	controller1.setUserAccount(existingAccounts, theAccount);
    	Scene createAccountScene = new Scene(root1, 450, 225);
    	bankAccountStage.setScene(createAccountScene);
    	bankAccountStage.show();
    }

    @FXML
    void toLoginWindow(ActionEvent event) throws IOException {
    	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("ApplicationScene.fxml"));
    	Parent root2 = loader2.load();
    	bankAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	loginController controller2 = loader2.getController();
    	controller2.setUserAccount(existingAccounts, theAccount);
    	Scene createAccountScene = new Scene(root2, 450, 250);
    	bankAccountStage.setScene(createAccountScene);
    	bankAccountStage.show();
    }

    @FXML
    void toWithdrawWindow(ActionEvent event) throws IOException {
    	FXMLLoader loader3 = new FXMLLoader(getClass().getResource("WithdrawScene.fxml"));
    	Parent root3 = loader3.load();
    	bankAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	WithdrawController controller3 = loader3.getController();
    	controller3.setUserAccount(existingAccounts, theAccount);
    	Scene createAccountScene = new Scene(root3, 450, 225);
    	bankAccountStage.setScene(createAccountScene);
    	bankAccountStage.show();
    }
    
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    	double balance = accountUsed.getAccountBalance();
    	double bankLoan = accountUsed.getBankLoanAmount();
    	double bankPMT = accountUsed.calculateBankPMT(bankLoan);
    	double carLoan = accountUsed.getCarLoanAmount();
    	double carPMT = accountUsed.calculateCarPMT(carLoan);
    	double mortgage = accountUsed.getMortgageAmount();
    	double mortgagePMT = accountUsed.calculateMortgagePMT(mortgage);
    	accountBalanceLabel.setText("$" + balance);
    	bankLoanLabel.setText("Bank Loan Monthly Installment: $" + bankPMT);
    	carLoanLabel.setText("Car Loan Monthly Installment: $" + carPMT);
    	mortgageLabel.setText("Mortgage Monthly Installment: $" + mortgagePMT);
    }

}

