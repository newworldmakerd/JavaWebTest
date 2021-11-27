package net.lyh.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(servletNames = {"cookieServlet"})
@WebFilter(filterName = "loginFilter",urlPatterns = {"/user/*","/order/*"},initParams = {
        @WebInitParam(name="encoding",value = "UTF-8"),
        @WebInitParam(name = "loginPage",value = "/login.jsp"),
})
public class LoginFilter implements Filter {
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
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
        if(httpServletRequest.getSession().getAttribute("loginUser")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            httpServletRequest.setAttribute("msg","非法访问，请重修登录");
            httpServletRequest.getRequestDispatcher(loginPage).forward(httpServletRequest,httpServletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
