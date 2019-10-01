package com.robertharbison.classicalciphers.ciphers;

import org.junit.Assert;
import org.junit.Test;

import com.robertharbison.classicalciphers.ciphers.Rot13;

public class Rot13Test {
	
	@Test
	public void testAlphabet() {
		String startMessage = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String encoded = Rot13.encrypt(startMessage);
		Assert.assertEquals("cipher", "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM", encoded);
		
		String decoded = Rot13.encrypt(encoded);
		Assert.assertEquals("decipher", startMessage, decoded);
	}
	
	@Test
	public void testSpecialCharactersAndSpaces() {
		String startMessage = "/?.>,<'\";:|[] {} =+-_)(*&^%$#@!~`\\";
		
		String encoded = Rot13.encrypt(startMessage);
		Assert.assertEquals(startMessage, encoded);
	}
	
	@Test
	public void testNumbers() {
		String startMessage = "0123456789";
		
		String encoded = Rot13.encrypt(startMessage);
		Assert.assertEquals(startMessage, encoded);
	}
}
