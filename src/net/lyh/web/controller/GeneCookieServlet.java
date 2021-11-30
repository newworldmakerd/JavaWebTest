package net.lyh.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gene_cookie_test")
public class GeneCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("token","nihao");
        //20秒过期时间，过期后不会自动携带过去
        cookie.setMaxAge(20);
        resp.addCookie(cookie);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
