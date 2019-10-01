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

## Todo:
+ Polybius Square Cipher
+ Autokey Cipher
+ Vigenère cipher
+ Four-Square Cipher
+ Hill Cipher
+ Straddle Checkerboard Cipher
+ Switch to a gradle build system.