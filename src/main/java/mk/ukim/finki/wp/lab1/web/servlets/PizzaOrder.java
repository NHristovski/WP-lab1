package mk.ukim.finki.wp.lab1.web.servlets;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab1.model.Order;
import mk.ukim.finki.wp.lab1.model.Pizza;
import mk.ukim.finki.wp.lab1.service.PizzaService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/pizzaOrder.do")
@AllArgsConstructor
public class PizzaOrder extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext webContext = new WebContext(req, resp, req.getServletContext());

        String pizzaSize = req.getParameter("pizza_size");

        Order order = (Order) req.getSession().getAttribute("order");

        if (pizzaSize == null || pizzaSize.isBlank()){
            resp.sendRedirect("/selectPizza.do");
            return;
        }

        order.setPizzaSize(pizzaSize);
        req.getSession().setAttribute("order",order);

        webContext.setVariable("order", order);
        resp.setContentType("text/html; charset=UTF-8");

        this.springTemplateEngine.process("deliveryInfo.html", webContext, resp.getWriter());
    }
}
