package com.robertharbison.classicciphers.ciphers;

import static com.robertharbison.classicciphers.CommonCiphers.LETTERS_IN_ALPHABET;

public class AtbashCipher {

	/**
	 * Encrypt message using Atbash Cipher.
	 * 
	 * @param input The input message to be encrypted.
	 * @return The result of the encrypted input.
	 */
	public static String encrypt(String input) {
		StringBuilder cipher = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			cipher.append(reposition(input.charAt(i)));
		}
		
		return cipher.toString();
	}
	
	/**
	 * Gets the correct character. If the input is A the output is Z and so on.
	 * 
	 * @param input The input character.
	 * @return The output character.
	 */
	private static char reposition(char c) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
		// Checks if the character exists in the alphabet.
		if (alphabet.indexOf(c) != -1) {
			for (int i = 0; i < alphabet.length(); i++) {
				String chars = "";
				
				if (Character.isLowerCase(c)) {
					// Gets the lowercase section from alphabet
					chars = alphabet.substring(0, LETTERS_IN_ALPHABET);
				} else if (Character.isUpperCase(c)) {
					// Gets the uppercase section from alphabet
					chars = alphabet.substring(LETTERS_IN_ALPHABET);
				}
				
				char listChar = chars.charAt(i);
				if (c == listChar) {
					return chars.charAt((chars.length() - 1) - chars.indexOf(listChar));
				}
			}
		}
		
		return c;
	}
}
