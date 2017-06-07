
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ssd
 */
public class Utilities {
    
    public static ImageIcon getScaledIcon( JLabel label,BufferedImage img){
       Rectangle rect = label.getBounds(null); 
       Image scimage = img.getScaledInstance(rect.width,rect.height,Image.SCALE_DEFAULT);
       return new ImageIcon(scimage);
    }

}
