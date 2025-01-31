package se.suhan.javasystematiskprojekt2.managermodule;

/**
 * ManagerFile class is within the manager module of the application.
 * Contains information about the files managed by manager.
 * Attributes: title and infoText both of datatype String
 *
 * @author Suhana
 * @date 2025-01-30
 */
public class ManagerFile {

    // Attributes
    private String title;
    private String infoText;

    // Empty constructor
    public ManagerFile() {
    }

    // Constructor
    public ManagerFile(String title, String infoText) {
        this.title = title;
        this.infoText = infoText;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getInfoText() {
        return infoText;
    }
    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }
}
