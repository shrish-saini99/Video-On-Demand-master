
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.navigation.event.NavigationStarted;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class ViewCourseDetail extends javax.swing.JFrame {

    int w, h;
    String course;
    int amount;
    String desc, photo, sphoto;
    String title, video, vphoto, email;
    int duration, lectureno;
    String r;
    boolean myflag = false;
//    JFileChooser jfc;

    public ViewCourseDetail() {
        initComponents();
    }

    public ViewCourseDetail(String course, String email) {
        initComponents();
        this.email = email;
        this.course = course;
        setTitle("Course Detail");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        w = (int) d.getWidth();
        h = (int) d.getHeight();
        lbprice.setBounds(w - 100, 20, 70, 30);
        btpay.setBounds(w - 100, 70, 80, 30);
//jScrollPane1.setBounds(10,220,w-20,300);

        new Thread(new Runnable() {
            public void run() {
                lbwidephoto.setSize(w, 130);
                categorypanel.setSize(w, 150);
                jScrollPane1.setSize(w - 30, 400);

                try {
                    HttpResponse httpresponse1 = Unirest.get(GlobalData.hostname + "/viewonecourse")
                            .queryString("course", course).asString();
                    if (httpresponse1.getStatus() == 200) {
                        String res = httpresponse1.getBody().toString();
                        StringTokenizer st = new StringTokenizer(res, ";");
                        amount = Integer.parseInt(st.nextToken());
                        desc = st.nextToken();
                        photo = st.nextToken();
                        sphoto = st.nextToken();
                        lbdesc.setText(desc);
                        lbprice.setText("Rs." + amount + "/-");
                        lbcoursename.setText(course);
                        URL url = new URL(GlobalData.hostname + "/getresource/" + photo);
                        BufferedImage img = ImageIO.read(url);
                        BufferedImage newimg = resize(img, lbwidephoto.getWidth(), lbwidephoto.getHeight());
                        lbwidephoto.setIcon(new ImageIcon(newimg));
                        URL url2 = new URL(GlobalData.hostname + "/getresource/" + sphoto);
                        BufferedImage img2 = ImageIO.read(url2);
                        BufferedImage newimg2 = resize(img2, lbimg.getWidth(), lbimg.getHeight());
                        lbimg.setIcon(new ImageIcon(newimg2));

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();

        new Thread(new fetchVideos()).start();
        setSize(w, h);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    class fetchVideos implements Runnable {

        public void run() {
            try {
                HttpResponse httpresponse1 = Unirest.get(GlobalData.hostname + "/checksubscription")
                        .queryString("course", course)
                        .queryString("email", email).asString();
                if (httpresponse1.getStatus() == 200) {
                    r = httpresponse1.getBody().toString();
                    if (r.equals("payment done")) {
                        btpay.setEnabled(false);
                        myflag = true;
                    } else {
                        btpay.setEnabled(true);
                        myflag = false;
                    }
                }

                HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/getvideos")
                        .queryString("course", course).asString();
                if (httpresponse.getStatus() == 200) {
                    String res = httpresponse.getBody().toString();
                    StringTokenizer st = new StringTokenizer(res, "~");
                    int c = st.countTokens();
                    videopanel[] vp = new videopanel[c];
                    int x = 10, y = 10;
                    mainpanel.removeAll();
                    mainpanel.repaint();
                    for (int i = 0; i < c; i++) {
                        mainpanel.setPreferredSize(new Dimension(w - 20, 500));

                        vp[i] = new videopanel();
                        vp[i].setBounds(x, y, 180, 180);
                        if (myflag == false) {
                            vp[i].btdownload.setEnabled(false);
                            vp[i].btplay.setEnabled(false);
                        } else {
                            vp[i].btdownload.setEnabled(true);
                            vp[i].btplay.setEnabled(true);
                        }
                        StringTokenizer st2 = new StringTokenizer(st.nextToken(), ";");
                        title = st2.nextToken();
                        duration = Integer.parseInt(st2.nextToken());
                        lectureno = Integer.parseInt(st2.nextToken());
                        vphoto = st2.nextToken();
                        System.out.println("photo" + vphoto);
                        video = st2.nextToken();
                        System.out.println(title + " " + duration);
                        vp[i].lbduration.setText("Duration: " + duration);
                        vp[i].lblectureno.setText("Lecture No: " + lectureno);
                        vp[i].lbtitle.setText("Title : " + title);
                        URL url1 = new URL(GlobalData.hostname + "/getresource/" + vphoto);
                        BufferedImage img = ImageIO.read(url1);
                        BufferedImage newimg = resize(img, 70, 70);
                        vp[i].lbphoto.setIcon(new ImageIcon(newimg));
                        if (x <= (w - 280)) {
                            x = x + 220;
                        } else {
                            y = y + 220;
                            x = 10;
                        }
                        mainpanel.add(vp[i]);
                        vp[i].repaint();
                        repaint();
                        mainpanel.repaint();
                        vp[i].btdownload.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                new Thread(new Runnable() {
                                    public void run() {
                                        try {
                                            HttpResponse<InputStream> httpresponse = Unirest.get(GlobalData.hostname + "/getresource/" + video)
                                                    .asBinary();
                                            if (httpresponse.getStatus() == 200) {
                                                InputStream is = httpresponse.getBody();
                                                long filesize = Integer.parseInt(httpresponse.getHeaders().getFirst("Content-Length"));
                                                int index = video.lastIndexOf("/");
                                                String name = video.substring(index + 1);
                                                System.out.println("Video name" + name);
                                                FileOutputStream fos = new FileOutputStream("D:\\VMM\\" + name);
                                                byte b[] = new byte[100];
                                                int count = 0;
                                                int r, per;
                                                VideoProgressBar obj = new VideoProgressBar();
                                                obj.jProgressBar1.setStringPainted(true);
                                                while (true) {
                                                    r = is.read(b, 0, b.length);
                                                        fos.write(b, 0, r);
                                                    count = count + r;
                                                    per = (int) ((count * 100.0) / filesize);

                                                    obj.jProgressBar1.setValue(per);
                                                    obj.jProgressBar1.setString(per + " % complete");

                                                    if (count == filesize) {
                                                        obj.dispose();
                                                        break;

                                                    }
                                                }
                                                fos.close();
                                                int ans = JOptionPane.showConfirmDialog(ViewCourseDetail.this, "Do you want to open file ?", "Confirmation !", JOptionPane.YES_NO_OPTION);
                                                if (ans == JOptionPane.YES_OPTION) {
                                                    Desktop d = Desktop.getDesktop();
                                                    d.open(new File("D:\\VMM\\" + name));
                                                }

                                            }
                                        } catch (Exception ex) {
                                            ex.printStackTrace();
                                        }

                                    }
                                }).start();

                            }

                        });
                        vp[i].btplay.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                System.out.println("Video path"+video);
                        JavaFXMediaPlayerFrame obj=new JavaFXMediaPlayerFrame(video);


                            }
                            
                        
                        
                        });
                        

                    }

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbwidephoto = new javax.swing.JLabel();
        categorypanel = new javax.swing.JPanel();
        lbimg = new javax.swing.JLabel();
        lbcoursename = new javax.swing.JLabel();
        lbdesc = new javax.swing.JLabel();
        lbprice = new javax.swing.JLabel();
        btpay = new javax.swing.JButton();
        btplayvideo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbwidephoto.setText("jLabel1");
        lbwidephoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lbwidephoto);
        lbwidephoto.setBounds(0, 0, 800, 130);

        categorypanel.setBackground(new java.awt.Color(255, 255, 255));
        categorypanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        categorypanel.setLayout(null);

        lbimg.setText("jLabel1");
        lbimg.setToolTipText("");
        lbimg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        categorypanel.add(lbimg);
        lbimg.setBounds(20, 10, 70, 50);

        lbcoursename.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbcoursename.setText("name");
        categorypanel.add(lbcoursename);
        lbcoursename.setBounds(100, 20, 170, 20);

        lbdesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbdesc.setText("jLabel1");
        categorypanel.add(lbdesc);
        lbdesc.setBounds(20, 50, 640, 60);

        lbprice.setText("jLabel1");
        categorypanel.add(lbprice);
        lbprice.setBounds(700, 4, 100, 30);

        btpay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btpay.setText("Pay");
        btpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpayActionPerformed(evt);
            }
        });
        categorypanel.add(btpay);
        btpay.setBounds(700, 60, 70, 30);

        btplayvideo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btplayvideo.setText("Play sample video");
        btplayvideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btplayvideoActionPerformed(evt);
            }
        });
        categorypanel.add(btplayvideo);
        btplayvideo.setBounds(280, 90, 150, 30);

        getContentPane().add(categorypanel);
        categorypanel.setBounds(0, 130, 800, 140);

        mainpanel.setBackground(new java.awt.Color(204, 255, 255));
        mainpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 280, 800, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpayActionPerformed
       
                EngineOptions options
                = EngineOptions
                        .newBuilder(HARDWARE_ACCELERATED)
                        //.licenseKey("1BNDHFSC1FS4XQB4SLO3FSPUAU35XTR29HLKP4V9U21WUU9I12GOLT3HJ2OJ3DDJIAQLAQ") //me
                        .licenseKey("1BNDHFSC1FS605ER6YDGHCEUBTA0K4E2CN79MLMHKKL09Y10SSF2YGC37B48SYH0H5W9BE")  //harpreet j
                        .build();
        Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            // Creating Swing component for rendering web content
            // loaded in the given Browser instance.
            BrowserView view = BrowserView.newInstance(browser);

            // Creating and displaying Swing app frame.
            JFrame frame = new JFrame("Payment Demo");
            // Close Engine and onClose app window
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("engine closed");
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//            int amount = 12345;

            browser.navigation().on(NavigationStarted.class, event -> {
                String url = event.url();
                System.out.println("url : " + url);
                if (url.contains("BookingSuccess.html")) {
                    String ss = url.substring(url.indexOf("?") + 1);
                    String id = ss.substring(ss.indexOf("=") + 1);
                   
                 // new req to add entry to db  
                 paydemo1 obj = new paydemo1(id, course,email);
                      frame.dispose();
                       
                
                  
                }
            });
            System.out.println(amount);
            browser.navigation().loadUrl("http://amrinder.vmm.education/paymentdemo.html?amount="+amount+"&name="+course+"&desc=VideoOnDemand&photo=http://amrinder.vmm.education/java1.jpg");
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(1000, 700);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }); 
                
                
             

            
       
    }//GEN-LAST:event_btpayActionPerformed

    private void btplayvideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btplayvideoActionPerformed
        
                try {
                    HttpResponse httpresponse=Unirest.get(GlobalData.hostname+"/getsamplevideo")
                            .queryString("course",course)
                            .asString();
                    if(httpresponse.getStatus()==200){
                        System.out.println("course sample video");
                        String svideo=httpresponse.getBody().toString();
                        System.out.println(svideo);
                     //   String name=svideo.substring((svideo.lastIndexOf("/")+1));
                        JavaFXMediaPlayerFrame obj=new JavaFXMediaPlayerFrame(svideo);
                    }
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
              
      


    }//GEN-LAST:event_btplayvideoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewCourseDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCourseDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCourseDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCourseDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCourseDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btpay;
    private javax.swing.JButton btplayvideo;
    private javax.swing.JPanel categorypanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbcoursename;
    private javax.swing.JLabel lbdesc;
    private javax.swing.JLabel lbimg;
    private javax.swing.JLabel lbprice;
    private javax.swing.JLabel lbwidephoto;
    private javax.swing.JPanel mainpanel;
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
