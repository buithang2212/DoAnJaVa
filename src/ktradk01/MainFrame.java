/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktradk01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab06
 */
public class MainFrame extends javax.swing.JFrame implements TimKiem.CallbackSearch {

    /**
     * Creates new form MainFrame
     */
    ArrayList<Sach> lst;
    DefaultTableModel dtm = new DefaultTableModel();

    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            loadSach();
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
        }
    }

    private void loadSach() throws SQLException {
        DAOSach daos = new DAOSach();
        ArrayList<Sach> lst = daos.read();

        dtm.addColumn("Mã");
        dtm.addColumn("Tiêu đề");
        dtm.addColumn("Tác giả");
        dtm.addColumn("Nhà xuất bản");
        dtm.addColumn("Năm");
        dtm.addColumn("Giá");
        dtm.addColumn("Ngày nhập");

        for (int i = 0; i < lst.size(); i++) {
            Sach s = lst.get(i);
            Vector<Object> v = new Vector<>();
            v.add(s.getMaSach());
            v.add(s.getTenSach());
            v.add(s.getTacGia());
            v.add(s.getNhaXB());
            v.add(s.getNamXB());
            v.add(s.getGia());
            v.add(s.getNgayNhap());
            dtm.addRow(v);
        }
        tblDanhsach.setModel(dtm);
        if (lst.size() > 0) {
            tblDanhsach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int currentRow = tblDanhsach.getSelectedRow();
                    if (currentRow < 0) {
                        currentRow = 0;
                    }
                    txtMa.setText(lst.get(currentRow).getMaSach());
                    txtTen.setText(lst.get(currentRow).getTenSach());
                    txtTacGia.setText(lst.get(currentRow).getTacGia());
                    txtNhaXB.setText(lst.get(currentRow).getNhaXB());
                    txtNamXB.setText(String.valueOf(lst.get(currentRow).getNhaXB()));
                    txtGia.setText(String.valueOf(lst.get(currentRow).getGia()));
                    txtNgayNhap.setText(lst.get(currentRow).getNgayNhap());
                }
            });
            tblDanhsach.changeSelection(0, 0, false, false);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        txtNhaXB = new javax.swing.JTextField();
        txtNamXB = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        txtNgayNhap = new javax.swing.JFormattedTextField();
        txtReload = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JButton();
        txtXoa = new javax.swing.JButton();
        txtSua = new javax.swing.JButton();
        txtThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhsach = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý thư viện");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Đăng ký sách"));

        jLabel1.setText("Mã sách:");

        jLabel2.setText("Tác giả:");

        jLabel3.setText("Nhà XB:");

        jLabel4.setText("Năm XB:");

        jLabel5.setText("Ngày nhập:");

        jLabel6.setText("Tên sách: ");

        jLabel7.setText("Giá:");

        txtNgayNhap.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtTen))
                    .addComponent(txtNhaXB)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtGia))
                    .addComponent(txtNgayNhap))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNhaXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        txtReload.setText("Tải lại");
        txtReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReloadActionPerformed(evt);
            }
        });

        txtTimKiem.setText("Tìm kiếm");
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        txtXoa.setText("Xóa");

        txtSua.setText("Sửa");
        txtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSuaActionPerformed(evt);
            }
        });

        txtThem.setText("Thêm");
        txtThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThemActionPerformed(evt);
            }
        });

        tblDanhsach.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDanhsach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtReload)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtXoa)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReload)
                    .addComponent(txtTimKiem)
                    .addComponent(txtXoa)
                    .addComponent(txtSua)
                    .addComponent(txtThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThemActionPerformed
        try {
            String ma = txtMa.getText();
            String ten = txtTen.getText();
            String tacGia = txtTacGia.getText();
            String nha = txtNhaXB.getText();
            int nam = Integer.parseInt(txtNamXB.getText());
            float gia = Float.parseFloat(txtGia.getText());
            String ngay = txtNgayNhap.getText();

            Sach s = new Sach(ma, ten, tacGia, nha, nam, gia, ngay);
            DAOSach daos = new DAOSach();
            if (daos.insert(s)) {
                JOptionPane.showMessageDialog(rootPane, "Thêm dữ liệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm dữ liệu thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
            loadSach();
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtThemActionPerformed

    private void txtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSuaActionPerformed
        try {
            Sach s = new Sach(txtMa.getText(), txtTen.getText(), txtTacGia.getText(), txtNhaXB.getText(), Integer.parseInt(txtNamXB.getText()), Float.parseFloat(txtGia.getText()), txtNgayNhap.getText());
            DAOSach daos = new DAOSach();
            int row = daos.update(s);
            if (row > 0) {

                JOptionPane.showMessageDialog(rootPane, "Sửa thành công", "BKAP", JOptionPane.INFORMATION_MESSAGE);
                loadSach();

            } else {
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại", "BKAP", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi: "+ex.toString());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtSuaActionPerformed

    private void txtReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReloadActionPerformed
        try {
            loadSach();
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtReloadActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        TimKiem tk = new TimKiem(this, true, this);
        tk.setVisible(true);
    }//GEN-LAST:event_txtTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhsach;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNamXB;
    private javax.swing.JFormattedTextField txtNgayNhap;
    private javax.swing.JTextField txtNhaXB;
    private javax.swing.JButton txtReload;
    private javax.swing.JButton txtSua;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTen;
    private javax.swing.JButton txtThem;
    private javax.swing.JButton txtTimKiem;
    private javax.swing.JButton txtXoa;
    // End of variables declaration//GEN-END:variables

    @Override
    public void doAction(String tenSach) {
        try {
            loadSach();
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
        }
    }
}
