package application;

public class BankAccountInfo {
	
	protected double accountBalance = 5000.00;
		
	public String depositAmount(String depositAmount) {
		String depositError = "";
		double amountToDeposit = 0;
		int counter3 = 0;
		boolean validDepositAmount = true;
		for (char c3 : depositAmount.toCharArray()) {
			if ((c3 == '.') || (Character.isDigit(c3))) {
				validDepositAmount = true;
				if (c3 == '.') {
					counter3++;
				}
			}
			else {
				validDepositAmount = false;
				depositError = "Please enter a dollar amount to deposit!";
			}
		}
		if (validDepositAmount) {
			if (counter3 > 1) {
				validDepositAmount = false; 
				depositError = "Please enter a dollar amount to deposit!";
			}
			else {
				validDepositAmount = true;
				depositError = "";
			}
		}
		if (validDepositAmount) {
			amountToDeposit = Double.parseDouble(depositAmount);
		}
		accountBalance += amountToDeposit;
		return depositError;
	}
	
	public String withdrawAmount(String withdrawAmount) {
		String withdrawError = "";
		double amountToWithdraw = 0;
		int counter4 = 0;
		boolean validWithdrawAmount = true;
		for (char c4 : withdrawAmount.toCharArray()) {
			if ((c4 == '.') || (Character.isDigit(c4))) {
				validWithdrawAmount = true;
				if (c4 == '.') {
					counter4++;
				}
			}
			else {
				validWithdrawAmount = false;
				withdrawError = "Please enter a dollar amount to withdraw!";
			}
		}
		if (validWithdrawAmount) {
			if (counter4 > 1) {
				validWithdrawAmount = false;
				withdrawError = "Please enter a dollar amount to withdraw!";
			}
			else {
				validWithdrawAmount = true;
				withdrawError = "";
			}
		}
		if (validWithdrawAmount) {
			amountToWithdraw = Double.parseDouble(withdrawAmount);
		}
		if (amountToWithdraw > accountBalance) {
			withdrawError = "Error: There are not sufficient funds in your bank account to be able to withdraw: $" + amountToWithdraw + ".";
			amountToWithdraw = 0;
		}
		else {
			accountBalance -= amountToWithdraw;
		}
		return withdrawError;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
}