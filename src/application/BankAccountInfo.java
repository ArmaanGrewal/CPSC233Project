package application;

import java.lang.Math;

public class BankAccountInfo {
	
	protected double accountBalance = 5000.00;
	protected double bankLoan = 0.00;
	protected double carLoan = 0.00;
	protected double mortgageAmount = 0.00;
	private int term1 = 5;
	private int term2 = 10;
	private double interestYearly = 0.05;
	private double bankPMT = 0.00;
	private double carPMT = 0.00;
	private double mortgagePMT = 0.00;
	
	public String setBankLoan(String anAmount) {
		String bankLoanError = "";
		int counter = 0;
		boolean validAmount = true;
		for (char c : anAmount.toCharArray()) {
			if (!Character.isDigit(c)) {
				if (c == '.') {
					counter++;
					validAmount = true;
				}
				else {
					validAmount = false;
					bankLoanError = "Please enter a dollar amount for the bank loan!";
				}
			}
		}
		if (validAmount) {
			if (counter == 0 || counter == 1) {
				validAmount = true;
			}
			else {
				validAmount = false;
				bankLoanError = "Please enter a dollar amount for the bank loan!";
			}
		}
		if (validAmount) {
			bankLoan = Double.parseDouble(anAmount);
		}
		if (bankLoan < 0) {
			bankLoanError = "Please enter a dollar amount for the bank loan!";
			bankLoan = 0;
		}
		return bankLoanError;
	}
	
	public String setCarLoan(String anAmount) {
		String carError = "";
		int counter1 = 0;
		boolean validCarAmount = true;
		for (char c1 : anAmount.toCharArray()) {
			if (!Character.isDigit(c1)) {
				if (c1 == '.') {
					counter1++;
					validCarAmount = true;
				}
				else {
					validCarAmount = false;
					carError = "Please enter a dollar amount for the car loan!";
				}
			}
		}
		if (validCarAmount) {
			if (counter1 == 0 || counter1 == 1) {
				validCarAmount = true;
			}
			else {
				validCarAmount = false;
				carError = "Please enter a dollar amount for the car loan!";
			}
		}
		if (validCarAmount) {
			carLoan = Double.parseDouble(anAmount);
		}
		if (carLoan < 0) {
			carError = "Please enter a dollar amount for the car loan!";
			carLoan = 0;
		}
		return carError;
	}
	
	public String setMortgage(String anAmount) {
		String mortgageError = "";
		int counter2 = 0;
		boolean validMortgageAmount = true;
		for (char c2 : anAmount.toCharArray()) {
			if (!Character.isDigit(c2)) {
				if (c2 == '.') {
					counter2++;
					validMortgageAmount = true;
				}
				else {
					validMortgageAmount = false;
					mortgageError = "Please enter a dollar amount for the mortgage!";
				}
			}
		}
		if (validMortgageAmount) {
			if (counter2 == 0 || counter2 == 1) {
				validMortgageAmount = true;
			}
			else {
				validMortgageAmount = false;
				mortgageError = "Please enter a dollar amount for the mortgage!";
			}
		}
		if (validMortgageAmount) {
			mortgageAmount = Double.parseDouble(anAmount);
		}
		if (mortgageAmount < 0) {
			mortgageError = "Please enter a dollar amount for the mortgage";
			mortgageAmount = 0;
		}
		return mortgageError;
	}
	
	public double calculateBankPMT(double aBankLoan) {
		double bankMonthlyPMT = 0;
		double numerator = aBankLoan * (interestYearly / 12);
		double denominator = (1 - (Math.pow((1 + (interestYearly/12)), (term1 * -1 * 12))));
		bankMonthlyPMT = numerator / denominator;
		bankPMT = bankMonthlyPMT;
		return bankMonthlyPMT;
	}
	
	public double calculateCarPMT(double aCarLoan) {
		double carMonthlyPMT = 0;
		double numerator = aCarLoan * (interestYearly / 12);
		double denominator = (1 - (Math.pow((1 + (interestYearly/12)), (term1 * -1 * 12))));
		carMonthlyPMT = numerator / denominator;
		carPMT = carMonthlyPMT;
		return carMonthlyPMT;
	}
	
	public double calculateMortgagePMT(double aMortgage) {
		double mortgageMonthlyPMT = 0;
		double numerator = aMortgage * (interestYearly / 12);
		double denominator = (1 - (Math.pow((1 + (interestYearly/12)), (term2 * -1 * 12))));
		mortgageMonthlyPMT = numerator / denominator;
		mortgagePMT = mortgageMonthlyPMT;
		return mortgageMonthlyPMT;
	}
	
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
	
	public String payLoans() {
		String loanError = "";
		double totalPMT = bankPMT + carPMT + mortgagePMT;
		if (bankLoan > 0 || carLoan > 0 || mortgageAmount > 0) {
			if (totalPMT > accountBalance) {
				loanError = "Not enough funds in your bank account. Please deposit more!";
			}
			else {
				accountBalance -= totalPMT;
				bankLoan -= bankPMT;
				carLoan -= carPMT;
				mortgageAmount -= mortgagePMT;
			}
		}
		return loanError;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public double getBankLoanAmount() {
		return bankLoan;
	}
	
	public double getCarLoanAmount() {
		return carLoan;
	}
	
	public double getMortgageAmount() {
		return mortgageAmount;
	}
}