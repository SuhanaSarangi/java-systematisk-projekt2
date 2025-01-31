package se.suhan.javasystematiskprojekt2.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.suhan.javasystematiskprojekt2.model.ApplicationUser;
import se.suhan.javasystematiskprojekt2.repository.AppUserRepository;

/**
 * This class handles HTTP POST requests for user registration submissions.
 *
 * @author Suhana
 * @date 2025-01-31
 */
@Controller // means it is a Spring MVC controller
@RequestMapping("/registerSubmit") // maps all requests that start with "/registerSubmit"
public class RegistrationSubmitController {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor for RegistrationSubmitController.
     *
     * @param appUserRepository The repository used to manage application-users.
     * @param passwordEncoder The password encoder used to securely store passwords.
     */
    @Autowired // automatically injects the AppUserRepository and PasswordEncoder dependencies
    public RegistrationSubmitController(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * This method handles HTTP POST requests for user registration submissions.
     * Maps POST requests to the "/registerSubmit" URL and
     * returns the view "registerSuccess".
     *
     * @param username Username of the new user, String
     * @param password Password of the new user, String
     * @param role The role of the new user, String
     * @return view "registerSuccess", String
     */

    @PostMapping // map HTTP POST requests
    public String registrationSubmit(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("role") String role) {

        String encodedPassword = passwordEncoder.encode(password);
        ApplicationUser person = new ApplicationUser(username, encodedPassword, role);
        appUserRepository.save(person);
        return "registerSuccess"; // html.file
    }
}

