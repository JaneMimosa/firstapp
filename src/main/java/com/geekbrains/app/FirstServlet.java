package com.geekbrains.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geekbrains.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

@WebServlet(name = "FirstServlet", urlPatterns = "/first_servlet")
public class FirstServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);
    Random rand = new Random();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("LOG: GET");
        resp.getWriter().printf("<html><body><h1>PRODUCTS</h1></body></html>");
        int cost;
        for (int i = 0; i < 10; i++) {
            cost = rand.nextInt(10000);
            //resp.getWriter().println(new Product(i,"Product", cost).show());
            resp.getWriter().printf("<html><body><h2>%s</h2></body></html>", (new Product(i,"Product", cost)).show());
        }
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
