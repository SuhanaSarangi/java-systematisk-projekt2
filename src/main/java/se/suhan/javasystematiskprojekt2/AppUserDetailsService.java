package se.suhan.javasystematiskprojekt2;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.suhan.javasystematiskprojekt2.model.ApplicationUser;
import se.suhan.javasystematiskprojekt2.repository.AppUserRepository;

import java.util.List;

/**
 * This class implements the UserDetailsService interface to provide logic for customized user authentication.
 * Uses information from the AppUserRepository through constructor and creates a UserDetails object
 * for Spring Security.
 *
 * @author Suhana
 * @date 2025-01-31
 */
@Service // a Spring-managed service bean
public class AppUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    // The constructor below injects the AppUserRepository dependency
    public AppUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    /**
     * This method loads user-details by username. This method tries to retrieve the
     * user from the database using the username. If the user is not found, exception is thrown.
     * If the user is found, a UserDetails object is created and returned.
     *
     * @param username The username of the user
     * @return A UserDetails object containing the user-data
     * @throws UsernameNotFoundException If the user with the given username is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ApplicationUser person = appUserRepository.findByUsername(username);
        if (person == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // authorities is a list of GrantedAuthority objects. This class SimpleGrantedAuthority
        // is used to represent a single authority granted to the user.
        List<GrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority("ROLE_" + person.getRole()) // Prefix "ROLE_" for Spring Security
        );

        return new org.springframework.security.core.userdetails.User(
                person.getUsername(),
                person.getPassword(),
                true, true, true, true,
                List.of(new SimpleGrantedAuthority("ROLE_" + person.getRole()))
        );
    }
}


