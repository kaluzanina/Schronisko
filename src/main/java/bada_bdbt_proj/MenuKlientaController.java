package bada_bdbt_proj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuKlientaController {

    @GetMapping("/menu_klienta")
    public String showMenuKlienta() {
        return "menu_klienta"; // Returns the `index.html` page
    }

    @RequestMapping("/adopcje")
    public String showAdopcjePage() {
        return "adopcje"; // Returns the `adopcje.html` page
    }

    @RequestMapping("/Profil")
    public String showProfilPage() {
        return "profil"; // Returns the `profil.html` page
    }
}
