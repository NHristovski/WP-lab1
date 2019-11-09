package mk.ukim.finki.wp.lab1.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListenerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        System.out.println("[WP-Log] contextCreated");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("[WP-Log] contextDestroyed");
    }
}
