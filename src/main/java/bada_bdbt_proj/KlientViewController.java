package bada_bdbt_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view/klient")
public class KlientViewController {

    private  KlientService klientService;
    private final AuthenticationUtil authenticationUtil;

    @Autowired
    public KlientViewController(KlientService klientService,AuthenticationUtil authenticationUtil) {

        this.klientService = klientService;
        this.authenticationUtil = authenticationUtil;
    }

    @GetMapping("/klienci")
    public String showAllClients(Model model) {
        List<Klient> klienci = klientService.getAllKlienci(); // Replace with your service method to fetch all clients
        model.addAttribute("klienci", klienci);
        UserAttributes attributes = authenticationUtil.getUserAttributes();
        model.addAttribute("username", attributes.getUsername());
        model.addAttribute("role", attributes.getRole());
        model.addAttribute("id", attributes.getId());
        return "klienci"; // This corresponds to `src/main/resources/templates/klienci.html`
    }

    @GetMapping("/menu_klienta")
    public String menuKlienta() {
        return "menu_klienta"; // Odpowiada plikowi menu_klient.html w katalogu templates
    }

}
