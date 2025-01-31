package se.suhan.javasystematiskprojekt2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.suhan.javasystematiskprojekt2.model.ApplicationUser;

/**
 * AppUserRepository interface is a subclass of public interface JpaRepository.
 * Parameters mean: Repository is meant for managing ApplicationUser entities with Long as their primary key type.
 * Provides the mechanism for CRUD operations on ApplicationUser objects.
 *
 * @author Suhana
 * Created on: 2025-01-30
 */

public interface AppUserRepository extends JpaRepository<ApplicationUser, Long> {

    /**
     * Method finds an ApplicationUser by username.
     *
     * @param username of String type
     * @return a ApplicationUser with the specified username, or null if no such user exists
     */

    ApplicationUser findByUsername(String username);
}
