package com.jackzhang.webSocket;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class EchoSocketServlet extends WebSocketServlet {

    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.register(EchoSocket.class);
    }
}
