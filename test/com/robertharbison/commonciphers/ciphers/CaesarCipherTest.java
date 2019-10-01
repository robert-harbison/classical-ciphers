package com.robertharbison.commonciphers.ciphers;

import org.junit.Assert;
import org.junit.Test;

import com.robertharbison.commonciphers.CommonCiphers;

public class CaesarCipherTest {
	
	@Test
	public void testAlphabet() {
		String startMessage = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String encoded = CommonCiphers.cipherCaesarCipher(startMessage, 7);
		Assert.assertEquals("cipher", "hijklmnopqrstuvwxyzabcdefgHIJKLMNOPQRSTUVWXYZABCDEFG", encoded);
		
		String decoded = CommonCiphers.decipherCaesarCipher(encoded, 7);
		Assert.assertEquals("decipher", startMessage, decoded);
	}
	
	@Test
	public void testSpecialCharactersAndSpaces() {
		String startMessage = "/?.>,<'\";:|[] {} =+-_)(*&^%$#@!~`\\";
		
		String encoded = CommonCiphers.cipherCaesarCipher(startMessage, 7);
		Assert.assertEquals(startMessage, encoded);
	}
	
	@Test
	public void testNumbers() {
		String startMessage = "0123456789";
		
		String encoded = CommonCiphers.cipherCaesarCipher(startMessage, 7);
		Assert.assertEquals(startMessage, encoded);
	}
}
