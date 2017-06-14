
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class MainSegFrame extends javax.swing.JFrame {

   String img_src=null;
   public static BufferedImage inputimage=null;
   public static BufferedImage image=null;
    
    
    public MainSegFrame() {
     
     initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        segCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        mainsrc = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Grayscale = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Negative = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        About = new javax.swing.JMenu();
        Help = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jTextField1.setText("jTextField1");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Segmentation");
        setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);

        segCombo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        segCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Color Segmentation", "Edge Segmentation", "WaterShed Segmentation", "Texture Segmentation" }));
        segCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                segComboActionPerformed(evt);
            }
        });
        getContentPane().add(segCombo);
        segCombo.setBounds(700, 70, 210, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Select Segmentaion");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(530, 70, 140, 19);

        mainsrc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(mainsrc);
        mainsrc.setBounds(70, 80, 370, 330);

        File.setText("File");

        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        File.add(Open);

        Exit.setText("Exit");
        File.add(Exit);

        jMenuBar1.add(File);

        Edit.setText("Edit");

        Grayscale.setText("Grayscale");
        Grayscale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrayscaleActionPerformed(evt);
            }
        });
        Edit.add(Grayscale);
        Edit.add(jSeparator2);

        Negative.setText("Negative");
        Negative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NegativeActionPerformed(evt);
            }
        });
        Edit.add(Negative);

        jMenuItem2.setText("Reset");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Edit.add(jMenuItem2);

        jMenuBar1.add(Edit);

        About.setText("About");
        jMenuBar1.add(About);

        Help.setText("Help");
        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void segComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_segComboActionPerformed
if(image==null){
    JOptionPane.showMessageDialog(this,"Please select an image first, then proceed with segmentation options");
}
else{
        int i=segCombo.getSelectedIndex();
        System.out.println(""+i);
switch(i)
{
    
    case 0:
    {      
       
        colorSegFrame csf=new colorSegFrame();
        csf.setVisible(true);
      break;
    }
    case 1:
    {
         edgeSegFrame esf=new edgeSegFrame();
         esf.setVisible(true);
         break;        
    }
    case 2:
    {
        watershedSegFrame wtrshedf=new watershedSegFrame();
        wtrshedf.setVisible(true);
        break;
    }
    case 3:
    {
        texSegFrame tex=new texSegFrame();
        tex.setVisible(true);
        break;       
    }
}    }
    }//GEN-LAST:event_segComboActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        // TODO add your handling code here:
        FileHandling fh=new FileHandling(this);
        inputimage=fh.ReadImage();
        
       image=Utilities.getImageCopy(inputimage);
      
       mainsrc.setIcon(Utilities.getScaledIcon(mainsrc,image));
    }//GEN-LAST:event_OpenActionPerformed

    private void GrayscaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrayscaleActionPerformed
        // TODO add your handling code here:
        
        Utilities.convertToGreyscale(image);
        mainsrc.setIcon(Utilities.getScaledIcon(mainsrc,image));
        
    }//GEN-LAST:event_GrayscaleActionPerformed

    private void NegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NegativeActionPerformed
        // TODO add your handling code here:
        
         Utilities. convertToNegative(image);
         mainsrc.setIcon(Utilities.getScaledIcon(mainsrc,image));
    }//GEN-LAST:event_NegativeActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        image = Utilities.getImageCopy(inputimage);
        mainsrc.setIcon(Utilities.getScaledIcon(mainsrc,image));
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(MainSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainSegFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainSegFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu About;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem Grayscale;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem Negative;
    private javax.swing.JMenuItem Open;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel mainsrc;
    private javax.swing.JComboBox segCombo;
    // End of variables declaration//GEN-END:variables
}
