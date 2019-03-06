package io.cloud.layer.websocket;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;

/**
 * @author RippleChan
 */
@Slf4j
public abstract class DefaultServerEndopoint {


    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.warn("WebSockt已关闭-{}：{}", session.getRequestURI(), closeReason.getCloseCode());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("WebSocket发生错误-{}:{}",session.getRequestURI(),throwable.getMessage());
    }

    public abstract void onOpen(Session session, EndpointConfig endpointConfig);

    public abstract void onMessage(Session session, String message);

}
