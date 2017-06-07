
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
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
    
    public static BufferedImage getImageCopy(BufferedImage bi) {
    ColorModel cm = bi.getColorModel();
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
    WritableRaster raster = bi.copyData(bi.getRaster().createCompatibleWritableRaster());
    return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
}

}
