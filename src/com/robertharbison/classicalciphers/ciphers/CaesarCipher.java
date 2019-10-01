/**
 * Implementation of the Caesar Cipher which is a simple letter substitution
 * cipher that replaces a letter with the "x" letter after it in the alphabet. When it
 * reaches "z" it starts back at "a".
 */

package com.robertharbison.classicalciphers.ciphers;

import static com.robertharbison.classicalciphers.ClassicalCiphers.LETTERS_IN_ALPHABET;

public class CaesarCipher {
	
	/**
	 * Encrypt message using Caesar Cipher.
	 * 
	 * @param input The input message to be encrypted.
	 * @param shift The number of letters to shift each character by.
	 * @return The result of the encrypted input.
	 */
	public static String encrypt(String input, int shift) {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (Character.isLowerCase(c)) {
				c = shift(c, 'a', shift);
			} else if (Character.isUpperCase(c)) {
				c = shift(c, 'A', shift);
			}

			result.append(c);
		}

		return result.toString();
	}
	
	/**
	 * Decrypt message using Caesar Cipher.
	 * 
	 * @param input The input message to be decrypted.
	 * @param shift The number of letters to shift each character by.
	 * @return The result of the decrypted input.
	 */
	public static String decrypt(String input, int shift) {
		// Calculates the shift needed to shift it all the way around.
		shift = LETTERS_IN_ALPHABET - (shift % LETTERS_IN_ALPHABET);
		return encrypt(input, shift);
	}
	
	/**
	 * Shifts a character x times in the alphabet.
	 * 
	 * @param c The character to shift.
	 * @param startingChar The starting character of the alphabet depending on if 'c' is capital. (Generally either 'a' or 'A')
	 * @param shift The number of letters to shift each character by.
	 * @return The new character.
	 */
	private static char shift(char c, char startingChar, int shift) {
		return (char) ((((c - startingChar) + shift) % LETTERS_IN_ALPHABET) + startingChar);
	}
}
