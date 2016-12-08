/*
 * Lab 2
 * SE 2811 - Winter Quarter
 * @author Kyra Oberholtzer
 * @version 1.0
 */

import java.util.ArrayList;

/**
 * Encrypter that uses a shift algorithm to encrypt and
 * decrypt files.
 */
public class ShiftEncrypter implements Encrypter {

    private int index;

    /**
     * Instantiates the shift encrypter object.
     */
    public ShiftEncrypter(int shiftIndex){
        index = shiftIndex;
    }

    /**
     * Decrypts the given text using the shift
     * algorithm.
     * @param text String to be decrypted
     * @return decrypted String
     */
    public String decrypt(String text){

        ArrayList<Character> message = new ArrayList<>();
        String out = "";

        for(int i = 0; i < text.length(); i++){
            Character j = text.charAt(i);
            int k = (int)j;
            k -= index;
            if(k < 0){
               k += 128;
            }
            message.add((char)k);
        }

        for(int i = 0; i < message.size(); i++){
            out += message.get(i);
        }

        return out;
    }

    /**
     * Encrypts the given text using the shift
     * algorithm.
     * @param text String to be encrypted
     * @return encrypted String
     */
    public String encrypt(String text){

        ArrayList<Character> message = new ArrayList<>();
        String out = "";

        for(int i = 0; i < text.length(); i++){
            Character j = text.charAt(i);
            int k = (int)j;
            k += index;
            if(k > 127){
                k -= 128;
            }
            message.add((char)k);
        }

        for(int i = 0; i < message.size(); i++){
            out += message.get(i);
        }

        return out;
    }

}
