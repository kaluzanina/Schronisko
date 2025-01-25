package bada_bdbt_proj;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("UNKNOWN");

        if (role.equals("ROLE_ADMIN")) {
            response.sendRedirect("/admin");
        } else if (role.equals("ROLE_KLIENT")) {
            response.sendRedirect("/menu_klienta");
        } else if (role.equals("ROLE_KIEROWNIK")) {
            response.sendRedirect("/kierownik");
        } else if (role.equals("ROLE_OPIEKUN")) {
            response.sendRedirect("/opiekun");
        } else {
            response.sendRedirect("/");
        }
    }
}
