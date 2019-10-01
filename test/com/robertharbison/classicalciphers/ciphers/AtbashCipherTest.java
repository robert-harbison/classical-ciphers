package com.robertharbison.classicalciphers.ciphers;

import org.junit.Assert;
import org.junit.Test;

import com.robertharbison.classicalciphers.ciphers.AtbashCipher;

public class AtbashCipherTest {

	@Test
	public void testAlphabet() {
		String startMessage = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String encoded = AtbashCipher.encrypt(startMessage);
		Assert.assertEquals("cipher", "zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA", encoded);
		
		String decoded = AtbashCipher.encrypt(encoded);
		Assert.assertEquals("decipher", startMessage, decoded);
	}
	
	@Test
	public void testSpecialCharactersAndSpaces() {
		String startMessage = "/?.>,<'\";:|[] {} =+-_)(*&^%$#@!~`\\";
		
		String encoded = AtbashCipher.encrypt(startMessage);
		Assert.assertEquals(startMessage, encoded);
	}
	
	@Test
	public void testNumbers() {
		String startMessage = "0123456789";
		
		String encoded = AtbashCipher.encrypt(startMessage);
		Assert.assertEquals(startMessage, encoded);
	}
}
