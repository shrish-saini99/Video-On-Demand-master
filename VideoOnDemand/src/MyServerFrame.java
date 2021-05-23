
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class MyServerFrame extends javax.swing.JFrame
{
    MyServer myserver;
    public MyServerFrame()
    {
        initComponents();
                setTitle("Server Frame");

        lbback.setSize(500, 500);
        lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));

        setSize(500,500);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btStartServer = new javax.swing.JButton();
        btStopServer = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btStartServer.setBackground(new java.awt.Color(255, 255, 255));
        btStartServer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btStartServer.setText("Start Server");
        btStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartServerActionPerformed(evt);
            }
        });
        getContentPane().add(btStartServer);
        btStartServer.setBounds(120, 40, 160, 40);

        btStopServer.setBackground(new java.awt.Color(255, 255, 255));
        btStopServer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btStopServer.setText("Stop Server");
        btStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStopServerActionPerformed(evt);
            }
        });
        getContentPane().add(btStopServer);
        btStopServer.setBounds(120, 140, 160, 40);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartServerActionPerformed

        try {
            myserver=new MyServer(9000);
            btStartServer.setEnabled(false);
            btStopServer.setEnabled(true);
        } catch (IOException ex) {

            ex.printStackTrace();
        }


    }//GEN-LAST:event_btStartServerActionPerformed

    private void btStopServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStopServerActionPerformed
            myserver.shutdown();
            btStartServer.setEnabled(true);
            btStopServer.setEnabled(false);

    }//GEN-LAST:event_btStopServerActionPerformed
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
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyServerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btStartServer;
    private javax.swing.JButton btStopServer;
    private javax.swing.JLabel lbback;
    // End of variables declaration//GEN-END:variables
}
