package helper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
}
