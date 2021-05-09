package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.coinbase.CoinbaseClientEndpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static model.Instrument.*;

@Path("/")
public class MessagesServiceImpl implements MessagesService {

    Logger logger = LoggerFactory.getLogger(MessagesServiceImpl.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getAll() {
        logger.info("Received get request");
        return CoinbaseClientEndpoint.History.values().toString();
    }

    @Path("/BTCUSD")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getBTCUSD() {
        logger.info("Received get request to BTCUSD");
        return CoinbaseClientEndpoint.History.get(BTCUSD);
    }

    @Path("/BTCEUR")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getBTCEUR() {
        logger.info("Received get request to BTCEUR");
        return CoinbaseClientEndpoint.History.get(BTCEUR);
    }

    @Path("/ETHEUR")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getETHEUR() {
        logger.info("Received get request to ETHEUR");
        return CoinbaseClientEndpoint.History.get(ETHEUR);
    }

    @Path("/ETHUSD")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String getETHUSD() {
        logger.info("Received get request to ETHUSD");
        return CoinbaseClientEndpoint.History.get(ETHUSD);
    }
}
