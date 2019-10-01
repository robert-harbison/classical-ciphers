# Classical Ciphers

Classical Ciphers is a Java library that adds different types of encryption. **Please Note:
These should not be used for anything that requires actual security as these are easy to
crack.**

## Supported Ciphers
### Caesar Cipher
Caesar Cipher is a simple letter substitution cipher that replaces a letter with the "x"
letter after it in the alphabet. When it reaches "z" it starts back at "a".

### Rot13 Cipher
Rot13 Cipher is a simple letter substitution cipher that replaces a letter with the
13th letter after it in the alphabet. When it reaches "z" it starts back at "a".
Because the alphabet has 26 characters running the same algorithm twice will bring
you back to the starting input.

### Affine Cipher
Affine Cipher is a monoalphabetic substitution cipher where each character
is mapped to its numeric equivalent and then encrypted using a simple mathematical equation.

### Atbash Cipher
Atbash Cipher is a monoalphabetic substitution cipher where each character is mapped to its
reverse so A is Z, B is Y, C is X etc.

##How To Use
```
public static void rot13Example() {
	/**
	 * Some of the algorithms such as Rot13 don't use a different
	 * decrypt algorithm so you should use the encrypt method for
	 * both encryption and decryption
	 */
	
	// Encrypt "Hello World!" and store it in a string
	String encrypted = ClassicalCiphers.encryptRot13("Hello world!");
	
	// Print the encrypted string
	System.out.println(encrypted);
	
	// Decrypt the encrypted string and store it in a new string.
	String decrypted = ClassicalCiphers.encryptRot13(encrypted);
	
	// Prints the decrypted string which is
	System.out.println(decrypted);
}
```

```
public static void affineExample() {
	// Encrypt "Hello World!" and store it in a string
	String encrypted = ClassicalCiphers.encryptAffine("Hello world!", 9, 15);
		
	// Print the encrypted string
	System.out.println(encrypted);
		
	// Decrypt the encrypted string and store it in a new string.
	String decrypted = ClassicalCiphers.decryptAffine(encrypted, 9, 15);
		
	// Prints the decrypted string which is
	System.out.println(decrypted);
}
```

## Todo:
+ Polybius Square Cipher
+ Autokey Cipher
+ Vigenère cipher
+ Four-Square Cipher
+ Hill Cipher
+ Straddle Checkerboard Cipher
+ Switch to a gradle build system.
