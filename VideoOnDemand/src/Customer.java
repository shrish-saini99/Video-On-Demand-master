
import javax.swing.ImageIcon;

public class Customer extends javax.swing.JFrame {

    public Customer() {
        initComponents();
        lbback.setSize(500, 500);
        lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));

        setSize(500,500);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btsignup = new javax.swing.JButton();
        btlogin = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btsignup.setText("Sign Up");
        btsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsignupActionPerformed(evt);
            }
        });
        getContentPane().add(btsignup);
        btsignup.setBounds(80, 50, 180, 40);

        btlogin.setText("Login");
        btlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btloginActionPerformed(evt);
            }
        });
        getContentPane().add(btlogin);
        btlogin.setBounds(80, 120, 180, 40);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsignupActionPerformed
UserSignUp obj=new UserSignUp();
    }//GEN-LAST:event_btsignupActionPerformed

    private void btloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btloginActionPerformed
UserLogin obj=new UserLogin();
    }//GEN-LAST:event_btloginActionPerformed

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlogin;
    private javax.swing.JButton btsignup;
    private javax.swing.JLabel lbback;
    // End of variables declaration//GEN-END:variables
}
