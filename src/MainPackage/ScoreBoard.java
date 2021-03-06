/*
 * This is for viewing the Scores of different players.
 */
package MainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


class obj {

    String name;
    int time;

    public obj(String name, int time) {
        this.name = name;
        this.time = time;
    }

}

public class ScoreBoard extends javax.swing.JFrame {

    DefaultTableModel model;
    /**
     * Creates new form ScoreBoard
     */
    int i = 0, j = 1, ct = 1;
    public ScoreBoard() {

        initComponents();
        this.setTitle("MAD at Sudoku");
        
        Image icon = Toolkit.getDefaultToolkit().getImage("src/sudoku/icon image.jpg");
        this.setIconImage(icon);
         this.getContentPane().setBackground(Color.WHITE);
         setSize(700, 700);
         this.setLocation(550, 150);
        model = new DefaultTableModel();
        jTable3.setFont(new Font("Tahoma",Font.BOLD,16));
        jTable3.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,24));
        jTable3.setForeground(new Color(51,0,255));
        jTable3.setOpaque(false);
        //((DefaultTableCellRenderer)jTable3.getDefaultRenderer(Object.class)).setOpaque(false);
        String[] columnNames = {"Rank", "Name", "Time"};
        String[][] data = new String[50][3];
        try {
            File f = new File("src/sudoku/name.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String st;           
            while ((st = br.readLine()) != null) {
                data[i][0] = ct + "";
                ct++;
                data[i][j] = st;
                i++;
                if (j == 1) {
                    j = 2;
                    ct--;
                    i--;
                } else if (j == 2) {
                    j = 1;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(MenuScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        data=sort(data);
        model = new DefaultTableModel();
        model.setDataVector(data, columnNames);
        jTable3.setModel(model);

    }

    String[][] sort(String[][] arr) {
        int n=i;
        for (int l= 0; l< n - 1; l++) {
            for (int j = 0; j < n - l - 1; j++) {
                if (Integer.parseInt(arr[j][2]) > Integer.parseInt(arr[j + 1][2])) {
                    for (int k = 1; k < 3; k++) {
                        String temp = (arr[j][k]);
                        arr[j][k] = arr[j + 1][k];
                        arr[j + 1][k] = temp+"";
                    }

                }
            }
        }
        return arr;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("ScoreBoard");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 10, 228, 42);

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            jTable3.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            jTable3.getColumnModel().getColumn(2).setHeaderValue("Title 3");
        }

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(90, 90, 470, 340);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 255));
        jButton1.setText("Back to Menu");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 480, 200, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sudoku/sudoku image 1.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 250, 620, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MenuScreen ms1 = new MenuScreen();
        ms1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScoreBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
