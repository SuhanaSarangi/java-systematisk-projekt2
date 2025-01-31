package se.suhan.javasystematiskprojekt2.adminmodule;

/**
 * AdminDocument class is within the admin module of the application.
 * Contains information about the documents managed by admin.
 * Attributes: title and description both of datatype String
 *
 * @author Suhana
 * @date 2025-01-30
 */
public class AdminDocument {

    // Attributes
    private String title;
    private String description;

    // Default no-argument constructor
    public AdminDocument() {
    }

    // Constructor
    public AdminDocument(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters ans setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
