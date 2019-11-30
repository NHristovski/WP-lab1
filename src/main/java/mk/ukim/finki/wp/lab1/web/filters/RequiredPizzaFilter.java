package mk.ukim.finki.wp.lab1.web.filters;

import mk.ukim.finki.wp.lab1.model.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter
public class RequiredPizzaFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        Order order = (Order) httpRequest.getSession().getAttribute("order");

        String path = httpRequest.getServletPath();

        if (path.isBlank() || "/selectPizza.do".equals(path) || "/add/pizza".equals(path)){
            System.out.println("[WP-Log] Pizza does not need to be selected. Continue...");
            filterChain.doFilter(servletRequest, servletResponse);
        }else if (order == null || order.getPizzaType() == null || order.getPizzaType().isBlank()){

            System.out.println("[WP-Log] No pizza was selected. Redirecto to '/'");
            httpResp.sendRedirect("");
        }else{
            System.out.println("[WP-Log] Pizza was selected. Continue...");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
