import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
    
    public static void convertToGreyscale(BufferedImage img){
        //get image width and height
    int width = img.getWidth();
    int height = img.getHeight();
    
    //convert to grayscale
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        int p = img.getRGB(x,y);

        int a = (p>>24)&0xff;
        int r = (p>>16)&0xff;
        int g = (p>>8)&0xff;
        int b = p&0xff;

        //calculate average
        int avg = (r+g+b)/3;

        //replace RGB value with avg
        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

        img.setRGB(x, y, p);
      }
    }
    }
    
    public static void convertToNegative(BufferedImage img){
        //get image width and height
    int width = img.getWidth();
    int height = img.getHeight();

    //convert to grayscale
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        int p = img.getRGB(x,y);

        int a = (p>>24)&0xff;
        int r = (p>>16)&0xff;
        int g = (p>>8)&0xff;
        int b = p&0xff;
        
        r=255-r;
        g=255-g;
        b=255-b;
        //calculate average
        int avg = (r+g+b)/3;

        //replace RGB value with avg
        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

        img.setRGB(x, y, p);
      }
    }
    }

    public static double getRadian(int deg){
        return deg*Math.PI/180;
    }

public static BufferedImage convertRenderedImage(RenderedImage img) {
    if (img instanceof BufferedImage) {
        return (BufferedImage)img;  
    }   
    ColorModel cm = img.getColorModel();
    int width = img.getWidth();
    int height = img.getHeight();
    WritableRaster raster = cm.createCompatibleWritableRaster(width, height);
    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
    Hashtable properties = new Hashtable();
    String[] keys = img.getPropertyNames();
    if (keys!=null) {
        for (int i = 0; i < keys.length; i++) {
            properties.put(keys[i], img.getProperty(keys[i]));
        }
    }
    BufferedImage result = new BufferedImage(cm, raster, isAlphaPremultiplied, properties);
    img.copyData(raster);
    return result;
}

    
    }


