/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import Project.ConnectionProvider;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.geom.Point2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Agrani
 */
public class AllReports extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    @SuppressWarnings("empty-statement")
    public AllReports() throws SQLException {
        initComponents();
        
        setBackground(new Color(0, 0, 0, 0));
         int totalSale = fetchTotalSaleFromDatabase();

    // Create a JLabel to display the total sale
    JLabel totalSaleLabel = new JLabel("Sale: Rs " + totalSale);
    totalSaleLabel.setFont(new Font("Arial", Font.BOLD, 20));
    totalSaleLabel.setHorizontalAlignment(JLabel.CENTER);

    // Create a JPanel for the dashboard square with a blue gradient background
    JPanel dashboardSquare = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            Point2D start = new Point2D.Float(0, 0);
            Point2D end = new Point2D.Float(0, getHeight());
            float[] dist = {0.0f, 1.0f};
            Color[] colors = {new Color(50, 50, 255), new Color(0, 0, 150)};
            LinearGradientPaint gp = new LinearGradientPaint(start, end, dist, colors);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
        
        
    };

    // Set layout and border for the dashboard square
    dashboardSquare.setLayout(new BorderLayout());
    dashboardSquare.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

    // Add the total sale label to the center of the square
    dashboardSquare.add(totalSaleLabel, BorderLayout.CENTER);

    // Add the dashboard square to the content pane
    getContentPane().add(dashboardSquare, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 220, 180, 130));

    // Make the JFrame visible
    setVisible(true);
        
   
    
    
   //code 
    
    
    
    
    
        
 //System.out.println("customers: Rs " + totalCustomers);
  //System.out.println("Sale: Rs " + totalSale);
        
        
        
        
       /*       try {
    Connection con = ConnectionProvider.getCon();
    Statement st = con.createStatement();
    ResultSet r = st.executeQuery("SELECT * FROM inventary");
    
    DefaultTableModel tblmodel = (DefaultTableModel)jTable3.getModel();
    
    while (r.next()) {
            String[] rowData = {
                Integer.toString(r.getInt(1)),   // Convert INT to String
                r.getString(2),
                r.getString(3),
                Integer.toString(r.getInt(4)),   // Convert INT to String
                r.getString(5),
                r.getString(6),
                Integer.toString(r.getInt(7)),   // Convert INT to String
                Integer.toString(r.getInt(8)),   // Convert INT to String
                Integer.toString(r.getInt(9)),   // Convert INT to String
                r.getString(10)
            };
            tblmodel.addRow(rowData);
        }    
    //jTable3.setModel(DbUtils.resultSetToTableModel(rs));

} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
 
}*/
              
           
              
              
              
 try {
        Connection con = ConnectionProvider.getCon();
        Statement st = con.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM inventary");

        DefaultTableModel tblmodel1 = (DefaultTableModel) jTable3.getModel();

        while (r.next()) {
            String[] rowData = {
                Integer.toString(r.getInt(1)),
                r.getString(2),
                r.getString(3),
                Integer.toString(r.getInt(4)),
                r.getString(5),
                r.getString(6),
                Integer.toString(r.getInt(7)),
                Integer.toString(r.getInt(8)),
                Integer.toString(r.getInt(9)),
                r.getString(10)
            };
            tblmodel1.addRow(rowData);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error fetching data for jTable3: " + e.getMessage());
    }

    // Populate jTable2 with data from fdevice table
try {
    Connection con = ConnectionProvider.getCon();
    Statement st = con.createStatement();
    ResultSet r = st.executeQuery("SELECT * FROM fdevice");

    DefaultTableModel tblmodel2 = (DefaultTableModel) jTable2.getModel();

    while (r.next()) {
        // Directly add elements to tblmodel2
        String[] rowData = {
            Integer.toString(r.getInt(1)),
            r.getString(2),
            r.getString(3),
            r.getString(4),
            //Integer.toString(r.getInt(4)),
            r.getString(5),
            r.getString(6),
            //Integer.toString(r.getInt(7)),
            r.getString(7),
            r.getDate(8).toString(), // Assuming column 8 is of type Date in the database
            r.getString(9),
            r.getString(10)
        };
        tblmodel2.addRow(rowData);
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error fetching data for jTable2: " + e.getMessage());
    
}





try {
    Connection con = ConnectionProvider.getCon();
    Statement st = con.createStatement();
    ResultSet r = st.executeQuery("SELECT * FROM customer");

    DefaultTableModel tblmodel1 = (DefaultTableModel) jTable1.getModel();

    while (r.next()) {
        // Directly add elements to tblmodel2
        String[] rowData = {
            r.getString(1),
            r.getString(2),
            r.getString(3),
            r.getString(4),
            r.getDate(5).toString(),
        };
        tblmodel1.addRow(rowData);
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error fetching data for jTable2: " + e.getMessage());
    
}







           
        
        
       // jScrollPane1;
     //jScrollPane2;
     
     //jScrollPane3.setBackground(new Color(0, 0, 0, 0));;
    //jTabbedPane1.setBackground(new Color(0, 0, 0, 0));;
    }

    
    private JPanel createDashboardSquare(JLabel label, Color startColor, Color endColor) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Point2D start = new Point2D.Float(0, 0);
                Point2D end = new Point2D.Float(0, getHeight());
                float[] dist = {0.0f, 1.0f};
                Color[] colors = {startColor, endColor};
                LinearGradientPaint gp = new LinearGradientPaint(start, end, dist, colors);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
    }
    
    private int fetchDataFromDatabase(String tableName, String aggregateFunction) {
        // JDBC connection parameters (replace with your database details)
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "Maya@123";

        // SQL query to get the specified data from the database
        String sqlQuery = "SELECT " + aggregateFunction + " FROM " + tableName;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt("total_data");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0; // Default value if there is an issue fetching data
    }
    
    
     private int fetchTotalSaleFromDatabase() {
        // JDBC connection parameters (replace with your database details)
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "Maya@123";

        // SQL query to get the total sale from the database
        String sqlQuery = "SELECT SUM(rate) AS total_sale FROM bill";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt("total_sale");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0; // Default value if there is an issue fetching data
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Contact No", "Email", "Address", "Reg_date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newclose.png"))); // NOI18N
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newprint.png"))); // NOI18N
        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(34, 34, 34)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Customer", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DeviceID", "DeviceType", "Brand", "Model", "IMEISerialNumber", "RepairHistory", "DeviceCondition", "DateReceived", "Notes", "ContactNo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newclose.png"))); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newprint.png"))); // NOI18N
        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(39, 39, 39)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Device", jPanel2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iid", "Brand", "Category", "Rate", "Description", "Activate", "Stock", "Remainingstock", "Soldstock", "Indate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTable3ComponentShown(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newprint.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newclose.png"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(40, 40, 40)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Inventory", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, 530));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        // Modify the text
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 220, 120));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable3ComponentShown
        // TODO add your handling code here:
        
        
        
        
        
        
        

    }//GEN-LAST:event_jTable3ComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          try{
            jTable3.print(JTable.PrintMode.NORMAL);
        }
        catch(Exception e)
        {}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
            jTable2.print(JTable.PrintMode.NORMAL);
        }
        catch(Exception e)
        {}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try{
            jTable1.print(JTable.PrintMode.NORMAL);
        }
        catch(Exception e)
        {}
    }//GEN-LAST:event_jButton6ActionPerformed

    
    //dashboard total sales
    
   
    
    
    
    
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
            java.util.logging.Logger.getLogger(AllReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AllReports().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AllReports.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
