package mk.ukim.finki.wp.lab1.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab1.model.Order;
import mk.ukim.finki.wp.lab1.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/confirmInfo.do")
@AllArgsConstructor
public class ConfirmationInfo extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext webContext = new WebContext(req, resp, req.getServletContext());

        Order order = (Order) req.getSession().getAttribute("order");
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        String browser = req.getHeader("User-Agent");
        String ipAddress = req.getRemoteAddr();

        Order newOrder = orderService.placeOrder(order.getPizzaType(),order.getPizzaSize(), clientName, clientAddress);

        req.getSession().setAttribute("order",newOrder);

        webContext.setVariable("order", newOrder);
        webContext.setVariable("browser", browser);
        webContext.setVariable("ipAddress", ipAddress);

        resp.setContentType("text/html; charset=UTF-8");

        this.springTemplateEngine.process("confirmationInfo.html", webContext, resp.getWriter());
    }
}
