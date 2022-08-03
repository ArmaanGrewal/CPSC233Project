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
		return bankMonthlyPMT;
	}
	
	public double calculateCarPMT(double aCarLoan) {
		double carMonthlyPMT = 0;
		double numerator = aCarLoan * (interestYearly / 12);
		double denominator = (1 - (Math.pow((1 + (interestYearly/12)), (term1 * -1 * 12))));
		carMonthlyPMT = numerator / denominator;
		return carMonthlyPMT;
	}
	
	public double calculateMortgagePMT(double aMortgage) {
		double mortgageMonthlyPMT = 0;
		double numerator = aMortgage * (interestYearly / 12);
		double denominator = (1 - (Math.pow((1 + (interestYearly/12)), (term2 * -1 * 12))));
		mortgageMonthlyPMT = numerator / denominator;
		return mortgageMonthlyPMT;
	}
	
	public String depositAmount(double depositAmount) {
		accountBalance += depositAmount;
		return "You have successfully deposited: $" + depositAmount + ". Your new account balance is: $" + accountBalance + ".";
	}
	
	public String withdrawAmount(double withdrawAmount) {
		String withdrawError = "";
		if (withdrawAmount > accountBalance) {
			withdrawError = "Error: There are not sufficient funds in your bank account to be able to withdraw: $" + withdrawAmount + ".";
		}
		else {
			accountBalance -= withdrawAmount;
		}
		return withdrawError;
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