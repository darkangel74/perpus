package util;

import java.sql.*;

public class DBKoneksi {

    public Connection conn = null;
    public static DBKoneksi dbConn = null;
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_perpus";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    public DBKoneksi() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            } catch (ClassNotFoundException x) {
                System.out.println("MySql Gagal Di Panggil.");
            } catch (Exception x) {
            }
        }
    }

    public static DBKoneksi getInstance() {
        DBKoneksi conn = null;
        if (dbConn == null) {
            dbConn = new DBKoneksi();
        }
        conn = dbConn;
        return conn;
    }

    public Connection getCon() throws SQLException {
        return this.conn;
    }
}