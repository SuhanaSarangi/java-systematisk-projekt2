package se.suhan.javasystematiskprojekt2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * WebSecurityConfiguration class configures the web security settings for the application.
 * Uses Spring Security to handle authentication and authorization.
 * Defines access rules for paths based on roles (MANAGER, ADMIN, USER)
 *
 * @author Suhana
 * @date 2025-01-30
 */

@Configuration // Meaning the class contains one or more @Beans
@EnableWebSecurity // Enables spring security's web security support
public class WebSecurityConfiguration {

     // Beans defined in a @Configuration class can be injected into other beans
     // using @Autowired, @Inject, or constructor injection.

    /**
     * The method creates security for http requests
     * @param http A HttpSecurity configuration object used to configure HTTP security settings
     * @return A configured SecurityFilterChain object
     * @throws Exception If an error occurs during configuration
     */

    @Bean // Creates and configures the SecurityFilterChain bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.formLogin(Customizer.withDefaults()); // enables form-based login using default settings
        // below are the different authorization rules for http requests(url paths) for different roles
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/manager/**").hasRole("MANAGER")
                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "MANAGER")
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN", "MANAGER")
                .anyRequest().authenticated()); // All other requests must be authenticated
        return http.build(); // builds and returns a SecurityFilterChain object
    }

    /**
     * Configures a PasswordEncoder bean.
     * @return A PasswordEncoder that uses BCrypt hashing.
     */

    @Bean // Encrypts passwords
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // GK: BCrypt is a strong and adaptive hashing function designed
    // to protect against brute-force attacks. It uses a random salt
    // and has a configurable workload factor, which makes it slower
    // to compute, adding an extra layer of security.
}
