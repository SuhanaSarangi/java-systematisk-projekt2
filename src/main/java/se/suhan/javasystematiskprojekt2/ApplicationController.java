package se.suhan.javasystematiskprojekt2;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ApplicationController handles various HTTP GET requests and maps them to specific view names.
 *
 * @author Suhana
 * @date 2025-02-31
 */
@Controller // indicates it being a Spring MVC controller
public class ApplicationController {

    /**
     * The method handles the root URL ("/") and returns the "index" view.
     *
     * @param model The Model object to pass attributes to the view.
     * @return view ("index")
     */
    @GetMapping("/") // maps HTTP GET requests to this url path
    public String getHomePage(Model model) {
        model.addAttribute("message", "You are logged in.");
        return "index"; // html-file
    }

    /**
     * These below methods handle URLs "/user/{name}", "/admin/{name}" and
     * "/manager/{name}" and return "user", "admin" and "manager" views.
     *
     * @param name {}means path variable, the username.
     * @param model a Model object
     * @return view "user", "admin" or "manager"
     */

    @GetMapping("/user/{name}")
    public String getUserPage(@PathVariable String name, Model model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        authentication.getName();
        return "user"; // The name of an HTML page located under src/resources/templates
    }

    @GetMapping("/admin/{name}")
    public String getAdminPage(@PathVariable String name, Model model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        authentication.getName();
            return "admin"; // The name of an HTML page located under src/resources/templates
    }

    @GetMapping("/manager/{name}")
    public String getManagerPage(@PathVariable String name, Model model) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        authentication.getName();
            return "manager"; // The name of an HTML page located under src/resources/templates
    }
}
