package application;

public class BankAccount {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public String setUsername(String username1) {
		String usernameError = "";
		boolean validUsername = true;
		if (username1.length() != 16) {
			usernameError = "The username must requires a 16-digit card number.";
		}
		else if (username1.length() == 16) {
			for (char letter : username1.toCharArray()) {
				if (!Character.isDigit(letter)) {
					validUsername = false;
					usernameError = "The username must requires a 16-digit card number. Please don't include the character '"
							+ letter + "' .";
				}
				else {
					validUsername = true;
				}
			}
			if (validUsername) {
				username = username1;
			}
		}
		
		return usernameError;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String setPassword(String password1) {
		String passwordError = "";
		boolean validPassword = true;
		int lowerCaseCounter = 0;
		int upperCaseCounter = 0;
		int digitCounter = 0;
		if (password1.length() < 8) {
			passwordError = "Your password must be at least 8 character in length.";
		}
		else if (password1.length() >= 8) {
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
			if (lowerCaseCounter < 1) {
				validPassword = false; 
				passwordError = "Check Password: Must contain at least 1 lowercase character.";
			}
			else if (upperCaseCounter < 1) {
				validPassword = false; 
				passwordError = "Check Password: Must contain at least 1 uppercase character.";
			}
			else if (digitCounter < 1) {
				validPassword = false; 
				passwordError = "Check Password: Must contain at least 1 digit.";
			}
			else {
				validPassword = true;
				passwordError = "";
				password = password1;
			}
			
		}
		
		return passwordError;
	}
}
