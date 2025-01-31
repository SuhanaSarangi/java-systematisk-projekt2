package se.suhan.javasystematiskprojekt2.adminmodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
/**
 * This class handles HTTP GET requests for admin documents.
 *
 * @author Suhana
 * @date 2025-01-31
 */
@Controller// meaning it is a Spring MVC controller
public class AdminDocController {

    public final AdminDataInitializer adminDataInitializer;

    @Autowired // automatically injects the required bean
    // DI of AdminDataInitializer class through constructor to create and manage admin documents
    /**
     * Constructor for AdminDocController
     *
     * @param adminDataInitializer an AdminDataInitializer object used to create admin documents
     */
    public AdminDocController(AdminDataInitializer adminDataInitializer) {
        this.adminDataInitializer = adminDataInitializer;
    }

    /**
     * This method handles HTTP GET requests for the admin documents page.
     * Uses an AdminDataInitializer object to add to the model,
     * and returns the view "adminDoc".
     *
     * @param model A Model object to pass attributes to the view
     * @return view "adminDoc"
     */

    @GetMapping("/admin/adminDocuments")
    public String getAdminDocuments(Model model) {
        List<AdminDocument> adminDocuments = adminDataInitializer.createAdminDocuments();
        model.addAttribute("adminDocuments", adminDocuments);
        return "adminDoc";// returns the name of a html-file
    }
}
