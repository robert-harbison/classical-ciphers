/**
 * Implementation of the Caesar Cipher which is a simple letter substitution
 * cipher that replaces a letter with the "x" letter after it in the alphabet. When it
 * reaches "z" it starts back at "a".
 */

package com.robertharbison.classicciphers.ciphers;

import static com.robertharbison.classicciphers.CommonCiphers.LETTERS_IN_ALPHABET;

public class CaesarCipher {

	/**
	 * Uses Caesar Cipher to cipher a message.
	 * 
	 * @param input The input that you would like to cipher.
	 * @param shift The number of letters you want to shift.
	 * @return The result of the ciphered input.
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
	 * Uses Caesar Cipher to decipher a message.
	 * 
	 * @param input The input that you would like to decipher.
	 * @param shift The number of letters you want to shift.
	 * @return The result of the deciphered input..
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
	 * @param startingChar The character in the alphabet to start shifting by.
	 * @param shift How much to shift by.
	 * @return The new character.
	 */
	private static char shift(char c, char startingChar, int shift) {
		return (char) ((((c - startingChar) + shift) % LETTERS_IN_ALPHABET) + startingChar);
	}
}
