package com.robertharbison.classicalciphers.ciphers;

import org.junit.Assert;
import org.junit.Test;

import com.robertharbison.classicalciphers.ciphers.CaesarCipher;

public class CaesarCipherTest {
	
	@Test
	public void testAlphabet() {
		String startMessage = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String encoded = CaesarCipher.encrypt(startMessage, 7);
		Assert.assertEquals("cipher", "hijklmnopqrstuvwxyzabcdefgHIJKLMNOPQRSTUVWXYZABCDEFG", encoded);
		
		String decoded = CaesarCipher.decrypt(encoded, 7);
		Assert.assertEquals("decipher", startMessage, decoded);
	}
	
	@Test
	public void testSpecialCharactersAndSpaces() {
		String startMessage = "/?.>,<'\";:|[] {} =+-_)(*&^%$#@!~`\\";
		
		String encoded = CaesarCipher.encrypt(startMessage, 7);
		Assert.assertEquals(startMessage, encoded);
	}
	
	@Test
	public void testNumbers() {
		String startMessage = "0123456789";
		
		String encoded = CaesarCipher.encrypt(startMessage, 7);
		Assert.assertEquals(startMessage, encoded);
	}
}
