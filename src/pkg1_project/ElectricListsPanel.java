/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author patte
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.*;
import javax.swing.*;
//import java.util.*;
//import java.sql.*;
import javax.swing.JOptionPane;
public class ElectricListsPanel extends javax.swing.JPanel {
    private File logs;
    public ElectricListsPanel() {
        initComponents();
        logs = new File("database.txt");
        try{
            logs.createNewFile();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        tb_load();
    }
    public void tb_load(){
        try{
            FileReader fr = new FileReader(logs);
            BufferedReader br = new BufferedReader(fr);
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            dt.setRowCount(0);
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            Object[] line = br.lines().toArray();
            for (Object line1 : line) {
                String[] row = line1.toString().split("/");
                model.addRow(row);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
            /*Statement s = DBModal.
            ResultSet rs = s.executeQuery("SELECT * fROM electronicmachine");
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                dt.addRow(v);
            }*/
    }
    public void tb_save(){
        try{
            FileWriter fw = new FileWriter(logs);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < jTable1.getRowCount(); i++){//row
                for(int j = 0; j < jTable1.getColumnCount(); j++){
                    bw.write(jTable1.getValueAt(i, j).toString()+"/");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        idnum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        elecname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usedtime = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        usedrate = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        updbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        etr = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(720, 540));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Electrical Machine", "ID Number", "Used Time ", "Used rate", "Electric rate", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel7.setText("ELECTRICAL MACHINE LISTS");

        idnum.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setText("Electronic name :");

        elecname.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setText("ID Number : ");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel3.setText("Used rate :");

        usedtime.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        usedtime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedtimeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel4.setText("Used time :");

        usedrate.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        usedrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedrateActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        addbtn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        addbtn.setText("Add new");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        delbtn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        delbtn.setText("Remove");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });

        updbtn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        updbtn.setText("Update");
        updbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updbtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel5.setText("Electric rate :");

        etr.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        etr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etrActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel6.setText("KwH");

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel8.setText("THB/UNIT");

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel9.setText("Hour");

        searchbar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbarActionPerformed(evt);
            }
        });
        searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbarKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel10.setText("Search Bar :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idnum))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(elecname, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usedtime)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usedrate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(delbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etr, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addComponent(searchbar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(elecname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(usedtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(usedrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(etr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updbtn)
                    .addComponent(delbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbtn)
                    .addComponent(jButton2))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usedtimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedtimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usedtimeActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // Save button
        String name = elecname.getText();
        String id = idnum.getText();
        String time = usedtime.getText();
        String rate = usedrate.getText();
        String elrate = etr.getText();
        //COST CALCULATE!!!
        String pay = "300";
        if(name.equals("")||id.equals("")||time.equals("")||rate.equals("")||elrate.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter All Data");
        }else{
            String []data = {name, id, time, rate, elrate, pay};
            DefaultTableModel dtm1 = (DefaultTableModel)jTable1.getModel();
            dtm1.addRow(data);
            JOptionPane.showMessageDialog(this, "Add new data sucessfully!");
        }
        elecname.setText("");
        idnum.setText("");
        usedtime.setText("");
        usedrate.setText("");
        etr.setText("");
        tb_save();
        tb_load();
    }//GEN-LAST:event_addbtnActionPerformed

    private void usedrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedrateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usedrateActionPerformed

    private void updbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updbtnActionPerformed
        // Update button
        String name = elecname.getText();
        String id = idnum.getText();
        String time = usedtime.getText();
        String rate = usedrate.getText();
        String elrate = etr.getText();
        int r = jTable1.getSelectedRow();
        DefaultTableModel dtm2 = (DefaultTableModel)jTable1.getModel();
        if(jTable1.getSelectedRowCount() == 1){
            dtm2.setValueAt(name, r, 0);
            dtm2.setValueAt(id, r, 1);
            dtm2.setValueAt(time, r, 2);
            dtm2.setValueAt(rate, r, 3);
            dtm2.setValueAt(elrate, r, 4);
            JOptionPane.showMessageDialog(null, "Data updated sucessfully!");
        }else{
            if(jTable1.getRowCount()==0){
                JOptionPane.showMessageDialog(this, "This table is empty.");
            }else{
                JOptionPane.showMessageDialog(this, "Please select single rows.");
            }
        }
        tb_save();
        tb_load();
    }//GEN-LAST:event_updbtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Clear button
        elecname.setText("");
        idnum.setText("");
        usedtime.setText("");
        usedrate.setText("");
        etr.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        // Remove button
        int r = jTable1.getSelectedRow();
        DefaultTableModel dtm3 = (DefaultTableModel)jTable1.getModel();
        if(jTable1.getSelectedRowCount()==1){
            dtm3.removeRow(r);
            JOptionPane.showMessageDialog(null, "Data removed!");
        }else{
            if(jTable1.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "This table is empty.");
            }else{
                JOptionPane.showMessageDialog(this, "Please select single rows.");
            }
        }
        elecname.setText("");
        idnum.setText("");
        usedtime.setText("");
        usedrate.setText("");
        etr.setText("");
        tb_save();
        tb_load();
    }//GEN-LAST:event_delbtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // Mouse Clicked
        int r = jTable1.getSelectedRow();
        String rname = jTable1.getValueAt(r, 0).toString();
        String rid = jTable1.getValueAt(r, 1).toString();
        String rtime = jTable1.getValueAt(r, 2).toString();
        String rrate = jTable1.getValueAt(r, 3).toString();
        String relrate = jTable1.getValueAt(r, 4).toString();
        elecname.setText(rname);
        idnum.setText(rid);
        usedtime.setText(rtime);
        usedrate.setText(rrate);
        etr.setText(relrate);
    }//GEN-LAST:event_jTable1MouseClicked

    private void etrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etrActionPerformed

    private void searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarActionPerformed

    private void searchbarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyReleased
        // searchbar
        String search = searchbar.getText();
        DefaultTableModel dtm4 = (DefaultTableModel)jTable1.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(dtm4);
        jTable1.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchbarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton delbtn;
    private javax.swing.JTextField elecname;
    private javax.swing.JTextField etr;
    private javax.swing.JTextField idnum;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchbar;
    private javax.swing.JButton updbtn;
    private javax.swing.JTextField usedrate;
    private javax.swing.JTextField usedtime;
    // End of variables declaration//GEN-END:variables
 
}