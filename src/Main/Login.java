/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Components.Toast.Notifications;
import Functions.Utils.MD5Utils;
import Functions.MySQL.Database;
import Functions.Utils.Screen;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import java.awt.Point;

/**
 *
 * @author dxrry
 */
public class Login extends javax.swing.JFrame {
    
    public Database db = new Database();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        FlatLaf.registerCustomDefaultsSource("Components.Toast");
        FlatIntelliJLaf.setup();
        Notifications.getInstance().setJFrame(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonRegister = new Components.Button();
        fieldUsername = new Components.TextField();
        jLabel3 = new javax.swing.JLabel();
        buttonLogin = new Components.Button();
        jLabel2 = new javax.swing.JLabel();
        fieldPassword = new Components.FieldPassword();
        backgroundMain = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonRegister.setBackground(new java.awt.Color(255, 189, 36));
        buttonRegister.setForeground(new java.awt.Color(255, 255, 255));
        buttonRegister.setText("Register");
        buttonRegister.setAutoscrolls(true);
        buttonRegister.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        buttonRegister.setRound(30);
        buttonRegister.setShadowColor(new java.awt.Color(0, 0, 0));
        buttonRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRegisterMouseClicked(evt);
            }
        });
        getContentPane().add(buttonRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 630, 320, 70));

        fieldUsername.setForeground(new java.awt.Color(0, 0, 0));
        fieldUsername.setText("johndoe");
        fieldUsername.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        fieldUsername.setRound(30);
        fieldUsername.setShadowColor(new java.awt.Color(0, 0, 0));
        fieldUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldUsernameMouseClicked(evt);
            }
        });
        fieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(fieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 650, 70));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 470, -1, -1));

        buttonLogin.setBackground(new java.awt.Color(255, 189, 36));
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Log In");
        buttonLogin.setAutoscrolls(true);
        buttonLogin.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        buttonLogin.setRound(30);
        buttonLogin.setShadowColor(new java.awt.Color(0, 0, 0));
        buttonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLoginMouseClicked(evt);
            }
        });
        getContentPane().add(buttonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 630, 320, 70));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, -1, -1));

        fieldPassword.setForeground(new java.awt.Color(0, 0, 0));
        fieldPassword.setText("DefaultPassword");
        fieldPassword.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        fieldPassword.setRound(30);
        fieldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldPasswordMouseClicked(evt);
            }
        });
        fieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 650, 70));

        backgroundMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackgroundAuthentication.png"))); // NOI18N
        getContentPane().add(backgroundMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldUsernameActionPerformed

    private void buttonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLoginMouseClicked
        // TODO add your handling code here:
        String username = fieldUsername.getText();
        char[] passwordChars = fieldPassword.getPassword();
        String password = new String(passwordChars);
        String md5Hash = MD5Utils.calculateMD5(password);
        
        // Database Function Starting
        String dbUserPassword = db.getUserPassword(username);
        if (md5Hash.equals(dbUserPassword)) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Berhasil Login");
            Point centerPoint = Screen.getCenterPoint();
            Loading Loading = new Loading("Dashboard", false);
            Loading.setUserId(db.getUserId(username));
            Loading.setLocation(centerPoint.x - Loading.getWidth() / 2, centerPoint.y - Loading.getHeight() / 2);
            Loading.setVisible(true);
            dispose();
        }else{
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Username / Password Salah");
        }
    }//GEN-LAST:event_buttonLoginMouseClicked

    private void buttonRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRegisterMouseClicked
        // TODO add your handling code here:
        
        Point centerPoint = Screen.getCenterPoint();
        Loading Loading = new Loading("Register", false);
        Loading.setLocation(centerPoint.x - Loading.getWidth() / 2, centerPoint.y - Loading.getHeight() / 2);
        Loading.setVisible(true);
        dispose(); // Menutup jendela login
    }//GEN-LAST:event_buttonRegisterMouseClicked

    private void fieldUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldUsernameMouseClicked
        // TODO add your handling code here:
        fieldUsername.setText("");
    }//GEN-LAST:event_fieldUsernameMouseClicked

    private void fieldPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldPasswordMouseClicked
        // TODO add your handling code here:
        fieldPassword.setText("");
    }//GEN-LAST:event_fieldPasswordMouseClicked

    private void fieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Login Login = new Login();
            Login.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundMain;
    private Components.Button buttonLogin;
    private Components.Button buttonRegister;
    private Components.FieldPassword fieldPassword;
    private Components.TextField fieldUsername;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
