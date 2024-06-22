package listener;

import com.files.entites.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HibernateListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Initialize Hibernate SessionFactory
        HibernateUtil.getSession();
        System.out.println("Hibernate SessionFactory initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Shutdown Hibernate SessionFactory
        HibernateUtil.shutdown();
        System.out.println("Hibernate SessionFactory shut down.");
    }
}
