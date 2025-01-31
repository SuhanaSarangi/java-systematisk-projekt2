package se.suhan.javasystematiskprojekt2;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.suhan.javasystematiskprojekt2.model.ApplicationUser;
import se.suhan.javasystematiskprojekt2.repository.AppUserRepository;

/**
 * This class initializes application user data at startup, one record for each role.
 *
 * @author Suhana
 * @date 2025-01-31
 */
@Component // makes the class a Spring-managed bean
public class AppUserDataInitializer {

    // declaration of instances of AppUserRepository and PasswordEncoder classes for DI through constructor
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor for AppUserDataInitializer.
     *
     * @param appUserRepository The repository created for application-users.
     * @param passwordEncoder The password encoder used to securely store passwords.
     */
    public AppUserDataInitializer(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {

        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * The method generates and saves three user data (one for each role)
     * after the application has started (after checking if a user with the
     * username exists already). Fills the constructor with arguments.
     */

    @PostConstruct // means it will be executed after the bean has been initialized
    public void init() {

        if (appUserRepository.findByUsername("Suhana") == null) {
            ApplicationUser person1 = new ApplicationUser();
            person1.setUsername("Suhana");
            person1.setPassword(passwordEncoder.encode("1111"));
            person1.setRole("USER");
            appUserRepository.save(person1);
        }
        if (appUserRepository.findByUsername("Ranjan") == null) {
            ApplicationUser person2 = new ApplicationUser();
            person2.setUsername("Ranjan");
            person2.setPassword(passwordEncoder.encode("2222"));
            person2.setRole("ADMIN");
            appUserRepository.save(person2);
        }
        if (appUserRepository.findByUsername("Stheyasi") == null) {
            ApplicationUser person3 = new ApplicationUser();
            person3.setUsername("Stheyasi");
            person3.setPassword(passwordEncoder.encode("0000"));
            person3.setRole("MANAGER");
            appUserRepository.save(person3);
        }
    }
}

