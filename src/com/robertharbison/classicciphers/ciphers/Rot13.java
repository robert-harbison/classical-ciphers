/**
 * Implementation of the Rot13 Cipher which is a simple letter substitution
 * cipher that replaces a letter with the 13th letter after it in the alphabet. When it
 * reaches "z" it starts back at "a". Because the alphabet has 26 characters running the
 * same algorithm twice will bring you back to the starting input.
 */

package com.robertharbison.classicciphers.ciphers;

public class Rot13 {

	/**
	 * Encrypt or decrypt a message using Rot13 Cipher.
	 * 
	 * @param input The input message to be encrypted.
	 * @return The result of the encrypted input.
	 */
	public static String encrypt(String input) {
		return CaesarCipher.encrypt(input, 13);
	}
}
