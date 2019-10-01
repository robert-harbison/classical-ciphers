package com.robertharbison.classicciphers.ciphers;

import org.junit.Assert;
import org.junit.Test;

import com.robertharbison.classicciphers.CommonCiphers;

public class CaesarCipherTest {
	
	@Test
	public void testAlphabet() {
		String startMessage = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String encoded = CommonCiphers.encryptCaesarCipher(startMessage, 7);
		Assert.assertEquals("cipher", "hijklmnopqrstuvwxyzabcdefgHIJKLMNOPQRSTUVWXYZABCDEFG", encoded);
		
		String decoded = CommonCiphers.decryptCaesarCipher(encoded, 7);
		Assert.assertEquals("decipher", startMessage, decoded);
	}
	
	@Test
	public void testSpecialCharactersAndSpaces() {
		String startMessage = "/?.>,<'\";:|[] {} =+-_)(*&^%$#@!~`\\";
		
		String encoded = CommonCiphers.encryptCaesarCipher(startMessage, 7);
		Assert.assertEquals(startMessage, encoded);
	}
	
	@Test
	public void testNumbers() {
		String startMessage = "0123456789";
		
		String encoded = CommonCiphers.encryptCaesarCipher(startMessage, 7);
		Assert.assertEquals(startMessage, encoded);
	}
}
