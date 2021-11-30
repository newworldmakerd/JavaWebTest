package net.lyh.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "cookieServlet",urlPatterns = {"/get_cookie_test"})
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (int i=0;i<cookies.length;i++){
            cookies[i].getDomain();
            System.out.println(cookies[i].getName());
            System.out.println(cookies[i].getDomain());
        }
    }
}
