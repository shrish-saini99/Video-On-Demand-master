
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UserChangePassword extends javax.swing.JFrame {
    String email,oldpassword,newpassword,cpassword;

    public UserChangePassword() {
        initComponents();
        setSize(500,500);
        setVisible(true);
    }
    public UserChangePassword(String email){
         initComponents();
        
        this.email=email;
                setTitle("Change Password");

        tfemail.setText(email);
        tfemail.setEditable(false);
        lbback.setSize(500, 500);
        lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        tfoldpassword = new javax.swing.JPasswordField();
        tfnewpassword = new javax.swing.JPasswordField();
        tfconfirmpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Change Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 14, 240, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Email");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 74, 170, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Old Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 130, 190, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("New Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 180, 150, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Confirm Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 250, 150, 20);
        getContentPane().add(tfemail);
        tfemail.setBounds(220, 70, 240, 40);
        getContentPane().add(tfoldpassword);
        tfoldpassword.setBounds(220, 120, 240, 40);
        getContentPane().add(tfnewpassword);
        tfnewpassword.setBounds(220, 180, 240, 40);
        getContentPane().add(tfconfirmpassword);
        tfconfirmpassword.setBounds(220, 240, 240, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 330, 180, 30);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 590, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Thread(new Runnable(){
            public void run(){
               email=tfemail.getText();
               oldpassword=tfoldpassword.getText();
               newpassword=tfnewpassword.getText();
               cpassword=tfconfirmpassword.getText();
                   if(email.isEmpty() || oldpassword.isEmpty() || newpassword.isEmpty() || cpassword.isEmpty()){
                  JOptionPane.showMessageDialog(rootPane, "All fields are required !!");
              }
                  if(newpassword.equals(cpassword)){
                      try {
                          HttpResponse httpresponse=Unirest.get(GlobalData.hostname+"/userchangepassword")  
                                  .queryString("email",email)
                                  .queryString("oldpassword",oldpassword)
                                  .queryString("newpassword",newpassword)
                                  .asString();
                          if(httpresponse.getStatus()==200){
                              String res=httpresponse.getBody().toString();
                              if(res.equals("password changed")){
                                  JOptionPane.showMessageDialog(rootPane, "Password changed successfully !!");
                                  dispose();
                              }
                              else{
                                  JOptionPane.showMessageDialog(rootPane, "Invalid old password !!");
                              }
                          }
                          else{
                              JOptionPane.showMessageDialog(rootPane, "Not found");
                          }
                          
                          
                          
                      } catch (Exception ex) {
                            ex.printStackTrace();
                                  }
                  }
                  else{
                      JOptionPane.showMessageDialog(rootPane, "New Password and Confirm Password must match !!");
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
            java.util.logging.Logger.getLogger(UserChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserChangePassword().setVisible(true);
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
    private javax.swing.JPasswordField tfconfirmpassword;
    private javax.swing.JTextField tfemail;
    private javax.swing.JPasswordField tfnewpassword;
    private javax.swing.JPasswordField tfoldpassword;
    // End of variables declaration//GEN-END:variables
}
