package helper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Config.Config.screenHeight;
import static Config.Config.screenWidth;

public class Helper {
    public static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

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
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(field.getText());
        return matcher.matches();
    }

    // isValic Postal Code
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
