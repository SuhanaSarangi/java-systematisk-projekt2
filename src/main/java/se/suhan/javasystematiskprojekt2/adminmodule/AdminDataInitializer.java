package se.suhan.javasystematiskprojekt2.adminmodule;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * This class is responsible for initializing admin documents.
 * Has method to create instances of AdminDocument objects.
 *
 * @author Suhana
 * @date 2025-01-31
 */
@Component
public class AdminDataInitializer {
    /**
     * This method creates a list of admin docs,
     * by initializing three instances of AdminDocument and
     * adding them together.
     *
     * @return A list of AdminDocument objects.
     */
    public List<AdminDocument> createAdminDocuments() {
        List<AdminDocument> adminDocuments = new ArrayList<>();

        AdminDocument doc1 = new AdminDocument();
        AdminDocument doc2 = new AdminDocument();
        AdminDocument doc3 = new AdminDocument();

        adminDocuments.add(doc1);
        adminDocuments.add(doc2);
        adminDocuments.add(doc3);

        return adminDocuments;
    }
}
