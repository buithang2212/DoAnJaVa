/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktradk01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lab06
 */
public class BKConnection {

    private static final String CHUOI_KET_NOI = "jdbc:sqlserver://localhost\\NTH\\:1433;databaseName=QLTV";
    private static final String TAI_KHOAN = "sa";
    private static final String MAT_KHAU = "1234$";

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conn = DriverManager.getConnection(CHUOI_KET_NOI, TAI_KHOAN, MAT_KHAU);
            return conn;
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi: " + ex.toString());
            ex.printStackTrace();
            return null;
        }
    }
}
