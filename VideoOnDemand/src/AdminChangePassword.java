
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AdminChangePassword extends javax.swing.JFrame {

    String username, oldpassword, newpassword, cpassword;

    public AdminChangePassword() {
        initComponents();
        setSize(500, 500);
        setVisible(true);
    }

    public AdminChangePassword(String username) {
        initComponents();
                setTitle("Change Password");

        this.username = username;
        tfusername.setText(username);
        tfusername.setEditable(false);
        lbback.setSize(500, 500);
        lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));

        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfOldPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        tfNewPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tfConfirmPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 80, 120, 30);
        getContentPane().add(tfusername);
        tfusername.setBounds(190, 80, 240, 30);

        jLabel2.setText("Old Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 130, 110, 30);
        getContentPane().add(tfOldPassword);
        tfOldPassword.setBounds(190, 130, 240, 30);

        jLabel3.setText("New Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 190, 110, 30);
        getContentPane().add(tfNewPassword);
        tfNewPassword.setBounds(190, 190, 240, 30);

        jLabel4.setText("Confirm Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 240, 120, 30);
        getContentPane().add(tfConfirmPassword);
        tfConfirmPassword.setBounds(190, 240, 240, 30);

        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(80, 310, 140, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Change Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 10, 220, 40);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 620, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Thread(new Runnable() {
            public void run() {
                // username=tfusername.getText();
                oldpassword = tfOldPassword.getText();
                newpassword = tfNewPassword.getText();
                cpassword = tfConfirmPassword.getText();
                if (username.isEmpty() || oldpassword.isEmpty() || newpassword.isEmpty() || cpassword.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "All fields are required !!");
                } else {
                    if (newpassword.equals(cpassword)) {
                        try {
                            HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/changepassword")
                                    .queryString("username", username)
                                    .queryString("oldpassword", oldpassword)
                                    .queryString("newpassword", newpassword)
                                    .asString();
                            if (httpresponse.getStatus() == 200) {
                                String res = httpresponse.getBody().toString();
                                if (res.equals("password changed")) {
                                    JOptionPane.showMessageDialog(rootPane, "Password changed successfully !!");
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Invalid old password !!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Not found");
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "New Password and Confirm Password must match !!");
                    }
                }
            }
        }).start();


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbback;
    private javax.swing.JPasswordField tfConfirmPassword;
    private javax.swing.JPasswordField tfNewPassword;
    private javax.swing.JPasswordField tfOldPassword;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
