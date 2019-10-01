/**
 * Implementation of the Caesar Cipher which is a simple letter substitution
 * cipher that replaces a letter with the "x" letter after it in the alphabet. When it
 * reaches "z" it starts back at "a".
 */

package com.robertharbison.commonciphers.ciphers;

public class CaesarCipher {

	/**
	 * Uses Caesar Cipher to cipher a message.
	 * 
	 * @param message The message that you would like to cipher.
	 * @param shift The number of letters you want to shift.
	 * @return The result of the ciphered message.
	 */
	public static String cipher(String message, int shift) {
		String cipher = "";

		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);

			if (c >= 'a' && c <= 'z') {
				c = (char) ((((c - 'a') + shift) % 26) + 'a');
			} else if (c >= 'A' && c <= 'Z') {
				c = (char) ((((c - 'A') + shift) % 26) + 'A');
			}

			cipher += c;
		}

		return cipher;
	}
	
	/**
	 * Uses Caesar Cipher to decipher a message.
	 * 
	 * @param message The message that you would like to decipher.
	 * @param shift The number of letters you want to shift.
	 * @return The result of the deciphered message..
	 */
	public static String decipher(String message, int shift) {
		// Calculates the shift needed to shift it all the way around.
		shift = 26 - (shift % 26);
		return cipher(message, shift);
	}
}
