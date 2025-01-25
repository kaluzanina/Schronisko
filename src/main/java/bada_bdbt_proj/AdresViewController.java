package bada_bdbt_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/view")
public class AdresViewController {

    private final AdresService adresService;

    @Autowired
    public AdresViewController(AdresService adresService) {
        this.adresService = adresService;
    }

    @GetMapping("/adres_by_id/{id}")
    public String showAdresById(@PathVariable("id") Long id, Model model) {
        Adres adres = adresService.getAdresById(id);
        model.addAttribute("adres", adres);
        return "adres_by_id"; // Maps to `adres_by_id.html`
    }


    // Display the edit form for the address
    @GetMapping("/adresy_edit/{id}")
    public String editAdresForm(@PathVariable("id") Long id, Model model) {
        Adres adres = adresService.getAdresById(id);
        model.addAttribute("adres", adres);
        return "adresy_edit"; // Maps to `adresy_edit.html`
    }

    /*// Handle the submission of the edited address
    @PostMapping("/adres_edit")
    public String updateAdres(@ModelAttribute("adres") Adres updatedAdres) {
        adresService.updateAdres(updatedAdres.getNrAdresu(),updatedAdres);
        return "redirect:/view/adres_by_id/" + updatedAdres.getNrAdresu(); // Redirect to the updated address view
    }*/
    @PostMapping("/adres_edit")
    public String updateAdres(@ModelAttribute("adres") Adres updatedAdres, RedirectAttributes redirectAttributes) {
        adresService.updateAdres(updatedAdres.getNrAdresu(),updatedAdres);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/view/adres_by_id/" + updatedAdres.getNrAdresu();
    }
}