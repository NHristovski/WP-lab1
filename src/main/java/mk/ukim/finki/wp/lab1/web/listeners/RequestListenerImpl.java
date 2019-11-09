package mk.ukim.finki.wp.lab1.web.listeners;

import org.apache.catalina.connector.RequestFacade;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListenerImpl extends RequestContextListener {
    @Override
    public void requestInitialized(ServletRequestEvent requestEvent) {

        System.out.println("[WP-Log] requestCreated: " + ((HttpServletRequest) requestEvent.getServletRequest()).getServletPath());

    }

    @Override
    public void requestDestroyed(ServletRequestEvent requestEvent) {
//        System.out.println("[WP-Log] requestDestroyed: " + ((HttpServletRequest) requestEvent.getServletRequest()).getServletPath());
    }
}
