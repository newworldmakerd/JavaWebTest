package net.lyh.web.servlet;

import net.lyh.web.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        if(name.equals("lyh")&&pwd.equals("123")) {
            User user = new User();
            user.setId(123);
            user.setName(name);
            user.setHost("lyh.net");
            session.setAttribute("loginuser",user);
            req.getRequestDispatcher("/user/user.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("msg","账号密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
