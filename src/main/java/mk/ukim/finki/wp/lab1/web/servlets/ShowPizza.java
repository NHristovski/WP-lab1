package mk.ukim.finki.wp.lab1.web.servlets;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab1.model.Pizza;
import mk.ukim.finki.wp.lab1.service.PizzaServiceOld;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "")
@AllArgsConstructor
public class ShowPizza extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final PizzaServiceOld pizzaServiceOld;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        List<Pizza> pizzas = pizzaServiceOld.listPizzas();

        webContext.setVariable("pizzas", pizzas);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("listPizzas.html", webContext, resp.getWriter());
    }
}
