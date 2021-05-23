
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import sun.rmi.transport.proxy.HttpReceiveSocket;

public class AdminViewCourses extends javax.swing.JFrame {

    String category;
    ArrayList<Course> al = new ArrayList<>();
    mymodel model;

    public AdminViewCourses() {
        initComponents();
                setTitle("View Courses");

        model = new mymodel();
        for (int i = 0; i < GlobalData.categories.length; i++) {
            jComboBox1.addItem(GlobalData.categories[i]);
        }
        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());
        jTable1.setRowHeight(40);
        lbback.setSize(600, 600);
        lbback.setIcon(new ImageIcon("src/Pics/bg5.jpg"));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btfetch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btdelete = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("View All Courses");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 0, 220, 40);

        jLabel2.setText("Select Category");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 50, 180, 20);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(40, 80, 430, 30);

        btfetch.setText("Fetch");
        btfetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfetchActionPerformed(evt);
            }
        });
        getContentPane().add(btfetch);
        btfetch.setBounds(40, 133, 120, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 190, 452, 210);

        btdelete.setText("Delete Course");
        btdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btdelete);
        btdelete.setBounds(190, 433, 140, 30);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 630, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btfetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfetchActionPerformed
        new Thread(new Runnable() {
            public void run() {
                loadDataFromDB();
            }
        }).start();


    }//GEN-LAST:event_btfetchActionPerformed

    private void btdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdeleteActionPerformed
        new Thread(new Runnable() {
            public void run() {
                if (jTable1.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Please select a row !!");
                } else {
                    int ans = JOptionPane.showConfirmDialog(rootPane, "Are you sure to delete ? ", "Delete confirmation!", JOptionPane.YES_NO_OPTION);
                    if (ans == JOptionPane.YES_OPTION) {
                        try {
                            HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/deletecourse")
                                    .queryString("coursename", al.get(jTable1.getSelectedRow()).name).asString();
                            if (httpresponse.getStatus() == 200) {
                                if (httpresponse.getBody().equals("success")) {
                                    JOptionPane.showMessageDialog(rootPane, "Course deleted successfully !!");
                                    loadDataFromDB();
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Record not found !!");

                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Not found");
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
            java.util.logging.Logger.getLogger(AdminViewCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminViewCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminViewCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminViewCourses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminViewCourses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdelete;
    private javax.swing.JButton btfetch;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbback;
    // End of variables declaration//GEN-END:variables

    class mymodel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).name;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).description;

            } else if (columnIndex == 2) {
                return al.get(rowIndex).amount;

            } else if (columnIndex == 3) {
                return al.get(rowIndex).photo;
            } else {
                return "something";
            }
        }

        @Override
        public String getColumnName(int column) {
            String title[] = {"Name", "Description", "Amount", "Photo"};
            return title[column];
        }

    }

    void loadDataFromDB() {
        al.clear();
        model.fireTableDataChanged();
        category = jComboBox1.getSelectedItem().toString();

        if (category.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please choose some category !!");
        } else {
            try {
                HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/fetchcourses")
                        .queryString("category", category)
                        .asString();
                String res = httpresponse.getBody().toString();
                StringTokenizer st = new StringTokenizer(res, "~");
                int count = st.countTokens();
                while (st.hasMoreTokens()) {
                    String s = st.nextToken();
                    StringTokenizer st2 = new StringTokenizer(s, ";");
                    while (st2.hasMoreTokens()) {
                        String name = st2.nextToken();
                        System.out.println(name);
                        int amount = Integer.parseInt(st2.nextToken());
                        String desc = st2.nextToken();
                        System.out.println(desc);
                        String sqphoto = st2.nextToken();
                        System.out.println(sqphoto);

                        al.add(new Course(name, desc, amount, sqphoto));
                        model.fireTableDataChanged();
                    }
                    System.out.println("Size:" + al.size());
                }

            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }

    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            try {
                URL url = new URL(GlobalData.hostname + "/getresource/" + al.get(row).photo);
                BufferedImage img = ImageIO.read(url);

                BufferedImage newimg = AdminViewCourses.this.resize(img, 50, 30);
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
