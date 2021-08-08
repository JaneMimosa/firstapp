package com.geekbrains.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geekbrains.context.configuration.ApplicationConfiguration;
import com.geekbrains.context.domain.Product;
import com.geekbrains.context.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "FirstServlet", urlPatterns = "/first_servlet")
public class FirstServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("LOG: GET");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        ProductService productService = context.getBean("productServiceImpl", ProductService.class);
        resp.getWriter().printf("<html><body><h1>PRODUCTS</h1></body></html>");
        for (Product product : productService.getProducts()) {
            resp.getWriter().printf("<html><body><h2>ID: %s | Title: %s, Price: %s</h2></body></html>", product.getId(), product.getTitle(), product.getCost());
        }
        context.close();
            }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.debug("Log: POST");
        resp.getWriter().printf("<html><body><h1>New POST request</h1></body></html>");
    }

    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}
