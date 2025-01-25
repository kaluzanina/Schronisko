package bada_bdbt_proj;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "KLIENCI")
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NR_KLIENTA", nullable = false)
    private Long nrKlienta;

    @Column(name = "IMIE", nullable = false, length = 20)
    private String imie;

    @Column(name = "NAZWISKO", nullable = false, length = 30)
    private String nazwisko;

    @Column(name = "PESEL", nullable = false, length = 11)
    private String pesel;

    @Column(name = "NR_TELEFONU", nullable = false, length = 12)
    private String nrTelefonu;

    @Column(name = "EMAIL", nullable = false, length = 30)
    private String email;

    @Column(name = "DATA_URODZENIA", nullable = false)
    private java.util.Date dataUrodzenia;

    @Column(name = "CZY_SPEŁNIA_WYMOGI", nullable = false, length = 1)
    private String czySpelniaWymogi;

    @Column(name = "PLEC", length = 1)
    private String plec;



   // @ManyToOne
   // @JoinColumn(name = "NR_SCHRONISKA", nullable = false)
   @Column(name = "NR_SCHRONISKA", nullable = false)
    private Long nrSchroniska;

    //@ManyToOne
    //@JoinColumn(name = "ID_ADRESU", nullable = false)
    //private Adres adres;
    @Column(name = "ID_ADRESU", nullable = false)
    private Long idAdresu;

    // Getters and Setters
    public Long getNrKlienta() {
        return nrKlienta;
    }

    public void setNrKlienta(Long nrKlienta) {
        this.nrKlienta = nrKlienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getCzySpelniaWymogi() {
        return czySpelniaWymogi;
    }

    public void setCzySpelniaWymogi(String czySpelniaWymogi) {
        this.czySpelniaWymogi = czySpelniaWymogi;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Long getNrSchroniska() {
        return nrSchroniska;
    }

    public void setNrSchroniska(Long nrSchroniska) {
        this.nrSchroniska = nrSchroniska;
    }

    public Long getIdAdresu() {
        return idAdresu;
    }

    public void setIdAdresu(Long idAdresu) {
        this.idAdresu = idAdresu;
    }
}