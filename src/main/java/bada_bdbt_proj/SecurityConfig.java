package bada_bdbt_proj;

import org.springframework.context.annotation.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    private final CustomAuthenticationSuccessHandler successHandler;

    public SecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        //.requestMatchers("/register", "/login").permitAll()
                        .requestMatchers("/","/index","/test","/register", "/login", "/css/**", "/images/**","/js/**").permitAll() // Allow static resources
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/kierownik/**").hasRole("KIEROWNIK")
                        .requestMatchers("/opiekun/**").hasRole("OPIEKUN")
                        .requestMatchers("/view/klient/**").hasRole("KLIENT")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                       // .defaultSuccessUrl("/",true)
                        .successHandler(successHandler) // Use the custom success handler
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable()); // Disables CSRF if necessary (only for development)

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}