/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Components.Button;
import Functions.Payment.SwitchButtonPayment;
import Functions.Utils.Screen;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dxrry
 */
public class PaymentGateway extends javax.swing.JFrame {

    
    private final SwitchButtonPayment changeActiveButton;
    private final Button[] componentsPaymentsButton;
    private final Map<Integer, Integer> checkoutList;
    private String paymentMethod = "GOPAY";
    private Integer userAuthLoginId = 0;
    
    
    /**
     * Creates new form MainPayment
     * @param userAuthLoginId
     * @param checkoutList
     */
    public PaymentGateway(Integer userAuthLoginId, Map<Integer, Integer> checkoutList) {
        initComponents();
        componentsPaymentsButton = new Button[] {
            buttonBCA,
            buttonDANA,
            buttonGOPAY,
            buttonOVO,
            buttonSHOPEEPAY
        };
        SwitchButtonPayment newChangeActiveButton = new SwitchButtonPayment(componentsPaymentsButton);
        this.changeActiveButton = newChangeActiveButton;
        changeActiveButton.setActiveButton("SHOPEEPAY");
        this.userAuthLoginId = userAuthLoginId;
        this.checkoutList = checkoutList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonNext = new Components.Button();
        buttonBCA = new Components.Button();
        buttonGOPAY = new Components.Button();
        buttonDANA = new Components.Button();
        buttonOVO = new Components.Button();
        buttonSHOPEEPAY = new Components.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonNext.setBackground(new java.awt.Color(255, 189, 36));
        buttonNext.setForeground(new java.awt.Color(255, 255, 255));
        buttonNext.setText("Lanjutkan Pembayaran");
        buttonNext.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        buttonNext.setRound(30);
        buttonNext.setShadowColor(new java.awt.Color(0, 0, 0));
        buttonNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNextMouseClicked(evt);
            }
        });
        getContentPane().add(buttonNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 680, 690, 80));

        buttonBCA.setBackground(new java.awt.Color(26, 75, 147));
        buttonBCA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Payments/BCA.png"))); // NOI18N
        buttonBCA.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        buttonBCA.setName("buttonBCA"); // NOI18N
        buttonBCA.setRound(30);
        buttonBCA.setShadowColor(new java.awt.Color(0, 0, 0));
        buttonBCA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBCAMouseClicked(evt);
            }
        });
        getContentPane().add(buttonBCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 340, 90));

        buttonGOPAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Payments/GOPAY.png"))); // NOI18N
        buttonGOPAY.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        buttonGOPAY.setName("buttonGOPAY"); // NOI18N
        buttonGOPAY.setRound(30);
        buttonGOPAY.setShadowColor(new java.awt.Color(0, 0, 0));
        buttonGOPAY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonGOPAYMouseClicked(evt);
            }
        });
        getContentPane().add(buttonGOPAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 440, 340, 90));

        buttonDANA.setBackground(new java.awt.Color(0, 140, 235));
        buttonDANA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Payments/DANA.png"))); // NOI18N
        buttonDANA.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        buttonDANA.setName("buttonDANA"); // NOI18N
        buttonDANA.setRound(30);
        buttonDANA.setShadowColor(new java.awt.Color(0, 0, 0));
        buttonDANA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDANAMouseClicked(evt);
            }
        });
        getContentPane().add(buttonDANA, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 340, 90));

        buttonOVO.setBackground(new java.awt.Color(76, 51, 148));
        buttonOVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Payments/OVO.png"))); // NOI18N
        buttonOVO.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        buttonOVO.setName("buttonOVO"); // NOI18N
        buttonOVO.setRound(30);
        buttonOVO.setShadowColor(new java.awt.Color(0, 0, 0));
        buttonOVO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonOVOMouseClicked(evt);
            }
        });
        getContentPane().add(buttonOVO, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 320, 340, 90));

        buttonSHOPEEPAY.setBackground(new java.awt.Color(238, 77, 45));
        buttonSHOPEEPAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Payments/SHOPEEPAY.png"))); // NOI18N
        buttonSHOPEEPAY.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        buttonSHOPEEPAY.setName("buttonSHOPEEPAY"); // NOI18N
        buttonSHOPEEPAY.setRound(30);
        buttonSHOPEEPAY.setShadowColor(new java.awt.Color(0, 0, 0));
        buttonSHOPEEPAY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSHOPEEPAYMouseClicked(evt);
            }
        });
        getContentPane().add(buttonSHOPEEPAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, 340, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackgroundPayment.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSHOPEEPAYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSHOPEEPAYMouseClicked
        // TODO add your handling code here
        this.paymentMethod = "SHOPEEPAY";
        changeActiveButton.setActiveButton(paymentMethod);
    }//GEN-LAST:event_buttonSHOPEEPAYMouseClicked

    private void buttonOVOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOVOMouseClicked
        // TODO add your handling code here:
        this.paymentMethod = "OVO";
        changeActiveButton.setActiveButton(paymentMethod);
    }//GEN-LAST:event_buttonOVOMouseClicked

    private void buttonDANAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDANAMouseClicked
        // TODO add your handling code here:
        this.paymentMethod = "DANA";
        changeActiveButton.setActiveButton(paymentMethod);
    }//GEN-LAST:event_buttonDANAMouseClicked

    private void buttonGOPAYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGOPAYMouseClicked
        // TODO add your handling code here:
        this.paymentMethod = "GOPAY";
        changeActiveButton.setActiveButton(paymentMethod);
    }//GEN-LAST:event_buttonGOPAYMouseClicked

    private void buttonBCAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBCAMouseClicked
        // TODO add your handling code here:
        this.paymentMethod = "BCA";
        changeActiveButton.setActiveButton(paymentMethod);
    }//GEN-LAST:event_buttonBCAMouseClicked

    private void buttonNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNextMouseClicked
        // TODO add your handling code here:
        if(!checkoutList.isEmpty()) {
            Point centerPoint = Screen.getCenterPoint();
            Loading Loading = new Loading("Payment", paymentMethod);
            Loading.setUserId(this.userAuthLoginId);
            Loading.setCheckoutList(checkoutList);
            Loading.setLocation(centerPoint.x - Loading.getWidth() / 2, centerPoint.y - Loading.getHeight() / 2);
            Loading.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_buttonNextMouseClicked

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
            java.util.logging.Logger.getLogger(PaymentGateway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentGateway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentGateway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentGateway.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PaymentGateway(1, new HashMap<>()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.Button buttonBCA;
    private Components.Button buttonDANA;
    private Components.Button buttonGOPAY;
    private Components.Button buttonNext;
    private Components.Button buttonOVO;
    private Components.Button buttonSHOPEEPAY;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
