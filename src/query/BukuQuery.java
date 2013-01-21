package query;

import dao.BukuDAO;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import model.Buku;


public class BukuQuery implements BukuDAO {

    private Connection conn = null;
    private String sql;
    private int row;

    public BukuQuery(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertBuku(Buku buku) {
        sql = "INSERT INTO tb_buku (buku_id, buku_judul, buku_pengarang, buku_penerbit,buku_desc) " +
                "VALUES (NULL, ?, ?, ?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, buku.getJudul());
            st.setString(2, buku.getPengarang());
            st.setString(3, buku.getPenerbit());
            st.setString(4, buku.getDesc());
            st.executeUpdate();
        } catch (SQLException x) {
            Logger.getLogger(BukuDAO.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    @Override
    public void deleteBuku(String id) {
        sql = "DELETE FROM tb_buku WHERE buku_id = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException x) {
            Logger.getLogger(BukuDAO.class.getName()).log(Level.SEVERE, null, x);
        }
    }

    @Override
    public void updateBuku(String OldId, Buku buku) {
        sql = "UPDATE tb_buku SET buku_judul = ?, buku_pengarang = ?, buku_penerbit = ?, buku_desc = ? WHERE buku_id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, buku.getJudul());
            st.setString(2, buku.getPengarang());
            st.setString(3, buku.getPenerbit());
            st.setString(4, buku.getDesc());
            st.setString(5, OldId);
            st.executeUpdate();
        } catch (SQLException x) {
            Logger.getLogger(BukuDAO.class.getName()).log(Level.SEVERE, null, x);
        }
    }  

    @Override
    public int cekBuku(Buku buku) {
        sql = "SELECT * FROM tb_buku WHERE buku_judul = ? AND buku_pengarang = ? AND buku_penerbit = ? AND buku_desc = ? LIMIT 0,1";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, buku.getJudul());
            st.setString(2, buku.getPengarang());
            st.setString(3, buku.getPenerbit());
            st.setString(4, buku.getDesc());
            ResultSet rs = st.executeQuery();
            rs.last();
            row = rs.getRow();
            rs.beforeFirst();
        } catch (SQLException x) {
            Logger.getLogger(BukuDAO.class.getName()).log(Level.SEVERE, null, x);
        }
        return row;
    }
}
