package com.robertharbison.classicalciphers;

import com.robertharbison.classicalciphers.ciphers.AffineCipher;
import com.robertharbison.classicalciphers.ciphers.AtbashCipher;
import com.robertharbison.classicalciphers.ciphers.CaesarCipher;
import com.robertharbison.classicalciphers.ciphers.Rot13;

public class ClassicalCiphers {
	public static int LETTERS_IN_ALPHABET = 26;
	
	/**
	 * Encrypt message using Affine Cipher.
	 * 
	 * @param input The input message to be encrypted.
	 * @param keyA First key of the cipher. (Must be a coprime of the number of letters in the alphabet.)
	 * @param keyB Second key of the cipher. (Must be no greater then 25 (The length of the alphabet - 1.).)
	 * @return The result of the encrypted input.
	 */
	public static String encryptAffine(String input, int keyA, int keyB) {
		return AffineCipher.encrypt(input, keyA, keyB);
	}
	
	/**
	 * Decrypt message using Affine Cipher.
	 * 
	 * @param input The input message to be decrypted.
	 * @param keyA First key of the cipher. (Must be a coprime of the number of letters in the alphabet.)
	 * @param keyB Second key of the cipher. (Must be no greater then 25 (The length of the alphabet - 1.).)
	 * @return The result of the decrypted input.
	 */
	public static String decryptAffine(String input, int keyA, int keyB) {
		return AffineCipher.decrypt(input, keyA, keyB);
	}
	
	/**
	 * Encrypt message using Atbash Cipher.
	 * 
	 * @param input The input message to be encrypted.
	 * @return The result of the encrypted input.
	 */
	public static String encryptAtbash(String input) {
		return AtbashCipher.encrypt(input);
	}
	
	/**
	 * Encrypt message using Caesar Cipher.
	 * 
	 * @param input The input message to be encrypted.
	 * @param shift The number of letters to shift each character by.
	 * @return The result of the encrypted input.
	 */
	public static String encryptCaesar(String input, int shift) {
		return CaesarCipher.encrypt(input, shift);
	}
	
	/**
	 * Decrypt message using Caesar Cipher.
	 * 
	 * @param input The input message to be decrypted.
	 * @param shift The number of letters to shift each character by.
	 * @return The result of the decrypted input.
	 */
	public static String decryptCaesar(String input, int shift) {
		return CaesarCipher.decrypt(input, shift);
	}

	/**
	 * Encrypt or decrypt a message using Rot13 Cipher.
	 * 
	 * @param input The input message to be encrypted.
	 * @return The result of the encrypted input.
	 */
	public static String encryptRot13(String input) {
		return Rot13.encrypt(input);
	}
}
