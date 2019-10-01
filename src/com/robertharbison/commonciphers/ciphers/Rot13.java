/**
 * Implementation of the Rot13 cipher which is a simple letter substitution
 * cipher that replaces a letter with the 13th letter after it. When it
 * reaches "z" it starts back at "a".
 */

package com.robertharbison.commonciphers.ciphers;

public class Rot13 {

	/**
	 * Applies the Rot13 cipher to your message. This method can also be used to
	 * decipher it.
	 * 
	 * @param message The message that you would like to cipher or decipher
	 * @return The Rot13 result of your input.
	 */
	public static String cipher(String message) {
		String cipher = "";

		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);

			if (c >= 'a' && c <= 'z') {
				c = (char) ((((c - 'a') + 13) % 26) + 'a');
			} else if (c >= 'A' && c <= 'Z') {
				c = (char) ((((c - 'A') + 13) % 26) + 'A');
			}

			cipher += c;
		}

		return cipher;
	}
}
