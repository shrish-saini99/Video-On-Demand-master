
import javax.swing.ImageIcon;

public class AdminHome extends javax.swing.JFrame {

    String username;

    public AdminHome() {
        initComponents();
        setSize(500, 500);
        setVisible(true);
    }

    AdminHome(String username) {
        initComponents();
                setTitle("Admin Home");

        lbback.setSize(700, 520);
        lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));

        this.username = username;
        jLabel1.setText("Welcome " + username);
        lbimg.setIcon(new ImageIcon("src/Pics/pic.jpg"));
        setSize(700, 520);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btChangePassword = new javax.swing.JButton();
        btaddcourse = new javax.swing.JButton();
        btviewcourses = new javax.swing.JButton();
        btmanagevideos = new javax.swing.JButton();
        btlogout = new javax.swing.JButton();
        lbimg = new javax.swing.JLabel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Welcome");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 20, 280, 40);

        btChangePassword.setText("Change Password");
        btChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btChangePassword);
        btChangePassword.setBounds(410, 80, 160, 40);

        btaddcourse.setText("Add courses");
        btaddcourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddcourseActionPerformed(evt);
            }
        });
        getContentPane().add(btaddcourse);
        btaddcourse.setBounds(0, 80, 130, 40);

        btviewcourses.setText("View courses");
        btviewcourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btviewcoursesActionPerformed(evt);
            }
        });
        getContentPane().add(btviewcourses);
        btviewcourses.setBounds(130, 80, 130, 40);

        btmanagevideos.setText("Manage Videos");
        btmanagevideos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmanagevideosActionPerformed(evt);
            }
        });
        getContentPane().add(btmanagevideos);
        btmanagevideos.setBounds(260, 80, 150, 40);

        btlogout.setText("Logout");
        btlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btlogout);
        btlogout.setBounds(570, 80, 110, 40);

        lbimg.setText("jLabel2");
        getContentPane().add(lbimg);
        lbimg.setBounds(40, 150, 620, 320);

        lbback.setText("jLabel2");
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 710, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangePasswordActionPerformed
        AdminChangePassword cobj = new AdminChangePassword(username);

    }//GEN-LAST:event_btChangePasswordActionPerformed

    private void btaddcourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddcourseActionPerformed
        AdminAddCourses obj = new AdminAddCourses();

    }//GEN-LAST:event_btaddcourseActionPerformed

    private void btviewcoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btviewcoursesActionPerformed
        AdminViewCourses obj = new AdminViewCourses();

    }//GEN-LAST:event_btviewcoursesActionPerformed

    private void btmanagevideosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmanagevideosActionPerformed
        AdminAddVideos obj = new AdminAddVideos();
    }//GEN-LAST:event_btmanagevideosActionPerformed

    private void btlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlogoutActionPerformed
        this.dispose();
        AdminLogin obj = new AdminLogin();


    }//GEN-LAST:event_btlogoutActionPerformed

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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChangePassword;
    private javax.swing.JButton btaddcourse;
    private javax.swing.JButton btlogout;
    private javax.swing.JButton btmanagevideos;
    private javax.swing.JButton btviewcourses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbimg;
    // End of variables declaration//GEN-END:variables
}
