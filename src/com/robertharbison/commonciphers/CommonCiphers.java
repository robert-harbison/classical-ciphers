package com.robertharbison.commonciphers;

import com.robertharbison.commonciphers.ciphers.CaesarCipher;

public class CommonCiphers {

	/**
	 * Uses Rot13 to cipher a message.
	 * 
	 * @param message The message that you would like to cipher or decipher
	 * @return The result of the ciphered message.
	 */
	public static String cipherRot13(String message) {
		return CaesarCipher.cipher(message, 13);
	}
	
	/**
	 * Uses Caesar Cipher to cipher a message.
	 * 
	 * @param message The message that you would like to cipher.
	 * @param shift The number of letters you want to shift.
	 * @return The result of the ciphered message.
	 */
	public static String cipherCaesarCipher(String message, int shift) {
		return CaesarCipher.cipher(message, shift);
	}
	
	/**
	 * Uses Caesar Cipher to decipher a message.
	 * 
	 * @param message The message that you would like to decipher.
	 * @param shift The number of letters you want to shift.
	 * @return The result of the deciphered message..
	 */
	public static String decipherCaesarCipher(String message, int shift) {
		return CaesarCipher.decipher(message, shift);
	}
}
