package mk.ukim.finki.wp.lab1.web.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class HttpSessionListenerImpl implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
//        System.out.println("[WP-Log] sessionCreated");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
//        System.out.println("[WP-Log] sessionDestroyed");
    }
}
