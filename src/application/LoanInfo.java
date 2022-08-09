package application;

import java.lang.Math;

public class LoanInfo extends BankAccountInfo {
	
	private double bankLoan = 0.00;
	private double carLoan = 0.00;
	private double mortgageAmount = 0.00;
	private double interestIncludedBank = 0.00;
	private double interestIncludedCar = 0.00;
	private double interestIncludedMortgage = 0.00;
	private double bankPMT = 0.00;
	private double carPMT = 0.00;
	private double mortgagePMT = 0.00;
	
	/**
	 * Check if the user enters a dollar amount for the bank loan (decimal numbers are allowed) and returns the appropriate error message 
	 * if a dollar amount isn't entered. 
	 * @param anAmount
	 * The bank loan entered by the user. 
	 * @return
	 * The error message (if there is one). 
	 */
	public String setBankLoan(String anAmount) {
		// set the bank loan error message as blank. 
		String bankLoanError = "";
		int counter = 0;
		boolean validAmount = true;
		// check the amount of periods in the bank loan amount entered by the user (also if the bank loan amount contain all digits).
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
		
		// if the above conditions are met, then check the number of periods in the amount entered by the user (and return the error message
		// if there are more than 1 period). 
		if (validAmount) {
			if (counter == 0 || counter == 1) {
				validAmount = true;
			}
			else {
				validAmount = false;
				bankLoanError = "Please enter a dollar amount for the bank loan!";
			}
		}
		
		// if all conditions are met, then set the bank loan amount as the amount entered by the user. 
		if (validAmount) {
			bankLoan = Double.parseDouble(anAmount);
		}
		if (bankLoan < 0) {
			bankLoanError = "Please enter a dollar amount for the bank loan!";
			bankLoan = 0;
		}
		return bankLoanError;
	}
	
	/**
	 * Check if the user enters a dollar amount for the car loan (decimal numbers are allowed) and returns the appropriate error message 
	 * if a dollar amount isn't entered.
	 * @param anAmount
	 * The car loan entered by the user. 
	 * @return
	 * The error message (if there is one). 
	 */
	public String setCarLoan(String anAmount) {
		// set the car loan error message as blank. 
		String carError = "";
		int counter1 = 0;
		boolean validCarAmount = true;
		
		// check the amount of periods in the car loan amount entered by the user (also if the car loan amount contain all digits).
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
		
		// if the above conditions are met, then check the number of periods in the amount entered by the user (and return the error message
		// if there are more than 1 period). 
		if (validCarAmount) {
			if (counter1 == 0 || counter1 == 1) {
				validCarAmount = true;
			}
			else {
				validCarAmount = false;
				carError = "Please enter a dollar amount for the car loan!";
			}
		}
		
		// if all conditions are met, then set the car loan amount as the amount entered by the user. 
		if (validCarAmount) {
			carLoan = Double.parseDouble(anAmount);
		}
		if (carLoan < 0) {
			carError = "Please enter a dollar amount for the car loan!";
			carLoan = 0;
		}
		return carError;
	}
	
	/**
	 * Check if the user enters a dollar amount for the mortgage amount (decimal numbers are allowed) and returns the appropriate error message 
	 * if a dollar amount isn't entered.
	 * @param anAmount
	 * The mortgage amount entered by the user. 
	 * @return
	 * The error message (if there is one). 
	 */
	public String setMortgage(String anAmount) {
		// set the mortgage error message as blank. 
		String mortgageError = "";
		int counter2 = 0;
		boolean validMortgageAmount = true;
		
		// check the amount of periods in the mortgage amount entered by the user (also if the mortgage amount contain all digits).
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
		
		// if the above conditions are met, then check the number of periods in the amount entered by the user (and return the error message
		// if there are more than 1 period). 
		if (validMortgageAmount) {
			if (counter2 == 0 || counter2 == 1) {
				validMortgageAmount = true;
			}
			else {
				validMortgageAmount = false;
				mortgageError = "Please enter a dollar amount for the mortgage!";
			}
		}
		
		// if all conditions are met, then set the mortgage amount as the amount entered by the user. 
		if (validMortgageAmount) {
			mortgageAmount = Double.parseDouble(anAmount);
		}
		if (mortgageAmount < 0) {
			mortgageError = "Please enter a dollar amount for the mortgage";
			mortgageAmount = 0;
		}
		return mortgageError;
	}
	
	/**
	 * Calculate the bank loan payment and the total bank loan balance including interest. 
	 * @param aBankLoan
	 * The bank loan amount.
	 * @return
	 * The monthly payment for the bank loan.
	 */
	public double calculateBankPMT(double aBankLoan) {
		// follow the monthly payment formula to set the bank loan payment amount. (also set the bank loan balance including interest).
		double bankMonthlyPMT = 0;
		
		// calculate the numerator and denominator of the bank loan monthly payment by using the formulas from our previous courses in 
		// Finance. (5 year 5% annual interest loan). 
		double numerator = aBankLoan * (0.05 / 12);
		double denominator = (1 - (Math.pow((1 + (0.05/12)), (5 * -1 * 12))));
		bankMonthlyPMT = numerator / denominator;
		
		// Calculate the bank loan balance including interest by multiplying the monthly payment by the number of payment periods. 
		interestIncludedBank = bankMonthlyPMT * 60;
		bankPMT = bankMonthlyPMT;
		return bankMonthlyPMT;
	}
	
	/**
	 * Calculate the car loan payment and the total car loan balance including interest. 
	 * @param aCarLoan
	 * The car loan amount.
	 * @return
	 * The monthly payment for the car loan.
	 */
	public double calculateCarPMT(double aCarLoan) {
		// follow the monthly payment formula to set the car loan payment amount. (also set the car loan balance including interest).
		double carMonthlyPMT = 0;
		
		// calculate the numerator and denominator of the car loan monthly payment by using the formulas from our previous courses in 
		// Finance. (5 year 5% annual interest loan). 
		double numerator = aCarLoan * (0.05 / 12);
		double denominator = (1 - (Math.pow((1 + (0.05 /12)), (5 * -1 * 12))));
		carMonthlyPMT = numerator / denominator;
		
		// Calculate the car loan balance including interest by multiplying the monthly payment by the number of payment periods. 
		interestIncludedCar = carMonthlyPMT * 60;
		carPMT = carMonthlyPMT;
		return carMonthlyPMT;
	}
	
	/**
	 * Calculate the mortgage payment and the total mortgage balance including interest. 
	 * @param aMortgage
	 * The mortgage amount. 
	 * @return
	 * The monthly payment for the mortgage. 
	 */
	public double calculateMortgagePMT(double aMortgage) {
		// follow the monthly payment formula to set the mortgage payment amount. (also set the mortgage balance including interest).
		double mortgageMonthlyPMT = 0;
		
		// calculate the numerator and denominator of the mortgage monthly payment by using the formulas from our previous courses in 
		// Finance. (10 year 5% annual interest loan). 
		double numerator = aMortgage * (0.05 / 12);
		double denominator = (1 - (Math.pow((1 + (0.05 /12)), (10 * -1 * 12))));
		mortgageMonthlyPMT = numerator / denominator;
		
		// Calculate the mortgage balance including interest by multiplying the monthly payment by the number of payment periods. 
		interestIncludedMortgage = mortgageMonthlyPMT * 120;
		mortgagePMT = mortgageMonthlyPMT;
		return mortgageMonthlyPMT;
	}
	
	/**
	 * Check if the total payments for the period are higher than the account balance. If not then subtract the total payment from the balance
	 * and reduce each of the loan balances by its respective monthly payments. 
	 * @return
	 * The error message (if there is one).
	 */
	public String payLoans() {
		// set the loan error message as blank. 
		String loanError = "";
		double totalPMT = 0;
		
		// check if the loan amounts (including interest) are greater than 0.001 (because the window displays it to 2 decimal places). 
		if (interestIncludedBank > 0.001 || interestIncludedCar > 0.001 || interestIncludedMortgage > 0.001) {
			if (interestIncludedBank > 0.001) {
				totalPMT += bankPMT;
			}
			if (interestIncludedCar > 0.001) {
				totalPMT += carPMT;
			}
			if (interestIncludedMortgage > 0.001) {
				totalPMT += mortgagePMT;
			}
			if (totalPMT > accountBalance) {
				loanError = "Not enough funds in your bank account. Please deposit more!";
			}
			
			// if the total payment for the period is less than the account balance then subtract the total payment from the account balance
			// and subtract the monthly loan payment amount from the respective loan. 
			else {
				if (interestIncludedBank > 0.001) {
					accountBalance -= bankPMT;
					interestIncludedBank -= bankPMT;
				}
				if (interestIncludedCar > 0.001) {
					accountBalance -= carPMT;
					interestIncludedCar -= carPMT;
				}
				if (interestIncludedMortgage > 0.001) {
					accountBalance -= mortgagePMT;
					interestIncludedMortgage -= mortgagePMT;
				}
			}
		}
		return loanError;
	}
	
	/**
	 * Get the bank loan amount (without interest)
	 * @return
	 * The bank loan amount (without interest)
	 */
	public double getBankLoanAmount() {
		return bankLoan;
	}
	
	/**
	 * Get the bank loan amount (including interest)
	 * @return
	 * The bank loan amount (including interest)
	 */
	public double getBankInterestIncluded() {
		return interestIncludedBank;
	}
	
	/**
	 * Get the total monthly bank loan payment amount
	 * @return
	 * The total monthly bank loan payment. 
	 */
	public double getBankPMT() {
		return bankPMT;
	}
	
	/**
	 * Get the car loan amount (without interest)
	 * @return
	 * The car loan amount (without interest)
	 */
	public double getCarLoanAmount() {
		return carLoan;
	}
	
	/**
	 * Get the car loan amount (including interest)
	 * @return
	 * The car loan amount (including interest). 
	 */
	public double getCarInterestIncluded() {
		return interestIncludedCar;
	}
	
	/**
	 * Get the total monthly car loan payment amount
	 * @return
	 * The total monthly car loan payment. 
	 */
	public double getCarPMT() {
		return carPMT;
	}
	
	/**
	 * Get the mortgage amount (without interest)
	 * @return
	 * The mortgage amount (without interest).
	 */
	public double getMortgageAmount() {
		return mortgageAmount;
	}
	
	/**
	 * Get the mortgage amount (including interest)
	 * @return
	 * The mortgage amount (including interest)
	 */
	public double getMortgageInterestIncluded() {
		return interestIncludedMortgage;
	}
	
	/**
	 * Get the total monthly mortgage payment amount
	 * @return
	 * The total monthly mortgage payment. 
	 */
	public double getMortgagePMT() {
		return mortgagePMT;
	}

}
