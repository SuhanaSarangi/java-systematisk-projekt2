package se.suhan.javasystematiskprojekt2.model;

import jakarta.persistence.*;

/**
 * ApplicationUser class provides a template/skeleton of the table we need in the database.
 * It represents a user entity in the application.
 * Attributes: id, username, password, and role
 *
 * @author Suhana
 * @date 2025-01-30
 */

@Entity //This class is an entity and is mapped to a database table
@Table(name = "APPLICATION_USER") //Table name
public class ApplicationUser {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier, generated automatically

    @Column(nullable = false, unique = true) // Column properties: can't be null, unique value across rows
    private String username;

    @Column(nullable = false)
    private String password;

    private String role; // Role options in this application: user/admin/manager

    public ApplicationUser() { // Default constructor required by JPA
    }

    /**
     * Parameterized constructor for the ApplicationUser class
     * @param username The username of the user, datatype String
     * @param password The password of the user, datatype string
     * @param role The role of the user, datatype String
     */
    public ApplicationUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and setters for the fields
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
