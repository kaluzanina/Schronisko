package bada_bdbt_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresy")
public class AdresController {

    @Autowired
    private AdresService adresService;

    @GetMapping
    public List<Adres> getAllAdresy() {
        return adresService.getAllAdresy();
    }

    @GetMapping("/{nrAdresu}")
    public ResponseEntity<Adres> getAdresById(@PathVariable Long nrAdresu) {
        Adres adres = adresService.getAdresById(nrAdresu);
        if (adres != null) {
            return ResponseEntity.ok(adres);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/edit/{id}")
    public String editAdres(@PathVariable("id") Long id, Model model) {
        Adres adres = adresService.getAdresById(id);
        model.addAttribute("adres", adres);
        return "adresy-edit"; // Corresponds to `adresy_edit.html` in `templates`
    }

    @PostMapping
    public Adres createAdres(@RequestBody Adres adres) {
        return adresService.createAdres(adres);
    }

    @PutMapping("/{nrAdresu}")
    public ResponseEntity<Adres> updateAdres(@PathVariable Long nrAdresu, @RequestBody Adres adresDetails) {
        Adres updatedAdres = adresService.updateAdres(nrAdresu, adresDetails);
        if (updatedAdres != null) {
            return ResponseEntity.ok(updatedAdres);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{nrAdresu}")
    public ResponseEntity<Void> deleteAdres(@PathVariable Long nrAdresu) {
        adresService.deleteAdres(nrAdresu);
        return ResponseEntity.noContent().build();
    }
}

