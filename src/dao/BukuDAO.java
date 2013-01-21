package dao;
import model.Buku;

public interface BukuDAO {
    public void insertBuku(Buku buku);
    public void deleteBuku(String id);
    public void updateBuku(String oldid, Buku buku);
    public int cekBuku(Buku buku);
    /*
    ini hasil editan dari git hub web site
    */
}
