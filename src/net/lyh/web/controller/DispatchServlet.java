package net.lyh.web.controller;

import net.lyh.web.domain.Config;
import net.lyh.web.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Config config = (Config) req.getServletContext().getAttribute("config");
        System.out.println(config.getTopic());
        System.out.println("DispatchServlet doGet");
//        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req,resp);
        User user=new User(1,"刘宇恒","www.baidu.com");
        req.setAttribute("user",user);
//        req.getRequestDispatcher("index.jsp").forward(req,resp);
        resp.sendRedirect("index.jsp");
    }

}
