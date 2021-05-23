
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserHome extends javax.swing.JFrame {

    String email;
    int w, h;
    //coursespanel p[];
    JLabel lb[];
    String images[] = {"src/Pics/slider1.png", "src/Pics/slider2.jpg", "src/Pics/slider3.jpg", "src/Pics/slider4.jpg", "src/Pics/slider5.jpeg"};

    public UserHome() {
    }

    public UserHome(String email) {
        initComponents();
        this.email = email;
                setTitle("User Home");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        w = (int) d.getWidth();
        h = (int) d.getHeight();
        setSize(w, h);
        jptitle.setBounds(10, 10, w - 20, 100);
        jpcarousel.setBounds(10, 120, w - 20, 250);
        try {
            HttpResponse<String> httpRes=Unirest.get(GlobalData.hostname+"/getusername").queryString("email",email).asString();
        if(httpRes.getStatus()==200){
            String res=httpRes.getBody();
                    jLabel1.setText("Welcome " + res);

        }
        } catch (UnirestException ex) {
//            Logger.getLogger(UserHome.class.getName()).log(Level.SEVERE, null, ex);
        ex.printStackTrace();
        }
        final PanelSlider42<JPanel> slider = new PanelSlider42<JPanel>(jpcarousel);
        final JPanel jPanel = slider.getBasePanel();
        for (int i = 0; i < images.length; i++) {
            try {
                JLabel lb = new JLabel();

                BufferedImage image = ImageIO.read(new File(images[i]));
                BufferedImage img = resize(image, jpcarousel.getWidth(), jpcarousel.getHeight());
                lb.setIcon(new ImageIcon(img));
                slider.addComponent(lb);
            } catch (Exception ex) {
                ex.printStackTrace();
// Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        slider.test();

        //   jPanel.setBounds(0, 0, 500, 500);
        //   getContentPane().add(jPanel);
        jScrollPane1.setBounds(10, 380, w - 20, 400);
        mainpanel.setPreferredSize(new Dimension(w - 20, 1500));

        new Thread(new Runnable() {

            public void run() {

                coursespanel p[] = new coursespanel[GlobalData.categories.length];
                int x = 10, y = 10;
                for (int i = 0; i < GlobalData.categories.length; i++) {
                    p[i] = new coursespanel();
                    p[i].setBackground(Color.white);

                    p[i].setBounds(x, y, w, 250);

                    p[i].lbcategory.setText("Courses under " + GlobalData.categories[i]);

                    p[i].jScrollPane2.setSize(new Dimension(w, 210));

                    try {
                        HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/fetchsomecategorycourse")
                                .queryString("category", GlobalData.categories[i]).asString();
                        if (httpresponse.getStatus() == 200) {
                            String resp = httpresponse.getBody().toString();
                            StringTokenizer st = new StringTokenizer(resp, "~");
                            int count = st.countTokens();
                            p[i].mainpanel2.setPreferredSize(new Dimension(count * 200, 210));

                            singlecoursepanel sp[] = new singlecoursepanel[count];
                            int new_x = 10;
                            int new_y = 10;

                            for (int j = 0; j < count; j++) {
                                sp[j] = new singlecoursepanel();
                                sp[j].setBounds(new_x, new_y, 180, 180);

                                String s = st.nextToken();
                                StringTokenizer st2 = new StringTokenizer(s, ";");
                                String cname = st2.nextToken();
                                String photo = st2.nextToken();
                                System.out.println(cname + " " + photo);
                                int amount = Integer.parseInt(st2.nextToken());
                                URL url = new URL(GlobalData.hostname + "/getresource/" + photo);
                                BufferedImage img = ImageIO.read(url);
                                BufferedImage newimg = resize(img, 100, 80);
                                sp[j].lbcoursename.setText(cname);
                                sp[j].lbimg.setIcon(new ImageIcon(newimg));
                                sp[j].lbprice.setText(amount + "");
                                sp[j].addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        if (e.getClickCount() == 2) {
                                            ViewCourseDetail v = new ViewCourseDetail(cname, email);
                                        }

                                    }

                                });

                                p[i].mainpanel2.add(sp[j]);
                                sp[j].repaint();
                                p[i].mainpanel2.repaint();
                                new_x += 200;
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    mainpanel.add(p[i]);
                    repaint();
                    mainpanel.repaint();
                    p[i].repaint();
                    p[i].lbcategory.repaint();

                    y = y + 270;

                }
            }
        }).start();
        this.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jptitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btchangepassword = new javax.swing.JButton();
        btlogout = new javax.swing.JButton();
        jpcarousel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jptitle.setBackground(new java.awt.Color(204, 255, 255));
        jptitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jptitle.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Welcome ");
        jptitle.add(jLabel1);
        jLabel1.setBounds(10, 0, 480, 40);

        btchangepassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btchangepassword.setText("Change Password");
        btchangepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btchangepasswordActionPerformed(evt);
            }
        });
        jptitle.add(btchangepassword);
        btchangepassword.setBounds(920, 10, 160, 30);

        btlogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btlogout.setText("Logout");
        btlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlogoutActionPerformed(evt);
            }
        });
        jptitle.add(btlogout);
        btlogout.setBounds(1100, 10, 160, 30);

        getContentPane().add(jptitle);
        jptitle.setBounds(0, 10, 1270, 80);

        jpcarousel.setBackground(new java.awt.Color(255, 204, 255));
        jpcarousel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jpcarousel.setLayout(null);
        getContentPane().add(jpcarousel);
        jpcarousel.setBounds(0, 100, 1270, 130);

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));
        mainpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 240, 1270, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btchangepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btchangepasswordActionPerformed
        UserChangePassword obj = new UserChangePassword(email);

    }//GEN-LAST:event_btchangepasswordActionPerformed

    private void btlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlogoutActionPerformed
        this.dispose();
        UserLogin obj = new UserLogin();
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
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome().setVisible(true);
            }
        });
    }

    BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btchangepassword;
    private javax.swing.JButton btlogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpcarousel;
    private javax.swing.JPanel jptitle;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
