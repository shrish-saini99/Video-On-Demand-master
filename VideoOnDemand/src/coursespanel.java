
import java.awt.Dimension;
import java.awt.Toolkit;

public class coursespanel extends javax.swing.JPanel {
int w,h;
    public coursespanel() {
        initComponents();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        w=(int)d.getWidth();
        setSize(w,200);
        mainpanel2.setSize(w,80);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        mainpanel2 = new javax.swing.JPanel();
        lbcategory = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);

        mainpanel2.setBackground(new java.awt.Color(255, 255, 153));
        mainpanel2.setLayout(null);
        jScrollPane2.setViewportView(mainpanel2);

        add(jScrollPane2);
        jScrollPane2.setBounds(10, 30, 940, 80);

        lbcategory.setText("label");
        add(lbcategory);
        lbcategory.setBounds(10, 4, 940, 20);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lbcategory;
    public javax.swing.JPanel mainpanel2;
    // End of variables declaration//GEN-END:variables
}
