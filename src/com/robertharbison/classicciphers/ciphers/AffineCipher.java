package com.robertharbison.classicciphers.ciphers;

import static com.robertharbison.classicciphers.CommonCiphers.LETTERS_IN_ALPHABET;

import java.math.BigInteger;

public class AffineCipher {

	public static String encrypt(String input, int a, int b) {
		if (!isCoprime(a, LETTERS_IN_ALPHABET)) {
			ArithmeticException e = new ArithmeticException("a is equal to " + a + " and must be a coprime of the length of the alphabet (" + LETTERS_IN_ALPHABET + ")");
			throw e;
		}
		
		if (b >= 26) {
			ArithmeticException e = new ArithmeticException("b is equal to " + b + " and must be less than 25.");
			throw e;
		}
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (Character.isLowerCase(c)) {
				c = shiftEncrypt(c, 'a', a, b);
			} else if (Character.isUpperCase(c)) {
				c = shiftEncrypt(c, 'A', a, b);
			}
			
			result.append(c);
		}

		return result.toString();
	}

	public static String decrypt(String input, int a, int b) {
		if (!isCoprime(a, LETTERS_IN_ALPHABET)) {
			ArithmeticException e = new ArithmeticException("a is equal to " + a + " and must be a coprime of the length of the alphabet (" + LETTERS_IN_ALPHABET + ")");
			throw e;
		}
		
		if (b >= 26) {
			ArithmeticException e = new ArithmeticException("b is equal to " + b + " and must be less than 25.");
			throw e;
		}
		
		StringBuilder result = new StringBuilder();
		BigInteger inverse = BigInteger.valueOf(a).modInverse(BigInteger.valueOf(LETTERS_IN_ALPHABET));
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isUpperCase(c)) {
				c = shiftDecrypt(c, 'A', inverse, b);
			} else if (Character.isLowerCase(c)) {
				c = shiftDecrypt(c, 'a', inverse, b);
			}

			result.append(c);
		}
		
		return result.toString();
	}
	
	private static char shiftEncrypt(char c, char startingChar, int a, int b) {
		return c = (char) ((a * (c - startingChar) + b) % LETTERS_IN_ALPHABET + startingChar);
	}
	
	private static char shiftDecrypt(char c, char startingChar, BigInteger inverse, int b) {
		int decoded = inverse.intValue() * (c - startingChar - b + LETTERS_IN_ALPHABET);
		return (char) (decoded % LETTERS_IN_ALPHABET + startingChar);
	}
	
	private static boolean isCoprime(int p, int q) {
	    return gcd(p, q) == 1;
	}
	
	private static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        
        return gcd(q, p % q);
    }
}
