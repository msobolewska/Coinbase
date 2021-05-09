package service.coinbase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;

@Singleton
public class CoinbaseWebSocket {

    private static String coinbaseProWSURI = "wss://ws-feed.pro.coinbase.com";

    private static WebSocketContainer webSocketContainer;
    private static Session session;

    public static void init() throws Exception {
        Logger logger = LoggerFactory.getLogger(CoinbaseWebSocket.class);

        logger.info("Starting CoinbaseProWSService");

        if(webSocketContainer == null){
            webSocketContainer = ContainerProvider.getWebSocketContainer();
        }

        if(session == null){
                session = webSocketContainer.
                        connectToServer(CoinbaseClientEndpoint.class, new URI(coinbaseProWSURI));

        }

        logger.info("Successfully started CoinbaseProWSService");

    }
}
