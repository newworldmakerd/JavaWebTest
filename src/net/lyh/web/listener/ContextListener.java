package net.lyh.web.listener;

import net.lyh.web.domain.Config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("inti");
        ServletContext servletContext = servletContextEvent.getServletContext();
        String url = servletContext.getInitParameter("url");
        String topic = servletContext.getInitParameter("topic");
        Config config=new Config();
        config.setTopic(topic);
        config.setUrl(url);
        servletContext.setAttribute("config",config);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
