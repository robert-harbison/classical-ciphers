/**
 * Implementation of the Affine Cipher which is a monoalphabetic substitution cipher where each character
 * is mapped to its numeric equivalent and then encrypted using a simple mathematical equation.
 */

package com.robertharbison.classicciphers.ciphers;

import static com.robertharbison.classicciphers.CommonCiphers.LETTERS_IN_ALPHABET;

import java.math.BigInteger;

public class AffineCipher {

	/**
	 * Encrypt message using Affine Cipher.
	 * 
	 * @param input The input message to be encrypted.
	 * @param keyA First key of the cipher. (Must be a coprime of the number of letters in the alphabet.)
	 * @param keyB Second key of the cipher. (Must be no greater then 25 (The length of the alphabet - 1.).)
	 * @return The result of the encrypted input.
	 */
	public static String encrypt(String input, int keyA, int keyB) {
		// Checks if 'a' is a coprime to the number of letters in the alphabet
		if (!isCoprime(keyA, LETTERS_IN_ALPHABET)) {
			ArithmeticException e = new ArithmeticException("\"keyA\" is equal to " + keyA
					+ " and must be a coprime of the length of the alphabet.");
			throw e;
		}

		// Makes sure that 'b' in no greater then the letters in the alphabet - 1
		if (keyB >= LETTERS_IN_ALPHABET) {
			ArithmeticException e = new ArithmeticException("\"keyB\" is equal to " + keyB + " but must be less than 25.");
			throw e;
		}

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (Character.isLowerCase(c)) {
				c = shiftEncrypt(c, 'a', keyA, keyB);
			} else if (Character.isUpperCase(c)) {
				c = shiftEncrypt(c, 'A', keyA, keyB);
			}

			result.append(c);
		}

		return result.toString();
	}

	/**
	 * Decrypt message using Affine Cipher.
	 * 
	 * @param input The input message to be decrypted.
	 * @param keyA First key of the cipher. (Must be a coprime of the number of letters in the alphabet.)
	 * @param keyB Second key of the cipher. (Must be no greater then 25 (The length of the alphabet - 1.).)
	 * @return The result of the decrypted input.
	 */
	public static String decrypt(String input, int keyA, int keyB) {
		// Checks if 'a' is a coprime to the number of letters in the alphabet
		if (!isCoprime(keyA, LETTERS_IN_ALPHABET)) {
			ArithmeticException e = new ArithmeticException("keyA is equal to " + keyA
					+ " and must be a coprime of the length of the alphabet (" + LETTERS_IN_ALPHABET + ")");
			throw e;
		}

		// Makes sure that 'b' in no greater then the letters in the alphabet - 1
		if (keyB >= 26) {
			ArithmeticException e = new ArithmeticException("keyB is equal to " + keyB + " and must be less than 25.");
			throw e;
		}

		StringBuilder result = new StringBuilder();
		BigInteger inverse = BigInteger.valueOf(keyA).modInverse(BigInteger.valueOf(LETTERS_IN_ALPHABET));

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isUpperCase(c)) {
				c = shiftDecrypt(c, 'A', inverse, keyB);
			} else if (Character.isLowerCase(c)) {
				c = shiftDecrypt(c, 'a', inverse, keyB);
			}

			result.append(c);
		}

		return result.toString();
	}

	/**
	 * Shift a character using the encrypt algorithm.
	 * 
	 * @param c The character to decrypt.
	 * @param startingChar The starting character of the alphabet depending on if 'c' is capital. (Generally either 'a' or 'A')
	 * @param keyA The first key to the cipher.
	 * @param keyB The second key to the cipher.
	 * @return The encrypted character.
	 */
	private static char shiftEncrypt(char c, char startingChar, int keyA, int keyB) {
		return c = (char) ((keyA * (c - startingChar) + keyB) % LETTERS_IN_ALPHABET + startingChar);
	}

	/**
	 * Shift a character using the decrypt algorithm.
	 * 
	 * @param c The character to decrypt.
	 * @param startingChar The starting character of the alphabet depending on if 'c' is capital. (Generally either 'a' or 'A')
	 * @param inverseA The inverse of the first key to the cipher.
	 * @param b The second key to the cipher.
	 * @return The dycrypted character.
	 */
	private static char shiftDecrypt(char c, char startingChar, BigInteger inverseA, int b) {
		int decoded = inverseA.intValue() * (c - startingChar - b + LETTERS_IN_ALPHABET);
		return (char) (decoded % LETTERS_IN_ALPHABET + startingChar);
	}

	/**
	 * Check if 'a' is a coprime to 'b'
	 * 
	 * @param a The first number.
	 * @param b The second number.
	 * @return The greatest common divisor.
	 */
	private static boolean isCoprime(int a, int b) {
		return gcd(a, b) == 1;
	}

	/**
	 * Get the greatest common divisor of 'a' and 'b'
	 * 
	 * @param a The first number.
	 * @param b The second number.
	 * @return The greatest common divisor.
	 */
	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}
}
