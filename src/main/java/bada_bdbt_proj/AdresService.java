package bada_bdbt_proj;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdresService {

    @Autowired
    private AdresRepository adresRepository;

    public List<Adres> getAllAdresy() {
        return adresRepository.findAll();
    }

    public Adres getAdresById(Long nrAdresu) {
        return adresRepository.findById(nrAdresu).orElse(null);
    }

    public Adres createAdres(Adres adres) {
        return adresRepository.save(adres);
    }

    public Adres updateAdres(Long nrAdresu, Adres adresDetails) {
        Adres adres = getAdresById(nrAdresu);
        if (adres != null) {
            adres.setKraj(adresDetails.getKraj());
            adres.setMiasto(adresDetails.getMiasto());
            adres.setUlica(adresDetails.getUlica());
            adres.setNumerBudynku(adresDetails.getNumerBudynku());
            adres.setNumerLokalu(adresDetails.getNumerLokalu());
            adres.setKodPocztowy(adresDetails.getKodPocztowy());
            return adresRepository.save(adres);
        }
        return null;
    }

    public void deleteAdres(Long nrAdresu) {
        adresRepository.deleteById(nrAdresu);
    }
}

