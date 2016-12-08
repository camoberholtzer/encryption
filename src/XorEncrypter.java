/*
 * Lab 2
 * SE 2811 - Winter Quarter
 * @author Kyra Oberholtzer
 * @version 1.0
 */

import java.util.ArrayList;

/**
 * Encrypter that uses a xor algorithm to encrypt and
 * decrypt files.
 */
public class XorEncrypter implements Encrypter {

    String key;

    /**
     * Instantiates the xor encrypter object.
     */
    public XorEncrypter(String key){
        this.key = key;
    }

    /**
     * Decrypts the given text using the xor
     * algorithm.
     * @param text String to be decrypted
     * @return decrypted String
     */
    public String decrypt(String text){

        ArrayList<Character> message = new ArrayList();
        String out = "";

        for(int i = 0; i < text.length(); i++){
            message.add(text.charAt(i));
        }

        byte[] keyValues = new byte[key.length()];

        for(int i = 0; i < key.length(); i++){
            keyValues[i] = (byte)key.charAt(i);
        }

        int index = 0;
        for(int i = 0; i < message.size(); i++) {

            char j = message.get(i);
            byte k = (byte)j;

            byte l = (byte)(k ^ keyValues[index]);

            out += (char)l;

        }
        return out;

    }

    /**
     * Encrypts the given text using the reverse
     * algorithm.
     * @param text String to be encrypted
     * @return encrypted String
     */
    public String encrypt(String text){

        ArrayList<Character> message = new ArrayList();
        String out = "";

        for(int i = 0; i < text.length(); i++){
            message.add(text.charAt(i));
        }

        byte[] keyValues = new byte[key.length()];

        for(int i = 0; i < key.length(); i++){
            keyValues[i] = (byte)key.charAt(i);
        }

        int index = 0;
        for(int i = 0; i < message.size(); i++) {

            char j = message.get(i);
            byte k = (byte)j;

            byte l = (byte)(k ^ keyValues[index]);

            out += (char)l;

        }
        return out;

    }

}
