
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UserSignUp extends javax.swing.JFrame {

    String email, password, confirmpassword, phone, name;

    public UserSignUp() {
        initComponents();
                setTitle("User Sign Up");

         lbback.setSize(500, 600);
        lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfphone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfpassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        tfcpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Customer Sign Up");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 10, 190, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter Email");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 190, 20);

        tfemail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tfemail);
        tfemail.setBounds(30, 90, 260, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Enter Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 130, 180, 30);

        tfname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tfname);
        tfname.setBounds(30, 160, 260, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Enter Phone Number");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 210, 210, 20);

        tfphone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tfphone);
        tfphone.setBounds(30, 240, 270, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Enter Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 290, 170, 30);

        tfpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tfpassword);
        tfpassword.setBounds(30, 320, 270, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Confirm Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 370, 190, 20);

        tfcpassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tfcpassword);
        tfcpassword.setBounds(30, 400, 260, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Sign Up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 460, 130, 30);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 410, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Thread(new Runnable() {
            public void run() {
                email = tfemail.getText();
                name = tfname.getText();
                phone = tfphone.getText();
                password = tfpassword.getText();
                confirmpassword = tfcpassword.getText();
                if (email.isEmpty() || password.isEmpty() || phone.isEmpty() || confirmpassword.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "All fields are required !!");
                } else {
                    if(phone.length()>=10){
                        
                    if(email.contains("@") && email.contains(".") && email.indexOf(".")>(email.indexOf("@")+1))
                    {
                    if (password.equals(confirmpassword)) {
                        try {
                            HttpResponse httpresponse=Unirest.get(GlobalData.hostname+"/usersignup")
                                    .queryString("name",name)
                                    .queryString("email",email)
                                    .queryString("password",password)
                                    .queryString("phone",phone).asString();
                            if(httpresponse.getStatus()==200){
                                String res=httpresponse.getBody().toString();
                                if(res.equals("already exists")){
                                    JOptionPane.showMessageDialog(rootPane, "This user already exists !!");
                                }
                                else if(res.equals("inserted")){
                                    JOptionPane.showMessageDialog(rootPane, "Sign Up successful !!");
                                    dispose();
                                    UserLogin obj=new UserLogin();
                                }
                            }
                            
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Password and confirm password should match !!");
                    }
                }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Enter valid email !");
                    }
                    }
                else{
                        JOptionPane.showMessageDialog(rootPane, "Enter valid phone number");
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
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSignUp().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbback;
    private javax.swing.JPasswordField tfcpassword;
    private javax.swing.JTextField tfemail;
    private javax.swing.JTextField tfname;
    private javax.swing.JPasswordField tfpassword;
    private javax.swing.JTextField tfphone;
    // End of variables declaration//GEN-END:variables
}
