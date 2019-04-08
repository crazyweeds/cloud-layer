package io.cloud.layer.websocket;

import org.springframework.boot.web.servlet.server.Session;

import java.util.HashSet;

public class SessionContext {

    private static final HashSet<Session> SESSION_CONTEXT = new HashSet<>(1024);

    public static HashSet<Session> getSessionContext() {
        return SESSION_CONTEXT;
    }

}
