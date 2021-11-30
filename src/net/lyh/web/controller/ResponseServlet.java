package net.lyh.web.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/response")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.addHeader("name","java");
        resp.addHeader("xxx","spring");
        resp.setHeader("Content-Type","text/html;charset=utf-8");
        String data="你好";
        byte[] bs = data.getBytes("UTF-8");
        ServletOutputStream os = resp.getOutputStream();
        os.write(bs);
    }
}
