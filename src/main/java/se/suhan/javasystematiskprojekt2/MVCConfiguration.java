package se.suhan.javasystematiskprojekt2;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class configures the MVC settings for the application.
 * Implements the WebMvcConfigurer interface to customize the default Spring MVC configuration.
 *
 * @author Suhana
 * @date 2025-1-31
 */

public class MVCConfiguration implements WebMvcConfigurer {

    /**
     * Method adds view controllers to the application, in this case
     * maps the root URL ("/") to the "index" view name.
     *
     * @param registry A ViewControllerRegistry object used to register view controllers.
     */

    @Override // overrides the method declared in the interface
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
}
