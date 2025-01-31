package se.suhan.javasystematiskprojekt2.managermodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
/**
 * This class handles HTTP GET requests for manager files.
 *
 * @author Suhana
 * @date 2025-01-31
 */
@Controller
public class ManagerFileController {

    public final ManagerDataInitializer managerDataInitializer;

    @Autowired // automatically injects the required bean
    // DI of AdminDataInitializer class through constructor to create and manage admin documents
    /**
     * Constructor for ManagerFileController
     *
     * @param managerDataInitializer a ManagerDataInitializer object used to create manager files
     */
    public ManagerFileController(ManagerDataInitializer managerDataInitializer) {
        this.managerDataInitializer = managerDataInitializer;
    }

    /**
     * This method handles HTTP GET requests for the manager files page.
     * Uses a ManagerDataInitializer object to add to the model,
     * and returns the view "managerFile".
     *
     * @param model A Model object to pass attributes to the view
     * @return view "managerFile", String
     */

    @GetMapping("/manager/managerFiles")
    public String getManagerInfos(Model model) {
        List<ManagerFile> managerFiles = managerDataInitializer.createManagerFiles();
        model.addAttribute("managerFiles", managerFiles);
        return "managerFile"; // a html-file
    }
}