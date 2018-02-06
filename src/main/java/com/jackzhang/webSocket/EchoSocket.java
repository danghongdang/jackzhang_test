package com.jackzhang.webSocket;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;

public class EchoSocket implements WebSocketListener {

    private static final Logger LOG = Log.getLogger(EchoSocket.class);

    private Session outbound;

    public void onWebSocketBinary(byte[] bytes, int i, int i1) {
        this.outbound = null;

    }

    public void onWebSocketText(String s) {
        if ((outbound != null) && (outbound.isOpen()))
        {
            LOG.info("Echoing back text message [{}]", s);
            for (int i=0; i<=100; i++) {
                outbound.getRemote().sendString(s + i,null);
            }
            outbound.getRemote().sendString(s,null);
        }
    }

    public void onWebSocketClose(int i, String s) {
        this.outbound = null;
        LOG.info("WebSocket Close: {} - {}", i, s);
    }

    public void onWebSocketConnect(Session session) {
        this.outbound = session;
        LOG.info("WebSocket Connect: {}",session);
        this.outbound.getRemote().sendString("You are now connected to " + this.getClass().getName(),null);
    }

    public void onWebSocketError(Throwable throwable) {
        LOG.info("WebSocket Error", throwable);
    }
}
