package bada_bdbt_proj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String query = "SELECT USERNAME, PASSWORD, TYPE FROM USERS WHERE USERNAME = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{username}, (rs, rowNum) -> {
            String role = rs.getString("TYPE").toUpperCase();
            return User.withUsername(rs.getString("USERNAME"))
                    .password(rs.getString("PASSWORD"))
                    .roles(role)
                    .build();
        });
    }
}
