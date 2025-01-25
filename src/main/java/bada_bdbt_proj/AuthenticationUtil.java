package bada_bdbt_proj;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUtil {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserAttributes getUserAttributes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        String username;
        String role;
        Long id = null;

        if (principal instanceof User) {
            User userDetails = (User) principal;
            username = userDetails.getUsername();
            role = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .findFirst()
                    .orElse("-");

            // Query the database to retrieve the ID
            try {
                String sql = "SELECT NVL(ID, 0) FROM USERS WHERE USERNAME = ?";
                id = jdbcTemplate.queryForObject(sql, new Object[]{username}, Long.class);
            } catch (Exception e) {
                System.err.println("Error retrieving user ID: " + e.getMessage());
            }

        } else if (principal instanceof String) {
            username = (String) principal;
            role = "-";
        } else {
            username = "Anonymous";
            role = "-";
        }

        return new UserAttributes(username, role, id);
    }
}
