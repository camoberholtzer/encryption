/*
 * Lab 2
 * SE 2811 - Winter Quarter
 * @author Kyra Oberholtzer
 * @version 1.0
 */

import java.io.*;

/**
 * FileEncrypter class that reads and writes to the desired files
 * and calls the encrypter's encrypt and decrypt methods.
 */
public class FileEncrypter {

    private String inputFilename;
    private String outputFilename;
    private Encrypter encrypter;

    /**
     * Instantiates the FileEncrypter object.
     * @param inFilename input filename
     * @param outFilename output filename
     * @param e encrypter object
     */
    public FileEncrypter(String inFilename, String outFilename, Encrypter e){

        inputFilename = inFilename;
        outputFilename = outFilename;
        encrypter = e;

    }

    /**
     * Calls to read the input file and then calls the encrypter objects's decrypt
     * method. Once the decryption is done it calls the writeFile method.
     * @throws IOException occurs when there is an issue with file reading
     * @throws UnsupportedOperationException occurs when a character is outside the ASCII range
     */
    public void decryptFile() throws IOException, UnsupportedOperationException{

        String in = readFile();
        String out = encrypter.decrypt(in);
        writeFile(out);

    }

    /**
     * Calls to read the input file and then calls the encrypter objects's encrypt
     * method. Once the encryption is done it calls the writeFile method.
     * @throws IOException occurs when there is an issue with file reading
     * @throws UnsupportedOperationException occurs when a character is outside the ASCII range
     */
    public void encryptFile() throws IOException, UnsupportedOperationException{

        String in = readFile();
        String out = encrypter.encrypt(in);
        writeFile(out);

    }

    /**
     * Reads the given input file, checking if each character is in the ASCII range
     * and then returning a String of the entire file.
     * @throws IOException occurs when there is an issue with file reading
     * @throws UnsupportedOperationException occurs when a character is outside the ASCII range
     */
    public String readFile() throws IOException, UnsupportedOperationException{

        String in = "";

        Reader reader = new FileReader(inputFilename);
        int data = reader.read();
        while (data != -1){
            Character value = (char)data;
            if(data > 127 || data < 0){
                throw new UnsupportedOperationException();
            }
            in += value;
            data = reader.read();
        }
        return in;

    }

    /**
     * Writes to the given output file, given the desired output String.
     * @throws IOException occurs when there is an issue with file reading
     * @throws UnsupportedOperationException occurs when a character is outside the ASCII range
     */
    public void writeFile(String out) throws IOException{

        Writer writer = new FileWriter(outputFilename);
        writer.write(out);
        writer.flush();
        writer.close();

    }



}
