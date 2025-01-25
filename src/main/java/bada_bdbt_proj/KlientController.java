package bada_bdbt_proj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/klienci")
public class KlientController {

    @Autowired
    private KlientService klientService;

    @GetMapping
    public List<Klient> getAllKlienci() {
        return klientService.getAllKlienci();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Klient> getKlientById(@PathVariable Long id) {
        Klient klient = klientService.getKlientById(id);
        if (klient != null) {
            return ResponseEntity.ok(klient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createKlient(@RequestBody Klient klient) {
        int rowsAffected = klientService.createKlient(klient);
        if (rowsAffected > 0) {
            return ResponseEntity.ok("Klient created successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to create klient.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateKlient(@PathVariable Long id, @RequestBody Klient klientDetails) {
        int rowsAffected = klientService.updateKlient(id, klientDetails);
        if (rowsAffected > 0) {
            return ResponseEntity.ok("Klient updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKlient(@PathVariable Long id) {
        int rowsAffected = klientService.deleteKlient(id);
        if (rowsAffected > 0) {
            return ResponseEntity.ok("Klient deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
