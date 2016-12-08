/*
 * Lab 2
 * SE 2811 - Winter Quarter
 * @author Kyra Oberholtzer
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Encrypter that uses a reverse algorithm to encrypt and
 * decrypt files.
 */
public class ReverseEncrypter implements Encrypter {

    /**
     * Instantiates the reverse encrypter object.
     */
    public ReverseEncrypter(){

    }

    /**
     * Decrypts the given text using the reverse
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

        Collections.reverse(message);

        for(int i = 0; i < message.size(); i++){
            out += message.get(i);
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

        Collections.reverse(message);

        for(int i = 0; i < message.size(); i++){
            out += message.get(i);
        }

        return out;
    }

}
