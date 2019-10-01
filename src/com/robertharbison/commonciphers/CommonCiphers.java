package com.robertharbison.commonciphers;

import com.robertharbison.commonciphers.ciphers.Rot13;

public class CommonCiphers {

	/**
	 * Uses Rot13 to cipher or decipher a message.
	 * 
	 * @param message The message that you would like to cipher or decipher
	 * @return The Rot13 result of your input.
	 */
	public static String cipherRot13(String message) {
		return Rot13.cipher(message);
	}
}
