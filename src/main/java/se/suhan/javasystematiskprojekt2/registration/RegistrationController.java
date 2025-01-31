package se.suhan.javasystematiskprojekt2.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * This class handles HTTP GET requests for the registration page.
 *
 * @author Suhana
 * @date 2025-01-31
 */
@Controller // meaning it is a Spring MVC controller
public class RegistrationController {
    /**
     * This method maps the "/register" URL to the "register" view.
     *
     * @param model A Model object
     * @return view "register", String
     */
    @GetMapping("/register")
    public String getRegisterPage(Model model) {

        return "register"; // html-file
    }
}
