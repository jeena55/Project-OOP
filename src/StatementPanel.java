
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.CSS;

public class StatementPanel extends javax.swing.JPanel {

    public SerchDataBill sdb;
    private String billAddCurrent;
    private double total_bill;
    private double num;

    public StatementPanel() {
        initComponents();
        SerchStatement sr = new SerchStatement();
        sr.Serch_Statement();
        sr.checkMonth(sr.getMonth());
        sr.checkYear(sr.getYear());
        UpdateStatement us = new UpdateStatement(sr.getMonth(), sr.getYear(), sr.getPay(), sr.getUnit(), sr.getBill(), sr.getOutstand());
        billAddCurrent = sr.getBill();
        try {
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            Statement s = Connector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * fROM updatestatement66");
            while (rs.next()) {
                Vector v = new Vector();
                String value1 = rs.getString(1);
                String value2 = rs.getString(2);
                String value3 = rs.getString(3);
                String value4 = rs.getString(4);
                String value5 = rs.getString(5);
                num = 0.0;
//                String value6 = rs.getString(6);

                if (value1 == null) {
                    value1 = "";  // Set a default value for null
                }
                if (value2 == null) {
                    value2 = "";  // Set a default value for null
                }
                if (value3 == null) {
                    value3 = "";  // Set a default value for null
                }
                if (value4 == null) {
                    value4 = "";  // Set a default value for null
                }
                if (value5 == null) {
                    value5 = "";  // Set a default value for null
                }

                v.add(value1);
                v.add(value2);
                v.add(value3);
                v.add(value4);
                v.add(value5);
                dt.addRow(v);

                if (value4.equals("")) {
                    num = 0;
                } else if (!"".equals(value4)) {
                    num = Double.parseDouble(value4);
                }
                total_bill += num;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String getBillAddCurrent() {
        return billAddCurrent;
    }

    public double getTotal_bill() {
        return total_bill;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(720, 601));

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("STATEMENT");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setText("collect all bill data");

        jButton1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2566", "2565" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 458, Short.MAX_VALUE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        jTable1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Month", "Pay in date", "All Power Used", "Bill cost in a month", "Outstanding balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new StatementPanel();
        String selectedYear = (String) jComboBox2.getSelectedItem();
        if (selectedYear.equals("2565")) {
            try {
                DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
                dt.setRowCount(0);
                Statement s = Connector.mycon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * fROM updatestatement65");
                while (rs.next()) {
                    Vector v = new Vector();
                    String value1 = rs.getString(1);
                    String value2 = rs.getString(2);
                    String value3 = rs.getString(3);
                    String value4 = rs.getString(4);
                    String value5 = rs.getString(5);
//                String value6 = rs.getString(6);

                    if (value1 == null) {
                        value1 = "";  // Set a default value for null
                    }
                    if (value2 == null) {
                        value2 = "";  // Set a default value for null
                    }
                    if (value3 == null) {
                        value1 = "";  // Set a default value for null
                    }
                    if (value4 == null) {
                        value2 = "";  // Set a default value for null
                    }
                    if (value5 == null) {
                        value1 = "";  // Set a default value for null
                    }

                    v.add(value1);
                    v.add(value2);
                    v.add(value3);
                    v.add(value4);
                    v.add(value5);
                    dt.addRow(v);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (selectedYear.equals("2566")) {
            try {
                DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
                dt.setRowCount(0);
                Statement s = Connector.mycon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * fROM updatestatement66");
                while (rs.next()) {
                    Vector v = new Vector();
                    String value1 = rs.getString(1);
                    String value2 = rs.getString(2);
                    String value3 = rs.getString(3);
                    String value4 = rs.getString(4);
                    String value5 = rs.getString(5);
//                String value6 = rs.getString(6);

                    if (value1 == null) {
                        value1 = "";  // Set a default value for null
                    }
                    if (value2 == null) {
                        value2 = "";  // Set a default value for null
                    }
                    if (value3 == null) {
                        value1 = "";  // Set a default value for null
                    }
                    if (value4 == null) {
                        value2 = "";  // Set a default value for null
                    }
                    if (value5 == null) {
                        value1 = "";  // Set a default value for null
                    }

                    v.add(value1);
                    v.add(value2);
                    v.add(value3);
                    v.add(value4);
                    v.add(value5);
                    dt.addRow(v);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
