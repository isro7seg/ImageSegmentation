
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

public class edgeSegFrame extends javax.swing.JFrame {

    EdgeSegmentation eseg;
    Image outputImage;
    BufferedImage bimage;
    MediaTracker tracker = null;
    PixelGrabber grabber = null;
    int width = 0, height = 0;
    //slider constraints
    int threshold = 60;
    boolean thresholdActive = false;
    int imageNumber = 0;
    public int orig[] = null;

    /**
     * Creates new form edgeSegFrame
     */
    public edgeSegFrame() {
        initComponents();
        Tfthresh.setText("" + 30);
        width = MainSegFrame.image.getWidth();
        height = MainSegFrame.image.getHeight();
        edgesrc.setIcon(Utilities.getScaledIcon(edgesrc, MainSegFrame.image));
        jradiobutton2.setSelected(true);
        thresholdActive = false;
        edgeslider.setEnabled(false);
        eseg = new EdgeSegmentation();
        processImage();

    }

    private void processImage() {
        orig = new int[width * height];
        PixelGrabber grabber = new PixelGrabber(MainSegFrame.image, 0, 0, width, height, orig, 0, width);
        try {
            grabber.grabPixels();
        } catch (InterruptedException e2) {
            System.out.println("error: " + e2);
        }
        eseg.init(orig, width, height);
        int[] res = eseg.process();
        res = threshold(res, threshold);
        final Image output = createImage(new MemoryImageSource(width, height, res, 0, width));
        outputImage = output;
        //conversion of image to buffered image
        bimage = new BufferedImage(outputImage.getWidth(null), outputImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        bimage.setRGB(0, 0, width, height, res, 0, width);
        edgedest.setIcon(Utilities.getScaledIcon(edgedest, bimage));

    }

    public int[] threshold(int[] original, int value) {
        for (int x = 0; x < original.length; x++) {
            if ((original[x] & 0xff) >= value && (original[x] >> 8 & 0xff) >= value && (original[x] >> 16 & 0xff) >= value) {
                original[x] = 0xffffffff;
            } else {
                original[x] = 0xff000000;
            }
        }
        return original;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jradioButton1 = new javax.swing.JRadioButton();
        jradiobutton2 = new javax.swing.JRadioButton();
        edgeslider = new javax.swing.JSlider();
        bedgesave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Tfthresh = new javax.swing.JTextField();
        edgesrc = new javax.swing.JLabel();
        edgedest = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edge Segmentation");
        setMinimumSize(new java.awt.Dimension(850, 600));
        setPreferredSize(new java.awt.Dimension(850, 600));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Threshold");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 350, 80, 16);

        buttonGroup1.add(jradioButton1);
        jradioButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jradioButton1.setText("Enable");
        jradioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jradioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jradioButton1);
        jradioButton1.setBounds(60, 380, 67, 27);

        buttonGroup1.add(jradiobutton2);
        jradiobutton2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jradiobutton2.setText("Disable");
        jradiobutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jradiobutton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jradiobutton2);
        jradiobutton2.setBounds(60, 410, 71, 27);

        edgeslider.setMajorTickSpacing(40);
        edgeslider.setMaximum(255);
        edgeslider.setMinorTickSpacing(10);
        edgeslider.setPaintLabels(true);
        edgeslider.setPaintTicks(true);
        edgeslider.setSnapToTicks(true);
        edgeslider.setValue(30);
        edgeslider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                edgesliderStateChanged(evt);
            }
        });
        getContentPane().add(edgeslider);
        edgeslider.setBounds(220, 400, 450, 50);

        bedgesave.setText("Save");
        bedgesave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedgesaveActionPerformed(evt);
            }
        });
        getContentPane().add(bedgesave);
        bedgesave.setBounds(710, 400, 57, 23);

        jLabel2.setText("Threshold");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(361, 360, 100, 14);

        Tfthresh.setEditable(false);
        getContentPane().add(Tfthresh);
        Tfthresh.setBounds(440, 360, 50, 20);

        edgesrc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(edgesrc);
        edgesrc.setBounds(110, 100, 290, 170);

        edgedest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(edgedest);
        edgedest.setBounds(470, 100, 300, 170);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edgesliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_edgesliderStateChanged

        // TODO add your handling code here:
        JSlider source = (JSlider) evt.getSource();
        if (!source.getValueIsAdjusting()) {
            System.out.println("threshold=" + source.getValue());
            threshold = source.getValue();
            Tfthresh.setText("" + source.getValue());
            processImage();

        }
    }//GEN-LAST:event_edgesliderStateChanged

    private void jradioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jradioButton1ActionPerformed
        // TODO add your handling code here:
        thresholdActive = true;
        edgeslider.setEnabled(true);
    }//GEN-LAST:event_jradioButton1ActionPerformed

    private void jradiobutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jradiobutton2ActionPerformed
        // TODO add your handling code here:
        thresholdActive = false;
        edgeslider.setEnabled(false);
    }//GEN-LAST:event_jradiobutton2ActionPerformed

    private void bedgesaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bedgesaveActionPerformed
        FileHandling fh = new FileHandling(this);
        fh.WriteImage(bimage);


    }//GEN-LAST:event_bedgesaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(edgeSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edgeSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edgeSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edgeSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edgeSegFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tfthresh;
    private javax.swing.JButton bedgesave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel edgedest;
    private javax.swing.JSlider edgeslider;
    private javax.swing.JLabel edgesrc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jradioButton1;
    private javax.swing.JRadioButton jradiobutton2;
    // End of variables declaration//GEN-END:variables
}
