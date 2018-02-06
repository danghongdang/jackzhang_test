package com.jackzhang.webSocket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.net.URL;

public class JettyRun {

    public static void main(String args[]) {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        ServletHolder wsHolder = new ServletHolder("c", new EchoSocketServlet());
        context.addServlet(wsHolder,"/echo");

        URL urlStatics = Thread.currentThread().getContextClassLoader().getResource("index.html");
        String urlBase = urlStatics.toExternalForm().replaceFirst("/[^/]*$","/");
        ServletHolder defHolder = new ServletHolder("default",new DefaultServlet());
        defHolder.setInitParameter("resourceBase",urlBase);
        defHolder.setInitParameter("dirAllowed","true");
        context.addServlet(defHolder,"/");

        try {
            server.start();
            server.join();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
