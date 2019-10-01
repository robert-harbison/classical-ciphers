package com.robertharbison.classicciphers.ciphers;

import org.junit.Assert;
import org.junit.Test;

public class AffineCipherTest {

	@Test
	public void testAlphabet() {
		String startMessage = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String encoded = AffineCipher.encrypt(startMessage, 9, 4);
		Assert.assertEquals("cipher", "enwfoxgpyhqzirajsbktcludmv ENWFOXGPYHQZIRAJSBKTCLUDMV", encoded);
		
		String decoded = AffineCipher.decrypt(encoded, 9, 4);
		Assert.assertEquals("decipher", startMessage, decoded);
	}
}
