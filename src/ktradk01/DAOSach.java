/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktradk01;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lab06
 */
public class DAOSach {
    ArrayList<Sach> lst = new ArrayList<>();
    public ArrayList<Sach> read() throws SQLException {
        String sql = "SELECT * FROM tblSach";
        Statement stt = BKConnection.getConnection().createStatement();
        ResultSet rs = stt.executeQuery(sql);
        
        while (rs.next()) {
            String ma = rs.getString("MaSach");
            String ten = rs.getString("TenSach");
            String tacgia = rs.getString("TacGia");
            String nha = rs.getString("NhaXB");
            int namXB = rs.getInt("NamXB");
            float gia = rs.getFloat("Gia");
            String ngay = rs.getString("NgayNhap");

            Sach s = new Sach(ma, ten, tacgia, nha, namXB, gia, ngay);
            lst.add(s);
        }
        return lst;
    }

    public boolean insert(Sach s) throws SQLException {
        String sql = "INSERT INTO tblSach VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pStt = BKConnection.getConnection().prepareCall(sql);
        pStt.setString(1, s.getMaSach());
        pStt.setString(2, s.getTenSach());
        pStt.setString(3, s.getTacGia());
        pStt.setString(4, s.getNhaXB());
        pStt.setInt(5, s.getNamXB());
        pStt.setFloat(6, s.getGia());
        pStt.setString(7, s.getNgayNhap());

        int row = pStt.executeUpdate();
        if (row > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int update(Sach s) {
        try {
            String sql = "UPDATE tblSach SET TenSach = ?, TacGia = ?, NhaXB= ?, NamXB = ?, Gia = ?, NgayNhap = ? WHERE MaSach = ?";
            PreparedStatement pStt = BKConnection.getConnection().prepareStatement(sql);
            pStt.setString(1, s.getTenSach());
            pStt.setString(2, s.getTacGia());
            pStt.setString(3, s.getNhaXB());
            pStt.setInt(4, s.getNamXB());
            pStt.setFloat(5, s.getGia());
            pStt.setString(6, s.getNgayNhap());
            pStt.setString(7, s.getMaSach());
            return pStt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
            return 0;
        }
    }

    public int delete(String id) {
        try {
            String sql = "DELETE tblSach WHERE MaSach = ?";
            PreparedStatement pStt = BKConnection.getConnection().prepareStatement(sql);
            pStt.setString(1, id);
            return pStt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
            return 0;
        }
    }
}
