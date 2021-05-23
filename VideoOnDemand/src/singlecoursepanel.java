
import java.awt.Dimension;
import java.awt.Toolkit;

public class singlecoursepanel extends javax.swing.JPanel {
    int w;
    public singlecoursepanel() {
        initComponents();
      //  setSize(100,100);
//       Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
//               w=(int)d.getWidth();

      //  setSize(w,200);
        setSize(100,60);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbimg = new javax.swing.JLabel();
        lbcoursename = new javax.swing.JLabel();
        lbprice = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setLayout(null);

        lbimg.setText("jLabel1");
        lbimg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add(lbimg);
        lbimg.setBounds(20, 10, 100, 80);

        lbcoursename.setText("jLabel1");
        add(lbcoursename);
        lbcoursename.setBounds(20, 100, 100, 30);

        lbprice.setText("jLabel1");
        add(lbprice);
        lbprice.setBounds(20, 140, 130, 20);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lbcoursename;
    public javax.swing.JLabel lbimg;
    public javax.swing.JLabel lbprice;
    // End of variables declaration//GEN-END:variables
}
