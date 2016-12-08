/*
 * Lab 2
 * SE 2811 - Winter Quarter
 * @author Kyra Oberholtzer
 * @version 1.0
 */

/**
 * Interface implemented by the specific encryption classes, such
 * as Shift, Reverse, and XOR.
 */
public interface Encrypter {

    /**
     * Decryption
     * @param text String to be decrypted
     * @return decrypted String
     */
    public String decrypt(String text);

    /**
     * Encryption
     * @param text String to be encrypted
     * @return encrypted String
     */
    public String encrypt(String text);

}
