package service.coinbase;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.InstrumentMessage;
import model.Instrument;
import model.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.websocket.*;
import java.util.HashMap;
import java.util.Map;

@ClientEndpoint
public class CoinbaseClientEndpoint {
    Logger logger = LoggerFactory.getLogger(CoinbaseClientEndpoint.class);

    private final static String type = "subscribe";
    private final static String[] productIds = {"BTC-USD", "BTC-EUR", "ETH-USD", "ETH-EUR"};
    private final static String[] channels = {"ticker"};

    private final Subscription subscription;
    private final ObjectMapper objectMapper;
    public static Map<Instrument, String> History;

    @Inject
    public CoinbaseClientEndpoint(){
        this.subscription = new Subscription();
        subscription.setType(type);
        subscription.setChannels(channels);
        subscription.setProductIds(productIds);
        this.objectMapper = new ObjectMapper();
        History = new HashMap<>();
    }

    @OnMessage
    public void onMessage(String messageIn, Session session) throws Exception{

        logger.debug("Message received from the server: {} ", messageIn);

        InstrumentMessage instrumentMessage = objectMapper.readValue(messageIn, InstrumentMessage.class);

        logger.debug("Message deserialized into: {}", instrumentMessage);

        Instrument instrument = instrumentMessage.getInstrument();

        String messageOut = objectMapper.writeValueAsString(instrumentMessage);

        logger.debug("Message serialized back: {}", messageOut);

        if(instrument != null) {
            History.put(instrument, messageOut);
        }
    }

    @OnOpen
    public void onOpen(Session session) throws Exception{

        logger.info("Session established, attempting to send subscription");

        session.getBasicRemote().sendText(objectMapper.writeValueAsString(this.subscription));

        logger.info("Subscription successfully sent");
    }

    @OnClose
    public void onClose(Session session){
        logger.info("Session closed");
    }

    @OnError
    public void OnError(Session session, Throwable throwable){
        logger.error("Error occurred", throwable);
    }

}
