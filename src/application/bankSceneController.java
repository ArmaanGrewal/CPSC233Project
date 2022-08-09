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

// Controller for the main bank account window. (BankAccountScene.fxml)
// Note: Lines 62-69, 83-90, and 104-111 come from the YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode

public class bankSceneController {

	private Stage bankAccountStage;
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
    private Label totalBankLoan;
    
    @FXML 
    private Label totalCarLoan;
    
    @FXML
    private Label totalMortgage;
    
    @FXML
    private Label loanPaymentError;
    
    @FXML
    private Label welcomeUser;
	
    /**
     * Go to the deposit window by clicking the 'Deposit' button and pass the existingAccount ArrayList
     * and the current account being used. 
     * @param event
     * The clicking of the 'Deposit' button.
     * @throws IOException
     */
    @FXML
    void toDepositWindow(ActionEvent event) throws IOException {
    	// The following block of code comes from this YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode
    	// (until line 69). 
    	FXMLLoader loader1 = new FXMLLoader(getClass().getResource("DepositScene.fxml"));
    	Parent root1 = loader1.load();
    	bankAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	DepositController controller1 = loader1.getController();
    	controller1.setUserAccount(existingAccounts, theAccount);
    	Scene depositScene = new Scene(root1, 450, 150);
    	bankAccountStage.setScene(depositScene);
    	bankAccountStage.show();
    }
    
    /**
     * Go to the login window by clicking the 'Sign Out' button and pass the existingAccounts ArrayList
     * and the current account being used. 
     * @param event
     * The clicking of the 'Sign Out' button.
     * @throws IOException
     */
    @FXML
    void toLoginWindow(ActionEvent event) throws IOException {
    	// The following block of code comes from this YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode
    	// (until line 90).
    	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
    	Parent root2 = loader2.load();
    	bankAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	loginController controller2 = loader2.getController();
    	controller2.setUserAccount(existingAccounts, theAccount);
    	Scene loginScene = new Scene(root2, 450, 250);
    	bankAccountStage.setScene(loginScene);
    	bankAccountStage.show();
    }
    
    /**
     * Go to the withdraw window by clicking the 'Withdraw' button and pass the existingAccounts ArrayList
     * and the current account being used. 
     * @param event
     * The clicking of the 'Withdraw' button.
     * @throws IOException
     */
    @FXML
    void toWithdrawWindow(ActionEvent event) throws IOException {
    	// The following block of code comes from this YouTube video: https://www.youtube.com/watch?v=wxhGKR3PQpo&ab_channel=BroCode
    	// (until line 111).
    	FXMLLoader loader3 = new FXMLLoader(getClass().getResource("WithdrawScene.fxml"));
    	Parent root3 = loader3.load();
    	bankAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	WithdrawController controller3 = loader3.getController();
    	controller3.setUserAccount(existingAccounts, theAccount);
    	Scene withdrawScene = new Scene(root3, 500, 150);
    	bankAccountStage.setScene(withdrawScene);
    	bankAccountStage.show();
    }
    
    /**
     * Call on the payLoans method for theAccount so that all of the respective amounts are decreased 
     * (account balance, bank loan balance, car loan balance, mortgage balance) and return an error
     * message if there are non-sufficient funds in the bank account. 
     * @param event
     * The clicking of the 'Pay Loan Amount' button.
     */
    @FXML
    void payMonthly(ActionEvent event) {
    	// Initially set the error message to blank. 
    	loanPaymentError.setText("");
    	
    	// Call on the pay loans method to decrease the loan balances and the account balance (if there
    	// are sufficient funds) and display the error message (if there is one). 
    	loanPaymentError.setText(theAccount.payLoans());
    	
    	// Display all the balances after paying loans . 
    	accountBalanceLabel.setText(String.format("$ %.2f", theAccount.getAccountBalance()));
    	totalBankLoan.setText(String.format("Total Bank Loan Balance (Including Interest): $ %.2f", theAccount.getBankInterestIncluded()));
    	totalCarLoan.setText(String.format("Total Car Loan Balance (Including Interest): $ %.2f", theAccount.getCarInterestIncluded()));
    	totalMortgage.setText(String.format("Total Mortgage Balance (Including Interest): $ %.2f", theAccount.getMortgageInterestIncluded()));
    }
    
    /**
     * This method is to be used when creating a new account to pass the existing accounts and the 
     * current account being used. Also, this method is for calculating the monthly payments (displaying 
     * them as well) and displaying all the loan balances. 
     * @param anAccountList
     * The existingAccounts ArrayList. 
     * @param accountUsed
     * The current account being used. 
     */
    public void setNewUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    	
    	// Display the welcome text and all of the balances and monthly payments. 
    	welcomeUser.setText("Welcome, " + theAccount.getName());
    	accountBalanceLabel.setText(String.format("$ %.2f", theAccount.getAccountBalance()));
    	bankLoanLabel.setText(String.format("Bank Loan Monthly Installment: $ %.2f", theAccount.calculateBankPMT(theAccount.getBankLoanAmount())));
    	totalBankLoan.setText(String.format("Total Bank Loan Balance (Including Interest): $ %.2f", theAccount.getBankInterestIncluded()));
    	carLoanLabel.setText(String.format("Car Loan Monthly Installment: $ %.2f", theAccount.calculateCarPMT(theAccount.getCarLoanAmount())));
    	totalCarLoan.setText(String.format("Total Car Loan Balance (Including Interest): $ %.2f", theAccount.getCarInterestIncluded()));
    	mortgageLabel.setText(String.format("Mortgage Monthly Installment: $ %.2f", theAccount.calculateMortgagePMT(theAccount.getMortgageAmount())));
    	totalMortgage.setText(String.format("Total Mortgage Balance (Including Interest): $ %.2f", theAccount.getMortgageInterestIncluded()));
    }
    
    /**
     * This method is to be used by scenes where the account already exists to display the balances on
     * the account and the account balance of a specific account. (no calculations done with this method). 
     * Also this will pass the existingAccounts ArrayList and the current account being used. 
     * @param anAccountList
     * The existingAccounts ArrayList. 
     * @param accountUsed
     * The current account being used. 
     */
    public void setUserAccount(ArrayList<BankAccount> anAccountList, BankAccount accountUsed) {
    	existingAccounts = anAccountList;
    	theAccount = accountUsed;
    	
    	// Display the welcome back message and all the payment and loan balances (including account balance). 
    	welcomeUser.setText("Welcome Back, " + theAccount.getName());
    	accountBalanceLabel.setText(String.format("$ %.2f", theAccount.getAccountBalance()));
    	bankLoanLabel.setText(String.format("Bank Loan Monthly Installment: $ %.2f", theAccount.getBankPMT()));
    	totalBankLoan.setText(String.format("Total Bank Loan Monthly Balance (Including Interest): $ %.2f", theAccount.getBankInterestIncluded()));
    	carLoanLabel.setText(String.format("Car Loan Monthly Installment: $%.2f", theAccount.getCarPMT()));
    	totalCarLoan.setText(String.format("Total Car Loan Balance (Including Interest): $ %.2f", theAccount.getCarInterestIncluded()));
    	mortgageLabel.setText(String.format("Mortgage Monthly Installment: $ %.2f", theAccount.getMortgagePMT()));
    	totalMortgage.setText(String.format("Total Mortgage Balance (Including Interest): $ %.2f", theAccount.getMortgageInterestIncluded()));
    }
}

