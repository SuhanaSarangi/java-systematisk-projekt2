package se.suhan.javasystematiskprojekt2.managermodule;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
/**
 * This class is responsible for initializing manager files data.
 * Has method to create instances of ManagerFile objects.
 *
 * @author Suhana
 * @date 2025-01-31
 */
@Component // makes the class a Spring-managed bean
public class ManagerDataInitializer {
    /**
     * This method creates a list of manager files,
     * by initializing three instances of ManagerFile and
     * adding them together.
     *
     * @return A list of ManagerFile objects.
     */
    public List<ManagerFile> createManagerFiles() {
        List<ManagerFile> managerFiles = new ArrayList<>();

        ManagerFile file1 = new ManagerFile();
        ManagerFile file2 = new ManagerFile();
        ManagerFile file3 = new ManagerFile();

        managerFiles.add(file1);
        managerFiles.add(file2);
        managerFiles.add(file3);

        return managerFiles;
    }
}
