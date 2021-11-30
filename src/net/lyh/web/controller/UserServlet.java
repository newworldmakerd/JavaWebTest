package net.lyh.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet( name = "userServlet",urlPatterns = {"/user/login"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("<div>do get刘宇恒 你好 很高兴认识你</div>");
//
//        ServletContext servletContext = req.getServletContext();
//        String url = servletContext.getInitParameter("url");
//        System.out.println(url);
//        servletContext.setAttribute("appInfo","lyh Info");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.write("<div> do post 刘宇恒你好呀</div>");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd=req.getParameter("upwd");
        if(uname.equals("lyh")&&pwd.equals("123")){
            resp.getWriter().write("登录成功");
        }
        else resp.getWriter().write("输入有误");
    }
}
