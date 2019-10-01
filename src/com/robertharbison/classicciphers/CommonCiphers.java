package com.robertharbison.classicciphers;

import com.robertharbison.classicciphers.ciphers.CaesarCipher;

public class CommonCiphers {
	
	public static int LETTERS_IN_ALPHABET = 26;

	/**
	 * Uses Rot13 to cipher a message.
	 * 
	 * @param message The message that you would like to cipher or decipher
	 * @return The result of the ciphered message.
	 */
	public static String encryptRot13(String message) {
		return CaesarCipher.encrypt(message, 13);
	}
	
	public static String encryptCaesarCipher(String message, int shift) {
		return CaesarCipher.encrypt(message, shift);
	}
	
	public static String decryptCaesarCipher(String message, int shift) {
		return CaesarCipher.decrypt(message, shift);
	}
}
