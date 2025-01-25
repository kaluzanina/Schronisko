package bada_bdbt_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserForm userForm, RedirectAttributes redirectAttributes) {
        String sql = "INSERT INTO USERS (USERNAME, PASSWORD, TYPE) VALUES (?, ?, ?)";
        int rowsAffected = 0;
        try {
            rowsAffected = jdbcTemplate.update(sql,
                    userForm.getUsername(),
                    new BCryptPasswordEncoder().encode(userForm.getPassword()),
                    "KLIENT"
            );

            if (rowsAffected > 0) {
                // Success
                redirectAttributes.addFlashAttribute("message", "Rejestracja zakończona sukcesem. Zaloguj się.");
                return "redirect:/login";
            } else {
                // Failure (unexpected case)
                redirectAttributes.addFlashAttribute("error", "Rejestracja nie powiodła się. Spróbuj ponownie.");
                return "redirect:/register";
            }
        } catch (Exception e)

        {
        /// Handle specific ORA-00001 error (unique constraint violation)
            if (e.getMessage() != null && e.getMessage().contains("ORA-00001")) {
                redirectAttributes.addFlashAttribute("error", "Nazwa użytkownika już istnieje. Wybierz inną nazwę użytkownika lub zaloguj się.");
            } else {
                // Log other errors and show a generic error message
                System.err.println("Error during registration: " + e.getMessage());
                redirectAttributes.addFlashAttribute("error", "Wystąpił błąd podczas rejestracji. Spróbuj ponownie.");
            }
        }
        return "redirect:/register";
    }
}