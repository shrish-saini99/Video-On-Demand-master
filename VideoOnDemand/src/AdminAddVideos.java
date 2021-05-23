
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class AdminAddVideos extends javax.swing.JFrame {

    String category, categories;
    JFileChooser jfcthumbnail, jfcvideos;
    String thumbnail, video;
    String course, title;
    int duration, lectureno;
    int videoid;
    MyModel tm;
    ArrayList<Videos> al = new ArrayList();

    public AdminAddVideos() {
        initComponents();
        setTitle("Add Videos");

        tm = new MyModel();
        jTable1.setModel(tm);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());
        jTable1.setRowHeight(40);

        cbcategory.addItem("--Select--");
        for (int i = 0; i < GlobalData.categories.length; i++) {
            cbcategory.addItem(GlobalData.categories[i]);
        }
        cbcategory.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            cbcourse.removeAllItems();
                            category = cbcategory.getSelectedItem().toString();
                            try {
                                System.out.println(category);
                                HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/fetchcbcourses")
                                        .queryString("cname", category)
                                        .asString();
                                if (httpresponse.getStatus() == 200) {
                                    String courses = httpresponse.getBody().toString();
                                    //  System.out.println(categories);
                                    StringTokenizer st = new StringTokenizer(courses, ";");
                                    while (st.hasMoreTokens()) {
                                        String s = st.nextToken();
                                        // System.out.println(s);
                                        cbcourse.addItem(s);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Not found !!");
                                }

                            } catch (Exception ex) {
                                ex.printStackTrace();

                            }

                        }
                    }).start();
                }

            }
        });
        lbback.setSize(1000, 600);
        lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbcategory = new javax.swing.JComboBox<>();
        cbcourse = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tflectureno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tftitle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfduration = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbthumbnail = new javax.swing.JLabel();
        btbrowsethumbnail = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbvideo = new javax.swing.JLabel();
        btbrowsevideo = new javax.swing.JButton();
        btadd = new javax.swing.JButton();
        mypanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btfetch = new javax.swing.JButton();
        btdelete = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Add New Video");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 0, 190, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Select Category");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 50, 120, 20);

        getContentPane().add(cbcategory);
        cbcategory.setBounds(420, 40, 200, 30);

        getContentPane().add(cbcourse);
        cbcourse.setBounds(420, 80, 200, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Select Course");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 80, 110, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Enter lecture number");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 150, 130, 30);
        getContentPane().add(tflectureno);
        tflectureno.setBounds(230, 150, 250, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Title");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 200, 110, 30);
        getContentPane().add(tftitle);
        tftitle.setBounds(230, 200, 250, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Duration");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 250, 110, 30);
        getContentPane().add(tfduration);
        tfduration.setBounds(230, 250, 250, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Thumbnail");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 300, 100, 20);

        lbthumbnail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lbthumbnail);
        lbthumbnail.setBounds(230, 300, 60, 50);

        btbrowsethumbnail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btbrowsethumbnail.setText("Browse");
        btbrowsethumbnail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowsethumbnailActionPerformed(evt);
            }
        });
        getContentPane().add(btbrowsethumbnail);
        btbrowsethumbnail.setBounds(400, 300, 100, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Select Video");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 350, 90, 30);

        lbvideo.setText("-------");
        getContentPane().add(lbvideo);
        lbvideo.setBounds(130, 350, 270, 30);

        btbrowsevideo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btbrowsevideo.setText("Browse");
        btbrowsevideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowsevideoActionPerformed(evt);
            }
        });
        getContentPane().add(btbrowsevideo);
        btbrowsevideo.setBounds(400, 350, 100, 30);

        btadd.setText("Add");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });
        getContentPane().add(btadd);
        btadd.setBounds(170, 420, 120, 30);

        mypanel.setBackground(new java.awt.Color(204, 255, 204));
        mypanel.setLayout(null);

        jScrollPane1.setViewportView(jTable1);

        mypanel.add(jScrollPane1);
        jScrollPane1.setBounds(30, 59, 390, 180);

        getContentPane().add(mypanel);
        mypanel.setBounds(540, 130, 430, 290);

        btfetch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btfetch.setText("Fetch");
        btfetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfetchActionPerformed(evt);
            }
        });
        getContentPane().add(btfetch);
        btfetch.setBounds(680, 50, 140, 30);

        btdelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btdelete.setText("Delete");
        btdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btdelete);
        btdelete.setBounds(660, 433, 150, 30);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 980, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed

        new Thread(new Runnable() {
            @Override
            public void run() {
                course = cbcourse.getSelectedItem().toString();
                category = cbcategory.getSelectedItem().toString();
                lectureno = Integer.parseInt(tflectureno.getText());
                duration = Integer.parseInt(tfduration.getText());
                title = tftitle.getText();

                if (category == null || course == null || tfduration.getText().isEmpty() || tflectureno.getText().isEmpty() || title.isEmpty() || thumbnail == null || video == null) {
                    JOptionPane.showMessageDialog(rootPane, "All fields are required !!");
                } else {
                    try {
                        HttpResponse httpresponse = Unirest.post(GlobalData.hostname + "/addvideos")
                                .queryString("title", title)
                                .queryString("duration", duration)
                                .queryString("lectureno", lectureno)
                                .queryString("category", category)
                                .queryString("course", course)
                                .field("thumbnail", new File(thumbnail))
                                .field("video", new File(video)).asString();

                        if (httpresponse.getStatus() == 200) {
                            if (httpresponse.getBody().toString().equals("already exists")) {
                                JOptionPane.showMessageDialog(rootPane, "Video already exists!!");
                            } else if (httpresponse.getBody().toString().equals("row inserted")) {
                                JOptionPane.showMessageDialog(rootPane, "Video added successfully !!");
                                loadData();
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }

            }
        }).start();

    }//GEN-LAST:event_btaddActionPerformed

    private void btbrowsethumbnailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrowsethumbnailActionPerformed
        jfcthumbnail = new JFileChooser("F:\\Videos");
        int ans = jfcthumbnail.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = jfcthumbnail.getSelectedFile();
            thumbnail = f.getPath();
            try {
                BufferedImage img = ImageIO.read(f);
                BufferedImage newimg = resize(img, lbthumbnail.getWidth(), lbthumbnail.getHeight());
                lbthumbnail.setIcon(new ImageIcon(newimg));

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }//GEN-LAST:event_btbrowsethumbnailActionPerformed

    private void btbrowsevideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrowsevideoActionPerformed
        jfcvideos = new JFileChooser();
        int ans = jfcvideos.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = jfcvideos.getSelectedFile();
            video = f.getPath();
            lbvideo.setText(video);
        }

    }//GEN-LAST:event_btbrowsevideoActionPerformed

    private void btfetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfetchActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                course = cbcourse.getSelectedItem().toString();
                //  category=cbcategory.getSelectedItem().toString();
                if (course == null) {
                    JOptionPane.showMessageDialog(rootPane, "Please select some course !!");
                } else {
                    loadData();
                }

            }
        }).start();

    }//GEN-LAST:event_btfetchActionPerformed

    private void btdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdeleteActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (jTable1.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Please select some row !");
                } else {
                  int ans=  JOptionPane.showConfirmDialog(rootPane, "Do you want to delete this video ?","Delete Confirmation !",JOptionPane.YES_NO_OPTION);
                    if(ans==JOptionPane.YES_OPTION){
                    videoid = al.get(jTable1.getSelectedRow()).videoid;
                    try {
                        HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/deletevideo").queryString("videoid", videoid).asString();
                        if (httpresponse.getStatus() == 200) {
                            String res = httpresponse.getBody().toString();
                            if (res.equals("deleted")) {
                                JOptionPane.showMessageDialog(rootPane, "Video deleted successfully !!");
                                al.clear();
                                loadData();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Video not deleted!!");

                            }
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    }
                }

            }
        }).start();


    }//GEN-LAST:event_btdeleteActionPerformed

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
            java.util.logging.Logger.getLogger(AdminAddVideos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAddVideos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAddVideos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAddVideos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAddVideos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btadd;
    private javax.swing.JButton btbrowsethumbnail;
    private javax.swing.JButton btbrowsevideo;
    private javax.swing.JButton btdelete;
    private javax.swing.JButton btfetch;
    private javax.swing.JComboBox<String> cbcategory;
    private javax.swing.JComboBox<String> cbcourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbthumbnail;
    private javax.swing.JLabel lbvideo;
    private javax.swing.JPanel mypanel;
    private javax.swing.JTextField tfduration;
    private javax.swing.JTextField tflectureno;
    private javax.swing.JTextField tftitle;
    // End of variables declaration//GEN-END:variables

    class MyModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return (al.size());

        }

        @Override
        public int getColumnCount() {

            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).videoid;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).lectureno;
            } else if (columnIndex == 2) {
                return al.get(rowIndex).title;

            } else if (columnIndex == 3) {
                return al.get(rowIndex).duration;
            } else if (columnIndex == 4) {
                return al.get(rowIndex).photo;
            } else {
                return "something";
            }

        }

        @Override
        public String getColumnName(int column) {

            String title[] = {"Videoid", "Lecture No", "Title", "Duration", "Thumbnail"};
            return title[column];
        }

    }

    void loadData() {
        try {
            HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/fetchvideos").queryString("course", course).asString();

            if (httpresponse.getStatus() == 200) {
                String res = httpresponse.getBody().toString();
                System.out.println(res);
                StringTokenizer st = new StringTokenizer(res, "~");

                al.clear();
                tm.fireTableDataChanged();
                while (st.hasMoreTokens()) {
                    String singlevideo = st.nextToken();
                    StringTokenizer st2 = new StringTokenizer(singlevideo, ";");
                    while (st2.hasMoreTokens()) {
                        lectureno = Integer.parseInt(st2.nextToken());
                        videoid = Integer.parseInt(st2.nextToken());
                        title = st2.nextToken();
                        duration = Integer.parseInt(st2.nextToken());
                        String tphoto = st2.nextToken();
                        Videos obj = new Videos(duration, lectureno, videoid, title, tphoto);
                        al.add(obj);
                        tm.fireTableDataChanged();

                    }
                }

            }

        } catch (UnirestException ex) {
            ex.printStackTrace();
        }
    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            try {
                URL url = new URL(GlobalData.hostname + "/getresource/" + al.get(row).photo);
                BufferedImage img = ImageIO.read(url);

                BufferedImage newimg = AdminAddVideos.this.resize(img, 50, 30);
                lbl.setIcon(new ImageIcon(newimg));

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return lbl;

        }

    }

    BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

}
