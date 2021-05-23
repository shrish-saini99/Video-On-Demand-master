
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AdminAddCourses extends javax.swing.JFrame {

    String category, coursename, description, sqphoto, widephoto, samplevideo;
    int amount;
    JFileChooser jfcsqphoto, jfcwidephoto, jfcsamplevideo;

    public AdminAddCourses() {
        initComponents();
        setTitle("Add Courses");
        jfcsqphoto = new JFileChooser();
        jfcwidephoto = new JFileChooser();
        jfcsamplevideo = new JFileChooser();

        for (int i = 0; i < GlobalData.categories.length; i++) {
            cbcategory.addItem(GlobalData.categories[i]);
        }
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        lbback.setSize(600,600);
                lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));

        setSize(600, 600);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbcategory = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfcoursename = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfdescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbsquarephoto = new javax.swing.JLabel();
        btbrowsesquarephoto = new javax.swing.JButton();
        lbwidephoto = new javax.swing.JLabel();
        btbrowsewidephoto = new javax.swing.JButton();
        lbsamplevideo = new javax.swing.JLabel();
        btbrowsesamplevideo = new javax.swing.JButton();
        tfamount = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Add category");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 10, 190, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Select Category");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 54, 160, 20);

        getContentPane().add(cbcategory);
        cbcategory.setBounds(250, 50, 260, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Enter Course Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 90, 170, 30);
        getContentPane().add(tfcoursename);
        tfcoursename.setBounds(250, 90, 260, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Enter Description");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 160, 140, 30);

        tfdescription.setColumns(20);
        tfdescription.setRows(5);
        jScrollPane1.setViewportView(tfdescription);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(250, 140, 260, 80);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Select square photo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 250, 140, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Select wide photo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 294, 140, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Select sample video");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 350, 120, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Enter purchase amount");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 390, 190, 50);

        lbsquarephoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lbsquarephoto);
        lbsquarephoto.setBounds(260, 240, 60, 50);

        btbrowsesquarephoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btbrowsesquarephoto.setText("Browse");
        btbrowsesquarephoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowsesquarephotoActionPerformed(evt);
            }
        });
        getContentPane().add(btbrowsesquarephoto);
        btbrowsesquarephoto.setBounds(390, 240, 110, 40);

        lbwidephoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lbwidephoto);
        lbwidephoto.setBounds(260, 294, 200, 40);

        btbrowsewidephoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btbrowsewidephoto.setText("Browse");
        btbrowsewidephoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowsewidephotoActionPerformed(evt);
            }
        });
        getContentPane().add(btbrowsewidephoto);
        btbrowsewidephoto.setBounds(470, 290, 110, 40);

        lbsamplevideo.setText("------");
        getContentPane().add(lbsamplevideo);
        lbsamplevideo.setBounds(160, 350, 290, 30);

        btbrowsesamplevideo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btbrowsesamplevideo.setText("Browse");
        btbrowsesamplevideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowsesamplevideoActionPerformed(evt);
            }
        });
        getContentPane().add(btbrowsesamplevideo);
        btbrowsesamplevideo.setBounds(470, 350, 110, 40);
        getContentPane().add(tfamount);
        tfamount.setBounds(260, 400, 260, 40);

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });
        getContentPane().add(btAdd);
        btAdd.setBounds(120, 450, 140, 40);
        getContentPane().add(lbback);
        lbback.setBounds(-10, -10, 740, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        new Thread(new Runnable() {
            public void run() {
                category = cbcategory.getSelectedItem().toString();
                coursename = tfcoursename.getText();
                description = tfdescription.getText();

                if (category.isEmpty() || coursename.isEmpty() || description.isEmpty() || tfamount.getText().isEmpty() || sqphoto==null || widephoto==null || samplevideo==null) {
                    JOptionPane.showMessageDialog(rootPane, "All fields are required !!");
                } else {
                    try {
                        amount = Integer.parseInt(tfamount.getText());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, "Amount must be number !!");
                    }
                    try {
                        HttpResponse httpresponse = Unirest.post(GlobalData.hostname + "/addcourse")
                                .queryString("category", category)
                                .queryString("coursename", coursename)
                                .queryString("description", description)
                                .queryString("amount", amount)
                                .field("sqphoto", new File(sqphoto))
                                .field("widephoto", new File(widephoto))
                                .field("samplevideo", new File(samplevideo)).asString();

                        if (httpresponse.getStatus() == 200) {
                            if (httpresponse.getBody().equals("already exists")) {
                                JOptionPane.showMessageDialog(rootPane, "This course already exists !!");
                            } else if (httpresponse.getBody().equals("row updated")) {
                                JOptionPane.showMessageDialog(rootPane, "Course added");
                                tfamount.setText("");
                                tfcoursename.setText("");
                                tfdescription.setText("");
//                                sqphoto=null;
//                                widephoto=null;
//                               

                                                                
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Not found");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();

                    }

                }

            }
        }).start();


    }//GEN-LAST:event_btAddActionPerformed

    private void btbrowsesquarephotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrowsesquarephotoActionPerformed
        int ans = jfcsqphoto.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {

            File f = jfcsqphoto.getSelectedFile();
            sqphoto = f.getPath();
            try {
                BufferedImage img = ImageIO.read(f);
                BufferedImage newimg = resize(img, lbsquarephoto.getWidth(), lbsquarephoto.getHeight());
                lbsquarephoto.setIcon(new ImageIcon(newimg));

            } catch (Exception ex) {
                ex.printStackTrace();
            }

//            lbsquarephoto.setText(sqphoto);
        }

    }//GEN-LAST:event_btbrowsesquarephotoActionPerformed

    private void btbrowsewidephotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrowsewidephotoActionPerformed
        int ans = jfcwidephoto.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {

            File f = jfcwidephoto.getSelectedFile();
            widephoto = f.getPath();
             try {
                BufferedImage img = ImageIO.read(f);
                BufferedImage newimg = resize(img, lbwidephoto.getWidth(), lbwidephoto.getHeight());
                lbwidephoto.setIcon(new ImageIcon(newimg));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
    

//            lbwidephoto.setText(widephoto);
        }
    }//GEN-LAST:event_btbrowsewidephotoActionPerformed

    private void btbrowsesamplevideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrowsesamplevideoActionPerformed
        int ans = jfcsamplevideo.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {

            File f = jfcsamplevideo.getSelectedFile();
            samplevideo = f.getPath();
            lbsamplevideo.setText(samplevideo);
        }
    }//GEN-LAST:event_btbrowsesamplevideoActionPerformed

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
            java.util.logging.Logger.getLogger(AdminAddCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAddCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAddCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAddCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAddCourses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btbrowsesamplevideo;
    private javax.swing.JButton btbrowsesquarephoto;
    private javax.swing.JButton btbrowsewidephoto;
    private javax.swing.JComboBox<String> cbcategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbsamplevideo;
    private javax.swing.JLabel lbsquarephoto;
    private javax.swing.JLabel lbwidephoto;
    private javax.swing.JTextField tfamount;
    private javax.swing.JTextField tfcoursename;
    private javax.swing.JTextArea tfdescription;
    // End of variables declaration//GEN-END:variables
 BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

}
