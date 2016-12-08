/*
 * Lab 2
 * SE 2811 - Winter Quarter
 * @author Kyra Oberholtzer
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * User Interface class, includes RadioButtons for encryption types,
 * JTextFields for Input and Output filenames, and encrypt and decrypt
 * buttons.
 */
public class EncryptionUI {

    private JFrame frame;

    private JTextField shiftAmountInput;
    private JTextField xorKeyInput;
    private JTextField inFileInput;
    private JTextField outFileInput;

    private FileEncrypter fe;

    /**
     * Instantiates the encryption UI and calls the init
     * method that populates the frame.
     */
    public EncryptionUI(){

        frame = new JFrame();
        frame.setLayout(new GridLayout(7, 1));

        initGUI();
        closeOperation();

        frame.setTitle("A Strategy-based File Encrypter");
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,400));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    /**
     * Based on the given encryption type, this method creates an encrypter object
     * of the desired type.
     * @param encType desired type of encryption
     * @param inputFile input filename
     * @param outputFile output filename
     */
    private void handleDecrypt(String encType, String inputFile, String outputFile){

        Encrypter encrypter;

        if(encType.equals("shift")){
            try{
                int amount = Integer.parseInt(shiftAmountInput.getText());
                encrypter = new ShiftEncrypter(amount);
                fe = new FileEncrypter(inputFile, outputFile, encrypter);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No Shift Amount Entered", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }else if(encType.equals("reverse")){
            encrypter = new ReverseEncrypter();
            fe = new FileEncrypter(inFileInput.getText(), outFileInput.getText(), encrypter);
        }else if(encType.equals("xor")){
            String key = xorKeyInput.getText();
            if(!key.equals("")) {
                encrypter = new XorEncrypter(key);
                fe = new FileEncrypter(inFileInput.getText(), outFileInput.getText(), encrypter);
            }else{
                JOptionPane.showMessageDialog(null, "No XOR Key Entered", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        try {
            fe.decryptFile();
        }catch(UnsupportedOperationException exception){
            JOptionPane.showMessageDialog(null, "File contained unsupported characters. Please use characters within the normal ASCII range.", "Unsupported Characters", JOptionPane.ERROR_MESSAGE);
        }catch(IOException exception){
            JOptionPane.showMessageDialog(null, "There was an error reading in the file.", "File Read Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Based on the given decryption type, this method creates an encrypter object
     * of the desired type.
     * @param encType desired type of encryption
     * @param inputFile input filename
     * @param outputFile output filename
     */
    private void handleEncrypt(String encType, String inputFile, String outputFile){

        Encrypter encrypter;

        if(encType.equals("shift")){
            try{
                int amount = Integer.parseInt(shiftAmountInput.getText());
                encrypter = new ShiftEncrypter(amount);
                fe = new FileEncrypter(inputFile, outputFile, encrypter);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No Shift Amount Entered", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }else if(encType.equals("reverse")){
            encrypter = new ReverseEncrypter();
            fe = new FileEncrypter(inFileInput.getText(), outFileInput.getText(), encrypter);
        }else if(encType.equals("xor")){
            String key = xorKeyInput.getText();
            if(!key.equals("")) {
                encrypter = new XorEncrypter(key);
                fe = new FileEncrypter(inFileInput.getText(), outFileInput.getText(), encrypter);
            }else{
                JOptionPane.showMessageDialog(null, "No XOR Key Entered", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        try {
            fe.encryptFile();
        }catch(UnsupportedOperationException exception){
            JOptionPane.showMessageDialog(null, "File contained unsupported characters. Please use characters within the normal ASCII range.", "Unsupported Characters", JOptionPane.ERROR_MESSAGE);
        }catch(IOException exception){
            JOptionPane.showMessageDialog(null, "There was an error reading in the file.", "File Read Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Creates the custom close operation for the frame.
     */
    private void closeOperation(){

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to close this window?", "Close",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            }
        });

    }

    /**
     * Based on the selection of the RadioButtons, this method returns a String
     * object containing the user choice of encryption type.
     * @param shift Shift RadioButton
     * @param reverse Reverse RadioButton
     * @param xor XOR RadioButton
     * @return string containing encryption type
     */
    private String encryptionCheck(JRadioButton shift, JRadioButton reverse, JRadioButton xor){

        String encType;

        if(shift.isSelected()){
            encType = "shift";
        }else if(reverse.isSelected()){
            encType = "reverse";
        }else{
            encType = "xor";
        }

        return encType;

    }

    /**
     * Initializes the specific objects of the GUI's frame.
     */
    private void initGUI(){

        JLabel encryptionHeader = new JLabel("Encryption Type:");
        ButtonGroup encryptionType = new ButtonGroup();
        JRadioButton shiftEncrypt = new JRadioButton();
        JRadioButton reverseEncrypt = new JRadioButton();
        JRadioButton xorEncrypt = new JRadioButton();

        encryptionType.add(shiftEncrypt);
        encryptionType.add(reverseEncrypt);
        encryptionType.add(xorEncrypt);

        shiftEncrypt.setText("Shift ");
        shiftEncrypt.setSelected(true);
        reverseEncrypt.setText("Reverse");
        xorEncrypt.setText("XOR ");

        JLabel shiftAmount = new JLabel("Amount: ");
        JLabel xorKey = new JLabel("Key: ");

        shiftAmountInput = new JTextField();
        shiftAmountInput.setPreferredSize(new Dimension(50,20));
        xorKeyInput = new JTextField();
        xorKeyInput.setPreferredSize(new Dimension(50,20));
        inFileInput = new JTextField("test.txt");
        inFileInput.setPreferredSize(new Dimension(100,20));
        outFileInput = new JTextField("output.txt");
        outFileInput.setPreferredSize(new Dimension(100,20));

        JLabel inputFile = new JLabel("Input File:");
        JLabel outputFile = new JLabel("Output File:");

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(e -> {
            String encType = encryptionCheck(shiftEncrypt, reverseEncrypt, xorEncrypt);
            handleEncrypt(encType, inFileInput.getText(), outFileInput.getText());
        });
        JButton decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(e -> {
            String encType = encryptionCheck(shiftEncrypt, reverseEncrypt, xorEncrypt);
            handleDecrypt(encType, inFileInput.getText(), outFileInput.getText());
        });

        JPanel shiftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        shiftPanel.add(shiftEncrypt);
        shiftPanel.add(shiftAmount);
        shiftPanel.add(shiftAmountInput);

        JPanel reversePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        reversePanel.add(reverseEncrypt);

        JPanel xorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        xorPanel.add(xorEncrypt);
        xorPanel.add(xorKey);
        xorPanel.add(xorKeyInput);

        JPanel inPanel = new JPanel(new GridLayout(2, 1));
        inPanel.add(inputFile);
        inPanel.add(inFileInput);

        JPanel outPanel = new JPanel(new GridLayout(2, 1));
        outPanel.add(outputFile);
        outPanel.add(outFileInput);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        frame.add(encryptionHeader);
        frame.add(shiftPanel);
        frame.add(reversePanel);
        frame.add(xorPanel);
        frame.add(inPanel);
        frame.add(outPanel);
        frame.add(buttonPanel);

    }

}
