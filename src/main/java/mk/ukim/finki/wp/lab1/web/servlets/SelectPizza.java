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
import java.util.Optional;

@WebServlet(urlPatterns = "/selectPizza.do")
@AllArgsConstructor
public class SelectPizza extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final PizzaService pizzaService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        List<Pizza> pizzas = pizzaService.listPizzas();

        String pizzaName = req.getParameter("pizza");

        Optional<Pizza> pizzaOptional = pizzaService.getPizzaByName(pizzaName);

        Pizza pizza;

        if (pizzaOptional.isEmpty()){

            Order order = (Order) req.getSession().getAttribute("order");
            if (order == null || order.getPizzaType() == null || order.getPizzaType().isBlank()){
                System.out.println("No pizza selected returning to '/'");
                resp.sendRedirect("");
                return;
            }else{
                pizza = pizzaService.getPizzaByName(order.getPizzaType()).get();
                pizzaName = pizza.getName();
            }
        }else{
            pizza = pizzaOptional.get();
        }

        createOrder(req, pizzaName);

        webContext.setVariable("pizza", pizza);
        resp.setContentType("text/html; charset=UTF-8");

        this.springTemplateEngine.process("selectPizzaSize.html", webContext, resp.getWriter());
    }

    private void createOrder(HttpServletRequest req, String pizzaName) {
        Order order = new Order();
        order.setPizzaType(pizzaName);

        req.getSession().setAttribute("order",order);
    }

}
