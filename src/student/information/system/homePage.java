package student.information.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
/**
 *
 * @author edwin
 */
public class homePage extends javax.swing.JFrame {
    
    registrationForm rf = new registrationForm();
    loginForm lf = new loginForm();
    
    public static String ff,fn;
    public String username = "";
    public String file;

    public homePage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        fileNameField = new javax.swing.JTextField();
        requestKeyButton = new javax.swing.JButton();
        getKeyButton = new javax.swing.JButton();
        showingField = new javax.swing.JTextField();
        encryptionButton = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        decryptionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Home Page");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        browseButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        browseButton.setText("Browse");
        browseButton.setFocusable(false);
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(browseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        fileNameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(fileNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 105, 259, 35));

        requestKeyButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        requestKeyButton.setText("Request Key");
        requestKeyButton.setFocusable(false);
        requestKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestKeyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(requestKeyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 160, 43));

        getKeyButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getKeyButton.setText("Get Key");
        getKeyButton.setFocusable(false);
        getKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getKeyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(getKeyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 160, 43));
        getContentPane().add(showingField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 357, 41));

        encryptionButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        encryptionButton.setText("Encryption");
        encryptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(encryptionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 110, 30));

        bg.setIcon(new javax.swing.ImageIcon("C:\\Users\\edwin\\OneDrive\\Pictures\\wallpaperflare.com_wallpaper.jpg")); // NOI18N
        bg.setText("jLabel2");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-390, -590, 1000, 1000));

        decryptionButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        decryptionButton.setText("Decryption");
        decryptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(decryptionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser jfc = new JFileChooser();       
        
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String file = jfc.getSelectedFile().getName();
            fileNameField.setText(file);
            boolean extension = file.endsWith(".pdf") || file.endsWith(".docx") || file.endsWith("pptx");
            
            if(extension){
                fn = jfc.getSelectedFile().getAbsolutePath();
                ff = jfc.getSelectedFile().getPath();
            }        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error opening the file !");
        }
        
        System.out.println(fn);
        System.out.println(ff);// TODO add your handling code here:
    }//GEN-LAST:event_browseButtonActionPerformed

    private void requestKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestKeyButtonActionPerformed
        try
        {
            loginForm lf = new loginForm();
            this.username = lf.username;
            if(username == null || username.isEmpty())
            {
                  JOptionPane.showMessageDialog(this, "Login first to proceed !");
                  dispose();
                  lf.show();         
            }
            else{
                System.out.println(username);
                String key = "no key";
                String name = lf.username;
                file = fileNameField.getText();
                if(!file.equals("") || !file.equals("null"))
                {
                    String enc_dec = "Pending";
                    String sql ="insert into key_generator(name,filename, secretkey, enc_dec) values('"+name+"','"+file+"','"+key+"','"+enc_dec+"')";
                    rf.st.executeUpdate(sql);
                    showingField.setText("Updated to database !");
                }
                else{
                 JOptionPane.showMessageDialog(this, "Select the file !");
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_requestKeyButtonActionPerformed

    private void getKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getKeyButtonActionPerformed
        if(file.equals("")){
            JOptionPane.showMessageDialog(this, "Select correct format of file !");
        }
        else{                  
            try {  
                SecretKey key; 
                key = KeyGenerator.getInstance("Blowfish").generateKey();
                String key1 = key.toString().substring(key.toString().indexOf("@") + 2);
                showingField.setText(key1);              
                String sql = "update key_generator set secretkey = '"+key1+"' where filename = '"+file+"'";
                rf.st.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Key Generated !");              
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }//GEN-LAST:event_getKeyButtonActionPerformed

    private void encryptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptionButtonActionPerformed
//       try {
//        FileInputStream file1 = new FileInputStream(fn);
//
//        File encryptDir = new File("src/encrypt");
//        if (!encryptDir.exists()) {
//            encryptDir.mkdirs();
//        }
//        FileOutputStream outStream = new FileOutputStream("src/encrypt/" + file);
//
//        // Generate a secret key
//        SecretKey secretKey = KeyGenerator.getInstance("Blowfish").generateKey();
//        byte[] keyBytes = secretKey.getEncoded();
//
//        // Secret key specification
//        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "Blowfish");
//
//        // Create and initialize the cipher for encryption
//        Cipher enc = Cipher.getInstance("Blowfish");
//        enc.init(Cipher.ENCRYPT_MODE, keySpec);
//
//        // Create a CipherOutputStream to write the encrypted data
//        CipherOutputStream cos = new CipherOutputStream(outStream, enc);
//
//        // Buffer to read and write data
//        byte[] buf = new byte[1024];
//        int read;
//
//        // Read from the input file and write to the CipherOutputStream
//        while ((read = file1.read(buf)) != -1) {
//            cos.write(buf, 0, read);
//        }
//
//        // Close streams
//        file1.close();
//        outStream.flush();
//        cos.close();
//
//        // Show success message
//        JOptionPane.showMessageDialog(null, "Encrypted Successfully");
//
//        // Update the database with the encryption status and secret key
//        String enc_dec = "Encrypted";
//        String encodedKey = java.util.Base64.getEncoder().encodeToString(keyBytes); // Convert the key to a base64 string for storage
//        String sql = "UPDATE key_generator SET enc_dec = '" + enc_dec + "', secretkey = '" + encodedKey + "' WHERE filename = '" + file + "'";
//        rf.st.executeUpdate(sql);
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
             
        dispose();
        Encrypt ec = new Encrypt();
        ec.show();
    }//GEN-LAST:event_encryptionButtonActionPerformed

    private void decryptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptionButtonActionPerformed
//    try {
//        // Open file chooser to select the encrypted file
//        JFileChooser jfc = new JFileChooser("src/encrypt");
//        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//            File encryptedFile = jfc.getSelectedFile();
//            String fileName = encryptedFile.getName();
//            showingField.setText(fileName);
//
//            // Retrieve the secret key from the database
//            String sql = "SELECT secretkey FROM key_generator WHERE filename = '" + fileName + "' AND enc_dec = 'Encrypted'";
//            rf.st = rf.conn.createStatement();
//            java.sql.ResultSet rs = rf.st.executeQuery(sql);
//
//            if (rs.next()) {
//                String encodedKey = rs.getString("secretkey");
//                byte[] keyBytes = java.util.Base64.getDecoder().decode(encodedKey);
//
//                // Create the secret key specification
//                SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "Blowfish");
//
//                // Create and initialize the cipher for decryption
//                Cipher dec = Cipher.getInstance("Blowfish");
//                dec.init(Cipher.DECRYPT_MODE, keySpec);
//
//                // Open input stream for the encrypted file
//                FileInputStream fileInputStream = new FileInputStream(encryptedFile);
//
//                // Open output stream for the decrypted file
//                FileOutputStream outStream = new FileOutputStream("src/encrypt/decryptedFile.txt");
//
//                // Create a CipherInputStream to read the encrypted data
//                CipherInputStream cis = new CipherInputStream(fileInputStream, dec);
//
//                // Buffer to read and write data
//                byte[] buf = new byte[1024];
//                int read;
//
//                // Read from the CipherInputStream and write to the output file
//                while ((read = cis.read(buf)) != -1) {
//                    outStream.write(buf, 0, read);
//                }
//
//                // Close streams
//                cis.close();
//                fileInputStream.close();
//                outStream.flush();
//                outStream.close();
//
//                // Show success message
//                JOptionPane.showMessageDialog(null, "Decrypted Successfully");
//
//                // Update the database with the decryption status
//                String enc_dec = "Decrypted";
//                String updateSql = "UPDATE key_generator SET enc_dec = '" + enc_dec + "' WHERE filename = '" + fileName + "'";
//                rf.st.executeUpdate(updateSql);
//
//            } else {
//                JOptionPane.showMessageDialog(this, "No encrypted file found with the specified name");
//            }
//            rs.close();
//            rf.st.close();
//        } else {
//            JOptionPane.showMessageDialog(this, "No file selected");
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//        dispose();
//        Decrypt dc = new Decrypt();
//        dc.show();
    }//GEN-LAST:event_decryptionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton decryptionButton;
    private javax.swing.JButton encryptionButton;
    private javax.swing.JTextField fileNameField;
    private javax.swing.JButton getKeyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton requestKeyButton;
    private javax.swing.JTextField showingField;
    // End of variables declaration//GEN-END:variables
}
