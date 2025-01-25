package bada_bdbt_proj;

import jakarta.persistence.*;

@Entity
@Table(name = "Adresy")
public class Adres {

    @Id
    @Column(name = "Nr_Adresu", nullable = false)
    private Long nrAdresu;

    @Column(name = "Kraj", nullable = false, length = 30)
    private String kraj;

    @Column(name = "Miasto", nullable = false, length = 30)
    private String miasto;

    @Column(name = "Ulica", nullable = false, length = 30)
    private String ulica;

    @Column(name = "Numer_budynku", nullable = false, length = 6)
    private String numerBudynku;

    @Column(name = "Numer_lokalu", length = 6)
    private String numerLokalu;

    @Column(name = "Kod_pocztowy", nullable = false, length = 6)
    private String kodPocztowy;

    // Getters and Setters
    public Long getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(Long nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerBudynku() {
        return numerBudynku;
    }

    public void setNumerBudynku(String numerBudynku) {
        this.numerBudynku = numerBudynku;
    }

    public String getNumerLokalu() {
        return numerLokalu;
    }

    public void setNumerLokalu(String numerLokalu) {
        this.numerLokalu = numerLokalu;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
}

