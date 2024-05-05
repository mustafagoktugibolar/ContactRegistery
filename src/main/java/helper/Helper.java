package helper;

import Config.Config;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Config.Config.screenHeight;
import static Config.Config.screenWidth;

public class Helper {
    //GET SCREEN DIMESIONS
    public static int getScreenCenter(String dim, Dimension size){
        int point;
        switch (dim){
            case "x" -> point = (screenWidth - size.width) / 2;
            case "y" -> point = (screenHeight - size.height) / 2;
            default -> point = 0;
        }
        return point;
    }

    // load image
    public static ImageIcon loadImageIcon(String path){
        try{
            BufferedImage image = ImageIO.read(new File(path));
            return new ImageIcon(image);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    // isValid Email
    public static boolean isValidEmail(JTextField field) {
        Pattern pattern = Pattern.compile(Config.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(field.getText());
        return matcher.matches();
    }

    // isValid Postal Code
    public static boolean isValidPostalCode(String postalCode) {
        // Postal code should be exactly 5 digits
        if (postalCode.length() != 5) {
            return false;
        }
        // Check if all characters are digits
        for (char c : postalCode.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        // If no issues found, postal code is valid
        return true;
    }

    // isValid phone number
    public static Date isValidBirthDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Config.DATE_REGEX);
        dateFormat.setLenient(false); // To enforce strict date parsing

        try {
            // Parse the date string
            java.util.Date utilDate = dateFormat.parse(dateString);
            // Convert java.util.Date to java.sql.Date
            Date sqlDate = new Date(utilDate.getTime());

            // Additional validation if needed, for example, checking if the person is not born in the future
            Date currentDate = new Date(System.currentTimeMillis()); // Get current date
            if (sqlDate.after(currentDate)) {
                showMessage("Birthdate is in the future", "Try Again!");
                return null; // Birthdate is in the future
            }

            return sqlDate; // Return valid date
        } catch (ParseException e) {
            // Parsing failed, return null indicating invalid date
            return null;
        }
    }

    // image path to file input stream
    public static byte[] getByteArray(String path){
        try {
            File file = new File(path);
            byte[] bytes = Files.readAllBytes(file.toPath());
//            Byte[] byteObjects = new Byte[bytes.length];
//
//            for (int i = 0; i < bytes.length; i++) {
//                byteObjects[i] = bytes[i];
//            }
            return bytes;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    // byte array to image
    public static Image writeByteArrayToImage(byte[] imageBytes){
       try {
           byte[] bytes = new byte[imageBytes.length];
           for (int i = 0; i < imageBytes.length; i++) {
               bytes[i] = imageBytes[i];
           }
           ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
           BufferedImage bufferedImage = ImageIO.read(bis);
           bis.close();

           return bufferedImage;
       }catch (Exception e){
           throw new RuntimeException(e);
       }
    }

    // fit image to label size
    public static ImageIcon fitImage(String path, JLabel label){
        try {
            // Load the image from file
            BufferedImage originalImage = ImageIO.read(new File(path));
            // Get the size of the label
            int labelWidth = label.getWidth();
            int labelHeight = label.getHeight();

            // Resize the image to fit the label
            Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

            // Set the image to the label
            return new ImageIcon(scaledImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon("src/main/images/profile-logo.png");
    }

    // isValid phone number
    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(Config.PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private static JFileChooser fileChooser(String description, int selectionMode, String... extensions){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(description, extensions));
        fileChooser.setFileSelectionMode(selectionMode);
        return fileChooser;
    }

    public static String fileSelector(Component parent) {
        JFileChooser fileChooser = fileChooser("PNG and JPG files", JFileChooser.FILES_ONLY, "png", "jpg", "jpeg");

        int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            return selectedFile.getAbsolutePath();
        }
        return null;
    }

    public static String pathSelector(Component parent){
        JFileChooser fileChooser = fileChooser("All Files", JFileChooser.FILES_AND_DIRECTORIES, "png", "jpg", "jpeg");

        int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file path
            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        else{
            showMessage("Couldn't get the path!");
            return null;
        }
    }

    //CHECK IS THE FIELD EMPTY
    public static boolean isFieldEmpty(JTextField... fields){
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                return true; // At least one field is empty
            }
        }
        return false; // All fields are non-empty
    }

    //SHOW DEFAULT POP-UP MESSAGE
    public static void showMessage(String input){
        String message;
        String title;
        switch (input){
            case "fill" ->{
                message = "Fill All The Fields!";
                title = "Error!";
            }
            case "done" ->{
                message = "Process Successful";
                title = "Success!";
            }
            default -> {
                message = input;
                title = "Something Wrong!";
            }
        }
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    // SHOW CUSTOM POP-UP MESSAGE
    public static void showMessage(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
