public class videopanel extends javax.swing.JPanel {

    public videopanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbphoto = new javax.swing.JLabel();
        lbtitle = new javax.swing.JLabel();
        lbduration = new javax.swing.JLabel();
        lblectureno = new javax.swing.JLabel();
        btplay = new javax.swing.JButton();
        btdownload = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setLayout(null);

        lbphoto.setText("jLabel1");
        lbphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add(lbphoto);
        lbphoto.setBounds(10, 10, 70, 70);

        lbtitle.setText("jLabel2");
        add(lbtitle);
        lbtitle.setBounds(10, 110, 200, 30);

        lbduration.setText("jLabel1");
        add(lbduration);
        lbduration.setBounds(10, 80, 220, 30);

        lblectureno.setText("jLabel1");
        add(lblectureno);
        lblectureno.setBounds(80, 30, 100, 30);

        btplay.setText("Play");
        add(btplay);
        btplay.setBounds(10, 140, 53, 30);

        btdownload.setText("Download");
        add(btdownload);
        btdownload.setBounds(70, 140, 90, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btdownload;
    public javax.swing.JButton btplay;
    public javax.swing.JLabel lbduration;
    public javax.swing.JLabel lblectureno;
    public javax.swing.JLabel lbphoto;
    public javax.swing.JLabel lbtitle;
    // End of variables declaration//GEN-END:variables
}
