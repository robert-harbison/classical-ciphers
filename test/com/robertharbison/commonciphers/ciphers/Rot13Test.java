package com.robertharbison.commonciphers.ciphers;

import org.junit.Assert;
import org.junit.Test;

public class Rot13Test {
	
	@Test
	public void testAlphabet() {
		String startMessage = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String encoded = Rot13.cipher(startMessage);
		Assert.assertEquals("nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM", encoded);
	}
	
	@Test
	public void testSpecialCharactersAndSpaces() {
		String startMessage = "/?.>,<'\";:|[] {} =+-_)(*&^%$#@!~`\\";
		
		String encoded = Rot13.cipher(startMessage);
		Assert.assertEquals(startMessage, encoded);
	}
	
	@Test
	public void testNumbers() {
		String startMessage = "0123456789";
		
		String encoded = Rot13.cipher(startMessage);
		Assert.assertEquals(startMessage, encoded);
	}
}
