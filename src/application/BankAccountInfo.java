package application;

public class BankAccountInfo {
	
	// Initialize the account balance at 5000 allowing the user to have $5000 when they open a account with our app. 
	protected double accountBalance = 5000.00;
	
	/**
	 * Set the deposit amount of the account by checking if the deposit information entered by the user is a whole number or a decimal point
	 * number and returning the appropriate error message if the condition is not met. If all conditions are met, deposit the amount entered
	 * to account balance.
	 * @param depositAmount
	 * The amount entered by the user. 
	 * @return
	 * The error message (if there is one). 
	 */
	public String depositAmount(String depositAmount) {
		// Set the deposit error message as blank.
		String depositError = "";
		double amountToDeposit = 0;
		int counter3 = 0;
		boolean validDepositAmount = true;
		
		// count the number of periods in the deposit amount and check if all the characters of the deposit amount are digits. 
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
		
		// if the above conditions are met, check if the number of periods are 1 or 0 otherwise set the appropriate error message. 
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
		
		// if all conditions above are met, then convert the entered deposit amount to a double and add it to the account balance. 
		if (validDepositAmount) {
			amountToDeposit = Double.parseDouble(depositAmount);
		}
		accountBalance += amountToDeposit;
		return depositError;
	}
	
	/**
	 * Set the withdraw amount of the account by checking if the withdraw information entered by the user is a whole number or a decimal point
	 * number and returning the appropriate error message if the condition is not met. If all conditions are met, withdraw the amount entered
	 * to account balance.
	 * @param withdrawAmount
	 * The withdraw amount entered by the user. 
	 * @return
	 * The error message (if there is one). 
	 */
	public String withdrawAmount(String withdrawAmount) {
		// Set the withdraw error message as blank.
		String withdrawError = "";
		double amountToWithdraw = 0;
		int counter4 = 0;
		boolean validWithdrawAmount = true;
		
		// count the number of periods in the withdraw amount and check if all the characters of the withdraw amount are digits. 
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
		
		// if the above conditions are met, check if the number of periods are 1 or 0 otherwise set the appropriate error message. 
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
		
		// if all conditions above are met, then convert the entered withdraw amount to a double and subtract it from the account balance. 
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
	
	/**
	 * Get the account balance of the account. 
	 * @return
	 * The account balance. 
	 */
	public double getAccountBalance() {
		return accountBalance;
	}
}