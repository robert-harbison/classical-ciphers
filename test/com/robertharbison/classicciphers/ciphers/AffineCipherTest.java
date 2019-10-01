package com.robertharbison.classicciphers.ciphers;

import org.junit.Assert;
import org.junit.Test;

public class AffineCipherTest {

	@Test
	public void testAlphabet() {
		String startMessage = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String encoded = AffineCipher.encrypt(startMessage, 9, 4);
		Assert.assertEquals("cipher", "enwfoxgpyhqzirajsbktcludmvENWFOXGPYHQZIRAJSBKTCLUDMV", encoded);
		
		String decoded = AffineCipher.decrypt(encoded, 9, 4);
		Assert.assertEquals("decipher", startMessage, decoded);
	}
	
	@Test
	public void testSpecialCharactersAndSpaces() {
		String startMessage = "/?.>,<'\";:|[] {} =+-_)(*&^%$#@!~`\\";
		
		String encoded = AffineCipher.encrypt(startMessage, 9, 4);
		Assert.assertEquals(startMessage, encoded);
	}
	
	@Test
	public void testNumbers() {
		String startMessage = "0123456789";
		
		String encoded = AffineCipher.encrypt(startMessage, 9, 4);
		Assert.assertEquals(startMessage, encoded);
	}
}
