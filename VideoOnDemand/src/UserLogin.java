
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UserLogin extends javax.swing.JFrame {

    String email, password;

    public UserLogin() {
        initComponents();
        setTitle("User Login");

        lbback.setSize(500, 500);
        lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        btlogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Enter Email");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 50, 200, 20);

        tfemail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tfemail);
        tfemail.setBounds(20, 80, 220, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 180, 30);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(20, 170, 220, 30);

        btlogin.setBackground(new java.awt.Color(255, 255, 255));
        btlogin.setText("Login");
        btlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btloginActionPerformed(evt);
            }
        });
        getContentPane().add(btlogin);
        btlogin.setBounds(80, 220, 140, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("User Login");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 0, 140, 40);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 430, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btloginActionPerformed
        new Thread(new Runnable() {
            public void run() {
                email = tfemail.getText();
                password = jPasswordField1.getText();
                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "All fields are required !!");
                } else {
                    try {
                        HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/userlogin")
                                .queryString("email", email)
                                .queryString("password", password)
                                .asString();
                        if (httpresponse.getStatus() == 200) {
                            String res = httpresponse.getBody().toString();
                            System.out.println(res);
                            if (res.equals("login successful")) {
                                JOptionPane.showMessageDialog(UserLogin.this, "Login successful!!");
                                dispose();

                                UserHome obj = new UserHome(email);
                            } else if (res.equals("incorrect detail")) {
                                JOptionPane.showMessageDialog(UserLogin.this, "Incorrect Username or Password !!");
                            }

                        } else {
                            JOptionPane.showMessageDialog(UserLogin.this, "Login failed !!");
                        }

                    } catch (Exception ex) {

                        ex.printStackTrace();
                    }

                }
            }
        }).start();


    }//GEN-LAST:event_btloginActionPerformed

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
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lbback;
    private javax.swing.JTextField tfemail;
    // End of variables declaration//GEN-END:variables
}
