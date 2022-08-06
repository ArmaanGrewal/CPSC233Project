package application;

public class BankAccount extends LoanInfo {
	
	private String username;
	private String password;
	private String name;
	
	
	/**
	 * Get the user-name of the account. 
	 * @return 
	 * The account card number. 
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Checks if the user-name (card number) is a 16-digit card number and returns an error message if it isn't. 
	 * @param username1
	 * The card number entered by the user. 
	 * @return
	 * The error message (if there is one). 
	 */
	public String setUsername(String username1) {
		// set error message to blank. 
		String usernameError = "";
		boolean validUsername = true;
		// check length of the card number entered by the user. 
		if (username1.length() != 16) {
			usernameError = "The username must require a 16-digit card number.";
		}
		else if (username1.length() == 16) {
			
			// if length condition is met, then check if all the characters are a digit. 
			for (char letter : username1.toCharArray()) {
				if (!Character.isDigit(letter)) {
					validUsername = false;
					usernameError = "The username must require a 16-digit card number. Please don't include the character '"
							+ letter + "' .";
				}
				else {
					validUsername = true;
				}
			}
			// If the user-name entered is valid then set the user-name variable as the user-name entered (card number).
			if (validUsername) {
				username = username1;
			}
		}
		
		return usernameError;
	}
	
	/**
	 * Get the password of the account.
	 * @return
	 * The account password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Check if the password entered by the account is a 8-character password including, at least 1 upper-case character, 
	 * at least 1 lower-case character, and at least 1 digit. 
	 * @param password1
	 * The password entered by the user. 
	 * @return
	 * The error message (if the conditions mentioned above are met).
	 */
	public String setPassword(String password1) {
		// Set the password error message to blank.
		String passwordError = "";
		int lowerCaseCounter = 0;
		int upperCaseCounter = 0;
		int digitCounter = 0;
		
		// Check if the length of the password is 8. 
		if (password1.length() < 8) {
			passwordError = "Your password must be at least 8 character in length.";
		}
		else if (password1.length() >= 8) {
			
			// If password length condition is met, then count the amount of upper-case, lower-case, and digit characters. 
			for (char passCharacter : password1.toCharArray()) {
				if (Character.isLowerCase(passCharacter)) {
					lowerCaseCounter++;
				}
				else if (Character.isUpperCase(passCharacter)) {
					upperCaseCounter++;
				}
				else if (Character.isDigit(passCharacter)) {
					digitCounter++;
				}
			}
			
			// If the count of any character type is less than one then set the appropriate error message. 
			if (lowerCaseCounter < 1) {
				passwordError = "Check Password: Must contain at least 1 lowercase character.";
			}
			else if (upperCaseCounter < 1) {
				passwordError = "Check Password: Must contain at least 1 uppercase character.";
			}
			else if (digitCounter < 1) {
				passwordError = "Check Password: Must contain at least 1 digit.";
			}
			
			// If the character conditions are met, then set the password of the account as the password provided by the user. 
			else {
				passwordError = "";
				password = password1;
			}	
		}	
		return passwordError;
	}
	
	/**
	 * Get the name entered by the user.
	 * @return
	 * The users name on the account. 
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * Set the name of the user according to what they enter.
	 * @param aName
	 * The name entered by the user.
	 */
	public void setName(String aName) {
		// set the account name as the name entered by the user. 
		name = aName;
	}
}
