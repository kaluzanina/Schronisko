package bada_bdbt_proj;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.GrantedAuthority;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Ensure login.html exists in src/main/resources/templates
    }

    @GetMapping("/")
    public String homePage(Model model) {
        // Get logged-in user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        String username;
        String role;

        if (principal instanceof org.springframework.security.core.userdetails.User) {
            org.springframework.security.core.userdetails.User userDetails =
                    (org.springframework.security.core.userdetails.User) principal;
            username = userDetails.getUsername();
            role = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .findFirst()
                    .orElse("-");
        } else if (principal instanceof String) {
            username = (String) principal;
            role = "-"; // Or fetch the role from your database if needed
        } else {
            username = "Anonymous";
            role = "-";
        }

        model.addAttribute("username", username);
        model.addAttribute("role", role);

        return "index";
    }
}

