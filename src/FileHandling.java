
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;





public class FileHandling {
    JFileChooser chooser;
    int result;
    JFrame frame; 
    File file=null;
    String imgPath=null; // to get path of the source image in the main frame as golbal varibale

    public FileHandling(JFrame frame) {
        chooser=new JFileChooser("c:\\");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            this.frame=frame;       
    }
    public String getImagePath(){
        return imgPath;
    }
    
    public BufferedImage ReadImage() 
    { // read input imag from file chooser
        result=chooser.showOpenDialog(frame);
        
        if(result==JFileChooser.APPROVE_OPTION){
            file=chooser.getSelectedFile();        
            try {
                this.imgPath=file.getAbsolutePath();
                return ImageIO.read(file);
            } catch (IOException ex) {
               ex.printStackTrace();
            }
        }
        return null;
    }
    
    
    public void WriteImage(BufferedImage image){
        //save the segmented image 
        result=chooser.showSaveDialog(frame);
        if(result==JFileChooser.APPROVE_OPTION){
            file=chooser.getSelectedFile();
            try { 
             
            ImageIO.write(image, "jpg", file); 
        } catch (Exception e) { 
            System.out.println(e.toString()+" Image '"+file.getName()
                                +"' saving failed."); 
        } 
        }
        
    }
}
