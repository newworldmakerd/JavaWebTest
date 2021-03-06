package net.lyh.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
//@WebFilter(servletNames = {"cookieServlet"})
@WebFilter(filterName = "xxx",urlPatterns = "/*",initParams = {
        @WebInitParam(name="encoding",value = "UTF-8"),
        @WebInitParam(name = "loginPage",value = "/login.jsp"),
},dispatcherTypes = {DispatcherType.FORWARD})
public class CustomFilter implements Filter {
private FilterConfig filterConfig;
private String loginPage;
private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
        this.filterConfig=filterConfig;
        String name=filterConfig.getFilterName();
        this.encoding=filterConfig.getInitParameter("encoding");
        this.loginPage=filterConfig.getInitParameter("loginPage");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        servletResponse.setContentType("text/html;charset=utf-8");
        servletResponse.setCharacterEncoding(encoding);
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
