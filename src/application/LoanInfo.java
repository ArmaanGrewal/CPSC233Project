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
		double numerator = aBankLoan * (0.05 / 12);
		double denominator = (1 - (Math.pow((1 + (0.05/12)), (5 * -1 * 12))));
		bankMonthlyPMT = numerator / denominator;
		interestIncludedBank = bankMonthlyPMT * 60;
		bankPMT = bankMonthlyPMT;
		return bankMonthlyPMT;
	}
	
	public double calculateCarPMT(double aCarLoan) {
		double carMonthlyPMT = 0;
		double numerator = aCarLoan * (0.05 / 12);
		double denominator = (1 - (Math.pow((1 + (0.05 /12)), (5 * -1 * 12))));
		carMonthlyPMT = numerator / denominator;
		interestIncludedCar = carMonthlyPMT * 60;
		carPMT = carMonthlyPMT;
		return carMonthlyPMT;
	}
	
	public double calculateMortgagePMT(double aMortgage) {
		double mortgageMonthlyPMT = 0;
		double numerator = aMortgage * (0.05 / 12);
		double denominator = (1 - (Math.pow((1 + (0.05 /12)), (10 * -1 * 12))));
		mortgageMonthlyPMT = numerator / denominator;
		interestIncludedMortgage = mortgageMonthlyPMT * 120;
		mortgagePMT = mortgageMonthlyPMT;
		return mortgageMonthlyPMT;
	}
	
	public String payLoans() {
		String loanError = "";
		double totalPMT = bankPMT + carPMT + mortgagePMT;
		if (interestIncludedBank > 0 || interestIncludedCar > 0 || interestIncludedMortgage > 0) {
			if (totalPMT > accountBalance) {
				loanError = "Not enough funds in your bank account. Please deposit more!";
			}
			else {
				if (interestIncludedBank > 0) {
					accountBalance -= bankPMT;
					interestIncludedBank -= bankPMT;
				}
				if (interestIncludedCar > 0) {
					accountBalance -= carPMT;
					interestIncludedCar -= carPMT;
				}
				if (interestIncludedMortgage > 0) {
					accountBalance -= mortgagePMT;
					interestIncludedMortgage -= mortgagePMT;
				}
			}
		}
		return loanError;
	}
		
	public double getBankLoanAmount() {
		return bankLoan;
	}
	
	public double getBankInterestIncluded() {
		return interestIncludedBank;
	}
	
	public double getBankPMT() {
		return bankPMT;
	}
	
	public double getCarLoanAmount() {
		return carLoan;
	}
	
	public double getCarInterestIncluded() {
		return interestIncludedCar;
	}
	
	public double getCarPMT() {
		return carPMT;
	}
	
	public double getMortgageAmount() {
		return mortgageAmount;
	}
	
	public double getMortgageInterestIncluded() {
		return interestIncludedMortgage;
	}
	
	public double getMortgagePMT() {
		return mortgagePMT;
	}

}
