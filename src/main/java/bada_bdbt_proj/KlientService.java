package bada_bdbt_proj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class KlientService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public KlientService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klient> getAllKlienci() {
        String sql = "SELECT * FROM SYSTEM.KLIENCI";
        return jdbcTemplate.query(sql, this::mapRowToKlient);
    }

    public Klient getKlientById(Long id) {
        String sql = "SELECT * FROM SYSTEM.KLIENCI WHERE NR_KLIENTA = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRowToKlient, id);
    }

    public int createKlient(Klient klient) {
        String sql = "INSERT INTO SYSTEM.KLIENCI (IMIE, NAZWISKO, PESEL, NR_TELEFONU, EMAIL, DATA_URODZENIA, CZY_SPEŁNIA_WYMOGI, PLEC, NR_SCHRONISKA, ID_ADRESU) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, klient.getImie(), klient.getNazwisko(), klient.getPesel(), klient.getNrTelefonu(), klient.getEmail(), klient.getDataUrodzenia(), klient.getCzySpelniaWymogi(), klient.getPlec(), klient.getNrSchroniska(), klient.getIdAdresu());
    }

    public int updateKlient(Long id, Klient klientDetails) {
        String sql = "UPDATE SYSTEM.KLIENCI SET IMIE = ?, NAZWISKO = ?, PESEL = ?, NR_TELEFONU = ?, EMAIL = ?, DATA_URODZENIA = ?, CZY_SPEŁNIA_WYMOGI = ?, PLEC = ?, NR_SCHRONISKA = ?, ID_ADRESU = ? WHERE NR_KLIENTA = ?";
        return jdbcTemplate.update(sql, klientDetails.getImie(), klientDetails.getNazwisko(), klientDetails.getPesel(), klientDetails.getNrTelefonu(), klientDetails.getEmail(), klientDetails.getDataUrodzenia(), klientDetails.getCzySpelniaWymogi(), klientDetails.getPlec(), klientDetails.getNrSchroniska(), klientDetails.getIdAdresu(), id);
    }

    public int deleteKlient(Long id) {
        String sql = "DELETE FROM SYSTEM.KLIENCI WHERE NR_KLIENTA = ?";
        return jdbcTemplate.update(sql, id);
    }

    private Klient mapRowToKlient(ResultSet rs, int rowNum) throws SQLException {
        Klient klient = new Klient();
        klient.setNrKlienta(rs.getLong("NR_KLIENTA"));
        klient.setImie(rs.getString("IMIE"));
        klient.setNazwisko(rs.getString("NAZWISKO"));
        klient.setPesel(rs.getString("PESEL"));
        klient.setNrTelefonu(rs.getString("NR_TELEFONU"));
        klient.setEmail(rs.getString("EMAIL"));
        klient.setDataUrodzenia(rs.getDate("DATA_URODZENIA"));
        klient.setCzySpelniaWymogi(rs.getString("CZY_SPEŁNIA_WYMOGI"));
        klient.setPlec(rs.getString("PLEC"));
        klient.setNrSchroniska(rs.getLong("NR_SCHRONISKA"));
        klient.setIdAdresu(rs.getLong("ID_ADRESU"));
        return klient;
    }
}
