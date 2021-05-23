^
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AdminLogin extends javax.swing.JFrame {

    String username;
    String password;

    public AdminLogin() {
        initComponents();
        setTitle("Admin Login");

        lbback.setSize(500, 500);
        lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));
        setSize(500, 500);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 90, 120, 30);

        tfusername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tfusername);
        tfusername.setBounds(180, 80, 230, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 150, 110, 30);

        tfpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tfpassword);
        tfpassword.setBounds(180, 140, 230, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(130, 270, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Admin Login ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 10, 220, 40);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 350, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Thread(new Runnable() {
            public void run() {
                username = tfusername.getText();
                password = tfpassword.getText();
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(AdminLogin.this, "All fields are required !!");
                } else {
                    try {
                        HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/login")
                                .queryString("username", username)
                                .queryString("password", password)
                                .asString();
                        if (httpresponse.getStatus() == 200) {
                            String res = httpresponse.getBody().toString();
                            System.out.println(res);
                            if (res.equals("login successful")) {
                                JOptionPane.showMessageDialog(AdminLogin.this, "Login successful!!");
                                dispose();

                                AdminHome obj = new AdminHome(username);
                            } else {
                                JOptionPane.showMessageDialog(AdminLogin.this, "Incorrect Username or Password !!");
                            }

                        } else {
                            JOptionPane.showMessageDialog(AdminLogin.this, "Login failed !!");
                        }

                    } catch (Exception ex) {

                        ex.printStackTrace();
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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbback;
    private javax.swing.JPasswordField tfpassword;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
